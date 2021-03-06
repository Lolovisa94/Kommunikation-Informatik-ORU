/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Objects.CurrentUser;
import Validation.Validation;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author ramin.aslami
 */
public class BookMeetingGUI extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public BookMeetingGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField6 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        iconLogga = new javax.swing.JLabel();
        lblUniversitet = new javax.swing.JLabel();
        lblOrebro = new javax.swing.JLabel();
        lblWelcome5 = new javax.swing.JLabel();
        lblWelcome6 = new javax.swing.JLabel();
        lblWelcome7 = new javax.swing.JLabel();
        lblWelcome8 = new javax.swing.JLabel();
        lblWelcome10 = new javax.swing.JLabel();
        privatjRadio = new javax.swing.JRadioButton();
        publikjRadio = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        lblWelcome11 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        timePicker1 = new com.github.lgooddatepicker.components.TimePicker();
        timePicker2 = new com.github.lgooddatepicker.components.TimePicker();

        jTextField6.setText("hh:mm:ss");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(158, 174, 187));

        iconLogga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logga.png"))); // NOI18N

        lblUniversitet.setFont(new java.awt.Font("Poppins Medium", 1, 18)); // NOI18N
        lblUniversitet.setForeground(new java.awt.Color(202, 100, 91));
        lblUniversitet.setText("?rebro");

        lblOrebro.setFont(new java.awt.Font("Poppins Medium", 1, 18)); // NOI18N
        lblOrebro.setForeground(new java.awt.Color(202, 100, 91));
        lblOrebro.setText("Universitet");

        lblWelcome5.setBackground(new java.awt.Color(77, 85, 92));
        lblWelcome5.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        lblWelcome5.setForeground(new java.awt.Color(77, 85, 92));
        lblWelcome5.setText("H?r kan du antingen boka ett privat eller publikt m?te");

        lblWelcome6.setBackground(new java.awt.Color(77, 85, 92));
        lblWelcome6.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        lblWelcome6.setForeground(new java.awt.Color(77, 85, 92));
        lblWelcome6.setText("Namn:");

        lblWelcome7.setBackground(new java.awt.Color(77, 85, 92));
        lblWelcome7.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        lblWelcome7.setForeground(new java.awt.Color(77, 85, 92));
        lblWelcome7.setText("Starttid:");

        lblWelcome8.setBackground(new java.awt.Color(77, 85, 92));
        lblWelcome8.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        lblWelcome8.setForeground(new java.awt.Color(77, 85, 92));
        lblWelcome8.setText("Sluttid:");

        lblWelcome10.setBackground(new java.awt.Color(77, 85, 92));
        lblWelcome10.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        lblWelcome10.setForeground(new java.awt.Color(77, 85, 92));
        lblWelcome10.setText("Beskrivning:");

        privatjRadio.setForeground(new java.awt.Color(77, 85, 92));
        privatjRadio.setText("Privat");
        privatjRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                privatjRadioActionPerformed(evt);
            }
        });

        publikjRadio.setForeground(new java.awt.Color(77, 85, 92));
        publikjRadio.setText("Publik");
        publikjRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                publikjRadioActionPerformed(evt);
            }
        });

        jButton1.setText("Boka");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        lblWelcome11.setBackground(new java.awt.Color(77, 85, 92));
        lblWelcome11.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        lblWelcome11.setForeground(new java.awt.Color(77, 85, 92));
        lblWelcome11.setText("Datum:");

        jPanel2.setBackground(new java.awt.Color(158, 174, 187));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconLogga)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUniversitet)
                            .addComponent(lblOrebro))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                        .addComponent(lblWelcome5, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(93, 93, 93)
                                        .addComponent(publikjRadio))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lblWelcome10)
                                                    .addComponent(lblWelcome8)
                                                    .addComponent(lblWelcome6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(96, 96, 96))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(lblWelcome7)
                                                .addGap(127, 127, 127)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField1)
                                            .addComponent(timePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
                                            .addComponent(timePicker2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(privatjRadio))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblWelcome11)
                                .addGap(113, 113, 113)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addComponent(jButton1)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(iconLogga))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(lblUniversitet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblOrebro)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblWelcome5)))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWelcome6)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWelcome7)
                    .addComponent(timePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWelcome8)
                    .addComponent(timePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWelcome10)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(lblWelcome11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(publikjRadio)
                    .addComponent(privatjRadio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(19, 19, 19))
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

    private void privatjRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_privatjRadioActionPerformed
        // TODO add your handling code here:

        if (privatjRadio.isSelected()) {

            publikjRadio.setSelected(false);

        }

    }//GEN-LAST:event_privatjRadioActionPerformed

    private void publikjRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_publikjRadioActionPerformed
        // TODO add your handling code here:

        if (publikjRadio.isSelected()) {

            privatjRadio.setSelected(false);

        }


    }//GEN-LAST:event_publikjRadioActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

        ResultSet userInfo = null;
        ResultSet userInfo2 = null;
        
        
        System.out.println(timePicker1.getTime());

        if (Validation.fieldEmpty(jTextField1.getText()) || Validation.fieldEmpty(jTextField4.getText())) {

            System.out.println("N?got av f?lten ?r tomma");
            JOptionPane.showMessageDialog(null, "N?got av f?lten ?r tomma!");
              

        } else {
            
            if (timePicker1.getTime() == null || timePicker2.getTime() == null) {
                
                System.out.println("j?vla idiot!!!!");
                JOptionPane.showMessageDialog(null, "Var v?nlig och ange tiden f?r m?tet!");
                
            } else { 

            try {
                       
                Date date = jDateChooser1.getDate();
                DateFormat format = new SimpleDateFormat("yyyy/MM/dd");
                String s = format.format(date);
                

                Statement st = Connectivity.ConnectionClass.conn.createStatement();
                Statement t = Connectivity.ConnectionClass.conn.createStatement();

                if (publikjRadio.isSelected()) {

                    String publicMeeting = "insert into M?te(Namn, StartTid, SlutTidTime, Beskrivning, Datum, Publik) values (" + "'" + jTextField1.getText() + "'" + ", '" + timePicker1.getTime() + "', '" + timePicker2.getTime() + "', '" + jTextField4.getText() + "', '" + s + "', 'J')";
                    st.executeUpdate(publicMeeting);
                     System.out.println("detta funkar");
                    //we need the specific meeting ID of the planned meeting in order to connect it to 1 or multiple users.
                    String pwQuery = "Select M?te_ID from M?te where Namn = " + "'" + jTextField1.getText() + "' and " + "Beskrivning = " + "'" + jTextField4.getText() + "'";

                    System.out.println(pwQuery);
                    userInfo = st.executeQuery(pwQuery);

                    if (userInfo.next()) {

                        int i = userInfo.getInt("M?te_ID");
                       

                        System.out.println(i);

                        String meet_user = "insert into M?te_Anv?ndare (M?te_ID, Anv?ndare_ID) values(" + i + ", " + CurrentUser.currentUser.getID() + ")";

                        System.out.println("hej");
                        t.executeUpdate(meet_user);

                        System.out.println("apperently it's working");
                        JOptionPane.showMessageDialog(null, "M?tet ?r inbokat");

                    }
                }

                if (privatjRadio.isSelected()) {

                    String privateMeeting = "insert into M?te(Namn, StartTid, SlutTidTime, Beskrivning, Datum, Publik) values (" + "'" + jTextField1.getText() + "'" + ", '" + timePicker1.getTime() + "', '" + timePicker2.getTime() + "', '" + jTextField4.getText() + "', '" + s + "', 'N')";
                    st.executeUpdate(privateMeeting);

                    //we need the specific meeting ID of the planned meeting in order to connect it to 1 or multiple users.
                    String privateQuery = "Select M?te_ID from M?te where Namn = " + "'" + jTextField1.getText() + "' and " + "Beskrivning = " + "'" + jTextField4.getText() + "'";

                    userInfo = st.executeQuery(privateQuery);

                    if (userInfo.next()) {

                        int i = userInfo.getInt("M?te_ID");

                        System.out.println(i);

                        String meet_user = "insert into M?te_Anv?ndare (M?te_ID, Anv?ndare_ID) values(" + i + ", " + CurrentUser.currentUser.getID() + ")";

                        System.out.println("hej");
                        t.executeUpdate(meet_user);

                        System.out.println("apperently it's working");
                        JOptionPane.showMessageDialog(null, "M?tet ?r inbokat");
                    }

                }

            } catch (Exception e) {

                System.out.println("termination");
            }
        }

        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(BookMeetingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookMeetingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookMeetingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookMeetingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookMeetingGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel iconLogga;
    private javax.swing.JButton jButton1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JLabel lblOrebro;
    private javax.swing.JLabel lblUniversitet;
    private javax.swing.JLabel lblWelcome10;
    private javax.swing.JLabel lblWelcome11;
    private javax.swing.JLabel lblWelcome5;
    private javax.swing.JLabel lblWelcome6;
    private javax.swing.JLabel lblWelcome7;
    private javax.swing.JLabel lblWelcome8;
    private javax.swing.JRadioButton privatjRadio;
    private javax.swing.JRadioButton publikjRadio;
    private com.github.lgooddatepicker.components.TimePicker timePicker1;
    private com.github.lgooddatepicker.components.TimePicker timePicker2;
    // End of variables declaration//GEN-END:variables
}
