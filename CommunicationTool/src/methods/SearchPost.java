/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import Connectivity.ConnectionClass;
import GUI.PageGUI;
import Validation.Validation;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

/**
 *
 * @author FridaEriksson
 */
public class SearchPost {

    Statement st;
    ResultSet rs = null;

    public boolean findPost(String searchForumPost, JTable forumTable) {
        
        boolean postFound = false;

        try {
            st = ConnectionClass.conn.createStatement();
        } catch (Exception e) {
            System.out.println("");
            System.out.println(e);
            return postFound;
        }
        
        
        Object forumColumnNames[] = {"Kategori", "Titel", "Trådförfattare", "Publicerad"};
        DefaultTableModel model = new DefaultTableModel(forumColumnNames, 0);

        String containsForumQuery = "SELECT i.titel, i.publiceringsdatum, i.publiceringstid, k.namn AS Kategori, a.Namn AS Publicerare FROM Inlägg i INNER JOIN Kategori k ON k.kategori_id = i.kategori_id"
                    + " INNER JOIN Inlägg_Användare ia ON ia.Inlägg_ID = i.Inlägg_ID"
                    + " INNER JOIN Användare a ON a.Användare_ID = ia.Användare_ID"
                    + " WHERE i.titel LIKE '%" + searchForumPost + "%';";

        try {
            rs = st.executeQuery(containsForumQuery);

            // Itererar igenom tills det inte finns några rader kvar att iterera
            while (rs.next()) {
                String kategori = rs.getString("Kategori");
                String titel = rs.getString("Titel");
                String text = rs.getString("Publicerare");
                String publicerad = rs.getString("Publiceringsdatum") + ", kl. " + rs.getString("Publiceringstid");
                

//                String kategorinamnQuery = "SELECT namn from Kategori where Kategori_ID = " + kategoriID + ";";
//
//                rs = st.executeQuery(kategorinamnQuery);
//
//                String kategori = "";
//
//                while (rs.next()) {
//                    kategori = rs.getString("Namn");
//                }
                Object rowData[] = {kategori, titel, text, publicerad};

                model.addRow(rowData);
                 
            }

            forumTable.setModel(model);
            if (forumTable.getRowCount() > 0) {
                postFound = true;
            }
        } catch (SQLException e) {
            System.out.println("Felmeddelande");
            System.out.println(e);
        } finally {
            try {
                st.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
        
        return postFound;

    }
}
