/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Statement;
import java.sql.ResultSet;
import GUI.PostGUI;
import static java.lang.Integer.parseInt;
import java.lang.reflect.Array;

//implements Runnable 
public class FetchComments{

    private String[] messages = {};
    private int msgCounter = 0;
    private JPanel panel;
    private JScrollPane scrollPane;
    private Timer timer;
    private ResultSet rs = null;
    public static JFrame frame;
    private int postID;
//    private String[] commentIDs = {};
    private String[] commentLikes = {};
     private ResultSet rs2 = null;
     private String[] commentIDs = {};
//    private String commentID;
//    private String[] likes;
    

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new FetchComments());
//    }

    public FetchComments(int postID) {
//        timer();
        this.postID = postID;
        String[] nyMessages = {};
//        GUI.PostGUI.addMessage(nyMessages[0]);
//        this.msgCounter = 0;
        this.messages = nyMessages;
        getMessages();
        sortMessages();
        addMessages();
        

//        run();



    }

    public void getMessages() {
        try {

            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            int i = 0;
            String getCommentTextSQL = "SELECT Användare.Namn, Kommentarer.Text, Kommentarer.Kommentar_ID FROM Kommentarer Inner join Användare on Användare.Användare_ID = Kommentarer.Användare_ID Inner join Inlägg on Kommentarer.Inlägg_ID = Inlägg.Inlägg_ID where Kommentarer.Inlägg_ID=" + postID;
            
            rs = st.executeQuery(getCommentTextSQL);
            
            int size = 0;
            if (rs != null && !rs.isLast()) {
                
                while (rs.next()) {
                    
                    size++;


                }

            }
            messages = new String[size];
            commentIDs = new String [size];
            
            rs = st.executeQuery(getCommentTextSQL);
            while (rs.next()) {

                String text = rs.getString("Text");
                Integer commentID = rs.getInt("Kommentar_ID");

                messages[i] = text;
                commentIDs[i] =  commentID.toString();
                

//                String checkLikes = "SELECT COUNT(*) AS Total FROM Gilla_Kommentar WHERE Gillar = 'J' AND Kommentar_ID =" + commentID;
//                
//                
//                rs2 = st.executeQuery(checkLikes);
////                if (rs2 != null){
//                if(rs2.next()){
//
//                    String oneLike = rs2.getString("Total");
//                    commentLikes[i] = oneLike;
//                }
//                }
               
//                new FetchCommentLikes(commentID);
//                 commentIDs[i] = commentID.toString();


//                String user = rs.getString("Namn");
                i++;

            }
            
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    public void sortMessages(){
        int y = 0;
        String message;
        String commentID;
        int lastMessage = messages.length - 1;
        String[] orderMessages = new String[lastMessage + 1];
        String[] orderCommentIDs = new String[lastMessage + 1];
    while(0 <= lastMessage){
        commentID = Array.get(commentIDs, lastMessage).toString();
    
        message = Array.get(messages, lastMessage).toString();
        orderMessages[y] = message;
        orderCommentIDs[y] = commentID;

        lastMessage--;
        y++;
    }

    messages = orderMessages;
    commentIDs = orderCommentIDs;
    }
    
    
    public void addMessages(){
  
        while(msgCounter <  messages.length)        
            if (msgCounter < messages.length) { 
                    String likes = methods.FetchCommentLikes.getLikes(commentIDs[msgCounter]);
//                methods.FetchCommentLikes.getLikes();
                    GUI.PostGUI.addMessage(messages[msgCounter], likes, parseInt(commentIDs[msgCounter]));
                    msgCounter++;
                } 
    }
    
}
    
