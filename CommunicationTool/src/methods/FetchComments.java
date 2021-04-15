/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.Statement;
import java.sql.ResultSet;
import GUI.PostGUI;

//implements Runnable 
public class FetchComments{

    private String[] messages = {};
    private int msgCounter = 0;
    private JPanel panel;
    private JScrollPane scrollPane;
    private Timer timer;
    private ResultSet rs = null;
    public static JFrame frame;
    private int postID;
    

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new FetchComments());
//    }

    public FetchComments(int postID) {
//        timer();
        this.postID = postID;
        String[] nyMessages = {};
//        GUI.PostGUI.addMessage(nyMessages[0]);
//        this.msgCounter = 0;
        this.messages = nyMessages;
        getMessages();
        addMessages();
        System.out.println("getMessages fungerar om vi ser detta");
//        run();


        System.out.println("Run fungerar om vi ser detta");
    }

    public void getMessages() {
        try {
            System.out.println("1");
            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            int i = 0;
            String getCommentTextSQL = "SELECT Användare.Namn, Kommentarer.Text FROM Kommentarer Inner join Användare on Användare.Användare_ID = Kommentarer.Användare_ID Inner join Inlägg on Kommentarer.Inlägg_ID = Inlägg.Inlägg_ID where Kommentarer.Inlägg_ID=" + postID;
            rs = st.executeQuery(getCommentTextSQL);
            System.out.println("2");

            int size = 0;
            if (rs != null && !rs.isLast()) {
                while (rs.next()) {
                    size++;
                    System.out.println("size är lika med" + size);

                }

            }
            messages = new String[size];
            
            rs = st.executeQuery(getCommentTextSQL);
            while (rs.next()) {

                String text = rs.getString("Text");

                System.out.println("i är lika med" + i + text);
                messages[i] = text;

                System.out.println("i nr 2 är lika med" + i);

//                String user = rs.getString("Namn");
                i++;

            }
            
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    public void addMessages(){
        while(msgCounter <  messages.length)
            if (msgCounter < messages.length) {
                    GUI.PostGUI.addMessage(messages[msgCounter]);
                    msgCounter++;
                } 
    }
    
//    public void timer(){
//        timer = new Timer(0, new ActionListener() {
//            public void actionPerformed(ActionEvent event) {
//                if (msgCounter < messages.length) {
//                    GUI.PostGUI.addMessage(messages[msgCounter]);
//                    msgCounter++;
//                } 
//                else {
//                    timer.stop();
//                }
//            }
//        });
//        timer.start();
//}

//    public void run() {
//        panel = new JPanel();
//        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//
//        scrollPane = new JScrollPane(panel);
//        scrollPane.setVerticalScrollBarPolicy(
//                JScrollPane.VERTICAL_SCROLLBAR_NEVER);
//        scrollPane.setAutoscrolls(true);
//
//    frame = new JFrame("Message App");
//    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
//    frame.setSize(260, 180);
////    frame.setLocationRelativeTo(null);
//    frame.setVisible(true);
//
//        timer = new Timer(0, new ActionListener() {
//            public void actionPerformed(ActionEvent event) {
//                if (msgCounter < messages.length) {
//                    addMessage(messages[msgCounter]);
//                } else {
//                    timer.stop();
//                }
//            }
//        });
//        timer.start();
//    }

//    private void addMessage(String text) {
//        boolean oddMessage = msgCounter % 2 != 0;
//        Color color = oddMessage ? Color.WHITE : Color.GRAY;
//
//        JTextArea label = new JTextArea(text);
//        label.setMaximumSize(new java.awt.Dimension(600, 600));
//        label.setLineWrap(true);
//        label.setOpaque(true);
//        label.setBackground(color);
//        label.setBorder(BorderFactory.createCompoundBorder());
//
//    JPanel panelBox = new JPanel();
//    panelBox.setLayout(new BoxLayout(panelBox, BoxLayout.X_AXIS));
//    panelBox.setBorder(BorderFactory.createEmptyBorder(2,4,2,4));
//    panelBox.add(label);
//    panel.add(panelBox);
//    panel.revalidate();
//    msgCounter++;
//    }

//    @Override
//    public void run() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
