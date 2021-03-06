package methods;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Connectivity.ConnectionClass;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author pierre
 */
public class User {
    private int id;
    private String name;
    private int phone;
    private String pw;
    private boolean admin;
    private String email;
    private String notifikation;

    public User(int id, String name, int phone, String pw, String admin, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.pw = pw;
        setAdmin(admin);
        this.email = email;
    }
    
    public User(String notifikation) {
        
        this.notifikation = notifikation;
        

    }
    
    public void setNotify(String notifikation) {

        this.notifikation = notifikation;

    }

    public String getNotify() {

        return notifikation;

    }

    public void setID(int id) {

        this.id = id;

    }

    public int getID() {

        return id;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setAdmin(String admin) {
        if (admin.toLowerCase().equals("j")) {
            this.admin = true;
        }
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public String getPw() {
        return pw;
    }

    public boolean isAdmin() {
        return admin;
    }

    public String getEmail() {
        return email;
    }
    
    
        public void addNewUser(String namn, int tele, String email, String losenord, boolean admin) {

        try {

            //int anvTele = tele.VAD SKA DET ST? ? ();


            Statement st = ConnectionClass.conn.createStatement();
            String query = "";
            
            if (!admin) {
                query = "insert into `Anv?ndare` (namn, telefon, l?senord, admin, email) values ('" + namn + "'," + tele + ", '" + losenord + "','N', '" + email + "');";
            } else {
                query = "insert into `Anv?ndare` (namn, telefon, l?senord, admin, email) values ('" + namn + "'," + tele + ", '" + losenord + "','J', '" + email + "');";
            }
            st.execute(query);
            

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
