package DammAutomationFramework.utils;

import com.sun.mail.imap.IMAPFolder;

import javax.mail.*;
import java.util.Properties;

public class IMAPClient {

    public static void main(String[] args) {

        String host = "imap.gmail.com";
        String username = "dummytestmindata@gmail.com";
        String password = "MDTest1234";

        System.out.println("Starting...");

        retriveAllMessages(host, username, password);
    }

    // retrive all mails
    private static Message[] retriveAllMessages(String host, String username, String password) {
        try {
            // IMAP 1st try - works fine
            Properties properties = new Properties();
            properties.setProperty("mail.imap.ssl.enable", "true");
            Session session = Session.getInstance(properties);
            Store store = session.getStore("imap");
            store.connect(host, username, password);

            System.out.println("After connection...");

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);

            //close the store and folder objects
            emailFolder.close(false);
            store.close();

            return messages;
        } catch (NoSuchProviderException e) {
            e.printStackTrace();

            throw new Error("Failed trying to retrive mails: " + e);
        } catch (Exception e) {
            e.printStackTrace();

            throw new Error("Failed trying to retrive mails: " + e);
        }
    }

    // get mails with specific subject
    // get mails since specific moment
    // get mails from specific sender
    private void processMessages(Message[] messages) {
        try {
            for (Message message: messages) {
                System.out.println("---------------------------------");
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
