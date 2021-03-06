/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
 

import Connectivity.ConnectionClass;
import Objects.CurrentUser;
import Validation.Validation;

import Methods.SearchUser;
import com.mysql.cj.MysqlType;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import javax.management.modelmbean.ModelMBean;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import methods.SuggestMeeting;
import java.util.ArrayList;

/**
 *
 * @author ramin.aslami
 */
public class SuggestMeetingGUI extends javax.swing.JFrame {
Statement st;
    ArrayList<String> email = new ArrayList<String>();
    int suggestedMeetingID;
    /**
     * Creates new form NewJFrame
     */
    public SuggestMeetingGUI() {
        initComponents();
       SearchUser allusers = new SearchUser();
        allusers.getAllUsers(jTable2);

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
        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        lblWelcome11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        timePicker1 = new com.github.lgooddatepicker.components.TimePicker();
        timePicker2 = new com.github.lgooddatepicker.components.TimePicker();
        datePicker1 = new com.github.lgooddatepicker.components.DatePicker();

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
        lblWelcome5.setText("H?r kan du f?resl? 1-3 m?testider till andra");

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

        jButton1.setText("L?gg till tid");
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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Datum", "StartTid", "SlutTid"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Skapa inbjudan");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Namn", "Epost", "Telefon"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Namn", "Epost", "Telefon"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jButton3.setText("Bjud in anv?ndare");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        timePicker1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                timePicker1FocusGained(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(253, 253, 253)
                .addComponent(lblWelcome5, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(iconLogga)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblUniversitet)
                            .addComponent(lblOrebro)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addGap(72, 72, 72))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblWelcome6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblWelcome8)
                                    .addComponent(lblWelcome10)
                                    .addComponent(lblWelcome7))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton1))
                                        .addComponent(timePicker2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(timePicker1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblWelcome11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(44, 44, 44)))
                .addGap(894, 894, 894)
                .addComponent(jButton2)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(iconLogga))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lblUniversitet)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblOrebro)
                            .addComponent(lblWelcome5))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblWelcome6)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblWelcome7)
                                    .addComponent(timePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblWelcome8)
                                    .addComponent(timePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblWelcome10)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton3)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWelcome11)
                    .addComponent(datePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(54, 54, 54))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(236, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Object columnNames[] = {"Datum", "StartTid", "SlutTidTime"};
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        if(!Validation.fieldEmpty(jTextField1.getText())){
         
         if(!Validation.fieldTooLong(jTextField1.getText(),45)){
             if(timePicker1.getTime()!=null){
                 if(timePicker2.getTime()!=null){
                     if(datePicker1.getDate()!=null){
                         if(!jTextField4.getText().equals("")){
              if(model.getRowCount()<3){
        
 
       model.addRow(new Object[]{datePicker1.getDate(), timePicker1.getTime(),timePicker2.getTime()});}
        else{
            JOptionPane.showMessageDialog(null, "Du kan tyv?rr bara v?lja tre olika tider.");
        }
             
        }else{
                      JOptionPane.showMessageDialog(null, "Du m?ste skriva n?got i beskrivningen");       
                }
                     }else{
                         JOptionPane.showMessageDialog(null, "V?nligen v?lj ett Datum");
                     }
                 }else{
                     JOptionPane.showMessageDialog(null, "V?nligen v?lj en Sluttid");
                 }}else{
                 JOptionPane.showMessageDialog(null, "V?nligen v?lj en Starttid");
                 
             }}
         else{
         JOptionPane.showMessageDialog(null, "Namnet f?r max vara 45 bokst?ver");
         }
        
        }else{
            
        JOptionPane.showMessageDialog(null, "Du m?ste d?pa m?tet till n?got");
        }
        
     
        
                
               

    }//GEN-LAST:event_jButton1ActionPerformed

    private static boolean dateValidation(String date) {
        boolean status = false;
        if (checkDate(date)) {
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            dateFormat.setLenient(false);
            try {
                dateFormat.parse(date);
                status = true;
            } catch (Exception e) {
                status = false;
            }
        }
        return status;
    }

    static boolean checkDate(String date) {
        String pattern = "(0?[1-9]|[12][0-9]|3[01])\\/(0?[1-9]|1[0-2])\\/([0-9]{4})";
        boolean flag = false;
        if (date.matches(pattern)) {
            flag = true;
        }
        return flag;

    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        SuggestMeeting h = new SuggestMeeting();
        if(jTable1.getRowCount()<1){
            JOptionPane.showMessageDialog(null, "Du m?ste f?resl? minst en tid f?r att kunna skapa ett m?tesf?rslag");
        }
        if(jTable1.getRowCount()==1){
       
        h.createSuggestion1(CurrentUser.currentUser.getID(),jTextField1.getText(), jTextField4.getText(), jTable1.getModel().getValueAt(0,1 ).toString(), jTable1.getModel().getValueAt(0,2).toString(), jTable1.getModel().getValueAt(0,0).toString());
        suggestedMeetingID=h.getSuggestedMeetingID();
        }
        if(jTable1.getRowCount()==2){
            h.createSuggestion2(CurrentUser.currentUser.getID(),jTextField1.getText(), jTextField4.getText(),jTable1.getModel().getValueAt(0,1 ).toString(), jTable1.getModel().getValueAt(0,2).toString(), jTable1.getModel().getValueAt(0,0).toString(), jTable1.getModel().getValueAt(1,1).toString(), jTable1.getModel().getValueAt(1,2).toString(), jTable1.getModel().getValueAt(1,0).toString());
            suggestedMeetingID=h.getSuggestedMeetingID();
        }
        if(jTable1.getRowCount()==3){
        h.createSuggestion3(CurrentUser.currentUser.getID(),jTextField1.getText(), jTextField4.getText(),jTable1.getModel().getValueAt(0,1 ).toString(),jTable1.getModel().getValueAt(0,2 ).toString(), jTable1.getModel().getValueAt(0,0 ).toString(), jTable1.getModel().getValueAt(1,1 ).toString(), jTable1.getModel().getValueAt(1,2 ).toString(), jTable1.getModel().getValueAt(1,0 ).toString(), jTable1.getModel().getValueAt(2,1 ).toString(), jTable1.getModel().getValueAt(2,2 ).toString(), jTable1.getModel().getValueAt(2,0 ).toString());
        suggestedMeetingID=h.getSuggestedMeetingID();
        }

    for (int i = 0; i < jTable3.getRowCount(); i++) {
         Object[][] data = new Object[jTable3.getRowCount()][jTable3.getColumnCount()];
       data[i][1] = jTable3.getValueAt(i, 1);
        email.add(jTable3.getValueAt(i,1).toString());
    }
    for(int i=0; i<email.size(); i++){
        h.inviteOtherToMeeting(email.get(i),suggestedMeetingID);
      
    }
    JOptionPane.showMessageDialog(null, "Du har nu skapat en inbjudan");
    dispose();
    
  
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(!jTable2.getSelectionModel().isSelectionEmpty()){
            int selectedRow = JOptionPane.showConfirmDialog((Component) null, "Vill du L?gga till anv?ndaren ?", "L?gg till", JOptionPane.YES_NO_OPTION);
            if(selectedRow==0){
                int row = jTable2.getSelectedRow();
                String cellepost = jTable2.getModel().getValueAt(row, 2).toString();
                String sqlQuery= "select Namn, Email ,Telefon from Anv?ndare where Email= " + "'" + cellepost + "'";
                try{
                    System.out.println(sqlQuery);
                    ResultSet rs=null;
                     st = ConnectionClass.conn.createStatement();
                     rs = st.executeQuery(sqlQuery);
                     while(rs.next()){
                     String namn= rs.getString("Namn");
                     String email= rs.getString("Email");
                     int telefon= rs.getInt("Telefon");
                     Object rowData[] = {namn, email,telefon};
         DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
         model.addRow(rowData);
         jTable3.setModel(model);

                   }
                   
                } catch(Exception e){
                
                }
                           
            }
            }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void timePicker1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_timePicker1FocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_timePicker1FocusGained

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
            java.util.logging.Logger.getLogger(SuggestMeetingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SuggestMeetingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SuggestMeetingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SuggestMeetingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SuggestMeetingGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DatePicker datePicker1;
    private javax.swing.JLabel iconLogga;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
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
    private com.github.lgooddatepicker.components.TimePicker timePicker1;
    private com.github.lgooddatepicker.components.TimePicker timePicker2;
    // End of variables declaration//GEN-END:variables
}
