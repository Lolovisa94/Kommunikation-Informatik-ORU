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

    private int msgCounter = 0;
    private ResultSet rs;
    private String[] messages;
    private static String chatID;
    private String[] messageSender;
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

        String chatMottagareSQL = "SELECT a.Namn AS Namn FROM Chatt c INNER JOIN Användare a ON c.Mottagar_ID = a.Användare_ID WHERE Sändar_ID =" + userID + " OR Mottagar_ID = " + userID;
        String chatSändareSQL = "SELECT a.Namn AS Namn FROM Chatt c INNER JOIN Användare a ON c.Sändar_ID = a.Användare_ID WHERE Sändar_ID =" + userID + " OR Mottagar_ID = " + userID;
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
            rs = st.executeQuery(chatSändareSQL);
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
                    clearChatMessage();
                    getChatMessages();
                    addChatMessages();
                }
                if (click.getButton() == MouseEvent.BUTTON3) {
                    System.out.println("Höger");
                }
            }

        });

    }

    public void addChatMessages() {
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

    public void getChatMessages() {
        try {

            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            int i = 0;
            int row = PageGUI.tblChats.getSelectedRow();
            String chatPerson = PageGUI.tblChats.getValueAt(row, 0).toString();
            System.out.println(chatPerson);
            String getChatIDSQL = "SELECT Användare_ID FROM Användare WHERE Namn = '" + chatPerson + "'";
            rs = st.executeQuery(getChatIDSQL);
            rs.next();
            String chatUserID = rs.getString("Användare_ID");
            String getChatID = "SELECT Chatt_ID FROM Chatt WHERE Sändar_ID = " + userID + " AND  Mottagar_ID = " + chatUserID + " OR Mottagar_ID = " + userID + " AND Sändar_ID = " + chatUserID;
            rs = st.executeQuery(getChatID);
            rs.next();
            chatID = rs.getString("Chatt_ID");
            System.out.println(chatID);
            String getChatTextSQL = "SELECT Text, m.Sändar_ID FROM Meddelande m INNER JOIN Chatt c ON m.Chatt_ID = c.Chatt_ID WHERE c.Chatt_ID = " + chatID;

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
                String messageSenderID = rs.getString("Sändar_ID");
                messages[i] = text;
                messageSender[i] = messageSenderID;
                i++;

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Så mycket fel du gör.....");
            System.out.println(e);
        }

    }

    public static void clearChatMessage() {
        GUI.PageGUI.panelBoxChat.removeAll();
        GUI.PageGUI.panelBoxChat.revalidate();
        GUI.PageGUI.panelBoxChat.repaint();

    }
    
    public static void createChatMessage()
    {
        String getText = GUI.PageGUI.taCreateChatMessage.getText();
        String createMessage = "INSERT INTO Meddelande (Chatt_ID, Text, Tid, Sändar_ID) VALUES (" + chatID + ", '" + getText + "', '" + java.time.LocalDateTime.now()+ "', " + userID + ")";
        try{
            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            st.executeUpdate(createMessage);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "ÖRRU");
            System.out.println(e);
        }
    }
}
