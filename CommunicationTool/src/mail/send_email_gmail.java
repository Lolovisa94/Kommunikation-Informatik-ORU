
package mail;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*; 
import javax.mail.*; 
import javax.mail.PasswordAuthentication;
import javax.mail.internet.*;

public class send_email_gmail {
    
    Mail m = new Mail();
    
    public static boolean iterationDone;
   
    //ArrayList<String> arrayEmail, ArrayList<String> arrayNamn
    public void mail(ArrayList<String> arrayEmail, ArrayList<String> arrayName, String titel) {
         //
         
         final String username = "InformatikOrebro@gmail.com";
		final String password = "Jonas991";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props,
		  
                        new javax.mail.Authenticator() {
			
                      protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
			}
		  });
		try {
                    
                
                    //for loop
                   for(int i = 0; i< arrayEmail.size(); i++)  {
                             
                        Message message = new MimeMessage(session);
			//message.setFrom(new InternetAddress("fromemail@gmail.com"));
                        message.setFrom(new InternetAddress(arrayEmail.get(i)));                        
			message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(arrayEmail.get(i)));
			message.setSubject("Titel innehåll");    
			message.setText("Hej! " + arrayName.get(i) + " En ny post har lagts upp med titeln: " + titel);   
                       
                        
                        //message.setDisposition("Inlägget handlar om rödluvan och hur hon influerat lärarna på informatik programmet!");
                    
			Transport.send(message);
			System.out.println("Done");                                                                       
                   }
                   
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
         
     }
    
    public void mailComments(String title, ArrayList<String> emailCommentator) {
         //
         
         final String username = "InformatikOrebro@gmail.com";
		final String password = "Jonas991";
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props,
		  
                        new javax.mail.Authenticator() {
			
                      protected PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(username, password);
			}
		  });
                
 
		try {
                    
                
                    
                    //for loop
                   for(int i = 0; i< emailCommentator.size(); i++)  {
                             
                        Message message = new MimeMessage(session);
			//message.setFrom(new InternetAddress("fromemail@gmail.com"));
                        message.setFrom(new InternetAddress(emailCommentator.get(i)));                        
			message.setRecipients(Message.RecipientType.TO,
			InternetAddress.parse(emailCommentator.get(i)));
			message.setSubject("Ny kommentar");    
			message.setText("Hej! " + " En ny kommentar har lagts på tråden " + "'" + title + "'");   
                        
                        //message.setDisposition("Inlägget handlar om rödluvan och hur hon influerat lärarna på informatik programmet!");
                    
			Transport.send(message);
			System.out.println("Done");                                                                       
                   }
                   
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
         
     }
	
	
}
