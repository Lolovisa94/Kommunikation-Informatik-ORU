/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Pierre
 */
public class Validation {
    private static boolean resultat;

    //felmeddelande när ett fält är tomt, tar in en String i parametern och returnar en boolean
    public static boolean fieldEmpty(String field) {
        resultat = false;
        if (field.equals("")) {
            resultat = true;
        }
        return resultat;
    }

    public static void setLabelText(javax.swing.JLabel label, String text) {
        label.setText(text);
    }
    
    //Validerar user input för att kontrollera att namn endast innehåller bokstäver och mellanslag.
    public static boolean isValidatedName(String name) {
        Pattern pattern = Pattern.compile("^[a-zA-Z\\s]+$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(name);
        boolean matchFound = matcher.find();

        return matchFound;
    }
    
            public static boolean fieldTooLong(String field, int maxLength){
            resultat = false;
            if(field.length() > maxLength){
            resultat = true;
            }
            
                    return resultat;
        }
        
        public static boolean titleExists(String field1, String field2){
            resultat = false;
            if(field1.toLowerCase().equals(field2.toLowerCase())){
            resultat = true;
            }
        
            return resultat;
        }
}
