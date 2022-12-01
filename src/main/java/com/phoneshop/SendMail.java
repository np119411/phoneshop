package com.phoneshop;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.phoneshop.shopping.Cart;
import com.phoneshop.shopping.LineItem;

import java.util.Properties;

public class SendMail {

    public static void sendMail(String recieverMail, Cart cart, String address) {

        // Recipient's email ID needs to be mentioned.
        String to = recieverMail;

        // Sender's email ID needs to be mentioned
        String from = "ngankoyeuai671192@gmail.com";

        // Assuming you are sending email from through gmails smtp
        String host = "smtp.gmail.com";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        ///System.getenv("EMAIL");

        System.out.println(System.getenv("APP_PASSWORD"));
        // Get the Session object.// and pass username and password
        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

            protected PasswordAuthentication getPasswordAuthentication() {
                 //setup app password reference https://support.google.com/accounts/answer/185833?hl=en
                return new PasswordAuthentication(from, System.getenv("APP_PASSWORD"));

            }

        });

        // Used to debug SMTP issues
        session.setDebug(true);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Có đơn hàng mới nè!");
            
            String content ="";
            
            content = content + "Address: "+ address +"\n";
            String listLineItem ="";
            for (LineItem lineitem: cart.getLineItems()) {
            	if (lineitem.getPhoneDTO() != null) {
            		listLineItem = listLineItem + "Name: " +lineitem.getPhoneDTO().getName() + "---- quantity: "+ lineitem.getQuantity() + "\n";
            	}
            	
            }
            content = content + listLineItem;
            //message.setText(from, host);
            // Now set the actual message
            message.setText(content);
            System.out.println("sending...");
            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
    public static void main(String[] args) {
    	Cart cart = new Cart();
    	
        sendMail("19110096@student.hcmute.edu.vn", cart, "Nghe An");
    }

}
