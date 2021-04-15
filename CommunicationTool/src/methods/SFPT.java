/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package methods;
	
  
  import com.jcraft.jsch.*;
import java.io.File;
 
  public class SFPT {
  
     
     
      private Session session = null;
  
      public void connect() throws JSchException {
          JSch jsch = new JSch();
          String localDir = System.getProperty("user.dir");
           localDir =localDir.replace("\\", "\\\\"); 
           String windowsKey= localDir + "\\\\putty key.ppk" ;
           String macKey = localDir + "/putty key.ppk";
     
     if(localDir.startsWith("/")==true){
 jsch.addIdentity(macKey, "Tom123");}else{
         jsch.addIdentity(windowsKey, "Tom123");
     }
     



         // jsch.addIdentity(key, "Tom123");
  
          session = jsch.getSession("rsa-key-20210415", "34.118.46.184");
          session.setPassword("Tom123");

          session.setConfig("StrictHostKeyChecking", "no");
          session.connect();
      }
  
      public void upload(String source) throws JSchException, SftpException {
          Channel channel = session.openChannel("sftp");
          channel.connect();
          ChannelSftp sftpChannel = (ChannelSftp) channel;
          sftpChannel.put(source, "/home/rsa-key-20210415");
          sftpChannel.exit();
      }
 
      public void download(String source, String destination) throws JSchException, SftpException {
          Channel channel = session.openChannel("sftp");
          channel.connect();
          ChannelSftp sftpChannel = (ChannelSftp) channel;
          sftpChannel.get(source, destination);
          sftpChannel.exit();
      }
  
      public void disconnect() {
          if (session != null) {
              session.disconnect();
          }
      }
  }