/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import java.sql.Statement;
import com.sun.jdi.connect.spi.Connection;
import Connectivity.ConnectionClass;
import GUI.PageGUI;
import GUI.VoteMeetingGUI;
import Objects.CurrentUser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author olive
 */
public class SuggestMeeting {

    Statement st;
    Statement st1;
    ResultSet rs = null;
    public static String startTid1;
    public static String startTid2;
    public static String startTid3;
    public static String slutTid1;
    public static String slutTid2;
    public static String slutTid3;
    public static String datum1;
    public static String datum2;
    public static String datum3;
    public static int proposeID;
    public static String insertQuery1;
    public static String insertQuery2;
    public static String insertQuery3;
    public static SuggestMeeting currentSM;
    public static int numberOfProposals;
    public static String meetingName;

    public SuggestMeeting() {
        mouseClicker();
    }

    public SuggestMeeting(String m�tesNamn, String skapareNamn) {
        getSelectedProposes(m�tesNamn, skapareNamn);
        setMeetingProposal();
        System.out.println(numberOfProposals);

    }

    public static int getNumberOfProposals() {
        return numberOfProposals;
    }
    
    

    public void createSuggestion1(int creatorID, String namn, String beskrivning, String Startid1, String Sluttid1, String datum1) {

        try {
            st = ConnectionClass.conn.createStatement();

            String createSuggestion = "insert into F�rslagstider(M�tesnamn, Beskrivning, Skapar_ID, Starttid1,Sluttid1, Datum1) values ('" + namn + "', " + "'" + beskrivning + "', " + "'" + creatorID + "', " + "'" + Startid1 + "', " + "'" + Sluttid1 + "', " + "'" + datum1 + "')";
            st.executeUpdate(createSuggestion);
        } catch (Exception e) {

        }
    }

    public void createSuggestion2(int creatorID, String namn, String beskrivning, String Startid1, String Sluttid1, String datum1, String Starttid2, String Sluttid2, String Datum2) {

        try {
            st = ConnectionClass.conn.createStatement();

            String createSuggestion = "insert into F�rslagstider(M�tesnamn, Beskrivning, Skapar_ID, Starttid1,Sluttid1, Datum1, Starttid2, Sluttid2, Datum2) values ('" + namn + "', " + "'" + beskrivning + "', " + "'" + creatorID + "', " + "'" + Startid1 + "', " + "'" + Sluttid1 + "', " + "'" + datum1 + "', " + "'" + Starttid2 + "', " + "'" + Sluttid2 + "', " + "'" + Datum2 + "')";

            st.executeUpdate(createSuggestion);
        } catch (Exception e) {
        }
    }

    public void createSuggestion3(int creatorID, String namn, String beskrivning, String Startid1, String Sluttid1, String datum1, String Starttid2, String Sluttid2, String Datum2, String Starttid3, String Sluttid3, String Datum3) {

        try {
            st = ConnectionClass.conn.createStatement();

            String createSuggestion = "insert into F�rslagstider(M�tesnamn, Beskrivning, Skapar_ID, Starttid1,Sluttid1, Datum1, Starttid2, Sluttid2, Datum2, Starttid3, Sluttid3, Datum3) values ('" + namn + "', " + "'" + beskrivning + "', " + "'" + creatorID + "', " + "'" + Startid1 + "', " + "'" + Sluttid1 + "', " + "'" + datum1 + "', " + "'" + Starttid2 + "', " + "'" + Sluttid2 + "', " + "'" + Datum2 + "', " + "'" + Starttid3 + "', " + "'" + Sluttid3 + "', " + "'" + Datum3 + "')";

            st.executeUpdate(createSuggestion);
        } catch (Exception e) {
        }
    }

    public void inviteOtherToMeeting(String email, int suggestID) {
        int userID = 0;
        try {
            st = ConnectionClass.conn.createStatement();
            //st1=ConnectionClass.conn.createStatement();
            String queryID = "select Anv�ndare_Id from Anv�ndare where email = '" + email + "'";
            rs = st.executeQuery(queryID);

            while (rs.next()) {

                userID = rs.getInt("Anv�ndare_ID");
            }
            String query = "Insert into F�rslag_Anv�ndare(Anv�ndare_ID, F�rslags_ID) values (" + userID + ", " + suggestID + ")";

            st.executeUpdate(query);

        } catch (Exception e) {

        }
    }

    public int getSuggestedMeetingID() {
        int id = 0;
        try {
            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            String getSuggestedMeetingID = "SELECT F�rslags_ID FROM F�rslagstider ORDER BY F�rslags_ID DESC LIMIT 1";
            rs = st.executeQuery(getSuggestedMeetingID);
            while (rs.next()) {
                id = rs.getInt("F�rslags_ID");
            }

        } catch (Exception e) {
        }
        return id;
    }

    public ArrayList<String> getF�rslagsID(int userID) {
        ArrayList f�rslagsID = new ArrayList<String>();

        try {
            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            String f�rslagsIDQuery = "select F�rslags_ID from F�rslag_Anv�ndare where Anv�ndare_ID=" + userID;
            rs = st.executeQuery(f�rslagsIDQuery);
            while (rs.next()) {
                f�rslagsID.add(rs.getInt("F�rslags_ID"));
            }
        } catch (Exception e) {
            ;
        }

        return f�rslagsID;
    }

