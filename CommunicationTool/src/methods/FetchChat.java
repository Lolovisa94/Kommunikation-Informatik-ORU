/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import GUI.PageGUI;
import Objects.CurrentUser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.text.DefaultCaret;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pierre
 */
public class FetchChat {

    private static int msgCounter = 0;
    private static ResultSet rs;
    private static String[] messages;
    private static String chatID;
    private static String[] messageSender;
    static int userID = CurrentUser.currentUser.getID();
    static String userName = CurrentUser.currentUser.getName();

    public FetchChat() {
        //this.chatID = chatID;
        addChatTable();
        mouseClicker();

    }
    
    


    public static void createChatMessage(String text, boolean rightAlligned) {
        JTextArea chatLabel = new JTextArea();

        chatLabel.setText(text);
        chatLabel.setMaximumSize(new java.awt.Dimension(600, 600));
        chatLabel.setLineWrap(true);
        chatLabel.setOpaque(true);
        chatLabel.setBackground(new java.awt.Color(158, 174, 187));
        Border border = BorderFactory.createLineBorder(new java.awt.Color(77, 85, 92));
        chatLabel.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        JPanel chatPanel = new JPanel();
        chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.X_AXIS));
        chatPanel.setBorder(BorderFactory.createEmptyBorder(2, 4, 2, 4));

        if (!rightAlligned) {
            chatPanel.add(Box.createHorizontalGlue());
            chatPanel.add(chatLabel);
            chatLabel.setBackground(Color.gray);
        } else {
            chatPanel.add(chatLabel);
            chatPanel.add(Box.createHorizontalGlue());
            chatLabel.setBackground(Color.white);
        }

        GUI.PageGUI.panelBoxChat.add(chatPanel);

    }

    public void addChatTable() {
        DefaultTableModel model = (DefaultTableModel) PageGUI.tblChats.getModel();
        model.setRowCount(0);

        String chatMottagareSQL = "SELECT a.Namn AS Namn FROM Chatt c INNER JOIN Anv�ndare a ON c.Mottagar_ID = a.Anv�ndare_ID WHERE S�ndar_ID =" + userID + " OR Mottagar_ID = " + userID;
        String chatS�ndareSQL = "SELECT a.Namn AS Namn FROM Chatt c INNER JOIN Anv�ndare a ON c.S�ndar_ID = a.Anv�ndare_ID WHERE S�ndar_ID =" + userID + " OR Mottagar_ID = " + userID;
        try {
            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            rs = st.executeQuery(chatMottagareSQL);
            while (rs.next()) {
                if (!rs.getString("Namn").equals(userName)) {
                    String chatPerson = rs.getString("Namn");
                    model.insertRow(PageGUI.tblChats.getRowCount(), new Object[]{chatPerson});
                    System.out.println(chatPerson);
                }
            }
            rs = st.executeQuery(chatS�ndareSQL);
            while (rs.next()) {
                if (!rs.getString("Namn").equals(userName)) {
                    String chatPerson = rs.getString("Namn");
                    model.insertRow(PageGUI.tblChats.getRowCount(), new Object[]{chatPerson});
                    System.out.println(chatPerson);
                }

            }
        } catch (Exception e) {

        }

    }

    public void mouseClicker() {

        PageGUI.tblChats.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent click) {

                if (click.getButton() == MouseEvent.BUTTON1) {
                    reloadChat();
                }
                if (click.getButton() == MouseEvent.BUTTON3) {

                    System.out.println("H�ger");
                }
            }

        });

    }

    public static void addChatMessages() {
        System.out.println("1000000");
        Integer uID = userID;
        boolean rightAlligned = true;
        msgCounter = 0;
        while (msgCounter < messages.length) {
            if (msgCounter < messages.length) {

                if (messageSender[msgCounter].equals(uID.toString())) {
                    rightAlligned = false;
                }
                createChatMessage(messages[msgCounter], rightAlligned);
                msgCounter++;
                if (rightAlligned) {

                }
            }
        }
    }

    public static void getChatMessages() {
        try {

            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            int i = 0;
            int row = PageGUI.tblChats.getSelectedRow();
            String chatPerson = PageGUI.tblChats.getValueAt(row, 0).toString();
            System.out.println(chatPerson);
            String getChatIDSQL = "SELECT Anv�ndare_ID FROM Anv�ndare WHERE Namn = '" + chatPerson + "'";
            rs = st.executeQuery(getChatIDSQL);
            rs.next();
            String chatUserID = rs.getString("Anv�ndare_ID");
            String getChatID = "SELECT Chatt_ID FROM Chatt WHERE S�ndar_ID = " + userID + " AND  Mottagar_ID = " + chatUserID + " OR Mottagar_ID = " + userID + " AND S�ndar_ID = " + chatUserID;
            rs = st.executeQuery(getChatID);
            rs.next();
            chatID = rs.getString("Chatt_ID");
            System.out.println(chatID);
            String getChatTextSQL = "SELECT Text, m.S�ndar_ID FROM Meddelande m INNER JOIN Chatt c ON m.Chatt_ID = c.Chatt_ID WHERE c.Chatt_ID = " + chatID;

            rs = st.executeQuery(getChatTextSQL);

            int size = 0;
            if (rs != null && !rs.isLast()) {

                while (rs.next()) {

                    size++;

                }

            }
            messages = new String[size];
            messageSender = new String[size];
            rs = st.executeQuery(getChatTextSQL);
            while (rs.next()) {

                String text = rs.getString("Text");
                String messageSenderID = rs.getString("S�ndar_ID");
                messages[i] = text;
                messageSender[i] = messageSenderID;
                i++;

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "S� mycket fel du g�r.....");
            System.out.println(e);
        }

    }

    public static void clearChatMessage() {
        GUI.PageGUI.panelBoxChat.removeAll();
        GUI.PageGUI.panelBoxChat.revalidate();
        GUI.PageGUI.panelBoxChat.repaint();

    }
    
    public static void sendChatMessage()
    {
        String getText = GUI.PageGUI.taCreateChatMessage.getText();
        
        if(!Validation.Validation.fieldEmpty(getText)){
            
            if(!Validation.Validation.fieldTooLong(getText, 250)){
        String createMessage = "INSERT INTO Meddelande (Chatt_ID, Text, Tid, S�ndar_ID) VALUES (" + chatID + ", '" + getText + "', '" + java.time.LocalDateTime.now()+ "', " + userID + ")";
        try{
            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            st.executeUpdate(createMessage);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "�RRU");
            System.out.println(e);
        }
            }else{
                JOptionPane.showMessageDialog(null, "Ett chattmeddelande f�r h�gst vara 250 tecken l�ngt, skriv om ditt meddelande eller skicka det i tv� v�ndor");
            
            }
        } else {
        
            JOptionPane.showMessageDialog(null, "Du m�ste skriva n�got i ditt meddelande innan du skickar.");
            
               }
    }
    
    
    
    public static boolean checkIfChatExists(String mottagarNamn){
        ResultSet rsCheck = null;
        boolean chatExists = false;
        String sqlQueryMottagarID = "SELECT Anv�ndare_ID from Anv�ndare WHERE namn = '" + mottagarNamn + "'";
        
        try{
        Statement st = Connectivity.ConnectionClass.conn.createStatement();
            rsCheck = st.executeQuery(sqlQueryMottagarID);
            
            rsCheck.next();
            int chatUserID = rsCheck.getInt("Anv�ndare_ID");
            
            String sqlQuery = "SELECT * FROM Chatt WHERE S�ndar_ID = " + CurrentUser.currentUser.getID() + " AND  Mottagar_ID = " + chatUserID + " OR Mottagar_ID = " + CurrentUser.currentUser.getID() + " AND S�ndar_ID = " + chatUserID;
    
            rsCheck = st.executeQuery(sqlQuery);
            
            if(rsCheck.next()){
            
            
            chatExists = true;
            
            } else {
            
            createChat(chatUserID);
                System.out.println("Chattskapad");
            
            }
        
        } catch (Exception e){
        
            System.out.println(e);
        }
    
        return chatExists;
    }
    
    
    public static void createChat(int chatUserID){
    
    String sqlQuery = "INSERT INTO Chatt (S�ndar_ID, Mottagar_ID) VALUES (" + CurrentUser.currentUser.getID() + ", " + chatUserID + ")";
    
    try{
        Statement st = Connectivity.ConnectionClass.conn.createStatement();
        st.executeUpdate(sqlQuery);
        
    
    } catch (Exception e){
    
        System.out.println(e);
    }
    
    }
    
    public static void reloadChat(){
    
                        clearChatMessage();
                    getChatMessages();
                    addChatMessages();
    }
    

        
}
