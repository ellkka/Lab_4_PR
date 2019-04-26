
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SMTP_SendMailSSL implements ActionListener {
    public void actionPerformed(ActionEvent e1) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("","");//mail , password
                    }
                });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(""));//mail send
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(""));//mail inbox
            message.setSubject("Testing Subject");
            message.setText("Metoda SMTP!");

            Transport.send(message);
            System.out.println("Done");
        }
        catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}