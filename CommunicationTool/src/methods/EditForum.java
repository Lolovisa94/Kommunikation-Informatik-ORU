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
            String query1 = "delete from `Inlägg_Användare` where `Inlägg_Användare`.`Inlägg_ID` = (SELECT `Inlägg`.`Inlägg_ID` from `Inlägg` where titel = '"+title+"');";
            String query2 = "delete from `Inlägg` where titel = '"+title+"';";
           
            st.execute(query1);
            st.execute(query2);
            
            //SÄTT IN KOD ATT UPPDATERA JTABLE I PAGEGUI
         
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void updatePost(String update, String title, String time){
        try {
            Statement st = ConnectionClass.conn.createStatement();
            String query = "update `Inlägg` set text = '"+update+"' where titel = '"+title+"' and publiceringsTid = '"+time+"';";

            st.execute(query);
            
            //SÄTT IN KOD ATT UPPDATERA JTABLE HÄR
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
