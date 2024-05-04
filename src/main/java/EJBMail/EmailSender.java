package EJBMail;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class EmailSender {

    public static void main(String[] args) {
        // Set up mail server properties
        Properties properties = new Properties();
        properties.put("mail.smtp.host", "smtp.gmail.com"); // Replace with your SMTP server host
        properties.put("mail.smtp.port", "587"); // Replace with your SMTP server port
        properties.put("mail.smtp.auth", "true"); // Enable authentication
        properties.put("mail.smtp.starttls.enable", "true"); // Enable STARTTLS

        // Set up authentication credentials
        String username = "guruteja799@gmail.com"; // Replace with your email address
        String password = "guruteja@123"; // Replace with your email password

        // Create a mail session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username)); 
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("guruteja799@gmail.com")); // Set recipient email address
            message.setSubject("Test Email"); // Set email subject
            message.setText("This is a test email sent from JavaMail."); // Set email content

            // Send the message
            Transport.send(message);

            System.out.println("Email sent successfully.");
        } catch (MessagingException e) {
            System.err.println("Error sending email: " + e.getMessage());
        }
    }
}
