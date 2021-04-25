/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import GUI.DecideMeetingGUI;
import GUI.PageGUI;
import Objects.CurrentDM;
import Objects.CurrentUser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pierre
 */
public class DecideMeeting {

    private String startTid1;
    private String startTid2;
    private String startTid3;
    private String slutTid1;
    private String slutTid2;
    private String slutTid3;
    private String datum1;
    private String datum2;
    private String datum3;
    private int total1;
    private int total2;
    private int total3;
    private int specificProposeID;
    private String meetingName;
    private int numberOfProposals;
    private String description;
    public boolean created = false;

    private ArrayList<String> alUserIDs;

    public DecideMeeting(JTable table) {

        fillMeetingDecideTable(table);
        mouseClicker();
        
        this.created = true;
    }

    public DecideMeeting(String mötesNamn) {
        getSelectedProposes(mötesNamn);
        getVotes();
        setMeetingProposal();
        System.out.println("antal förslag konstruktorsslut" + numberOfProposals);

    }
    
    public boolean created(){
    return created;
    }
    
    public void decideMeetingConstructor(String mötesNamn){
            getSelectedProposes(mötesNamn);
        getVotes();
        setMeetingProposal();
    
    }

    public int getNumberOfProposals() {
        return numberOfProposals;
    }

    public String getDescription() {
        return description;
    }
    
    

    public void fillMeetingDecideTable(JTable table) {
        ResultSet rs = null;
        Object columnNames[] = {"MötesNamn", "Antal som röstat"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        String query = "SELECT Mötesnamn, Förslags_ID FROM Förslagstider WHERE Skapar_ID =" + CurrentUser.currentUser.getID();

        try {
            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String mötesnamn = rs.getString("Mötesnamn");
                int proposeID = rs.getInt("Förslags_ID");

                int votes = getMeetingVotes(proposeID);

                System.out.println("Sout ppID" + proposeID);

                Object rowData[] = {mötesnamn, votes};

                model.addRow(rowData);
            }

        } catch (Exception e) {

        }
        table.setModel(model);

    }

    public int getMeetingVotes(int proposeID) {
        int total = 0;
        ResultSet rsGMV = null;

        String sqlCountQuery = "SELECT COUNT(DISTINCT Användare_ID) AS Total FROM Godkänt_Mötesförslag gm INNER JOIN Förslagstider ft on ft.Förslags_ID = gm.Förslags_ID WHERE Skapar_ID =" + CurrentUser.currentUser.getID() + " AND ft.Förslags_ID = " + proposeID;

        try {
            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            rsGMV = st.executeQuery(sqlCountQuery);
            if (rsGMV.next()) {

                total = rsGMV.getInt("Total");

            }

        } catch (Exception e) {

            System.out.println(e);
        }
        return total;
    }

    public void getSelectedProposes(String mötesNamn) {
        ResultSet rs = null;
        String queryGetProposes = "SELECT * FROM Förslagstider ft INNER JOIN \n"
                + "Användare a ON a.Användare_ID = ft.Skapar_ID \n"
                + "WHERE ft.Mötesnamn = '" + mötesNamn + "'  \n"
                + "AND a.Användare_ID = " + CurrentUser.currentUser.getID() + "";

        try {

            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            rs = st.executeQuery(queryGetProposes);

            rs.next();

            startTid1 = rs.getString("Starttid1");
            startTid2 = rs.getString("Starttid2");
            startTid3 = rs.getString("Starttid3");

            slutTid1 = rs.getString("Sluttid1");
            slutTid2 = rs.getString("Sluttid2");
            slutTid3 = rs.getString("Sluttid3");

            datum1 = rs.getString("Datum1");
            datum2 = rs.getString("Datum2");
            datum3 = rs.getString("Datum3");

            specificProposeID = rs.getInt("Förslags_ID");
            meetingName = rs.getString("Mötesnamn");
            description = rs.getString("Beskrivning");

        } catch (Exception e) {

            System.out.println(e);

        }

    }

