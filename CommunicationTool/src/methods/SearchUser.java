/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import Connectivity.ConnectionClass;
import Validation.Validation;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LovisaKampe
 */
public class SearchUser {
    Statement st;
    ResultSet queryResult = null;

    public boolean findUsers(String searchText, JTable table){
        if(!Validation.isValidatedName(searchText)) {
            return false;
        }
        
        boolean usersFound = false;
        
        try {
            st = ConnectionClass.conn.createStatement();
        }
        catch(Exception e)
        {
            System.out.println("Failed to create statement.");
            System.out.println(e.toString());
            return usersFound;
        }

        Object columnNames[] = {"Namn", "Telefon", "Email"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        
        String containsUsersQuery = "SELECT Namn, Telefon, Email FROM `Användare` WHERE Namn LIKE '%" + searchText + "%';";
        
        try {
            queryResult = st.executeQuery(containsUsersQuery);
            
            // Iterates as long as there are rows left to process
            while (queryResult.next()) {                
                String namn = queryResult.getString("Namn");
                String telefon = queryResult.getString("Telefon");
                String email = queryResult.getString("Email");
                
                Object rowData[] = {namn, telefon, email};
                
                model.addRow(rowData);
            }
            table.setModel(model);
            
            if (table.getRowCount() > 0){
                usersFound = true;
            }
            //table.setPreferredScrollableViewportSize(table.getPreferredSize());
            //table.setFillsViewportHeight(true);
            
        } catch (SQLException e) {
            System.out.println("Database access error.");
            System.out.println(e.toString());
        } finally {
            // We have to close the connection and release the resources used.
            // Closing the statement results in closing the resultSet as well.
            try {
                st.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return usersFound;
    }
    
    
        public boolean removeUser(String email)
    {
        boolean userRemoved = false;
        String query = "delete from `Användare` where Email = '"+email+"';";
        String query2 = "SELECT Användare_ID FROM Användare WHERE Email = '" + email +"';"; 

        
        try{
            st = ConnectionClass.conn.createStatement();
            ResultSet rs = st.executeQuery(query2); 
            if(rs.next()){
            int id = rs.getInt("Användare_ID");
            String deleteQuery = "DELETE FROM Notifikation WHERE Användare_ID =" + id;
            
            st.execute(deleteQuery);
            st.execute(query);
            userRemoved = true;
            
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        return userRemoved;
    }
    
}
