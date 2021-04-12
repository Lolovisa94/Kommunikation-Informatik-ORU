package Methods;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.ResultSet;
/**
 *
 * @author pierre
 */
public class User {
    private String name;
    private int phone;
    private String pw;
    private boolean admin;
    private String email;

    public User(String name, int phone, String pw, String admin, String email) {
        this.name = name;
        this.phone = phone;
        this.pw = pw;
        setAdmin(admin);
        this.email = email;
    }
    
    
    public void setName(String name){
        this.name = name;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public void setAdmin(String admin) {
        if(admin.toLowerCase().equals("j")){
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
    
    
    
    
}
