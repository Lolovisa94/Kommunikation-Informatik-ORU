package GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.KeyEvent;
import methods.LogIn;
import java.sql.ResultSet;
/**
 *
 * @author Pierre
 */
public class LogInGUI extends javax.swing.JFrame {

    /**
     * Creates new form LoginGUI
     */
    public LogInGUI() {
        initComponents();
        lblFelmeddelande.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgInlogg = new javax.swing.JPanel();
        bgPink = new javax.swing.JPanel();
        iconLogga = new javax.swing.JLabel();
        lblOrebroUniversitet1 = new javax.swing.JLabel();
        bgBlue = new javax.swing.JPanel();
        lblValkommen = new javax.swing.JLabel();
        panelLogIn = new javax.swing.JPanel();
        btnLogIn = new javax.swing.JPanel();
        lblbtnLoggaIn = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        sepEmail = new javax.swing.JSeparator();
        sepPw = new javax.swing.JSeparator();
        lblPw = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        pfPw = new javax.swing.JPasswordField();
        lblFelmeddelande = new javax.swing.JLabel();
        lblLoggaIn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(0, 0, 600, 400));
        setMinimumSize(new java.awt.Dimension(600, 400));
        setSize(new java.awt.Dimension(600, 400));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bgInlogg.setPreferredSize(new java.awt.Dimension(600, 400));
        bgInlogg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bgPink.setBackground(new java.awt.Color(77, 85, 92));
        bgPink.setMinimumSize(new java.awt.Dimension(300, 400));
        bgPink.setPreferredSize(new java.awt.Dimension(300, 400));

        iconLogga.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logga.png"))); // NOI18N

        lblOrebroUniversitet1.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        lblOrebroUniversitet1.setForeground(new java.awt.Color(202, 100, 91));
        lblOrebroUniversitet1.setText("�rebro Universitet");

