package org.nuc.purefriends.util;

import org.nuc.purefriends.model.MailObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by zhangliang on 15/11/13.
 */
public class MailUtil {

    private final static Logger LOGGER = LoggerFactory.getLogger( MailUtil.class);

    public static void mailTo(MailObject object) {

        String hostname = object.getHostname();

        Properties props = System.getProperties();
        props.put("mail.transpot.protocol", "smtp");
        props.put("mail.store.protocol", "imap");
        props.put("mail.smtp.class", "com.sun.mail.smtp.SMTPTransport");
        props.put("mail.imap.class", "com.sun.mail.IMAPStore");
        props.put("mail.smtp.host", hostname);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.connectiontimeout", "10000");
        props.put("mail.smtp.timeout", "10000");

        Authenticator au = new Authenticator() {

            @Override
            public PasswordAuthentication getPasswordAuthentication() {

                // TODO Auto-generated method stub
                String username = object.getMailAuthentication().getUsername();
                String password = object.getMailAuthentication().getPassword();
                return new PasswordAuthentication(username, password);
            }

        };

        Session mailsession = Session.getInstance(props, au);
        MimeMessage msg = new MimeMessage(mailsession);

        InternetAddress[] toAddrs = new InternetAddress[0];
        try {
            toAddrs = InternetAddress.parse(object.getToAddresses(), false);
        } catch (AddressException e) {
            e.printStackTrace();
            LOGGER.error( e.getMessage(), e);
        }
        try {
            msg.setRecipients(Message.RecipientType.TO, toAddrs);
            msg.setRecipients(Message.RecipientType.CC, object.getCcAddresses());
            msg.setSubject(object.getSubject(), "UTF-8");
            msg.setFrom(new InternetAddress(object.getMailAuthentication().getUsername()));
            msg.setText(object.getBody(), "UTF-8", "html");
        } catch (MessagingException e) {
            e.printStackTrace();
            LOGGER.error( e.getMessage(), e);
        }

        LOGGER.debug("=== Email Debug ===");
        LOGGER.debug(object.getSubject());
        LOGGER.debug(object.getToAddresses());
        LOGGER.debug(object.getBody());
        try {
            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
            LOGGER.error( e.getMessage(), e);
        }
    }
}
