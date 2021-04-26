/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.SftpException;
import java.io.File;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JFileChooser;
import methods.CreatePost;
import methods.FetchPosts;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import methods.Inlagg;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import methods.Filnamn;
import methods.SFPT;

/**
 *
 * @author Pierre
 */
public class CreatePostGUI extends javax.swing.JFrame {

    private ResultSet rs = null;
    private String filename;

    /**
     * Creates new form CreatePostGUI
     */
    public CreatePostGUI() {
        initComponents();
        fillCategories();

    }

    private void fillCategories() {
        try {
            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            String categorySQL = "SELECT Namn FROM Kategori";
            rs = st.executeQuery(categorySQL);
            while (rs.next()) {
                cbCategory.addItem(rs.getString("Namn"));
            }
        } catch (Exception e) {

        }
    }

    public static String textField() {

        String text = taText.getText();
        textEmpty = Validation.Validation.fieldEmpty(text);
        textTooLong = Validation.Validation.fieldTooLong(text, 8000);

        return text;
    }

    public static String getCategory() {
        String category = cbCategory.getSelectedItem().toString();
        return category;
    }

    public static String getTitel() {
        String titel = tfTitel.getText();
        titleEmpty = Validation.Validation.fieldEmpty(titel);
        titleTooLong = Validation.Validation.fieldTooLong(titel, 45);
        return titel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        panelMenuLogga = new javax.swing.JPanel();
        iconLogga = new javax.swing.JLabel();
        lblOrebro = new javax.swing.JLabel();
        lblUniversitet = new javax.swing.JLabel();
        pnlCreatePost = new javax.swing.JPanel();
        cbCategory = new javax.swing.JComboBox<>();
        lblKategori = new javax.swing.JLabel();
        lblTradtitel = new javax.swing.JLabel();
        sepTradtitel = new javax.swing.JSeparator();
        tfTitel = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        taText = new javax.swing.JTextArea();
        lblInnehall = new javax.swing.JLabel();
        btnPost = new javax.swing.JButton();
        btnBifogaFil = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(158, 174, 187));

        panelMenuLogga.setBackground(new java.awt.Color(158, 174, 187));
        panelMenuLogga.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iconLogga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logga.png"))); // NOI18N
        panelMenuLogga.add(iconLogga, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        lblOrebro.setFont(new java.awt.Font("Poppins Medium", 1, 18)); // NOI18N
        lblOrebro.setForeground(new java.awt.Color(202, 100, 91));
        lblOrebro.setText("Universitet");
        panelMenuLogga.add(lblOrebro, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, -1, 22));

