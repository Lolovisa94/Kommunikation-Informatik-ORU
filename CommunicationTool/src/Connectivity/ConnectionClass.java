package Connectivity;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pierre
 */
import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionClass {
    private static Connection connection;
    
    public static void test(){
	ConnectionClass obj_DB_Connection = new ConnectionClass();
	Connection connection=null;
	connection = obj_DB_Connection.get_connection();
	System.out.println(connection);
    }
    
    //Only establishes new connection if no other connection is found. Returns current connection if connection is found.
    
    public static Connection get_connection(){
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://35.228.178.255:3306/CommunicationDB", "root", "Projektgruppen123@!");

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return connection;
    }
     
    public static Connection conn = ConnectionClass.get_connection();
}

    
