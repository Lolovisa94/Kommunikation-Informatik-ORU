/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import Connectivity.ConnectionClass;
import java.sql.Statement;

/**
 *
 * @author Linus
 */
public class EditForum {
        public static void removeThread(String title) {

        try {
            Statement st = ConnectionClass.conn.createStatement();
            String query1 = "delete from `Inl�gg_Anv�ndare` where `Inl�gg_Anv�ndare`.`Inl�gg_ID` = (SELECT `Inl�gg`.`Inl�gg_ID` from `Inl�gg` where titel = '"+title+"');";
            String query2 = "delete from `Inl�gg` where titel = '"+title+"';";
           
            st.execute(query1);
            st.execute(query2);
            
            //S�TT IN KOD ATT UPPDATERA JTABLE I PAGEGUI
         
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void updatePost(String update, String title, String time){
        try {
            Statement st = ConnectionClass.conn.createStatement();
            String query = "update `Inl�gg` set text = '"+update+"' where titel = '"+title+"' and publiceringsTid = '"+time+"';";

            st.execute(query);
            
            //S�TT IN KOD ATT UPPDATERA JTABLE H�R
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
