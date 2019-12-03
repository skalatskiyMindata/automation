package DammAutomationFramework.utils;

import com.sun.mail.imap.IMAPFolder;

import javax.mail.*;
import java.util.Properties;

public class IMAPClient {
    public static void check(String host, String username,
                             String password)
    {
        /* For try 2
        IMAPFolder folder = null;
        Store store = null;
        String subject = null;
        Flags.Flag flag = null;
         */

        try {
            // IMAP 1st try - works fine
            //create properties field
            ///*
            Properties properties = new Properties();

            properties.setProperty("mail.imap.ssl.enable", "true");
            // set any other needed mail.imap.* properties here
            Session session = Session.getInstance(properties);
            Store store = session.getStore("imap");
            store.connect(host, username, password);

            System.out.println("After connection...");
            //*/

            /* IMAP 2nd try - works fine
            Properties props = System.getProperties();
            props.setProperty("mail.store.protocol", "imaps");

            Session session = Session.getDefaultInstance(props, null);

            System.out.println("Props: " + props);

            store = session.getStore("imaps");

            System.out.println("getting Store....");

            store.connect("imap.googlemail.com",username, password);

            System.out.println("After connection...");
             */

            //create the folder object and open it
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            System.out.println("messages.length---" + messages.length);

            for (int i = 0, n = messages.length; i < n; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());

            }

            //close the store and folder objects
            emailFolder.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        String host = "imap.gmail.com";
        String username = "dummytestmindata@gmail.com";
        String password = "MDTest1234";

        System.out.println("Starting...");

        check(host, username, password);

    }


    //METHODS
    // get mails with specific subject
    // get mails since specific moment
    // get mails from specific sender
}
