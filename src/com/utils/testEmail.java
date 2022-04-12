package com.utils;
 
import java.util.Date ;
import java.util.Properties;
 
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import org.springframework.stereotype.Repository;

import com.vo.TowDetailsVO;
@Repository 
public class testEmail {
 
    public void sendHtmlEmail(TowDetailsVO towdetailsVO) throws Exception {
 
    	String host="smtp.gmail.com";
    	String port="587";
    	
    	final String userName="fmvtestbasic@gmail.com";
    	final String password="pritthakkar12345";
    	String toAddress=(String)towdetailsVO.getRtoVO().getOwnerEmail();;
    	String subject="YOUR VEHICLE HAS BEEN TOWED!";
    	String[] location = towdetailsVO.getImageupvo().getLocationVO().getLocation().split("-");
    	String message="Hello "+towdetailsVO.getRtoVO().getOwnerName()+",<br><br>Your vehicle : ("+towdetailsVO.getRtoVO().getNumPlate()+") is towed,<br><br> <u><i>PLEASE COLLECT IT FROM</u></i><br><br><hr><br><table><tr><td>Location:</td><td><b>"+location[0]+"</b></td></tr><tr><td>Area:</td><td><b>"+towdetailsVO.getImageupvo().getLocationVO().getAreaVO().getAreaName()+"</b></td></tr><tr><td>Date:</td><td><b>"+towdetailsVO.getDate()+"</b></td></tr></table><hr>  <b>Google Maps:<span style='color : blue;'><u>"+location[1]+"</u></span> ";   
    	
    	
        // sets SMTP server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
 
        // creates a new session with an authenticator
        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        };
 
        
        Session session = Session.getInstance(properties, auth);
 
        // creates a new e-mail message
        Message msg = new MimeMessage(session);
 
        
        msg.setFrom(new InternetAddress(userName));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        // set plain text message
        msg.setContent(message, "text/html");
        
 
        // sends the e-mail
        Transport.send(msg);
        
        /*String messagee = "Hello "+towdetailsVO.getRtoVO().getOwnerName()+",Your vehicle : ("+towdetailsVO.getRtoVO().getNumPlate()+") is TOWED!!!,\nPLEASE COLLECT IT FROM \nLocation:"+towdetailsVO.getImageupvo().getLocationVO().getLocation()+"\nArea:"+towdetailsVO.getImageupvo().getAreaVO().getAreaName()+"\nDate:"+towdetailsVO.getDate()+"";
    	
		String phone = towdetailsVO.getRtoVO().getContactNumber();
		String username = "fmv";
		String passwordd = "fmv";
		String address = "http://192.168.43.18";
		String portt = "8090";
		
		URL url = new URL(
				address+":"+portt+"/SendSMS?username="+username+"&password="+passwordd+
				"&phone="+phone+"&message="+URLEncoder.encode(messagee,"UTF-8"));
		
		URLConnection connection = url.openConnection();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		while((inputLine = bufferedReader.readLine()) !=null){
			System.out.println(inputLine);
		}
		bufferedReader.close();*/
 
    }
    
    
    
 
    /**
     * Test the send html e-mail method
     *
     */
   
  }
