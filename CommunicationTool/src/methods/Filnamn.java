/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;

/**
 *
 * @author olive
 */

    
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Filnamn {
    private String fileName;
    private ResultSet rs= null;
    
    
    public Path Filnamn(String filepath){
       Path path = Paths.get(filepath);
        Path fileLocation = path.getFileName();
        setShortName(fileLocation.toString());
        return fileLocation;
        
   
    }
    public void setShortName(String fileName){
        this.fileName=fileName;
    
    }
    public String getFilename(){
    return fileName;
    }
    
public boolean checkFileName(String fileName) throws SQLException{
                    boolean fileNameExists = false;
                    Statement st =Connectivity.ConnectionClass.conn.createStatement();
                    String freeFileName = "SELECT * FROM Filer where Namn =" + "'" + fileName + "'";
                    rs = st.executeQuery(freeFileName);
                        if(rs.next()){
                            fileNameExists = true;
                        }
                
    return fileNameExists;
}
public void linkFileToPost(String name) throws SQLException{
Statement st = Connectivity.ConnectionClass.conn.createStatement();
String getPostID = "SELECT Inlägg_ID FROM Inlägg ORDER BY Inlägg_ID DESC LIMIT 1";
rs=st.executeQuery(getPostID);
rs.next();
int postID =rs.getInt("Inlägg_ID");
    System.out.println("Post ID i filnamn klassen " + postID);
String createFile = "Insert into Filer (Namn, Inlägg_ID) values ('" + name + "'" + "," + postID + ")";
st.executeUpdate(createFile);
}

public String getFileObject(int Inlägg_ID) {
   
      String getFileObject = null;
        try {
             Statement st = Connectivity.ConnectionClass.conn.createStatement();
       
        String query= "SELECT Namn FROM Filer where Inlägg_ID=" + Inlägg_ID;
            System.out.println("query i fet fileobject" + query);
        rs=st.executeQuery(query);
        rs.next();
     getFileObject=rs.getString("Namn");
                System.out.println("Test metod getFileObject = " + getFileObject);
        
        }  catch (Exception e){
            System.out.println(e);
            }
    
return getFileObject;
}

}
