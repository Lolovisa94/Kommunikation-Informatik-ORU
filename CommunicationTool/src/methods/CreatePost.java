/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;
import Objects.CurrentUser;
import javax.swing.JOptionPane;
import java.sql.Statement;
import java.sql.ResultSet;
import GUI.CreatePostGUI;
import Objects.LatestPost;
import mail.Mail;
/**
 *
 * @author hamma
 */
public final class CreatePost
    {
    private int id;
    private String titel; //borde fungera
    private String text; //borde fungera
    private final String publiceringsdatum; //borde fungera
    private final String publiceringstid; //borde fungera
    private int kategori_ID; //borde
    private String kategori;
    private final String publicerare;
    private ResultSet rs = null;
    public static boolean postCreated = false;
    public static boolean titleExists = false;


    /**
     *
     */
    public CreatePost ()
    {
        this.publiceringsdatum = java.time.LocalDate.now().toString();
        this.publiceringstid = java.time.LocalTime.now().toString();
        this.publicerare = CurrentUser.currentUser.getName();
        this.text = CreatePostGUI.textField();
        this.kategori = CreatePostGUI.getCategory();
        this.titel = CreatePostGUI.getTitel();
        createPostSQL();
        sendEmailNotification();

    }
    @SuppressWarnings("UseSpecificCatch")
    
    public void sendEmailNotification(){
        
        
            if(postCreated){
            String selectIDQuery = "SELECT Inl�gg_ID FROM Inl�gg where Titel = '" + titel + "'";
                try{
            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            rs = st.executeQuery(selectIDQuery);
            rs.next();
            id = rs.getInt("Inl�gg_ID");
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null, "N�got gick fel kontakta IT med felkod" + e);
                    System.out.println(e);
                }
                Inlagg newPost = new Inlagg(id, titel, text, publiceringstid, kategori_ID);
                
                LatestPost.inlagg = newPost; 
                
                Mail mail = new Mail();
                mail.lagraEmail();
                mail.iterationMail();
            }
    }       
    
    
    public boolean createPostSQL()
    {
        postCreated = false;
        titleExists = false;

        try{
            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            String checkTitleSQL = "SELECT Titel FROM Inl�gg";
            rs = st.executeQuery(checkTitleSQL);
                    while(rs.next()){
                    if(titel.toLowerCase().equals(rs.getString("Titel").toLowerCase())){
                    
                        titleExists = true;
                        
                    }
                    
                    }
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "N�got gick fel kontakta IT med felkod " +e);
            
        }

        
        if(!CreatePostGUI.titleEmpty && !CreatePostGUI.textEmpty){
            if(!titleExists){
          if(!CreatePostGUI.titleTooLong){
              if(!CreatePostGUI.textTooLong){
        try
        {       Statement st = Connectivity.ConnectionClass.conn.createStatement();
                    String categorySQL = "SELECT * FROM Kategori where Kategori.Namn = '" + kategori + "'";//from dropdown
                    rs = st.executeQuery(categorySQL);
                    rs.next();
                    int kategoriIDSQL = rs.getInt("Kategori_ID");
                    this.titel = titel;
                    this.text = text;
                    this.kategori_ID = (kategoriIDSQL);
                    String addTitelSQLQuery = "INSERT INTO Inl�gg (Titel, Text, PubliceringsDatum, PubliceringsTid, Kategori_ID) VALUES('" + titel + "', '" + text + "', '" + publiceringsdatum + "', '" + publiceringstid + "', " + kategori_ID + ")";
                    st.executeUpdate(addTitelSQLQuery);
                    JOptionPane.showMessageDialog(null, "Inl�gg postat!");
                    postCreated = true;
                    SQLUser();
                    
        }
        catch (Exception e) 
        {
		System.out.println(e);
                JOptionPane.showMessageDialog(null, "N�got gick fel. Kontakta administrat�r. Felkod " + e);
               
        }
              }else{
                  JOptionPane.showMessageDialog(null, "OJ! Du gillar att skriva, tyv�rr har du �verskridit maxl�ngden p� ditt Inneh�ll, inneh�llet f�r som l�ngst vara 8000 tecken l�ng.");
              }
              
          } else{
          
              JOptionPane.showMessageDialog(null, "Du har �verskridit maxl�ngden p� din Titel, titeln f�r som l�ngst vara 45 tecken l�ng. ");
          
          }
              
              
          }else{
              JOptionPane.showMessageDialog(null, "Titeln existerar redan, d�p om tr�den till n�got annat innan du postar, eller kolla in den tr�den");
              
          }
        }else{
        JOptionPane.showMessageDialog(null, "Du beh�ver fylla i Tr�dtitel och Inneh�ll f�r att posta inl�gg");
        }
        return postCreated;
        
    }
    
    @SuppressWarnings("UseSpecificCatch")
    public void SQLUser()
    {
        try
        {
            Statement st = Connectivity.ConnectionClass.conn.createStatement();
            String postSQLQuery = "SELECT Inl�gg_ID FROM Inl�gg WHERE Titel = " + "'" + titel + "'";
            rs = st.executeQuery(postSQLQuery);
            rs.next();
            int postSQLAnswer = rs.getInt("Inl�gg_ID");
            String userSQLQuery = "SELECT Anv�ndare_ID FROM Anv�ndare WHERE Namn = '" + publicerare + "'";
            rs = st.executeQuery(userSQLQuery);
            rs.next();
            int userSQLAnswer = rs.getInt("Anv�ndare_ID");
            String userInsertQuery = "INSERT INTO Inl�gg_Anv�ndare VALUES (" + postSQLAnswer + ", " + userSQLAnswer + ")";
            st.executeUpdate(userInsertQuery);
        }
        catch(Exception e)
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "N�got gick fel. Kontakta administrat�r. Felkod " + e);
        }
    }

    private Inlagg newInlagg() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}