    public void showSuggestedMeetings(JTable table, int userID) {
        ResultSet rs = null;
        Object columnNames[] = {"M�tesNamn", "Skapare"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        String query = "select F�rslagstider.M�tesnamn, Anv�ndare.Namn from F�rslagstider join F�rslag_Anv�ndare on F�rslagstider.`F�rslags_ID`=F�rslag_Anv�ndare.`F�rslags_ID` join Anv�ndare on Anv�ndare.`Anv�ndare_ID`=F�rslagstider.Skapar_ID where F�rslag_Anv�ndare.`Anv�ndare_ID`=" + userID;
        try {
            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String m�tesnamn = rs.getString("F�rslagstider.M�tesnamn");
                String skapare = rs.getString("Anv�ndare.Namn");

                Object rowData[] = {m�tesnamn, skapare};

                model.addRow(rowData);

            }

        } catch (Exception e) {

        }
        table.setModel(model);

    }

    public void getSelectedProposes(String m�tesNamn, String skapareNamn) {

        String queryGetProposes = "SELECT * FROM F�rslagstider ft INNER JOIN \n"
                + "Anv�ndare a ON a.Anv�ndare_ID = ft.Skapar_ID \n"
                + "WHERE ft.M�tesnamn = '" + m�tesNamn + "'  \n"
                + "AND a.Namn = '" + skapareNamn + "'";

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

            proposeID = rs.getInt("F�rslags_ID");
            meetingName = rs.getString("M�tesnamn");

        } catch (Exception e) {

            System.out.println(e);

        }

    }

    public void setMeetingProposal() {

        Object columnNames[] = {"Datum", "Starttid", "Sluttid"};
        DefaultTableModel model = (DefaultTableModel) VoteMeetingGUI.tblMeetingProposes.getModel();
        numberOfProposals = 1;
        model.setValueAt(datum1, 0, 0);
        model.setValueAt(startTid1, 0, 1);
        model.setValueAt(slutTid1, 0, 2);

        if (startTid2 != null) {
            model.setValueAt(datum2, 1, 0);
            model.setValueAt(startTid2, 1, 1);
            model.setValueAt(slutTid2, 1, 2);
            
            numberOfProposals = 2;

            if (startTid3 != null) {
                model.setValueAt(datum3, 2, 0);
                model.setValueAt(startTid3, 2, 1);
                model.setValueAt(slutTid3, 2, 2);
                
                numberOfProposals = 3;
            }

        }

    }

    public void mouseClicker() {

        PageGUI.tblMeetings.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent click) {

                if (click.getButton() == MouseEvent.BUTTON1) {
                    int row = PageGUI.tblMeetings.getSelectedRow();
                    String m�tesNamn = PageGUI.tblMeetings.getValueAt(row, 0).toString();
                    System.out.println(m�tesNamn);
                    String skapareNamn = PageGUI.tblMeetings.getValueAt(row, 1).toString();
                    System.out.println(skapareNamn);
                    System.out.println("mouseclicked number of proposals " + numberOfProposals);
                    
                    VoteMeetingGUI currentVMG = new VoteMeetingGUI();
                    currentVMG.setVisible(true);
                    new SuggestMeeting(m�tesNamn, skapareNamn);
                    currentVMG.setComboBox(numberOfProposals);
                    currentVMG.setMeetingName(meetingName);
                    
                    
                    
                }
                if (click.getButton() == MouseEvent.BUTTON3) {
                    System.out.println("H�ger");
                }
            }

        });

    }

    public static void voteMeeting() {
        int i = setVoteMeetingQueries();
        doInsertQueries(i);
        

    }
    
    

    public static int setVoteMeetingQueries() {

        int i = 0;
        if (VoteMeetingGUI.cbMeeting1.isSelected()) {
            insertQuery1 = "INSERT INTO Godk�nt_M�tesf�rslag (Anv�ndare_ID, Starttid, Sluttid, Svar, F�rslags_ID, Datum) VALUES (" + CurrentUser.currentUser.getID() + ", '" + startTid1 + "', '" + slutTid1 + "', 'J', " + proposeID + ", '" + datum1 + "')";
            i = 1;
        }

        if (VoteMeetingGUI.cbMeeting2.isSelected()) {
            insertQuery2 = "INSERT INTO Godk�nt_M�tesf�rslag (Anv�ndare_ID, Starttid, Sluttid, Svar, F�rslags_ID, Datum) VALUES (" + CurrentUser.currentUser.getID() + ", '" + startTid2 + "', '" + slutTid2 + "', 'J', " + proposeID + ", '" + datum2 + "')";
            i = 2;
        }

        if (VoteMeetingGUI.cbMeeting3.isSelected()) {
            insertQuery2 = "INSERT INTO Godk�nt_M�tesf�rslag (Anv�ndare_ID, Starttid, Sluttid, Svar, F�rslags_ID, Datum) VALUES (" + CurrentUser.currentUser.getID() + ", '" + startTid3 + "', '" + slutTid3 + "', 'J', " + proposeID + ", '" + datum3 + "')";
            i = 3;
        }
        return i;
    }
    
    public static void doInsertQueries(int i){
    
            try {
            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            
            if (i == 1) {
                st.executeUpdate(insertQuery1);
            }
            if (i == 2) {
                st.executeUpdate(insertQuery1);
                st.executeUpdate(insertQuery2);
            }
            if (i == 3) {
                st.executeUpdate(insertQuery1);
                st.executeUpdate(insertQuery2);
                st.executeUpdate(insertQuery3);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void deleteFromProposes(){
        
    String deleteQuery = "DELETE FROM F�rslag_Anv�ndare WHERE Anv�ndare_ID = "+ CurrentUser.currentUser.getID() + " AND F�rslags_ID = "+ proposeID;
    
     try {
            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            st.execute(deleteQuery);
            
     } catch (Exception e){
         System.out.println(e);
     }

}

}
