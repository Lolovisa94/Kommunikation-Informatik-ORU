/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;
import GUI.PageGUI;
import GUI.PostGUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author hamma
 */
import javax.swing.table.DefaultTableModel;
public class FetchPosts {

    private ResultSet rs = null;

    public FetchPosts(){
    
    postList();
    }
    

    public void postList() {
        boolean categorySelected = true;
        DefaultTableModel model = (DefaultTableModel) PageGUI.tblForum.getModel();
        model.setRowCount(0);
        String postsSQLQuery = "";

        if (PageGUI.cbFOvrigt.isSelected() && !PageGUI.cbFUtbildning.isSelected() && !PageGUI.cbFForskning.isSelected()) {

            postsSQLQuery = "SELECT i.titel, i.publiceringsdatum, k.namn AS Kategori, a.Namn AS Publicerare FROM Inlägg i INNER JOIN Kategori k ON k.kategori_id = i.kategori_id"
                    + " INNER JOIN Inlägg_Användare ia ON ia.Inlägg_ID = i.Inlägg_ID"
                    + " INNER JOIN Användare a ON a.Användare_ID = ia.Användare_ID"
                    + " WHERE k.namn = 'Allmänt'";
        } else if (!PageGUI.cbFOvrigt.isSelected() && PageGUI.cbFUtbildning.isSelected() && !PageGUI.cbFForskning.isSelected()) {
            postsSQLQuery = "SELECT i.titel, i.publiceringsdatum, k.namn AS Kategori, a.Namn AS Publicerare FROM Inlägg i INNER JOIN Kategori k ON k.kategori_id = i.kategori_id"
                    + " INNER JOIN Inlägg_Användare ia ON ia.Inlägg_ID = i.Inlägg_ID"
                    + " INNER JOIN Användare a ON a.Användare_ID = ia.Användare_ID"
                    + " WHERE k.namn = 'Utbildning'";

        } else if (!PageGUI.cbFOvrigt.isSelected() && !PageGUI.cbFUtbildning.isSelected() && PageGUI.cbFForskning.isSelected()) {
            postsSQLQuery = "SELECT i.titel, i.publiceringsdatum, k.namn AS Kategori, a.Namn AS Publicerare FROM Inlägg i INNER JOIN Kategori k ON k.kategori_id = i.kategori_id"
                    + " INNER JOIN Inlägg_Användare ia ON ia.Inlägg_ID = i.Inlägg_ID"
                    + " INNER JOIN Användare a ON a.Användare_ID = ia.Användare_ID"
                    + " WHERE k.namn = 'Forskning'";
        } else if (PageGUI.cbFOvrigt.isSelected() && PageGUI.cbFUtbildning.isSelected() && !PageGUI.cbFForskning.isSelected()) {
            postsSQLQuery = "SELECT i.titel, i.publiceringsdatum, k.namn AS Kategori, a.Namn AS Publicerare FROM Inlägg i INNER JOIN Kategori k ON k.kategori_id = i.kategori_id"
                    + " INNER JOIN Inlägg_Användare ia ON ia.Inlägg_ID = i.Inlägg_ID"
                    + " INNER JOIN Användare a ON a.Användare_ID = ia.Användare_ID"
                    + " WHERE k.namn = 'Allmänt' OR k.namn = 'Utbildning'";

        } else if (!PageGUI.cbFOvrigt.isSelected() && PageGUI.cbFUtbildning.isSelected() && PageGUI.cbFForskning.isSelected()) {
            postsSQLQuery = "SELECT i.titel, i.publiceringsdatum, k.namn AS Kategori, a.Namn AS Publicerare FROM Inlägg i INNER JOIN Kategori k ON k.kategori_id = i.kategori_id"
                    + " INNER JOIN Inlägg_Användare ia ON ia.Inlägg_ID = i.Inlägg_ID"
                    + " INNER JOIN Användare a ON a.Användare_ID = ia.Användare_ID"
                    + " WHERE k.namn = 'Forskning' OR k.namn = 'Utbildning'";

        } else if (PageGUI.cbFOvrigt.isSelected() && !PageGUI.cbFUtbildning.isSelected() && PageGUI.cbFForskning.isSelected()) {
            postsSQLQuery = "SELECT i.titel, i.publiceringsdatum, k.namn AS Kategori, a.Namn AS Publicerare FROM Inlägg i INNER JOIN Kategori k ON k.kategori_id = i.kategori_id"
                    + " INNER JOIN Inlägg_Användare ia ON ia.Inlägg_ID = i.Inlägg_ID"
                    + " INNER JOIN Användare a ON a.Användare_ID = ia.Användare_ID"
                    + " WHERE k.namn = 'Allmänt' OR k.namn = 'Forskning'";

        } else if (PageGUI.cbFOvrigt.isSelected() && PageGUI.cbFUtbildning.isSelected() && PageGUI.cbFForskning.isSelected()) {
            postsSQLQuery = "SELECT i.titel, i.publiceringsdatum, k.namn AS Kategori, a.Namn AS Publicerare FROM Inlägg i INNER JOIN Kategori k ON k.kategori_id = i.kategori_id"
                    + " INNER JOIN Inlägg_Användare ia ON ia.Inlägg_ID = i.Inlägg_ID"
                    + " INNER JOIN Användare a ON a.Användare_ID = ia.Användare_ID";

        } else {
            categorySelected = false;

        }
        if (categorySelected == true) {
            try {

                Statement st = Connectivity.ConnectionClass.conn.createStatement();

                rs = st.executeQuery(postsSQLQuery);

                while (rs.next()) {
                    String category = rs.getString("Kategori");
                    String title = rs.getString ("Titel");
                    String publisher = rs.getString("Publicerare");
                    String date = rs.getString("PubliceringsDatum");
                    
                    model.insertRow(PageGUI.tblForum.getRowCount(), new Object[] {category, title, publisher, date});
                    
                }
                mouseClicker();
            } catch (Exception e) {
                System.out.println(e);

            }
        }

    }
    public void openText()
    {
        try{
                Statement st = Connectivity.ConnectionClass.conn.createStatement();
                int row = PageGUI.tblForum.getSelectedRow();
                String test = PageGUI.tblForum.getValueAt(row, 1).toString();
                String getTextSQLQuery = "SELECT i.titel, i.text, i.publiceringsdatum, k.namn AS Kategori, a.Namn AS Publicerare, i.Inlägg_ID FROM Inlägg i INNER JOIN Kategori k ON k.kategori_id = i.kategori_id"
                    + " INNER JOIN Inlägg_Användare ia ON ia.Inlägg_ID = i.Inlägg_ID"
                    + " INNER JOIN Användare a ON a.Användare_ID = ia.Användare_ID"
                    + " WHERE i.titel = '" + test +"'";

                rs = st.executeQuery(getTextSQLQuery);
                rs.next();
                int postID = rs.getInt("Inlägg_ID");
                String publisher = rs.getString("Publicerare");
                String title = rs.getString("Titel");
                String postText = rs.getString("Text");
                new PostGUI(postID, publisher, title, postText).setVisible(true);
                        }
                catch(Exception e)
                {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "Något gick fel, vänligen kontakta admin. Felkod: "+ e);
                }
    }
    public void mouseClicker()
    {
        
        PageGUI.tblForum.addMouseListener(new MouseAdapter()
        {
            
            public void mouseClicked(MouseEvent click)
            {   
    
                if(click.getButton() == MouseEvent.BUTTON1)
                {
                    openText();
                }
                if(click.getButton()== MouseEvent.BUTTON3)
                {
                    System.out.println("Höger");
                }
            }

        });
       
    }
}
