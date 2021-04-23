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

    public SuggestMeeting(String mötesNamn, String skapareNamn) {
        getSelectedProposes(mötesNamn, skapareNamn);
        setMeetingProposal();
        System.out.println(numberOfProposals);

    }

    public static int getNumberOfProposals() {
        return numberOfProposals;
    }
    
    

    public void createSuggestion1(int creatorID, String namn, String beskrivning, String Startid1, String Sluttid1, String datum1) {

        try {
            st = ConnectionClass.conn.createStatement();

            String createSuggestion = "insert into Förslagstider(Mötesnamn, Beskrivning, Skapar_ID, Starttid1,Sluttid1, Datum1) values ('" + namn + "', " + "'" + beskrivning + "', " + "'" + creatorID + "', " + "'" + Startid1 + "', " + "'" + Sluttid1 + "', " + "'" + datum1 + "')";
            st.executeUpdate(createSuggestion);
        } catch (Exception e) {

        }
    }

    public void createSuggestion2(int creatorID, String namn, String beskrivning, String Startid1, String Sluttid1, String datum1, String Starttid2, String Sluttid2, String Datum2) {

        try {
            st = ConnectionClass.conn.createStatement();

            String createSuggestion = "insert into Förslagstider(Mötesnamn, Beskrivning, Skapar_ID, Starttid1,Sluttid1, Datum1, Starttid2, Sluttid2, Datum2) values ('" + namn + "', " + "'" + beskrivning + "', " + "'" + creatorID + "', " + "'" + Startid1 + "', " + "'" + Sluttid1 + "', " + "'" + datum1 + "', " + "'" + Starttid2 + "', " + "'" + Sluttid2 + "', " + "'" + Datum2 + "')";

            st.executeUpdate(createSuggestion);
        } catch (Exception e) {
        }
    }

    public void createSuggestion3(int creatorID, String namn, String beskrivning, String Startid1, String Sluttid1, String datum1, String Starttid2, String Sluttid2, String Datum2, String Starttid3, String Sluttid3, String Datum3) {

        try {
            st = ConnectionClass.conn.createStatement();

            String createSuggestion = "insert into Förslagstider(Mötesnamn, Beskrivning, Skapar_ID, Starttid1,Sluttid1, Datum1, Starttid2, Sluttid2, Datum2, Starttid3, Sluttid3, Datum3) values ('" + namn + "', " + "'" + beskrivning + "', " + "'" + creatorID + "', " + "'" + Startid1 + "', " + "'" + Sluttid1 + "', " + "'" + datum1 + "', " + "'" + Starttid2 + "', " + "'" + Sluttid2 + "', " + "'" + Datum2 + "', " + "'" + Starttid3 + "', " + "'" + Sluttid3 + "', " + "'" + Datum3 + "')";

            st.executeUpdate(createSuggestion);
        } catch (Exception e) {
        }
    }

    public void inviteOtherToMeeting(String email, int suggestID) {
        int userID = 0;
        try {
            st = ConnectionClass.conn.createStatement();
            //st1=ConnectionClass.conn.createStatement();
            String queryID = "select Användare_Id from Användare where email = '" + email + "'";
            rs = st.executeQuery(queryID);

            while (rs.next()) {

                userID = rs.getInt("Användare_ID");
            }
            String query = "Insert into Förslag_Användare(Användare_ID, Förslags_ID) values (" + userID + ", " + suggestID + ")";

            st.executeUpdate(query);

        } catch (Exception e) {

        }
    }

    public int getSuggestedMeetingID() {
        int id = 0;
        try {
            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            String getSuggestedMeetingID = "SELECT Förslags_ID FROM Förslagstider ORDER BY Förslags_ID DESC LIMIT 1";
            rs = st.executeQuery(getSuggestedMeetingID);
            while (rs.next()) {
                id = rs.getInt("Förslags_ID");
            }

        } catch (Exception e) {
        }
        return id;
    }

    public ArrayList<String> getFörslagsID(int userID) {
        ArrayList förslagsID = new ArrayList<String>();

        try {
            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            String förslagsIDQuery = "select Förslags_ID from Förslag_Användare where Användare_ID=" + userID;
            rs = st.executeQuery(förslagsIDQuery);
            while (rs.next()) {
                förslagsID.add(rs.getInt("Förslags_ID"));
            }
        } catch (Exception e) {
            ;
        }

        return förslagsID;
    }

    public void showSuggestedMeetings(JTable table, int userID) {
        ResultSet rs = null;
        Object columnNames[] = {"MötesNamn", "Skapare"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        String query = "select Förslagstider.Mötesnamn, Användare.Namn from Förslagstider join Förslag_Användare on Förslagstider.`Förslags_ID`=Förslag_Användare.`Förslags_ID` join Användare on Användare.`Användare_ID`=Förslagstider.Skapar_ID where Förslag_Användare.`Användare_ID`=" + userID;
        try {
            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                String mötesnamn = rs.getString("Förslagstider.Mötesnamn");
                String skapare = rs.getString("Användare.Namn");

                Object rowData[] = {mötesnamn, skapare};

                model.addRow(rowData);

            }

        } catch (Exception e) {

        }
        table.setModel(model);

    }

    public void getSelectedProposes(String mötesNamn, String skapareNamn) {

        String queryGetProposes = "SELECT * FROM Förslagstider ft INNER JOIN \n"
                + "Användare a ON a.Användare_ID = ft.Skapar_ID \n"
                + "WHERE ft.Mötesnamn = '" + mötesNamn + "'  \n"
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

            proposeID = rs.getInt("Förslags_ID");
            meetingName = rs.getString("Mötesnamn");

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
                    String mötesNamn = PageGUI.tblMeetings.getValueAt(row, 0).toString();
                    System.out.println(mötesNamn);
                    String skapareNamn = PageGUI.tblMeetings.getValueAt(row, 1).toString();
                    System.out.println(skapareNamn);
                    System.out.println("mouseclicked number of proposals " + numberOfProposals);
                    
                    VoteMeetingGUI currentVMG = new VoteMeetingGUI();
                    currentVMG.setVisible(true);
                    new SuggestMeeting(mötesNamn, skapareNamn);
                    currentVMG.setComboBox(numberOfProposals);
                    currentVMG.setMeetingName(meetingName);
                    
                    
                    
                }
                if (click.getButton() == MouseEvent.BUTTON3) {
                    System.out.println("Höger");
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
            insertQuery1 = "INSERT INTO Godkänt_Mötesförslag (Användare_ID, Starttid, Sluttid, Svar, Förslags_ID, Datum) VALUES (" + CurrentUser.currentUser.getID() + ", '" + startTid1 + "', '" + slutTid1 + "', 'J', " + proposeID + ", '" + datum1 + "')";
            i = 1;
        }

        if (VoteMeetingGUI.cbMeeting2.isSelected()) {
            insertQuery2 = "INSERT INTO Godkänt_Mötesförslag (Användare_ID, Starttid, Sluttid, Svar, Förslags_ID, Datum) VALUES (" + CurrentUser.currentUser.getID() + ", '" + startTid2 + "', '" + slutTid2 + "', 'J', " + proposeID + ", '" + datum2 + "')";
            i = 2;
        }

        if (VoteMeetingGUI.cbMeeting3.isSelected()) {
            insertQuery2 = "INSERT INTO Godkänt_Mötesförslag (Användare_ID, Starttid, Sluttid, Svar, Förslags_ID, Datum) VALUES (" + CurrentUser.currentUser.getID() + ", '" + startTid3 + "', '" + slutTid3 + "', 'J', " + proposeID + ", '" + datum3 + "')";
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
        
    String deleteQuery = "DELETE FROM Förslag_Användare WHERE Användare_ID = "+ CurrentUser.currentUser.getID() + " AND Förslags_ID = "+ proposeID;
    
     try {
            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            st.execute(deleteQuery);
            
     } catch (Exception e){
         System.out.println(e);
     }

}

}
