/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import GUI.DecideMeetingGUI;
import GUI.PageGUI;
import Objects.CurrentUser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Statement;
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
    private int specificProposeID;
    private String meetingName;
    private int numberOfProposals;


    public DecideMeeting(JTable table) {
        
        fillMeetingDecideTable(table);
        mouseClicker();
    }
    
    public DecideMeeting(String m�tesNamn){
    getSelectedProposes(m�tesNamn);
    setMeetingProposal();
        System.out.println("antal f�rslag konstruktorsslut" + numberOfProposals);
    
    }
    
    
 
    
    
    public void fillMeetingDecideTable(JTable table){   
        ResultSet rs = null;
        Object columnNames[] = {"M�tesNamn", "Antal som r�stat"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        String query = "SELECT M�tesnamn, F�rslags_ID FROM F�rslagstider WHERE Skapar_ID =" + CurrentUser.currentUser.getID();
        
        try {
            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String m�tesnamn = rs.getString("M�tesnamn");
                int proposeID = rs.getInt("F�rslags_ID");
                
                int votes = getMeetingVotes(proposeID);

                
                System.out.println("Sout ppID" +proposeID);

                Object rowData[] = {m�tesnamn, votes};

                model.addRow(rowData);
            }

        } catch (Exception e) {

        }
        table.setModel(model);

    }
    
    public int getMeetingVotes(int proposeID){
    int total = 0;
    ResultSet rsGMV = null;
    
    String sqlCountQuery = "SELECT COUNT(DISTINCT Anv�ndare_ID) AS Total FROM Godk�nt_M�tesf�rslag gm INNER JOIN F�rslagstider ft on ft.F�rslags_ID = gm.F�rslags_ID WHERE Skapar_ID =" + CurrentUser.currentUser.getID() + " AND ft.F�rslags_ID = " + proposeID;
    
    try{
    Statement st = Connectivity.ConnectionClass.conn.createStatement();
    rsGMV = st.executeQuery(sqlCountQuery);
    if(rsGMV.next()){
    
    total = rsGMV.getInt("Total");
    
    }
    
    }catch (Exception e){
    
        System.out.println(e);
    }
    return total;
    }
    
    
    
    
    public void getSelectedProposes(String m�tesNamn) {
            ResultSet rs = null;
        String queryGetProposes = "SELECT * FROM F�rslagstider ft INNER JOIN \n"
                + "Anv�ndare a ON a.Anv�ndare_ID = ft.Skapar_ID \n"
                + "WHERE ft.M�tesnamn = '" + m�tesNamn + "'  \n"
                + "AND a.Anv�ndare_ID = " + CurrentUser.currentUser.getID() + "";

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

            specificProposeID = rs.getInt("F�rslags_ID");
            meetingName = rs.getString("M�tesnamn");

        } catch (Exception e) {

            System.out.println(e);

        }

    }
        
    public void setMeetingProposal() {
System.out.println("4 nr proposals" + numberOfProposals);
        Object columnNames[] = {"Datum", "Starttid", "Sluttid"};
        DefaultTableModel model = (DefaultTableModel) DecideMeetingGUI.tblMeetingProposes.getModel();
        numberOfProposals = 1;
        model.setValueAt(datum1, 0, 0);
        model.setValueAt(startTid1, 0, 1);
        model.setValueAt(slutTid1, 0, 2);
        System.out.println("41 nr proposals" + numberOfProposals);

        if (startTid2 != null) {
            model.setValueAt(datum2, 1, 0);
            model.setValueAt(startTid2, 1, 1);
            model.setValueAt(slutTid2, 1, 2);
            
            numberOfProposals = 2;
            System.out.println("42 nr proposals" + numberOfProposals);

            if (startTid3 != null) {
                model.setValueAt(datum3, 2, 0);
                model.setValueAt(startTid3, 2, 1);
                model.setValueAt(slutTid3, 2, 2);
                
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
                    String m�tesNamn = PageGUI.tblMeetingsDecide.getValueAt(row, 0).toString();
                    System.out.println(m�tesNamn);
                    System.out.println("1 nr proposals" + numberOfProposals);
                    
                    DecideMeetingGUI currentDMG = new DecideMeetingGUI();
                    currentDMG.setVisible(true);
                    DecideMeeting currentDM = new DecideMeeting(m�tesNamn);
                    System.out.println("5 nr proposals" + currentDM.numberOfProposals);
                    currentDMG.setComboBox(currentDM.numberOfProposals);
                    currentDMG.setMeetingName(m�tesNamn);
                    
                    
                    
                }
                if (click.getButton() == MouseEvent.BUTTON3) {
                    System.out.println("H�ger");
                }
            }

        });

    }
        
}
