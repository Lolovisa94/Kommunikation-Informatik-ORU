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
        
        System.out.println("getMessages fungerar om vi ser detta");
//        run();


        System.out.println("Run fungerar om vi ser detta");
    }

    public void getMessages() {
        try {
            System.out.println("1");
            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            int i = 0;
            String getCommentTextSQL = "SELECT Användare.Namn, Kommentarer.Text, Kommentarer.Kommentar_ID FROM Kommentarer Inner join Användare on Användare.Användare_ID = Kommentarer.Användare_ID Inner join Inlägg on Kommentarer.Inlägg_ID = Inlägg.Inlägg_ID where Kommentarer.Inlägg_ID=" + postID;
            
            
            rs = st.executeQuery(getCommentTextSQL);
            System.out.println("2");

            int size = 0;
            if (rs != null && !rs.isLast()) {
                while (rs.next()) {
                    size++;
                    System.out.println("size är lika med" + size);

                }

            }
            messages = new String[size];
//            commentLikes = new String[size];
//            commentIDs = new String[size];
            
            rs = st.executeQuery(getCommentTextSQL);
            while (rs.next()) {

                String text = rs.getString("Text");
                
                System.out.println("i är lika med" + i + text);
                messages[i] = text;
                
//                Integer commentID = rs.getInt("Kommentar_ID");
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
                System.out.println("i nr 2 är lika med" + i);

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
        int lastMessage = messages.length - 1;
        String[] orderMessages = new String[lastMessage + 1];

    while(0 <= lastMessage){

    
        message = Array.get(messages, lastMessage).toString();
        orderMessages[y] = message;

        System.out.println(message);
        System.out.println(lastMessage);
        System.out.println(y);
        lastMessage--;
        y++;
    }

    messages = orderMessages;
    }
    
//     public void getLikes() {
//        try {
//            Statement st = Connectivity.ConnectionClass.conn.createStatement();
//            int i = 0;
//           String checkLike = "SELECT COUNT(*) AS Total FROM Gilla_Kommentar WHERE Gillar = 'J' AND Kommentar_ID =" + commentID;
//            rs = st.executeQuery(checkLike);
//
//            int size = 0;
//            if (rs != null && !rs.isLast()) {
//                while (rs.next()) {
//                    size++;
//                    System.out.println("size är lika med" + size);
//
//                }
//
//            }
//            likes = new String[size];
//            
//            rs = st.executeQuery(checkLike);
//            while (rs.next()) {
//
//                String text = rs.getString("Total");
//
//                System.out.println("i är lika med" + i + text);
//                likes[i] = text;
//
//                System.out.println("i nr 2 är lika med" + i);
//
////                String user = rs.getString("Namn");
//                i++;
//
//            }
//            
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//    }
    
//    public void sortLikes(){
//        int y = 0;
//        String like;
//        int lastLike = likes.length - 1;
//        String[] orderLikes = new String[lastLike + 1];
//
//    while(0 <= lastLike){
//
//
//        like = Array.get(likes, lastLike).toString();
//        orderLikes[y] = like;
//
//        System.out.println(like);
//        System.out.println(lastLike);
//        System.out.println(y);
//        lastLike--;
//        y++;
//    }
//
//    likes = orderLikes;
//    }
    
    public void addMessages(){
        while(msgCounter <  messages.length)
            if (msgCounter < messages.length) {
                    GUI.PostGUI.addMessage(messages[msgCounter], "Like");
                    msgCounter++;
                } 
    }
    
}
    
