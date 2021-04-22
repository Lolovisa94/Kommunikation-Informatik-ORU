package methods;

/*
 * To change this license header, choose License Headers inIP Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template inIP the editor.
 */

import Validation.Validation;
import Objects.CurrentUser;
import Connectivity.ConnectionClass;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import GUI.LogInGUI;
import GUI.PageGUI;
import com.mysql.cj.util.StringUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
/**
 *
 * @author Pierre
 */
public class LogIn {
    private static User loggedInUser;
    private static boolean logInSuccessful;

    public static boolean logIn(String email, String pw) {
        logInSuccessful = false;
        ResultSet userInfo = null;
        ResultSet userInfo2 = null;

        System.out.println("1");
        if (fieldEmpty(email, pw)) {
            System.out.println("2");
        } else {
            try {
                Statement st = ConnectionClass.conn.createStatement();
                String pwQuery = "SELECT * from Användare where Email = " + "'" + email + "'";
                System.out.println("3");
                userInfo = st.executeQuery(pwQuery);

                System.out.println("4");
                if (userInfo.next()) {
                    System.out.println("5");
                    String dbPw = userInfo.getString("Lösenord");
                    System.out.println("6");

                    if (dbPw.equals(pw)) {

                        System.out.println(userInfo.getString(2) + " Logged In");
                        loggedInUser = new User(userInfo.getInt(1), userInfo.getString(2), userInfo.getInt(3),
                                userInfo.getString(4), userInfo.getString(5), userInfo.getString(6));
                        System.out.println("7");
                        CurrentUser.currentUser = loggedInUser;

                        String notisInfo = "Select * from Notifikation where Användare_ID = " + CurrentUser.currentUser.getID();
                        userInfo2 = st.executeQuery(notisInfo);
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

            } catch (Exception e) {
                System.out.println(e);
            }

        }
        return logInSuccessful;

    }

    public static boolean fieldEmpty(String email, String pw) {

        boolean isEmpty = false;

        if (Validation.fieldEmpty(email) && Validation.fieldEmpty(pw)) {
            LogInGUI.setFelmeddelande("<html>Du behöver fylla i Email<br>och Lösenord för att logga in</html>");

        } else if (Validation.fieldEmpty(email)) {
            LogInGUI.setFelmeddelande("<html>Du behöver fylla i Email<br>för att logga in.</html>");

        } else if (Validation.fieldEmpty(pw)) {
            LogInGUI.setFelmeddelande("<html>Du behöver fylla i Lösenord<br>för att logga in.</html>");
        }

        return isEmpty;

    }
    
    public static void setLoggedInUserLoginLocationAndTime() throws Exception {
        int loggedInUserID = loggedInUser.getID();        

        //Hämtar datum och tid för senaste inloggning
        String latestLogIn = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        System.out.print(latestLogIn);
        
        //Hämtar IP-adressen.
        URL userIP = new URL("http://checkip.amazonaws.com");
        BufferedReader inIP = null;
        String ip = "";
        try {
            inIP = new BufferedReader(new InputStreamReader(
                    userIP.openStream()));
            ip = inIP.readLine();
            System.out.print(ip);
        } finally {
            if (inIP != null) {
                try {
                    inIP.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        //Hämtar longitud och latitud från IP-adressen.
        //API access key: 46828498e782c6fd94a2ca1e902f402b
        String latitude = "";
        String longitude = "";
        String LatestLogInLocation = "";
        String locationJSON = "";
        
        //URL userLocationLatitude = new URL("http://api.ipstack.com/" + ip + "?access_key=46828498e782c6fd94a2ca1e902f402b&fields=latitude");
        URL userLocation = new URL("http://geoplugin.net/json.gp?ip=" + ip);
        BufferedReader inLocation = null;


        try {
            inLocation= new BufferedReader(new InputStreamReader(
                    userLocation.openStream()));
            String currentLine = "";
//            do {
//                currentLine = inLocation.readLine();
//                locationJSON += currentLine;
//            } while (!(currentLine == "}" || currentLine == null));
            while(!currentLine.equalsIgnoreCase("}")) {
                currentLine = inLocation.readLine();
                locationJSON += currentLine;
            }
            System.out.print(ip);
            
        } finally {
            if (inLocation != null) {
                try {
                    inLocation.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        JSONParser parser = new JSONParser();
        try{
            Object obj = parser.parse(locationJSON);
            JSONObject locationObject = (JSONObject)obj;
            latitude = locationObject.get("geoplugin_latitude").toString();
            longitude = locationObject.get("geoplugin_longitude").toString();
        } catch (ParseException e) {
            System.out.println(e);
        }
        
        LatestLogInLocation = latitude + "," + longitude;
        
        Statement st;
        ResultSet queryResult = null;
        try {
            st = ConnectionClass.conn.createStatement();
        }
        catch(Exception e)
        {
            System.out.println("Failed to create statement.");
            System.out.println(e.toString());
            return;
        }

        String updateUserLoginInformation = "UPDATE Användare set Kordninater = '" + LatestLogInLocation + "', Datum= '" + latestLogIn + "' where Användare_ID = " + loggedInUserID + ";";
        
         try {
            st.executeUpdate(updateUserLoginInformation);
            
         } catch(SQLException e) {
            System.out.println("Database access error.");
            System.out.println(e);
         } 
    }
}

    
    
