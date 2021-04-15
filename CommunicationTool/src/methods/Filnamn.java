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
public class Filnamn {
    private String fileName;
    private ResultSet rs= null;
    public Path Filnamn(String filepath){
       Path path = Paths.get(filepath);
    Path filename = path.getFileName();
        setShortName(filename.toString());
        return filename;
        
   
    }
    public void setShortName(String fileName){
        this.fileName=fileName;
    
    }
    public String getFilename(){
    return fileName;
    }
    
public boolean checkFileName(String fileName) throws SQLException{
   
                    Statement st =Connectivity.ConnectionClass.conn.createStatement();
                    String freeFileName = "SELECT * FROM Filer where Namn =" + "'" + fileName + "'";
                rs = st.executeQuery(freeFileName);
               boolean emptyUploadName= rs.next();
    return emptyUploadName;
}
public void linkFileToPost(String name) throws SQLException{
Statement st =Connectivity.ConnectionClass.conn.createStatement();
String getPostID = "SELECT Inlägg_ID FROM Inlägg ORDER BY Inlägg_ID DESC LIMIT 1";
rs=st.executeQuery(getPostID);
rs.next();
int postID =rs.getInt("Inlägg_ID");
String createFile = "Insert into Filer (Namn, Inlägg_ID) values ('" + name + "'" + "," + postID + ")";
st.executeUpdate(createFile);
}
}
