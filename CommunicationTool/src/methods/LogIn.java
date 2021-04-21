package methods;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Validation.Validation;
import Objects.CurrentUser;
import Connectivity.ConnectionClass;
import java.sql.Statement;
import java.sql.ResultSet;
import GUI.LogInGUI;
import GUI.PageGUI;
/**
 *
 * @author Pierre
 */
public class LogIn {
    
    public static boolean logIn(String email, String pw){
    boolean logInSuccessful = false;
        ResultSet userInfo = null;
        ResultSet userInfo2 = null;
               

        if(fieldEmpty(email, pw)){

        } else {
        try{
        Statement st = ConnectionClass.conn.createStatement();
        String pwQuery = "SELECT * from Anv�ndare where Email = "+ "'" + email + "'";

        userInfo = st.executeQuery(pwQuery);
        

        if(userInfo.next()){

        String dbPw = userInfo.getString("L�senord");

        
            if (dbPw.equals(pw)){
              
                System.out.println(userInfo.getString(2) + " Logged In");
                User loggedInUser = new User(userInfo.getInt(1), userInfo.getString(2), userInfo.getInt(3), 
                 userInfo.getString(4), userInfo.getString(5), userInfo.getString(6));

                    CurrentUser.currentUser = loggedInUser;  
              
                     String notisInfo = "Select * from Notifikation where Anv�ndare_ID = " + CurrentUser.currentUser.getID();
                     userInfo2= st.executeQuery(notisInfo);

                     userInfo2.next();

                     userInfo2.getString("Notifiering");

                     CurrentUser.currentUser.setNotify(userInfo2.getString(2));   

                     new PageGUI().setVisible(true);
                     logInSuccessful = true;
                    
        } else {
                System.out.println("Inloggning misslyckades");
                LogInGUI.setFelmeddelande("<html>Fel inloggningsuppgifter<br>f�rs�k igen</html>");
               
            }
        } else {
        System.out.println("Inloggning misslyckades, empty resultset");
                LogInGUI.setFelmeddelande("<html>Fel inloggningsuppgifter<br>f�rs�k igen</html>");
        }
        
        }catch (Exception e) {
		System.out.println(e);
	}
        
        }
        return logInSuccessful;
        
    }
    
    
    public static boolean fieldEmpty (String email, String pw){
        
        boolean isEmpty = false;
        
        if (Validation.fieldEmpty(email) && Validation.fieldEmpty(pw)){
            LogInGUI.setFelmeddelande("<html>Du beh�ver fylla i Email<br>och L�senord f�r att logga in</html>");
     
        } else if (Validation.fieldEmpty(email)){
            LogInGUI.setFelmeddelande("<html>Du beh�ver fylla i Email<br>f�r att logga in.</html>");
        
        } else if (Validation.fieldEmpty(pw)){
            LogInGUI.setFelmeddelande("<html>Du beh�ver fylla i L�senord<br>f�r att logga in.</html>");
        }
        
        return isEmpty;

        }
    
    
        
        
    
        
    
    }
    
    
