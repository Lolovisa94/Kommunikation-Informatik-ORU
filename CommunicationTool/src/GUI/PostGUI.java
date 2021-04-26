/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Objects.CurrentComments;
import Objects.CurrentUser;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.io.File;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.text.DefaultCaret;
import methods.FetchCommentLikes;
import methods.FetchComments;
import methods.Filnamn;
import methods.LikePost;
import methods.SFPT;

/**
 *
 * @author pierre
 */
import javax.swing.ImageIcon;
import methods.LikeComment;

public class PostGUI extends javax.swing.JFrame {

    private String[] messages = {};
    private int msgCounter = 0;
//    public static JPanel panel;
    private JScrollPane scrollPane;
    private Timer timer;
    private ResultSet rs = null;
    public static JFrame frame;
    public static int postID;
    public static String publisher;
    public static String title;
    public static String postText;
    public static String user;
    public static boolean admin;
    public String fileObject;
    public boolean isLiked = false;
    public static int lblWidth;
    public static Dimension lblSize;
    public static JPanel commentNLike = new JPanel();
    public ImageIcon likeIcon = new ImageIcon(getClass().getResource("/Images/likeIcon.png"));
    public static ImageIcon likesIcon;

    /**
     * Creates new form PostGUI
     */
    public PostGUI(int postID, String publisher, String title, String postText) {

        this.postID = postID;
        this.publisher = publisher;
        this.title = title;
        this.postText = postText;
        Filnamn fil = new Filnamn();
        this.fileObject = fil.getFileObject(postID);
        System.out.println("filobjekt = " + fileObject);

        this.likesIcon = likeIcon;

        initComponents();
        new FetchComments(postID);
        btnPGUppdateraPost.setVisible(false);
        btnPGRedigera.setVisible(false);

        if (CurrentUser.currentUser.isAdmin() || CurrentUser.currentUser.getName().equals(publisher)) {
            btnPGRedigera.setVisible(true);
        }
        if (fileObject == null) {
            btnHämtaFil.setVisible(false);
        }

        if (LikePost.checkLike(postID)) {
            if (LikePost.checkLikeJN(postID)) {
                btnPGLike.setBackground(new java.awt.Color(202, 100, 91));
                isLiked = true;
            }

        }

        Integer nrLikes = LikePost.likeCounter(postID);
        lblPostLike.setText(nrLikes.toString());

    }

    public static void clearMessage() {
        panelBox.removeAll();
        panelBox.revalidate();
        panelBox.repaint();

    }

    public static void addMessage(String text, String likes, int commentID) {
        JTextArea label = new JTextArea();

        DefaultCaret caret = (DefaultCaret) label.getCaret();
        caret.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
        label.setText(text);
        label.setMaximumSize(new java.awt.Dimension(600, 600));
        label.setLineWrap(true);
        label.setOpaque(true);
        label.setBackground(new java.awt.Color(158, 174, 187));
        Border border = BorderFactory.createLineBorder(new java.awt.Color(77, 85, 92));
        label.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        JPanel btnCLike = new JPanel();
        if(methods.LikeComment.checkLikeJN(commentID)){
        btnCLike.setBackground(new java.awt.Color(202, 100, 91));
        
        } else{
        btnCLike.setBackground(new java.awt.Color(77, 85, 92));
        }
        btnCLike.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(202, 100, 91), 2, true));

        btnCLike.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCLikeMouseClicked(evt);
                new LikeComment(commentID);
                clearMessage();
                new FetchComments(postID);