    public void getVotes() {
        ResultSet rs = null;
        String sqlGetVotes1 = "SELECT COUNT(*) AS Total FROM Godkänt_Mötesförslag gm INNER JOIN Förslagstider ft on "
                + "gm.förslags_ID = ft.Förslags_ID AND gm.Starttid = ft.Starttid1 "
                + "AND gm.Sluttid = ft.Sluttid1 AND gm.Datum = ft.Datum1 "
                + "WHERE ft.Förslags_ID = " + specificProposeID
                + " AND ft.Datum1 = '" + datum1 + "' AND ft.Starttid1 = '" + startTid1
                + "' AND ft.Sluttid1 = '" + slutTid1 + "' AND ft.Skapar_ID = " + CurrentUser.currentUser.getID();

        try {
            Statement st = Connectivity.ConnectionClass.conn.createStatement();

            rs = st.executeQuery(sqlGetVotes1);
            rs.next();
            total1 = rs.getInt("Total");

            if (startTid2 != null) {
                String sqlGetVotes2 = "SELECT COUNT(*) AS Total FROM Godkänt_Mötesförslag gm INNER JOIN Förslagstider ft on "
                        + "gm.förslags_ID = ft.Förslags_ID AND gm.Starttid = ft.Starttid2 "
                        + "AND gm.Sluttid = ft.Sluttid2 AND gm.Datum = ft.Datum2 "
                        + "WHERE ft.Förslags_ID = " + specificProposeID
                        + " AND ft.Datum2 = '" + datum2 + "' AND ft.Starttid2 = '" + startTid2
                        + "' AND ft.Sluttid2 = '" + slutTid2 + "' AND ft.Skapar_ID = " + CurrentUser.currentUser.getID();

                rs = st.executeQuery(sqlGetVotes2);
                rs.next();
                total2 = rs.getInt("Total");

                if (startTid3 != null) {

                    String sqlGetVotes3 = "SELECT COUNT(*) AS Total FROM Godkänt_Mötesförslag gm INNER JOIN Förslagstider ft on"
                            + " gm.förslags_ID = ft.Förslags_ID AND gm.Starttid = ft.Starttid3"
                            + " AND gm.Sluttid = ft.Sluttid3 AND gm.Datum = ft.Datum3"
                            + " WHERE ft.Förslags_ID = " + specificProposeID
                            + " AND ft.Datum3 = '" + datum3 + "' AND ft.Starttid3 = '" + startTid3
                            + "' AND ft.Sluttid3 = '" + slutTid3 + "' AND ft.Skapar_ID = " + CurrentUser.currentUser.getID();

                    rs = st.executeQuery(sqlGetVotes3);
                    rs.next();
                    total3 = rs.getInt("Total");

                }
            }
        } catch (Exception e) {

            System.out.println(e);
        }

    }

    public void setMeetingProposal() {
        System.out.println("4 nr proposals" + numberOfProposals);
        Object columnNames[] = {"Datum", "Starttid", "Sluttid", "Antal röster"};
        DefaultTableModel model = (DefaultTableModel) DecideMeetingGUI.tblMeetingProposes.getModel();
        numberOfProposals = 1;
        model.setValueAt(datum1, 0, 0);
        model.setValueAt(startTid1, 0, 1);
        model.setValueAt(slutTid1, 0, 2);
        model.setValueAt(total1, 0, 3);
        System.out.println("41 nr proposals" + numberOfProposals);

        if (startTid2 != null) {
            model.setValueAt(datum2, 1, 0);
            model.setValueAt(startTid2, 1, 1);
            model.setValueAt(slutTid2, 1, 2);
            model.setValueAt(total2, 1, 3);

            numberOfProposals = 2;
            System.out.println("42 nr proposals" + numberOfProposals);

            if (startTid3 != null) {
                model.setValueAt(datum3, 2, 0);
                model.setValueAt(startTid3, 2, 1);
                model.setValueAt(slutTid3, 2, 2);
                model.setValueAt(total3, 2, 3);

                numberOfProposals = 3;
                System.out.println("43 nr proposals" + numberOfProposals);
            }

        }

    }

