/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import Objects.CurrentUser;
import java.sql.ResultSet;
import Validation.Validation;
import Objects.CurrentUser;
import Connectivity.ConnectionClass;
import java.sql.Statement;
import java.sql.ResultSet;
import GUI.LogInGUI;
import GUI.PageGUI;
import GUI.changePassword;
import javax.swing.JOptionPane;

/**
 *
 * @author ramin.aslami
 */
public class ChangeUserInfo {

    public void changeMailTel(String mail, String tel) {

        ResultSet userInfo = null;
        //ResultSet userInfo2 = null;
        //ResultSet update = null;

        if (Validation.fieldEmpty(mail) || Validation.fieldEmpty(tel)) {

            System.out.println("N�got av f�lten �r tomma");
            JOptionPane.showMessageDialog(null, "N�got av f�lten �r tomma!");

        } else {

            try {
                Statement st = Connectivity.ConnectionClass.conn.createStatement();
                String controlEmail = "SELECT * from Anv�ndare where Anv�ndare_ID =" + CurrentUser.currentUser.getID();               
                userInfo = st.executeQuery(controlEmail);
                
                if (userInfo.next()) {
                   
                    // F�nga email och telefonen av personen genom databasen                      
                    String getEmail = userInfo.getString("Email");
                    String getNumber = userInfo.getString("Telefon");
 
                    boolean noti = controlRadio();     
                    if (getEmail.equals(mail) && getNumber.equals(tel) && !noti ) {

                        PageGUI.setFelmeddelandePIUppdatera();
                                            
                    } else {
                        
                        // SQL fr�gorna som anv�nts f�r att uppdatera email och telefonen
                        String email = "UPDATE Anv�ndare SET Email =" + "'" + mail + "'" + " where Anv�ndare_ID = " + CurrentUser.currentUser.getID();
                        String number = "UPDATE Anv�ndare SET Telefon =" + "'" + tel + "'" + " where Anv�ndare_ID =" + CurrentUser.currentUser.getID();

                        // uppdateringen sker h�r
                        st.executeUpdate(email);
                        st.executeUpdate(number);
                        
                        CurrentUser.currentUser.setEmail(mail);
                        CurrentUser.currentUser.setPhone(Integer.parseInt(tel));
                        JOptionPane.showMessageDialog(null, "Uppdaterat!");

                    }
                }
            } catch (Exception e) {

                System.out.println("termination");
            }
        }

    }

    public void changePassword(String oldPassword, String newPassword) {

        ResultSet userInfo = null;
      //  ResultSet update = null;

        System.out.println(CurrentUser.currentUser.getID());

        if (Validation.fieldEmpty(oldPassword) || Validation.fieldEmpty(newPassword)) {

            System.out.println("N�got av f�lten �r tomma");
            JOptionPane.showMessageDialog(null, "N�got av f�lten �r tomma!");

        } else {

            try {
                Statement st = Connectivity.ConnectionClass.conn.createStatement();
                String controlPass = "SELECT * from Anv�ndare where L�senord =" + "'" + oldPassword + "'" + " and Anv�ndare_ID= " + CurrentUser.currentUser.getID();
                userInfo = st.executeQuery(controlPass);
                
                if (userInfo.next()) { 
                    String getPassword = userInfo.getString("L�senord");

                    if (getPassword.equals(oldPassword) && newPassword.length() <= 100) {

                        String newPW = "UPDATE Anv�ndare SET L�senord =" + "'" + newPassword + "'" + " where Anv�ndare_ID = " + "'" + CurrentUser.currentUser.getID() + "'";
                        st.executeUpdate(newPW);
                        CurrentUser.currentUser.setPw(newPassword);
                        JOptionPane.showMessageDialog(null, "Uppdaterat!");

                    } 
                   
                }
                else  {
                        
                    JOptionPane.showMessageDialog(null, "Kontrollera att det gamla l�senordet �r skrivet r�tt och att det nya ej �verskrider 100 karakt�rer!");    
                    
                    }

                        
            } catch (Exception e) {

                System.out.println("termination");
            }
            
            
            
        }
    }
    public boolean controlRadio() {
        
        ResultSet userInfo = null;
        
        boolean hasChanged = false;
        
        try {
                Statement st = Connectivity.ConnectionClass.conn.createStatement();
                String controlNotification = "SELECT * from Notifikation where Anv�ndare_ID =" + CurrentUser.currentUser.getID();
                userInfo = st.executeQuery(controlNotification);
               

                if (userInfo.next()) {
                  
                    // F�nga email och telefonen av personen genom databasen                      
                    String getNotification = userInfo.getString("Notifiering");
                   
                    System.out.println(getNotification);
                    
                    if ((PageGUI.jRadioButton1.isSelected()) && !CurrentUser.currentUser.getNotify().equals("J")) {

                        String yesNotification = "UPDATE Notifikation SET Notifiering = " + "'J'" + "where Anv�ndare_ID = " + CurrentUser.currentUser.getID();
                        st.executeUpdate(yesNotification);
                       CurrentUser.currentUser.setNotify("J");
                        PageGUI.jRadioButton1.setSelected(true);
                        hasChanged = true;
                    

                    } 
                    else if (PageGUI.jRadioButton2.isSelected() && !CurrentUser.currentUser.getNotify().equals("N")) {

                       String noNotification = "UPDATE Notifikation SET Notifiering = " + "'N'" + "where Anv�ndare_ID = " + CurrentUser.currentUser.getID();
                       st.executeUpdate(noNotification);
                       CurrentUser.currentUser.setNotify("N");
                       PageGUI.jRadioButton2.setSelected(true);
                       hasChanged = true;
                        
                        
                    }else {
                       
                        System.out.println("error");
                    }
 {
                           
                        
                    }
                }
            } catch (Exception e) {

                System.out.println("termination");
            }
        
        return hasChanged;
        
    }

}
