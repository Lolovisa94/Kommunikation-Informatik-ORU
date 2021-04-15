/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

import java.util.Date;

/**
 *
 * @author ramin.aslami
 */
public class Inlagg {
    
    private int id;
    private String title;
    private String text;
    private String publicationDate;
    //private Date publicationTime;
    private int kategori_ID;
    
    public Inlagg(int id, String title, String text, String publicationDate, int kategori_ID ) {
        
        this.id = id;
        this.title = title;
        this.text = text;
        this.publicationDate = publicationDate;
       // this.publicationTime = publicationTime;
        this.kategori_ID = kategori_ID;
        
        
        
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(String publicationDate) {
        this.publicationDate = publicationDate;
    }

//    public Date getPublicationTime() {
//        return publicationTime;
//    }

//    public void setPublicationTime(Date publicationTime) {
//        this.publicationTime = publicationTime;
//    }

    public int getKategori_ID() {
        return kategori_ID;
    }

    public void setKategori_ID(int kategori_ID) {
        this.kategori_ID = kategori_ID;
    }
    
    
    
    
    
}
