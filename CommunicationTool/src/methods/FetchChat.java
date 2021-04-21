/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.text.DefaultCaret;

/**
 *
 * @author Pierre
 */
public class FetchChat {
private int msgCounter = 0;
private ResultSet rs; 
private String[] messages;
private String chatID;
    
    public FetchChat(String chatID){
        this.chatID = chatID;
        clearChatMessage();
        getChatMessages();
        addChatMessages();
        
    
    
    }
    
     public static void createChatMessage(String text){
        JTextArea chatLabel = new JTextArea();

        chatLabel.setText(text);
        chatLabel.setMaximumSize(new java.awt.Dimension(600, 600));
        chatLabel.setLineWrap(true);
        chatLabel.setOpaque(true);
        chatLabel.setBackground(new java.awt.Color(158, 174, 187));
        Border border = BorderFactory.createLineBorder(new java.awt.Color(77, 85, 92));
        chatLabel.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        GUI.PageGUI.panelBoxChat.add(chatLabel);

}


     
         public void addChatMessages(){
  
        while(msgCounter <  messages.length)        
            if (msgCounter < messages.length) { 

                    createChatMessage(messages[msgCounter]);
                    msgCounter++;
                } 
    }
         
         public void getChatMessages() {
            try {

            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            int i = 0;
            String getChatTextSQL = "SELECT Text, c.Sändar_ID FROM Meddelande m INNER JOIN Chatt c ON m.Chatt_ID = c.Chatt_ID WHERE c.Chatt_ID = " + chatID;
            
            rs = st.executeQuery(getChatTextSQL);
            
            int size = 0;
            if (rs != null && !rs.isLast()) {
                
                while (rs.next()) {
                    
                    size++;


                }

            }
            messages = new String[size];
            
            rs = st.executeQuery(getChatTextSQL);
            while (rs.next()) {

                String text = rs.getString("Text");

                messages[i] = text;
               
                i++;

            }
            
        } catch (Exception e) {
            System.out.println(e);
        }

    }
         
             public static void clearChatMessage() {
            GUI.PageGUI.panelBoxChat.removeAll();
            GUI.PageGUI.panelBoxChat.revalidate();
            GUI.PageGUI.panelBoxChat.repaint();

    }
    
}