        lblUniversitet.setFont(new java.awt.Font("Poppins Medium", 1, 18)); // NOI18N
        lblUniversitet.setForeground(new java.awt.Color(202, 100, 91));
        lblUniversitet.setText("�rebro");
        panelMenuLogga.add(lblUniversitet, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, -1, -1));

        pnlCreatePost.setBackground(new java.awt.Color(158, 174, 187));

        cbCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbCategoryActionPerformed(evt);
            }
        });

        lblKategori.setBackground(new java.awt.Color(77, 85, 92));
        lblKategori.setFont(new java.awt.Font("Poppins Medium", 0, 24)); // NOI18N
        lblKategori.setForeground(new java.awt.Color(77, 85, 92));
        lblKategori.setText("Kategori");

        lblTradtitel.setBackground(new java.awt.Color(77, 85, 92));
        lblTradtitel.setFont(new java.awt.Font("Poppins Medium", 0, 24)); // NOI18N
        lblTradtitel.setForeground(new java.awt.Color(77, 85, 92));
        lblTradtitel.setText("Tr�dtitel");

        sepTradtitel.setBackground(new java.awt.Color(0, 94, 125));
        sepTradtitel.setForeground(new java.awt.Color(0, 94, 125));

        tfTitel.setBackground(new java.awt.Color(158, 174, 187));
        tfTitel.setFont(new java.awt.Font("Playfair Display Medium", 0, 14)); // NOI18N
        tfTitel.setForeground(new java.awt.Color(0, 94, 125));
        tfTitel.setBorder(null);
        tfTitel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTitelActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(null);

        taText.setBackground(new java.awt.Color(158, 174, 187));
        taText.setColumns(20);
        taText.setFont(new java.awt.Font("Poppins Medium", 0, 12)); // NOI18N
        taText.setForeground(new java.awt.Color(77, 85, 92));
        taText.setLineWrap(true);
        taText.setRows(5);
        taText.setWrapStyleWord(true);
        taText.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 94, 125), 1, true));
        jScrollPane2.setViewportView(taText);

        lblInnehall.setFont(new java.awt.Font("Playfair Display Medium", 0, 14)); // NOI18N
        lblInnehall.setForeground(new java.awt.Color(77, 85, 92));
        lblInnehall.setText("Inneh�ll");

        btnPost.setBackground(new java.awt.Color(202, 100, 91));
        btnPost.setFont(new java.awt.Font("Poppins Medium", 0, 14)); // NOI18N
        btnPost.setForeground(new java.awt.Color(77, 85, 92));
        btnPost.setText("Posta");
        btnPost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPostActionPerformed(evt);
            }
        });

        btnBifogaFil.setBackground(new java.awt.Color(202, 100, 91));
        btnBifogaFil.setForeground(new java.awt.Color(77, 85, 92));
        btnBifogaFil.setText("Bifoga fil");
        btnBifogaFil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBifogaFilActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCreatePostLayout = new javax.swing.GroupLayout(pnlCreatePost);
        pnlCreatePost.setLayout(pnlCreatePostLayout);
        pnlCreatePostLayout.setHorizontalGroup(
            pnlCreatePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCreatePostLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(pnlCreatePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCreatePostLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btnBifogaFil)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPost, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70))
                    .addGroup(pnlCreatePostLayout.createSequentialGroup()
                        .addGroup(pnlCreatePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCreatePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfTitel)
                                .addComponent(sepTradtitel, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblTradtitel)
                            .addComponent(lblInnehall))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                        .addComponent(lblKategori)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCreatePostLayout.createSequentialGroup()
                        .addGroup(pnlCreatePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(pnlCreatePostLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2))
                        .addGap(21, 21, 21))))
        );
        pnlCreatePostLayout.setVerticalGroup(
            pnlCreatePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCreatePostLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pnlCreatePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTradtitel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblKategori))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 19, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfTitel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepTradtitel, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblInnehall)
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(pnlCreatePostLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPost)
                    .addComponent(btnBifogaFil))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelMenuLogga, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(pnlCreatePost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelMenuLogga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCreatePost, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void tfTitelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTitelActionPerformed

    }//GEN-LAST:event_tfTitelActionPerformed

    private void btnPostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPostActionPerformed
        createPost();
    }//GEN-LAST:event_btnPostActionPerformed

    public void createPost() {

        Filnamn newFile = new Filnamn();
        boolean fileNameExists = false;
//        boolean createPostWithoutFile = false;
//        boolean createPostWithFile = false;
        if (filename != null) {
            try {
                newFile.Filnamn(filename);
                fileNameExists = newFile.checkFileName(newFile.getFilename());

            } catch (Exception e){
                System.out.println(e);

            }
        } 
//        else {
//            createPostWithoutFile = true;
            new CreatePost();
//            dispose();
//            new FetchPosts();
//
//        }
        if (fileNameExists == false) {
//            createPostWithFile = true;
//            new CreatePost();
            SFPT uploadFile = new SFPT();
            try {
                uploadFile.connect();
                uploadFile.upload(filename);
                uploadFile.disconnect();
                try {
                    newFile.linkFileToPost(newFile.getFilename());
                } catch (SQLException ex) {
                    Logger.getLogger(CreatePostGUI.class.getName()).log(Level.SEVERE, null, ex);
                }

            } catch (JSchException ex) {
                Logger.getLogger(CreatePostGUI.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SftpException ex) {
                Logger.getLogger(CreatePostGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
//            dispose();
//            new FetchPosts();
        } else {

            JOptionPane.showMessageDialog(null, "Du m�ste tyv�rr byta till n�got annat namn p� filen");
        }

        //Ny kod, ers�tter det som �r utkommenterat i denna klass. 
//        if (createPostNow) {
//            new CreatePost();
            dispose();
            PageGUI.currentFetchPosts.postList();
//        }
    }

    private void cbCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbCategoryActionPerformed

    }//GEN-LAST:event_cbCategoryActionPerformed

    private void btnBifogaFilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBifogaFilActionPerformed
        // TODO add your handling code here:
        chooseFile();

    }//GEN-LAST:event_btnBifogaFilActionPerformed

    public void chooseFile() {
//        JFileChooser fileChooser = new JFileChooser();
//        fileChooser.setVisible(true);
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String filename = f.getAbsolutePath();
        setFilename(filename);
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
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
            java.util.logging.Logger.getLogger(CreatePostGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreatePostGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreatePostGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreatePostGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreatePostGUI().setVisible(true);
            }
        });
    }
    public static boolean textTooLong;
    public static boolean titleTooLong;
    public static boolean titleEmpty;
    public static boolean textEmpty;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBifogaFil;
    private javax.swing.JButton btnPost;
    public static javax.swing.JComboBox<String> cbCategory;
    private javax.swing.JLabel iconLogga;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblInnehall;
    private javax.swing.JLabel lblKategori;
    private javax.swing.JLabel lblOrebro;
    private javax.swing.JLabel lblTradtitel;
    private javax.swing.JLabel lblUniversitet;
    private javax.swing.JPanel panelMenuLogga;
    public static javax.swing.JPanel pnlCreatePost;
    private javax.swing.JSeparator sepTradtitel;
    public static javax.swing.JTextArea taText;
    public static javax.swing.JTextField tfTitel;
    // End of variables declaration//GEN-END:variables
}
