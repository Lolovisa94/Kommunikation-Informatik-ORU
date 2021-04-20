/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import GUI.PageGUI;
import Objects.CurrentUser;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author Pierre
 */
public class LikePost {

    private ResultSet rs;
    private String query;
    private int postID;
    private int userID;
    public static boolean like;

    public LikePost(int postID) {
        this.postID = postID;
        this.userID = CurrentUser.currentUser.getID();
        this.like = false;
        likePost();

    }

    public void likePost() {
        setQuery();
        try {

            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            st.execute(query);

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public void setQuery() {

        if (checkLike(postID)) {

            if (like) {

                query = "UPDATE Gilla_Inlägg SET Gillar = 'N' WHERE Användare_ID =" + userID + " AND Inlägg_ID =" + postID;

            } else {

                query = "UPDATE Gilla_Inlägg SET Gillar = 'J' WHERE Användare_ID =" + userID + " AND Inlägg_ID =" + postID;

            }

        } else {

            query = "INSERT INTO Gilla_Inlägg (Gillar, Användare_ID, Inlägg_ID) VALUES('J' ," + userID + "," + postID + ")";

        }

    }

    public static boolean checkLike(int postID) {
        boolean hasLiked = false;
        String checkLike = "SELECT Gillar FROM Gilla_Inlägg WHERE Användare_ID = " + CurrentUser.currentUser.getID() + " AND Inlägg_ID = " + postID;
        ResultSet rsLike;
        try {

            Statement st = Connectivity.ConnectionClass.conn.createStatement();

            System.out.println("1");

            rsLike = st.executeQuery(checkLike);

            System.out.println("2");

            if (rsLike.next()) {

                System.out.println("3");

                if (rsLike.getString("Gillar").equals("J")) {

                    System.out.println("4");

                    hasLiked = true;

                    like = true;

                    System.out.println("5");

                } else {

                    like = false;
                    hasLiked = true;
                    System.out.println("6");
                }
            }

        } catch (Exception e) {
            System.out.println(e);

        }

        return hasLiked;
    }

    public static boolean checkLikeJN(int postID) {
        boolean Likes = false;
        String checkLike = "SELECT Gillar FROM Gilla_Inlägg WHERE Användare_ID = " + CurrentUser.currentUser.getID() + " AND Inlägg_ID = " + postID;
        ResultSet rsLike;

        try {

            Statement st = Connectivity.ConnectionClass.conn.createStatement();

            rsLike = st.executeQuery(checkLike);

            if (rsLike.next()) {

                if (rsLike.getString("Gillar").equals("J")) {

                    Likes = true;

                } else {

                    Likes = false;
                }
            }

        } catch (Exception e) {
            System.out.println(e);

        }

        return Likes;

    }

    public static int likeCounter(int postID) {

        int likeCounter = 0;

        String checkLike = "SELECT COUNT(*) AS Total FROM Gilla_Inlägg WHERE GIllar = 'J' AND Inlägg_ID =" + postID;
        ResultSet rsCount;
        try {

            Statement st = Connectivity.ConnectionClass.conn.createStatement();

            rsCount = st.executeQuery(checkLike);

            if (rsCount.next()) {

                likeCounter = rsCount.getInt("Total");

            }

        } catch (Exception e) {

            System.out.println(e);
        }

        return likeCounter;
    }
}
