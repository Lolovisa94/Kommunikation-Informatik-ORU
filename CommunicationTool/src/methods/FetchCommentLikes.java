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

    private String[] likes = {};
    private int likeCounter = 0;
    private JPanel panel;
    private JScrollPane scrollPane;
    private Timer timer;
    private ResultSet rs = null;
    public static JFrame frame;
    private int commentID;
    

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new FetchComments());
//    }

    public FetchCommentLikes(int commentID) {
//        timer();
        this.commentID = commentID;
        String[] nyLikes = {};
//        GUI.PostGUI.addMessage(nyMessages[0]);
//        this.msgCounter = 0;
        this.likes = nyLikes;
//        getLikes();
//        sortLikes();
////        addLikes();
        
    }

    public void getLikes() {
        try {
            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            int i = 0;
           String checkLike = "SELECT COUNT(*) AS Total FROM Gilla_Kommentar WHERE Gillar = 'J' AND Kommentar_ID =" + commentID;
            rs = st.executeQuery(checkLike);

            int size = 0;
            if (rs != null && !rs.isLast()) {
                while (rs.next()) {
                    size++;
                    System.out.println("size är lika med" + size);

                }

            }
            likes = new String[size];
            
            rs = st.executeQuery(checkLike);
            while (rs.next()) {

                String text = rs.getString("Total");

                System.out.println("i är lika med" + i + text);
                likes[i] = text;

                System.out.println("i nr 2 är lika med" + i);

                i++;
            }
            
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    

    
    public String[] sortLikes(){
        
        int y = 0;
        String like;
        int lastLike = likes.length - 1;
        String[] orderLikes = new String[lastLike + 1];

    while(0 <= lastLike){


        like = Array.get(likes, lastLike).toString();
        orderLikes[y] = like;

        System.out.println(like);
        System.out.println(lastLike);
        System.out.println(y);
        lastLike--;
        y++;
    }

    likes = orderLikes;
    return orderLikes;
    }
    
    public void addLikes(){
        while(likeCounter <  likes.length)
            if (likeCounter < likes.length) {
//                    GUI.PostGUI.addLike(likes[likeCounter]);
                    likeCounter++;
                } 
    }
    
}
