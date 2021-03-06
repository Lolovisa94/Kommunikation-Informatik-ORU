/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import GUI.PostGUI;
import Objects.CurrentComments;
import Objects.CurrentUser;
import java.sql.Statement;
import javax.swing.JOptionPane;
import mail.Mail;

/**
 *
 * @author pierre
 */
public class PostComment {

    public static int postID;
    public static String date;

    public PostComment(int postID) {
        this.postID = postID;
        this.date = java.time.LocalDate.now().toString();
        postComment();
        PostGUI.clearMessage();
        new FetchComments(postID);

    }

    public void postComment() {
        int userID = CurrentUser.currentUser.getID();
        String commentText = GUI.CommentGUI.taCGText.getText();
        if (!Validation.Validation.fieldEmpty(commentText)) {
            if (!Validation.Validation.fieldTooLong(commentText, 100)) {
                String addCommentSQLQuery = "INSERT INTO Kommentarer (Text, Anv?ndare_ID, Inl?gg_ID, Datum) VALUES('" + commentText + " // " + CurrentUser.currentUser.getName() + "', " + userID + ", " + postID + ", '" + date + "')";
                try{
                Statement st = Connectivity.ConnectionClass.conn.createStatement();
                st.executeUpdate(addCommentSQLQuery);
                mail.Mail mail = new Mail();
                mail.commentsAndPost(postID);
                
                
                }catch (Exception e){
                    System.out.println(e);
                    JOptionPane.showMessageDialog(null, "N?got gick ordentligt fel, kontakta IT med felkod " + e);
                }
               
            } else {
                JOptionPane.showMessageDialog(null, "Kommentarer f?r max vara 100 tecken l?nga");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Du m?ste skriva n?got f?r att kommentera ;)");
        }
    }

}
