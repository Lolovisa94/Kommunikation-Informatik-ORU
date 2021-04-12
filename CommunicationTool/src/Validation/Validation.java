/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

/**
 *
 * @author Pierre
 */
public class Validation {
    
    //felmeddelande när ett fält är tomt, tar in en String i parametern och returnar en boolean
        public static boolean fieldEmpty(String field) {
        resultat = false;
        if (field.equals("")) {
            resultat = true;
        }
        return resultat;
    }
        
        public static void setLabelText(javax.swing.JLabel label, String text){
        label.setText(text);
        }        
        
private static boolean resultat;
}
