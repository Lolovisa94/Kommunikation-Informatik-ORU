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
       private static ArrayList<String> commentList = new ArrayList<String>();      
       private static String creatorOfPost;
       private static String emailOfCreator;
    
    public void lagraEmail() {
        
        ResultSet userInfo = null;
        
       // boolean hasChanged = false;
        
        try {
                Statement st = Connectivity.ConnectionClass.conn.createStatement();
                String emailQuery = "SELECT  Anv�ndare.Namn, Anv�ndare.`Anv�ndare_ID`, Notifiering, Email FROM Notifikation Inner join Anv�ndare on Anv�ndare.`Anv�ndare_ID` = Notifikation.Notifikation_ID where Notifiering = 'J';";
                userInfo = st.executeQuery(emailQuery);
       
                // userInfo = st.executeQuery(pwQuery);

                int i = 0;
                while (userInfo.next()) {
                  
                    emailList.add(userInfo.getString("Email"));
                    nameList.add(userInfo.getString("Namn"));
                    
                   
                   
                    // F�nga email och telefonen av personen genom databasen                                 
   
                    i++;
                    
                }
                
                send_email_gmail seg = new send_email_gmail();
             //   seg.mail(emailList, nameList);
             seg.mail(emailList, nameList);
                
                //av kommentera om du vill skicka det som arraylisten har f�ngat
                
                
            } catch (Exception e) {

                System.out.println("termination");
            }
        
    }
    
    public void iterationMail() {
        
        for(int i = 0; i< emailList.size(); i++) {
            
            //SELECT  * FROM Notifikation Inner join Anv�ndare on Anv�ndare.`Anv�ndare_ID` = Notifikation.Notifikation_ID where Notifiering = 'J';
            System.out.println(emailList.get(i));
            
        }
        
    }
    
    public void iterationName() {
        
         for(int i = 0; i< nameList.size(); i++) {
            
            
            System.out.println(nameList.get(i));
            
        }
        
    }
    
    public void commentsAndPost(int postID) {
        
        ResultSet userInfo1 = null;
        ResultSet userInfo2 = null;
        
        try {
                Statement st = Connectivity.ConnectionClass.conn.createStatement();
                System.out.println(postID);
                //f�nga skapare av tr�den
                String creatorPost = "select Anv�ndare.Email, Inl�gg.Titel, Anv�ndare.Namn, Anv�ndare.Anv�ndare_ID from Anv�ndare join Inl�gg_Anv�ndare on Anv�ndare.`Anv�ndare_ID` = Inl�gg_Anv�ndare.`Anv�ndare_ID` join Inl�gg on Inl�gg.`Inl�gg_ID` = Inl�gg_Anv�ndare.`Inl�gg_ID` join Notifikation on Anv�ndare.`Anv�ndare_ID` = Notifikation.`Anv�ndare_ID` where Inl�gg.`Inl�gg_ID` = " +  postID + " and Notifiering = 'J'";
                // f�nga kommentarsf�rfattarna
                String commentatorsPost = "select Distinct Anv�ndare.Email, Inl�gg.Titel, Anv�ndare.Namn, Kommentarer.`Anv�ndare_ID` from Anv�ndare join Kommentarer on Kommentarer.`Anv�ndare_ID` = Anv�ndare.`Anv�ndare_ID` join Inl�gg on Inl�gg.`Inl�gg_ID` = Kommentarer.`Inl�gg_ID` where Kommentarer.`Inl�gg_ID` = " + postID;
                // select Distinct Anv�ndare.Email, Inl�gg.Titel, Anv�ndare.Namn, Kommentarer.`Anv�ndare_ID` from Anv�ndare join Kommentarer on Kommentarer.`Anv�ndare_ID` = Anv�ndare.`Anv�ndare_ID` join Inl�gg on Inl�gg.`Inl�gg_ID` = Kommentarer.`Inl�gg_ID` join Notifikation on Anv�ndare.`Anv�ndare_ID` = Notifikation.`Anv�ndare_ID` where Inl�gg.`Inl�gg_ID` = 110 and Notifiering = 'J';

                userInfo1 = st.executeQuery(creatorPost);

            
            if (userInfo1.next()) {
             
//                int sk = userInfo1.getInt(2);
//                System.out.println(sk);

                creatorOfPost = userInfo1.getString("Inl�gg.Titel");
                emailOfCreator = userInfo1.getString("Anv�ndare.Email");
                   System.out.println(creatorPost);
                
                int i = 0;
                
                userInfo2 = st.executeQuery(commentatorsPost);
                while (userInfo2.next()) {                    
                    
                    System.out.println("hej");
                    commentList.add(userInfo2.getString("Anv�ndare.Email"));
                    i++;
                    
                    System.out.println("det funkar");
                }
                
                if (!commentList.contains(emailOfCreator)) {
                    
                    commentList.add(emailOfCreator);
                    System.out.println("inlagd");
     
                    
                }
                
                else {
                    
                    System.out.println("finns redan");
                    
                }
                
                send_email_gmail seg = new send_email_gmail();
                seg.mailComments(creatorOfPost, commentList);
                 
                
                
            }
            
            else {
                
                System.out.println("kontakta Kai!");
                
            }
  
            
                
            } catch (Exception e) {

                System.out.println("termination");
            }
        
    }
    
}
