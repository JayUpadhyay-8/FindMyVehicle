package com.utils;

import java.util.Random;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class Basemethods {
	
	public static String getUser(){
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = user.getUsername();
		return userName;
	} 
	
	// Send mail to user
		protected static void sendMail(String email, String subject , String content) {

			java.util.Properties properties = new java.util.Properties();
			properties.put("mail.smtp.auth", "true");
			properties.put("mail.smtp.starttls.enable", "true");
			javax.mail.Session mailSession = javax.mail.Session.getInstance(properties);

			try {
				MimeMessage message = new MimeMessage(mailSession);

				message.setContent(content, "text/html");
				message.setSubject(subject);

				InternetAddress sender = new InternetAddress("noreplymisbehave@gmail.com", "Study Portal");
				InternetAddress receiver = new InternetAddress(email);
				message.setFrom(sender);
				message.setRecipient(MimeMessage.RecipientType.TO, receiver);
				message.saveChanges();

				javax.mail.Transport transport = mailSession.getTransport("smtp");
				transport.connect("smtp.gmail.com", 587, "noreplymisbehave@gmail.com" , "rohananiket@12345");
				transport.sendMessage(message, message.getAllRecipients());
				transport.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		// Generate OTP
		protected static int generateOTP(int limit) {

	        int otp = 0;

	        if (limit > 5 || limit < 1)
	            limit = 3;

	        for (int i = 0; i < limit; i++) {

	            int x = new Random().nextInt(9);

	            if (x == 0 && i == 0)
	                i--;
	            else
	                otp = (otp * 10) + x;
	        }

	        return otp;
	    }
}
