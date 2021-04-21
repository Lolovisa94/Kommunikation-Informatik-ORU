/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import java.sql.Statement;
import com.sun.jdi.connect.spi.Connection;
import Connectivity.ConnectionClass;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author olive
 */
public class SuggestMeeting {
    Statement st;
    Statement st1;
    ResultSet rs=null;
    public SuggestMeeting(){
    
    
    }
    
    public void createSuggestion1(int creatorID, String namn, String beskrivning,String Startid1, String Sluttid1, String datum1){
    
    
    try{
     st =ConnectionClass.conn.createStatement();
     
   String createSuggestion="insert into Förslagstider(Namn, Beskrivning, Skapar_ID, Starttid1,Sluttid1, Datum1) values ('" + namn + "', " + "'" + beskrivning + "', " + "'" + creatorID + "', " + "'" + Startid1 + "', " + "'" + Sluttid1 + "', " + "'" + datum1 + "')" ;
   st.executeUpdate(createSuggestion);
    }catch(Exception e){
        
    }}


 public void createSuggestion2( int creatorID, String namn, String beskrivning,String Startid1, String Sluttid1, String datum1, String Starttid2, String Sluttid2, String Datum2){
    
    
    try{
     st =ConnectionClass.conn.createStatement();
     
   String createSuggestion="insert into Förslagstider(Namn, Beskrivning, Skapar_ID, Starttid1,Sluttid1, Datum1, Starttid2, Sluttid2, Datum2) values ('" + namn + "', " + "'" + beskrivning + "', " + "'" + creatorID +  "', " + "'" + Startid1 + "', " + "'" + Sluttid1 + "', " + "'" + datum1 + "', " + "'" +  Starttid2 + "', " + "'" +  Sluttid2 + "', " + "'" + Datum2 + "')" ;
        
   st.executeUpdate(createSuggestion);
    }catch(Exception e){
}
 }

 public void createSuggestion3(int creatorID, String namn, String beskrivning,String Startid1, String Sluttid1, String datum1, String Starttid2, String Sluttid2, String Datum2, String Starttid3, String Sluttid3, String Datum3){
    
    
    try{
     st =ConnectionClass.conn.createStatement();
     
   String createSuggestion="insert into Förslagstider(Namn, Beskrivning, Skapar_ID, Starttid1,Sluttid1, Datum1, Starttid2, Sluttid2, Datum2, Starttid3, Sluttid3, Datum3) values ('" + namn + "', " + "'" + beskrivning + "', " + "'" + creatorID + "', " + "'" + Startid1 + "', " + "'" + Sluttid1 + "', " + "'" + datum1 + "', " + "'" +  Starttid2 + "', " + "'" +  Sluttid2 + "', " + "'" + Datum2 + "', " + "'" + Starttid3 + "', " + "'" + Sluttid3 + "', " + "'" + Datum3 + "')" ;
      
   st.executeUpdate(createSuggestion);
    }catch(Exception e){
}
 }
 public void inviteOtherToMeeting(String email, int suggestID){
   int userID=0;
        try {
            st =ConnectionClass.conn.createStatement();
            //st1=ConnectionClass.conn.createStatement();
            String queryID= "select Användare_Id from Användare where email = '" + email + "'";
            rs=st.executeQuery(queryID);
            
            while(rs.next()){
                
                userID=rs.getInt("Användare_ID");
                        }
            String query="Insert into Förslag_Användare(Användare_ID, Förslags_ID) values (" + userID + ", " +  suggestID + ")"  ;
      
                    st.executeUpdate(query);
                       
        } catch (Exception e) {
           
        }
 }
     
   public int getSuggestedMeetingID() {
       int id=0;
       try {
            Statement st =Connectivity.ConnectionClass.conn.createStatement();
String getSuggestedMeetingID = "SELECT Förslags_ID FROM Förslagstider ORDER BY Förslags_ID DESC LIMIT 1";
rs=st.executeQuery(getSuggestedMeetingID);
while(rs.next())
    id=rs.getInt("Förslags_ID");
           
       } catch (Exception e) {
       }
     return id;
   }
   
   
   }
      
 
 




