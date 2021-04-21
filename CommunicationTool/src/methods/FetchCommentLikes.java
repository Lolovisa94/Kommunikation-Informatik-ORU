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
public class FetchCommentLikes{

//    private String[] likes = {};
    private int likeCounter = 0;
    private JPanel panel;
    private JScrollPane scrollPane;
    private Timer timer;
    public static ResultSet rs = null;
    public static JFrame frame;
//    private int commentID;
    

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new FetchComments());
//    }

    public FetchCommentLikes(int commentID) {
//        timer();
//        this.commentID = commentID;
        String[] nyLikes = {};
//        GUI.PostGUI.addMessage(nyMessages[0]);
//        this.msgCounter = 0;
//        this.likes = nyLikes;
//        getLikes();
//        sortLikes();
////        addLikes();
        
    }

    public static String getLikes(String commentID) {
        String likes = "0";
        
        try {
            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            int i = 0;
           String checkLike = "SELECT COUNT(*) AS Total FROM Gilla_Kommentar WHERE Gillar = 'J' AND Kommentar_ID =" + commentID;
            rs = st.executeQuery(checkLike);
            
            if (rs.next()){

                likes = rs.getString("Total");

            }
            
        } catch (Exception e) {
            System.out.println(e);
        }
        

        return likes;
    }
    

    
//    public String[] sortLikes(String [] likes){
//        
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
//    return orderLikes;
//    }
//    
//    public void addLikes(){
//        while(likeCounter <  likes.length)
//            if (likeCounter < likes.length) {
////                    GUI.PostGUI.addLike(likes[likeCounter]);
//                    likeCounter++;
//                } 
//    }
    
}