        javax.swing.GroupLayout bgPinkLayout = new javax.swing.GroupLayout(bgPink);
        bgPink.setLayout(bgPinkLayout);
        bgPinkLayout.setHorizontalGroup(
            bgPinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgPinkLayout.createSequentialGroup()
                .addGroup(bgPinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgPinkLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(iconLogga))
                    .addGroup(bgPinkLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(lblOrebroUniversitet1)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        bgPinkLayout.setVerticalGroup(
            bgPinkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgPinkLayout.createSequentialGroup()
                .addGap(124, 124, 124)
                .addComponent(iconLogga)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblOrebroUniversitet1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        bgInlogg.add(bgPink, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        bgBlue.setBackground(new java.awt.Color(158, 174, 187));
        bgBlue.setMinimumSize(new java.awt.Dimension(300, 400));
        bgBlue.setPreferredSize(new java.awt.Dimension(300, 400));

        lblValkommen.setFont(new java.awt.Font("Playfair Display Medium", 0, 12)); // NOI18N
        lblValkommen.setForeground(new java.awt.Color(202, 100, 91));
        lblValkommen.setText("V�lkommen till �rebro Universitet");

        panelLogIn.setBackground(new java.awt.Color(158, 174, 187));

        btnLogIn.setBackground(new java.awt.Color(0, 94, 125));
        btnLogIn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 94, 125), 2, true));
        btnLogIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogInMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLogInMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLogInMouseExited(evt);
            }
        });

        lblbtnLoggaIn.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lblbtnLoggaIn.setForeground(new java.awt.Color(158, 174, 187));
        lblbtnLoggaIn.setText("Logga In");
        lblbtnLoggaIn.setIconTextGap(5);
        btnLogIn.add(lblbtnLoggaIn);

        lblEmail.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(0, 94, 125));
        lblEmail.setText("Email");
        lblEmail.setIconTextGap(5);

        sepEmail.setBackground(new java.awt.Color(0, 94, 125));
        sepEmail.setForeground(new java.awt.Color(0, 94, 125));

        sepPw.setBackground(new java.awt.Color(0, 94, 125));
        sepPw.setForeground(new java.awt.Color(0, 94, 125));

        lblPw.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        lblPw.setForeground(new java.awt.Color(0, 94, 125));
        lblPw.setText("L�senord");
        lblPw.setIconTextGap(5);

        tfEmail.setBackground(new java.awt.Color(158, 174, 187));
        tfEmail.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        tfEmail.setForeground(new java.awt.Color(0, 94, 125));
        tfEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(158, 174, 187)));
        tfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEmailActionPerformed(evt);
            }
        });
        tfEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfEmailKeyPressed(evt);
            }
        });

        pfPw.setBackground(new java.awt.Color(158, 174, 187));
        pfPw.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        pfPw.setForeground(new java.awt.Color(0, 94, 125));
        pfPw.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(158, 174, 187)));
        pfPw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfPwActionPerformed(evt);
            }
        });
        pfPw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pfPwKeyPressed(evt);
            }
        });

        lblFelmeddelande.setFont(new java.awt.Font("Playfair Display Medium", 0, 12)); // NOI18N
        lblFelmeddelande.setForeground(new java.awt.Color(202, 100, 91));
        lblFelmeddelande.setText("felmeddelande");

        javax.swing.GroupLayout panelLogInLayout = new javax.swing.GroupLayout(panelLogIn);
        panelLogIn.setLayout(panelLogInLayout);
        panelLogInLayout.setHorizontalGroup(
            panelLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLogInLayout.createSequentialGroup()
                .addGroup(panelLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(sepEmail, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sepPw, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLogInLayout.createSequentialGroup()
                        .addComponent(lblPw)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pfPw, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLogInLayout.createSequentialGroup()
                        .addComponent(lblEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfEmail)))
                .addGap(14, 14, 14))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLogInLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblFelmeddelande)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        panelLogInLayout.setVerticalGroup(
            panelLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLogInLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(panelLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPw, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pfPw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepPw, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelLogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblFelmeddelande))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        lblLoggaIn.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        lblLoggaIn.setForeground(new java.awt.Color(202, 100, 91));
        lblLoggaIn.setText("Logga In");
        lblLoggaIn.setIconTextGap(5);

        javax.swing.GroupLayout bgBlueLayout = new javax.swing.GroupLayout(bgBlue);
        bgBlue.setLayout(bgBlueLayout);
        bgBlueLayout.setHorizontalGroup(
            bgBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgBlueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelLogIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(bgBlueLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(bgBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLoggaIn)
                    .addComponent(lblValkommen))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        bgBlueLayout.setVerticalGroup(
            bgBlueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgBlueLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblLoggaIn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblValkommen)
                .addGap(75, 75, 75)
                .addComponent(panelLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        bgInlogg.add(bgBlue, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, -1, -1));

        getContentPane().add(bgInlogg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEmailActionPerformed

    private void pfPwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfPwActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pfPwActionPerformed

    private void btnLogInMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogInMouseEntered
        // TODO add your handling code here:
        btnLogIn.setBackground(new java.awt.Color(158, 174, 187));

        btnLogIn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0,94,125), 2, true));
        lblbtnLoggaIn.setForeground(new java.awt.Color(0, 94, 125));

    }//GEN-LAST:event_btnLogInMouseEntered

    private void btnLogInMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogInMouseExited
        // TODO add your handling code here:
        btnLogIn.setBackground(new java.awt.Color(0, 94, 125));
        lblbtnLoggaIn.setForeground(new java.awt.Color(158, 174, 187));
        btnLogIn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 94, 125), 2, true));
    }//GEN-LAST:event_btnLogInMouseExited

    private void btnLogInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogInMouseClicked
        // TODO add your handling code here:
        if (LogIn.logIn(tfEmail.getText(), pfPw.getText())) {
            try {
                LogIn.setLoggedInUserLoginLocationAndTime();
            } catch (Exception e) {
                System.out.println(e);
            }

            dispose();
        }
    }//GEN-LAST:event_btnLogInMouseClicked

    private void pfPwKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pfPwKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (LogIn.logIn(tfEmail.getText(), pfPw.getText())) {
                try {
                    LogIn.setLoggedInUserLoginLocationAndTime();
                } catch (Exception e) {
                    System.out.println(e);
                }
                dispose();
            }
        }
    }//GEN-LAST:event_pfPwKeyPressed

    private void tfEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEmailKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (LogIn.logIn(tfEmail.getText(), pfPw.getText())) {
                dispose();
            }
        }
    }//GEN-LAST:event_tfEmailKeyPressed

    
    public static void setFelmeddelande(String text){
    
    Validation.Validation.setLabelText(lblFelmeddelande, text);
    lblFelmeddelande.setVisible(true);
    
    };
    
    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bgBlue;
    private javax.swing.JPanel bgInlogg;
    private javax.swing.JPanel bgPink;
    private javax.swing.JPanel btnLogIn;
    private javax.swing.JLabel iconLogga;
    private javax.swing.JLabel lblEmail;
    public static javax.swing.JLabel lblFelmeddelande;
    private javax.swing.JLabel lblLoggaIn;
    private javax.swing.JLabel lblOrebroUniversitet1;
    private javax.swing.JLabel lblPw;
    private javax.swing.JLabel lblValkommen;
    private javax.swing.JLabel lblbtnLoggaIn;
    private javax.swing.JPanel panelLogIn;
    private javax.swing.JPasswordField pfPw;
    private javax.swing.JSeparator sepEmail;
    private javax.swing.JSeparator sepPw;
    private javax.swing.JTextField tfEmail;
    // End of variables declaration//GEN-END:variables
}
