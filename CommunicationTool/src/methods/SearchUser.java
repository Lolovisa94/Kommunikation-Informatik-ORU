/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import Connectivity.ConnectionClass;
import Objects.CurrentUser;
import Validation.Validation;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author LovisaKampe
 */
public class SearchUser {
    Statement st;
    ResultSet queryResult = null;
    DefaultTableModel tableModel;

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

        Object columnNames[] = {"AnvändarID","Namn", "Telefon", "Email"};
        tableModel = new DefaultTableModel(columnNames, 0);
        
        String containsUsersQuery = "SELECT Användare_ID, Namn, Telefon, Email FROM `Användare` WHERE Namn LIKE '%" + searchText + "%';";
        
        try {
            queryResult = st.executeQuery(containsUsersQuery);
            
            // Iterates as long as there are rows left to process
            while (queryResult.next()) { 
                String anvandarID = queryResult.getString("Användare_ID");
                String namn = queryResult.getString("Namn");
                String telefon = queryResult.getString("Telefon");
                String email = queryResult.getString("Email");
                
                Object rowData[] = {anvandarID, namn, telefon, email};
                
                tableModel.addRow(rowData);
            }
            
            table.setModel(tableModel);
            TableColumn columnID = table.getColumnModel().getColumn(0);
            table.getColumnModel().removeColumn(columnID);
            
            
            if (table.getRowCount() > 0){
                usersFound = true;
            }
            
        } catch (SQLException e) {
            System.out.println("Database access error.");
            System.out.println(e.toString());
        } finally {
            // Closing the connection.
            try {
                st.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return usersFound;
    }
    
    //Method to get userID from the column AnvändarID that is hidden i the GUI.
    public String getUserID(int selectedRow) {
        String userID = tableModel.getValueAt(selectedRow, 0).toString();
        
        return userID;
    }
    
    public boolean removeUser(String email) {
        boolean userRemoved = false;
        String query = "delete from `Användare` where Email = '" + email + "';";
        String query2 = "SELECT Användare_ID FROM Användare WHERE Email = '" + email + "';";

        try {
            st = ConnectionClass.conn.createStatement();
            ResultSet rs = st.executeQuery(query2);
            if (rs.next()) {
                int id = rs.getInt("Användare_ID");
                String deleteQuery = "DELETE FROM Notifikation WHERE Användare_ID =" + id;

                st.execute(deleteQuery);
                st.execute(query);
                userRemoved = true;

            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return userRemoved;
    }
    
    
     public void getAllUsers(JTable table){
        
          try {
            st = ConnectionClass.conn.createStatement();
        }
        catch(Exception e)
        {
            System.out.println("Failed to create statement.");
            System.out.println(e.toString());
            
        }

        Object columnNames[] = {"Namn", "Telefon", "Email"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        
        String getAllUsersQuery = "SELECT Namn, Telefon, Email FROM `Användare` WHERE NOT Användare_ID = " + CurrentUser.currentUser.getID();
        
        try {
            queryResult = st.executeQuery(getAllUsersQuery);
            
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
        
        }
}
