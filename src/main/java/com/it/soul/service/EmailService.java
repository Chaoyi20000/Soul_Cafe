package com.it.soul.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService{

    @Autowired private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}") private String sender;

    public void sendMail(String recipient, String customerName, String orderNumber){
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(recipient);

            String msg = "Dear " + customerName + "\n"
                    + "We have completed your order.\n"
                    + "Your order number is " + orderNumber + ". "
                    + "Please use the number to collect your coffee!";

            mailMessage.setText(msg);
            mailMessage.setSubject("Your order has been completed - Soul Cafe");

            javaMailSender.send(mailMessage);
        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

