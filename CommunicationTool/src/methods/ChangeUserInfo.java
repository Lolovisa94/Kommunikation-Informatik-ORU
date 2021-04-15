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
        ResultSet userInfo2 = null;
        ResultSet update = null;

        if (Validation.fieldEmpty(mail) || Validation.fieldEmpty(tel)) {

            System.out.println("Något av fälten är tomma");
            JOptionPane.showMessageDialog(null, "Något av fälten är tomma!");

        } else {

            try {
                Statement st = Connectivity.ConnectionClass.conn.createStatement();
                System.out.println("1");
                String controlEmail = "SELECT * from Användare where Användare_ID =" + CurrentUser.currentUser.getID();
                //String controlNumber = "SELECT Telefon from Användare where Telefon =" + CurrentUser.currentUser.getPhone();

                userInfo = st.executeQuery(controlEmail);
                System.out.println("2");

                if (userInfo.next()) {
                    System.out.println("3");
                    // Fånga email och telefonen av personen genom databasen                      
                    String getEmail = userInfo.getString("Email");
                    String getNumber = userInfo.getString("Telefon");
                    System.out.println("4");
                    if (getEmail.equals(mail) && getNumber.equals(tel)) {

//                        GUI.changePersonInfo cPi = new GUI.changePersonInfo();
                        PageGUI.setFelmeddelandePIUppdatera();
                        System.out.println("5");
                    } else {
                        // SQL frågorna som använts för att uppdatera email och telefonen
                        System.out.println("6");
                        System.out.println(CurrentUser.currentUser.getID());
                        String email = "UPDATE Användare SET Email =" + "'" + mail + "'" + " where Användare_ID = " + CurrentUser.currentUser.getID();
                        String number = "UPDATE Användare SET Telefon =" + "'" + tel + "'" + " where Användare_ID =" + CurrentUser.currentUser.getID();

                        // uppdateringen sker här
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
        ResultSet update = null;

        System.out.println(CurrentUser.currentUser.getID());

        if (Validation.fieldEmpty(oldPassword) || Validation.fieldEmpty(newPassword)) {

            System.out.println("Något av fälten är tomma");
            JOptionPane.showMessageDialog(null, "Något av fälten är tomma!");

        } else {

            try {
                Statement st = Connectivity.ConnectionClass.conn.createStatement();

                //GUI.changePassword cp = new GUI.changePassword();
                String controlPass = "SELECT * from Användare where Lösenord =" + "'" + oldPassword + "'";
                //String controlNumber = "SELECT Telefon from Användare where Telefon =" + CurrentUser.currentUser.getPhone();

                userInfo = st.executeQuery(controlPass);

                if (userInfo.next()) {

                    // Fånga email och telefonen av personen genom databasen                      
                    String getPassword = userInfo.getString("Lösenord");
                    //  String getNumber = userInfo.getString("Telefon");

                    if (getPassword.equals(oldPassword) && newPassword.length() <= 100) {

                        String newPW = "UPDATE Användare SET Lösenord =" + "'" + newPassword + "'" + " where Användare_ID = " + "'" + CurrentUser.currentUser.getID() + "'";
                        st.executeUpdate(newPW);
                        CurrentUser.currentUser.setPw(newPassword);
                        JOptionPane.showMessageDialog(null, "Uppdaterat!");

                    } else {

                        JOptionPane.showMessageDialog(null, "Kontrollera att det gamla lösenordet är skrivet och att det nya ej överskrider 100 karaktärer!");

                    }
                }
            } catch (Exception e) {

                System.out.println("termination");
            }
        }
    }

}
