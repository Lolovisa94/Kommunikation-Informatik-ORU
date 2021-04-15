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
               
        System.out.println("1");
        if(fieldEmpty(email, pw)){
            System.out.println("2");
        } else {
        try{
        Statement st = ConnectionClass.conn.createStatement();
        String pwQuery = "SELECT * from Användare where Email = "+ "'" + email + "'";
            System.out.println("3");
        userInfo = st.executeQuery(pwQuery);
        
            System.out.println("4");
        if(userInfo.next()){
            System.out.println("5");
        String dbPw = userInfo.getString("Lösenord");
            System.out.println("6");
        
            if (dbPw.equals(pw)){
              
                System.out.println(userInfo.getString(2) + " Logged In");
                User loggedInUser = new User(userInfo.getInt(1), userInfo.getString(2), userInfo.getInt(3), 
                 userInfo.getString(4), userInfo.getString(5), userInfo.getString(6));
                System.out.println("7");
                    CurrentUser.currentUser = loggedInUser;  
              
                     String notisInfo = "Select * from Notifikation where Användare_ID = " + CurrentUser.currentUser.getID();
                     userInfo2= st.executeQuery(notisInfo);
                     System.out.println("8");
                     userInfo2.next();
                     System.out.println("9");
                     userInfo2.getString("Notifiering");
                        System.out.println("10");
                     CurrentUser.currentUser.setNotify(userInfo2.getString(2));   
                     System.out.println("11");
                     new PageGUI().setVisible(true);
                     logInSuccessful = true;
                    
        } else {
                System.out.println("Inloggning misslyckades");
                LogInGUI.setFelmeddelande("<html>Fel inloggningsuppgifter<br>försök igen</html>");
               
            }
        } else {
        System.out.println("Inloggning misslyckades, empty resultset");
                LogInGUI.setFelmeddelande("<html>Fel inloggningsuppgifter<br>försök igen</html>");
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
            LogInGUI.setFelmeddelande("<html>Du behöver fylla i Email<br>och Lösenord för att logga in</html>");
     
        } else if (Validation.fieldEmpty(email)){
            LogInGUI.setFelmeddelande("<html>Du behöver fylla i Email<br>för att logga in.</html>");
        
        } else if (Validation.fieldEmpty(pw)){
            LogInGUI.setFelmeddelande("<html>Du behöver fylla i Lösenord<br>för att logga in.</html>");
        }
        
        return isEmpty;

        }
    
    
        
        
    
        
    
    }
    
    
