/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mail;


import Objects.CurrentUser;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author ramin.aslami
 */
public class Mail {
    
       private static ArrayList<String> emailList = new ArrayList<String>(); 
       private static ArrayList<String> nameList = new ArrayList<String>();
         
    
    public void lagraEmail() {
        
        ResultSet userInfo = null;
        
       // boolean hasChanged = false;
        
        try {
                Statement st = Connectivity.ConnectionClass.conn.createStatement();
                String emailQuery = "SELECT  Användare.Namn, Användare.`Användare_ID`, Notifiering, Email FROM Notifikation Inner join Användare on Användare.`Användare_ID` = Notifikation.Notifikation_ID where Notifiering = 'J';";
                userInfo = st.executeQuery(emailQuery);
       
                // userInfo = st.executeQuery(pwQuery);

                int i = 0;
                while (userInfo.next()) {
                  
                    emailList.add(userInfo.getString("Email"));
                    nameList.add(userInfo.getString("Namn"));
                    
                   
                   
                    // Fånga email och telefonen av personen genom databasen                                 
   
                    i++;
                    
                }
                
                send_email_gmail seg = new send_email_gmail();
             //   seg.mail(emailList, nameList);
             seg.mail(emailList, nameList);
                
                //av kommentera om du vill skicka det som arraylisten har fångat
                
                
            } catch (Exception e) {

                System.out.println("termination");
            }
        
    }
    
    public void iterationMail() {
        
        for(int i = 0; i< emailList.size(); i++) {
            
            //SELECT  * FROM Notifikation Inner join Användare on Användare.`Användare_ID` = Notifikation.Notifikation_ID where Notifiering = 'J';
            System.out.println(emailList.get(i));
            
        }
        
    }
    
    public void iterationName() {
        
         for(int i = 0; i< nameList.size(); i++) {
            
            
            System.out.println(nameList.get(i));
            
        }
        
    }
    
}