//                String query = likeear.toString();
//                skrivUt(query);
            }
        });

        JLabel lblCommentLike = new JLabel();

        lblCommentLike.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N

        lblCommentLike.setForeground(new java.awt.Color(234, 234, 234));

        lblCommentLike.setIcon(likesIcon);

        lblCommentLike.setText(likes);

        btnCLike.add(lblCommentLike);

        panelBox.add(label);
        panelBox.add(btnCLike);

    }
    
    public static void skrivUt(String text){
    
        System.out.println(text);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taPostText = new javax.swing.JTextArea();
        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelBox = new javax.swing.JPanel();
        panel = new javax.swing.JPanel();
        lblUniversitet = new javax.swing.JLabel();
        lblOrebro = new javax.swing.JLabel();
        iconLogga = new javax.swing.JLabel();
        lblAuthor = new javax.swing.JLabel();
        btnPGComment = new javax.swing.JButton();
        btnPGRedigera = new javax.swing.JButton();
        btnPGUppdateraPost = new javax.swing.JButton();
        btnHämtaFil = new javax.swing.JButton();
        btnPGLike = new javax.swing.JPanel();
        lblPostLike = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(77, 85, 92));

        taPostText.setEditable(false);
        taPostText.setBackground(new java.awt.Color(158, 174, 187));
        taPostText.setColumns(20);
        taPostText.setForeground(new java.awt.Color(77, 85, 92));
        taPostText.setLineWrap(true);
        taPostText.setRows(5);
        taPostText.setText(postText);
        taPostText.setWrapStyleWord(true);
        jScrollPane2.setViewportView(taPostText);

        lblTitle.setBackground(new java.awt.Color(158, 174, 187));
        lblTitle.setFont(new java.awt.Font("Poppins Medium", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(158, 174, 187));
        lblTitle.setText(title);

        jScrollPane1.setBackground(new java.awt.Color(158, 174, 187));
        jScrollPane1.setAutoscrolls(true);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(panelBox);

        panelBox.setBackground(new java.awt.Color(158, 174, 187));
        panelBox.setAlignmentY(0.0F);
        panelBox.setAlignmentY(0.0F);
        panelBox.setLayout(new javax.swing.BoxLayout(panelBox, javax.swing.BoxLayout.PAGE_AXIS));

        panel.setBackground(new java.awt.Color(158, 174, 187));
        panel.setToolTipText("");
        panel.setRequestFocusEnabled(false);
        panel.setLayout(new javax.swing.BoxLayout(panel, javax.swing.BoxLayout.LINE_AXIS));
        panelBox.add(panel);
        panel.getAccessibleContext().setAccessibleName("");

        jScrollPane1.setViewportView(panelBox);

        lblUniversitet.setFont(new java.awt.Font("Poppins Medium", 1, 18)); // NOI18N
        lblUniversitet.setForeground(new java.awt.Color(202, 100, 91));
        lblUniversitet.setText("Örebro");

        lblOrebro.setFont(new java.awt.Font("Poppins Medium", 1, 18)); // NOI18N
        lblOrebro.setForeground(new java.awt.Color(202, 100, 91));
        lblOrebro.setText("Universitet");

        iconLogga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logga.png"))); // NOI18N

        lblAuthor.setBackground(new java.awt.Color(158, 174, 187));
        lblAuthor.setFont(new java.awt.Font("Poppins Medium", 1, 12)); // NOI18N
        lblAuthor.setForeground(new java.awt.Color(158, 174, 187));
        lblAuthor.setText(publisher);

        btnPGComment.setBackground(new java.awt.Color(0, 94, 125));
        btnPGComment.setForeground(new java.awt.Color(245, 245, 245));
        btnPGComment.setText("Kommentera");
        btnPGComment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPGCommentActionPerformed(evt);
            }
        });

        btnPGRedigera.setBackground(new java.awt.Color(0, 94, 125));
        btnPGRedigera.setForeground(new java.awt.Color(245, 245, 245));
        btnPGRedigera.setText("Redigera Post");
        btnPGRedigera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPGRedigeraActionPerformed(evt);
            }
        });

        btnPGUppdateraPost.setBackground(new java.awt.Color(0, 94, 125));
        btnPGUppdateraPost.setForeground(new java.awt.Color(245, 245, 245));
        btnPGUppdateraPost.setText("Uppdatera Post");
        btnPGUppdateraPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPGUppdateraPostActionPerformed(evt);
            }
        });

        btnHämtaFil.setBackground(new java.awt.Color(0, 94, 125));
        btnHämtaFil.setForeground(new java.awt.Color(245, 245, 245));
        btnHämtaFil.setText("Hämta bifogad fil");
        btnHämtaFil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHämtaFilActionPerformed(evt);
            }
        });

        btnPGLike.setBackground(new java.awt.Color(77, 85, 92));
        btnPGLike.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(202, 100, 91), 2, true));
        btnPGLike.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPGLikeMouseClicked(evt);
            }
        });

        lblPostLike.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        lblPostLike.setForeground(new java.awt.Color(234, 234, 234));
        lblPostLike.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/likeIcon.png"))); // NOI18N
        lblPostLike.setText("1");
        btnPGLike.add(lblPostLike);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(iconLogga)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblUniversitet)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblOrebro)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 396, Short.MAX_VALUE)
                                        .addComponent(btnPGComment, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTitle)
                                    .addComponent(lblAuthor))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnPGRedigera, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(btnPGUppdateraPost, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(btnHämtaFil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(63, 63, 63))
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPGLike, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblUniversitet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblOrebro)
                            .addComponent(btnPGComment))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPGRedigera)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPGUppdateraPost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnHämtaFil))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(iconLogga)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPGLike, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPGCommentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPGCommentActionPerformed
        // TODO add your handling code here:
        new CommentGUI(postID).setVisible(true);
    }//GEN-LAST:event_btnPGCommentActionPerformed

    private void btnPGRedigeraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPGRedigeraActionPerformed
        // TODO add your handling code here:
        taPostText.setEditable(true);
        btnPGUppdateraPost.setVisible(true);
    }//GEN-LAST:event_btnPGRedigeraActionPerformed

    private void btnPGUppdateraPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPGUppdateraPostActionPerformed
        // TODO add your handling code here:
        try {
            String newText = taPostText.getText();
            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            String query = "UPDATE `Inlägg` SET Text = '" + newText + "' where Titel = '" + title + "';";
            st.execute(query);

            btnPGUppdateraPost.setVisible(false);
            btnPGRedigera.setEnabled(false);
            taPostText.setEditable(false);
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btnPGUppdateraPostActionPerformed

    private void btnHämtaFilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHämtaFilActionPerformed
        // TODO add your handling code here:
        SFPT download = new SFPT();
        try {
            String home = System.getProperty("user.home");
            File file = new File(home + "/Downloads/" + fileObject);
            download.connect();
            download.download(fileObject, file.toString());
            download.disconnect();
        } catch (JSchException | SftpException ex) {
            Logger.getLogger(PostGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Filen: " + fileObject + " är nedladdad");
    }//GEN-LAST:event_btnHämtaFilActionPerformed

    private void btnPGLikeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPGLikeMouseClicked
        // TODO add your handling code here:

        if (isLiked) {
            btnPGLike.setBackground(new java.awt.Color(77, 85, 92));
            isLiked = false;
            new LikePost(postID);
        } else {
            btnPGLike.setBackground(new java.awt.Color(202, 100, 91));
            new LikePost(postID);
            isLiked = true;

        }
        Integer nrLikes = LikePost.likeCounter(postID);
        lblPostLike.setText(nrLikes.toString());

    }//GEN-LAST:event_btnPGLikeMouseClicked

    public static void btnCLikeMouseClicked(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PostGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PostGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PostGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PostGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PostGUI(postID, publisher, title, postText).setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHämtaFil;
    private javax.swing.JButton btnPGComment;
    private javax.swing.JPanel btnPGLike;
    private javax.swing.JButton btnPGRedigera;
    private javax.swing.JButton btnPGUppdateraPost;
    private javax.swing.JLabel iconLogga;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblOrebro;
    private javax.swing.JLabel lblPostLike;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblUniversitet;
    public static javax.swing.JPanel panel;
    public static javax.swing.JPanel panelBox;
    private javax.swing.JTextArea taPostText;
    // End of variables declaration//GEN-END:variables
}
