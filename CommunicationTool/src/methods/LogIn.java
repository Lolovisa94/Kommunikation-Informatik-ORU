package Methods;

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
    
    public static void logIn(String email, String pw){
    
        ResultSet userInfo = null;
        if(fieldEmpty(email, pw)){
        
        } else {
        try{
        Statement st = ConnectionClass.conn.createStatement();
        String pwQuery = "SELECT * from Användare where Email = "+ "'" + email + "'";;
        
        userInfo = st.executeQuery(pwQuery);
        
        if(userInfo.next()){
        String dbPw = userInfo.getString("Lösenord");
        
            if (dbPw.equals(pw)){
                System.out.println(userInfo.getString(2) + " Logged In");
                User loggedInUser = new User(userInfo.getString(2), userInfo.getInt(3), 
                        userInfo.getString(4), userInfo.getString(5), userInfo.getString(6));

                    CurrentUser.currentUser = loggedInUser;  
                    new PageGUI().setVisible(true);
                    
                    
                    
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
    
    
