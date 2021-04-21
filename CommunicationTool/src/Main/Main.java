package Main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author LovisaKampe
 */
import GUI.LogInGUI;
import Connectivity.ConnectionClass;
import GUI.SuggestMeetingGUI;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import methods.SuggestMeeting;

public class Main {
     public static void main(String[] args) {
	ConnectionClass.test();
        ConnectionClass.get_connection();
       
       new LogInGUI().setVisible(true);

     }
}
    
    

