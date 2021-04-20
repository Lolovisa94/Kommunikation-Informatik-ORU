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
        
       // String pwQuery = "select Namn, StartTid, SlutTidtime, Datum from Kalender where Datum = " +  "'" + day + "'" + " and Användare_ID = " + CurrentUser.currentUser.getID();
        String q = "select Namn, StartTid, SlutTidTime, Beskrivning, Datum from Möte join Möte_Användare on Möte.`Möte_ID` = Möte_Användare.`Möte_ID` where Möte_Användare.`Användare_ID` = " + CurrentUser.currentUser.getID() + " and Datum = " + "'" + day +  "'" + " ORDER BY StartTid ASC";
            
//select * from Kalender join Möte_Kalender on Kalender.Kalender_ID = Möte_Kalender.Kalender_ID join Möte on Möte.`Möte_ID` = Möte_Kalender.`Möte_ID` join Användare on Användare.`Användare_ID` =
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
                JOptionPane.showMessageDialog(null, "Inget är inplanerat på det visade datumet");
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
        
       // String pwQuery = "select Namn, StartTid, SlutTidtime, Datum from Kalender where Datum = " +  "'" + day + "'" + " and Användare_ID = " + CurrentUser.currentUser.getID();
       String z = "select Namn, StartTid, SlutTidTime, Beskrivning, Datum from Möte where Publik = 'J' and Datum = '" + day + "'" + " ORDER BY StartTid ASC";
//select * from Kalender join Möte_Kalender on Kalender.Kalender_ID = Möte_Kalender.Kalender_ID join Möte on Möte.`Möte_ID` = Möte_Kalender.`Möte_ID` join Användare on Användare.`Användare_ID` =
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
                JOptionPane.showMessageDialog(null, "Inget är inplanerat på det visade datumet");
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