    public void mouseClicker() {

        PageGUI.tblMeetingsDecide.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent click) {

                if (click.getButton() == MouseEvent.BUTTON1) {
                    int row = PageGUI.tblMeetingsDecide.getSelectedRow();
                    String mötesNamn = PageGUI.tblMeetingsDecide.getValueAt(row, 0).toString();
                    System.out.println(mötesNamn);

                    DecideMeetingGUI currentDMG = new DecideMeetingGUI();
                    currentDMG.setVisible(true);
//                    DecideMeeting createdDM = new DecideMeeting(mötesNamn);
//                    CurrentDM currentDM = new CurrentDM(createdDM);
                    CurrentDM.currentDM.decideMeetingConstructor(mötesNamn);
                    currentDMG.setComboBox(CurrentDM.currentDM.getNumberOfProposals());
                    currentDMG.setMeetingName(mötesNamn);

                }
                if (click.getButton() == MouseEvent.BUTTON3) {
                    System.out.println("Höger");
                }
            }

        });

    }

    public boolean decideMeeting(String startTime, String endTime, String description, String date) {
        boolean meetingDecided = false;

        ResultSet rs = null;
        String sqlQuery = "INSERT INTO Möte (Namn, Starttid, SlutTidTime, Beskrivning, Datum, Publik) VALUES ('" + meetingName + "', '" + startTime + "', '" + endTime + "', '" + description + "', '" + date + "' , 'N')";
                   ArrayList<String> alUserIDs = new ArrayList();
        try {
            Statement st = Connectivity.ConnectionClass.conn.createStatement();

            st.executeUpdate(sqlQuery);

            String selectMeetingID = "Select Möte_ID from Möte where Namn = " + "'" + meetingName + "' and " + "Beskrivning = " + "'" + description + "'";

            rs = st.executeQuery(selectMeetingID);

            if (rs.next()) {

                int meetingID = rs.getInt("Möte_ID");

                String meet_user = "insert into Möte_Användare (Möte_ID, Användare_ID) values(" + meetingID + ", " + CurrentUser.currentUser.getID() + ")";

                st.executeUpdate(meet_user);

                String invitersQuery = "SELECT Användare_ID FROM Förslag_Användare WHERE Förslags_ID = " + specificProposeID;

//                Statement st2 = Connectivity.ConnectionClass.conn.createStatement();
                ResultSet rs2 = st.executeQuery(invitersQuery);
                while (rs2.next()) {
 
                    Integer inviteUserID = rs2.getInt("Användare_ID");

                    alUserIDs.add(inviteUserID.toString());

                    System.out.println("ArrayList" + alUserIDs);

                }
                int i = 0;
                while (i < alUserIDs.size()) {
                    
                    String insertInviters = "insert into Möte_Användare (Möte_ID, Användare_ID) values(" + meetingID + ", " + alUserIDs.get(i) + ")";

                st.executeUpdate(insertInviters);
                    
                    i++;
                }

                String sqlDeleteQuery = "DELETE FROM Förslag_Användare WHERE Förslags_ID = " + specificProposeID;
                String sqlDeleteQuery2 = "DELETE FROM Förslagstider WHERE Förslags_ID = " + specificProposeID;
                String sqlDeleteQuery3 = "DELETE FROM Godkänt_Mötesförslag WHERE Förslags_ID = " + specificProposeID;

                st.execute(sqlDeleteQuery);
                st.execute(sqlDeleteQuery3);
                st.execute(sqlDeleteQuery2);

                meetingDecided = true;

            }

        } catch (Exception e) {

            System.out.println(e);
        }
        return meetingDecided;

    }

    public void decideSpecificMeeting() {

        String description = DecideMeetingGUI.taDescriptionMeeting.getText();

        if (DecideMeetingGUI.rbMeeting1.isSelected()) {

            decideMeeting(startTid1, slutTid1, description, datum1);

        } else if (DecideMeetingGUI.rbMeeting2.isSelected()) {

            decideMeeting(startTid2, slutTid2, description, datum2);

        } else if (DecideMeetingGUI.rbMeeting3.isSelected()) {

            decideMeeting(startTid3, slutTid3, description, datum3);

        }

    }

}
