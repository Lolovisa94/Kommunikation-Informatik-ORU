/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import Objects.CurrentUser;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pierre
 */
public class DecideMeeting {


    public DecideMeeting(JTable table) {
        
        fillMeetingDecideTable(table);
    }
    
    
 
    
    
public void fillMeetingDecideTable(JTable table){   
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

                
                System.out.println("Sout ppID" +proposeID);

                Object rowData[] = {mötesnamn, votes};

                model.addRow(rowData);
            }

        } catch (Exception e) {

        }
        table.setModel(model);

    }
    
    public int getMeetingVotes(int proposeID){
    int total = 0;
    ResultSet rsGMV = null;
    
    String sqlCountQuery = "SELECT COUNT(DISTINCT Användare_ID) AS Total FROM Godkänt_Mötesförslag gm INNER JOIN Förslagstider ft on ft.Förslags_ID = gm.Förslags_ID WHERE Skapar_ID =" + CurrentUser.currentUser.getID() + " AND ft.Förslags_ID = " + proposeID;
    
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
}
