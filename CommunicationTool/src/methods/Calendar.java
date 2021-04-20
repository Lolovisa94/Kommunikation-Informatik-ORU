/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import Connectivity.ConnectionClass;
import GUI.PageGUI;
import static GUI.PageGUI.lblKalenderFelText;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import Objects.CurrentUser;
import javax.swing.JOptionPane;

/**
 *
 * @author ramin.aslami
 */
public class Calendar {
    
    
    public void privateCalendar(JTable table, String day) {
    
    //PageGUI p = new PageGUI();
    Statement st;
    ResultSet queryResult = null;
        
        Object columnNames[] = {"Namn", "StartTid", "SlutTidTime", "Beskrivning", "Datum"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        
       // String pwQuery = "select Namn, StartTid, SlutTidtime, Datum from Kalender where Datum = " +  "'" + day + "'" + " and Anv�ndare_ID = " + CurrentUser.currentUser.getID();
        String q = "select Namn, StartTid, SlutTidTime, Beskrivning, Datum from M�te join M�te_Anv�ndare on M�te.`M�te_ID` = M�te_Anv�ndare.`M�te_ID` where M�te_Anv�ndare.`Anv�ndare_ID` = " + CurrentUser.currentUser.getID() + " and Datum = " + "'" + day +  "'" + " ORDER BY StartTid ASC";
            
//select * from Kalender join M�te_Kalender on Kalender.Kalender_ID = M�te_Kalender.Kalender_ID join M�te on M�te.`M�te_ID` = M�te_Kalender.`M�te_ID` join Anv�ndare on Anv�ndare.`Anv�ndare_ID` =
        try {
            
            
            
            st = ConnectionClass.conn.createStatement();
            queryResult = st.executeQuery(q);
            
             
            
            // Iterates as long as there are rows left to process
            
            if (queryResult.next()) {
                
                do {
                    
                String namn = queryResult.getString("Namn");
                String starttid = queryResult.getString("StartTid");
                String sluttid = queryResult.getString("SlutTidTime");
                String beskrivning = queryResult.getString("Beskrivning");
                String datum = queryResult.getString("Datum");
                
                Object rowData[] = {namn, starttid, sluttid, beskrivning, datum};
                
                model.addRow(rowData);
                
                    
                } while (queryResult.next());
                
            } else {
                
                System.out.println("inga resultat");
                JOptionPane.showMessageDialog(null, "Inget �r inplanerat p� det visade datumet");
                 //PageGUI.felmeddelandeText();
                //System.out.println(PageGUI.lblKalenderFelText.getText());
            }
            
            
            
            
            
            
            table.setModel(model);
            st.close();
            
            
            //table.setPreferredScrollableViewportSize(table.getPreferredSize());
            //table.setFillsViewportHeight(true);
            
        } catch (SQLException e) {
            System.out.println("Database access error.");
            System.out.println(e.toString());
        } 
        
    
    
}
    
    public void publicCalendar(JTable table, String day) {
    
    //PageGUI p = new PageGUI();
    Statement st;
    ResultSet queryResult = null;
        
        Object columnNames[] = {"Namn", "StartTid", "SlutTidTime", "Beskrivning", "Datum"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        
       // String pwQuery = "select Namn, StartTid, SlutTidtime, Datum from Kalender where Datum = " +  "'" + day + "'" + " and Anv�ndare_ID = " + CurrentUser.currentUser.getID();
       String z = "select Namn, StartTid, SlutTidTime, Beskrivning, Datum from M�te where Publik = 'J' and Datum = '" + day + "'" + " ORDER BY StartTid ASC";
//select * from Kalender join M�te_Kalender on Kalender.Kalender_ID = M�te_Kalender.Kalender_ID join M�te on M�te.`M�te_ID` = M�te_Kalender.`M�te_ID` join Anv�ndare on Anv�ndare.`Anv�ndare_ID` =
        try {
  
            st = ConnectionClass.conn.createStatement();
            queryResult = st.executeQuery(z);
            // Iterates as long as there are rows left to process
            
            if (queryResult.next()) {
                
                do {
                    
                String namn = queryResult.getString("Namn");
                String starttid = queryResult.getString("StartTid");
                String sluttid = queryResult.getString("SlutTidTime");
                String beskrivning = queryResult.getString("Beskrivning");
                String datum = queryResult.getString("Datum");
                
                Object rowData[] = {namn, starttid, sluttid, beskrivning, datum};
                
                model.addRow(rowData);
                
                    
                } while (queryResult.next());
                
            } else {
                
                System.out.println("inga resultat");
                JOptionPane.showMessageDialog(null, "Inget �r inplanerat p� det visade datumet");
                 //PageGUI.felmeddelandeText();
                //System.out.println(PageGUI.lblKalenderFelText.getText());
            }
            
            
            
            
            
            
            table.setModel(model);
            st.close();
            
            
            //table.setPreferredScrollableViewportSize(table.getPreferredSize());
            //table.setFillsViewportHeight(true);
            
        } catch (SQLException e) {
            System.out.println("Database access error.");
            System.out.println(e.toString());
        } 
        
    
    
}
    
    
   
    
    
    
}
