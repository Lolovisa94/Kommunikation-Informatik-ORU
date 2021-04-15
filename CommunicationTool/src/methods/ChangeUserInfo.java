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

            System.out.println("N�got av f�lten �r tomma");
            JOptionPane.showMessageDialog(null, "N�got av f�lten �r tomma!");

        } else {

            try {
                Statement st = Connectivity.ConnectionClass.conn.createStatement();
                System.out.println("1");
                String controlEmail = "SELECT * from Anv�ndare where Anv�ndare_ID =" + CurrentUser.currentUser.getID();
                //String controlNumber = "SELECT Telefon from Anv�ndare where Telefon =" + CurrentUser.currentUser.getPhone();

                userInfo = st.executeQuery(controlEmail);
                System.out.println("2");

                if (userInfo.next()) {
                    System.out.println("3");
                    // F�nga email och telefonen av personen genom databasen                      
                    String getEmail = userInfo.getString("Email");
                    String getNumber = userInfo.getString("Telefon");
                    System.out.println("4");
                    if (getEmail.equals(mail) && getNumber.equals(tel)) {

//                        GUI.changePersonInfo cPi = new GUI.changePersonInfo();
                        PageGUI.setFelmeddelandePIUppdatera();
                        System.out.println("5");
                    } else {
                        // SQL fr�gorna som anv�nts f�r att uppdatera email och telefonen
                        System.out.println("6");
                        System.out.println(CurrentUser.currentUser.getID());
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
        ResultSet update = null;

        System.out.println(CurrentUser.currentUser.getID());

        if (Validation.fieldEmpty(oldPassword) || Validation.fieldEmpty(newPassword)) {

            System.out.println("N�got av f�lten �r tomma");
            JOptionPane.showMessageDialog(null, "N�got av f�lten �r tomma!");

        } else {

            try {
                Statement st = Connectivity.ConnectionClass.conn.createStatement();

                //GUI.changePassword cp = new GUI.changePassword();
                String controlPass = "SELECT * from Anv�ndare where L�senord =" + "'" + oldPassword + "'";
                //String controlNumber = "SELECT Telefon from Anv�ndare where Telefon =" + CurrentUser.currentUser.getPhone();

                userInfo = st.executeQuery(controlPass);

                if (userInfo.next()) {

                    // F�nga email och telefonen av personen genom databasen                      
                    String getPassword = userInfo.getString("L�senord");
                    //  String getNumber = userInfo.getString("Telefon");

                    if (getPassword.equals(oldPassword) && newPassword.length() <= 100) {

                        String newPW = "UPDATE Anv�ndare SET L�senord =" + "'" + newPassword + "'" + " where Anv�ndare_ID = " + "'" + CurrentUser.currentUser.getID() + "'";
                        st.executeUpdate(newPW);
                        CurrentUser.currentUser.setPw(newPassword);
                        JOptionPane.showMessageDialog(null, "Uppdaterat!");

                    } else {

                        JOptionPane.showMessageDialog(null, "Kontrollera att det gamla l�senordet �r skrivet och att det nya ej �verskrider 100 karakt�rer!");

                    }
                }
            } catch (Exception e) {

                System.out.println("termination");
            }
        }
    }

}
