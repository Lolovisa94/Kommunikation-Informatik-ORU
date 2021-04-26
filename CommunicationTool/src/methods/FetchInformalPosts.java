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
 * @author Patrik & Linus
 */

import javax.swing.table.DefaultTableModel;

public class FetchInformalPosts {
    
    private ResultSet rs = null;

    public FetchInformalPosts(){
    postList();
    mouseClicker();
    }
    
    public void openText()
    {
        try{
                Statement st = Connectivity.ConnectionClass.conn.createStatement();
                int row = PageGUI.tblInformelltForum.getSelectedRow();
                String test = PageGUI.tblInformelltForum.getValueAt(row, 1).toString();
                String getTextSQLQuery = "SELECT i.titel, i.text, i.publiceringsdatum, k.namn AS Kategori, a.Namn AS Publicerare, i.Inl�gg_ID FROM Inl�gg i INNER JOIN Kategori k ON k.kategori_id = i.kategori_id"
                    + " INNER JOIN Inl�gg_Anv�ndare ia ON ia.Inl�gg_ID = i.Inl�gg_ID"
                    + " INNER JOIN Anv�ndare a ON a.Anv�ndare_ID = ia.Anv�ndare_ID"
                    + " WHERE i.titel = '" + test +"'";

                rs = st.executeQuery(getTextSQLQuery);
                rs.next();
                int postID = rs.getInt("Inl�gg_ID");
                String publisher = rs.getString("Publicerare");
                String title = rs.getString("Titel");
                String postText = rs.getString("Text");
                new PostGUI(postID, publisher, title, postText).setVisible(true);
                        }
                catch(Exception e)
                {
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "N�got gick fel, v�nligen kontakta admin. Felkod: "+ e);
                }
    }
    
    
    public void mouseClicker()
    {
        
        PageGUI.tblInformelltForum.addMouseListener(new MouseAdapter()
        {
            
            public void mouseClicked(MouseEvent click)
            {   
    
                if(click.getButton() == MouseEvent.BUTTON1)
                {
                    openText();
                }
                if(click.getButton()== MouseEvent.BUTTON3)
                {
                    System.out.println("H�ger");
                }
            }

        });
       
        
        }
    
    public void postList()
        {
        DefaultTableModel model = (DefaultTableModel) PageGUI.tblInformelltForum.getModel();
        model.setRowCount(0);
        String postsSQLQuery = "";
        
            postsSQLQuery = "SELECT i.titel, i.publiceringsdatum, i.publiceringstid, k.namn AS Kategori, a.Namn AS Publicerare FROM Inl�gg i INNER JOIN Kategori k ON k.kategori_id = i.kategori_id"
                    + " INNER JOIN Inl�gg_Anv�ndare ia ON ia.Inl�gg_ID = i.Inl�gg_ID"
                    + " INNER JOIN Anv�ndare a ON a.Anv�ndare_ID = ia.Anv�ndare_ID"
                    + " WHERE k.namn = 'Informellt';";
            try {

                Statement st = Connectivity.ConnectionClass.conn.createStatement();

                rs = st.executeQuery(postsSQLQuery);

                while (rs.next()) {
                    String category = rs.getString("Kategori");
                    String title = rs.getString ("Titel");
                    String publisher = rs.getString("Publicerare");
                    String date = rs.getString("PubliceringsDatum") + ", kl. " + rs.getString("PubliceringsTid");
                    
                    model.insertRow(PageGUI.tblInformelltForum.getRowCount(), new Object[] {category, title, publisher, date});
                    
                }

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    
}
