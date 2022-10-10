package com.it.soul.utils;
import java.security.Security;
        import java.util.Properties;
        import javax.mail.Message;
        import javax.mail.PasswordAuthentication;
        import javax.mail.Session;
        import javax.mail.Transport;
        import javax.mail.internet.InternetAddress;
        import javax.mail.internet.MimeMessage;

class MailerApp {
    private String mailhost = "smtp.gmail.com";

    public synchronized void sendMail(String subject, String body,
                                      String sender, String recipients) throws Exception {

        Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.host", mailhost);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.quitwait", "false");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(
                                "soulcafeteam@gmail.com", "Soulasdfghjkl");
                    }
                });

        MimeMessage message = new MimeMessage(session);
        message.setSender(new InternetAddress(sender));
        message.setSubject(subject);
        message.setContent(body, "text/plain");
        if (recipients.indexOf(',') > 0)
            message.setRecipients(Message.RecipientType.TO, InternetAddress
                    .parse(recipients));
        else
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(
                    recipients));

        Transport.send(message);

    }

    public static void main(String args[]) throws Exception {
        MailerApp mailutils = new MailerApp();
        mailutils.sendMail(
                "Email Tests",
                "hi welcome to soul cafe, we are happy to see you",
                "soulcafeteam@gmail.com",
                "stevenshichaoyi@gmail.com");
    }

}