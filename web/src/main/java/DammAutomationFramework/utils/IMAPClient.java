package DammAutomationFramework.utils;

import DammAutomationFramework.data.Email;

import javax.mail.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class IMAPClient {

    private static String HOST = "imap.gmail.com";
    private static String USERNAME = "dummytestmindata@gmail.com";
    private static String PASSWORD = "MDTest1234";

    public static void failIfMailIsNotReceived(String sender, String subject) {
        List<Email> emails = retrieveAllMessages(HOST, USERNAME, PASSWORD);

        filterMessages(emails, 120, sender, subject);
    }

    // retrieve all mails
    private static List<Email> retrieveAllMessages(String host, String username, String password) {
        try {
            Properties properties = new Properties();
            properties.setProperty("mail.imap.ssl.enable", "true");
            Session session = Session.getInstance(properties);
            Store store = session.getStore("imap");
            store.connect(host, username, password);
            Folder emailFolder = store.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);
            Message[] messages = emailFolder.getMessages();
            // TODO: Implement search term concept
            List<Email> emails = convertToEmails(messages);
            emailFolder.close(false);
            store.close();

            return emails;

        } catch (NoSuchProviderException e) {
            e.printStackTrace();

            throw new Error("Failed trying to retrive mails: " + e);
        } catch (Exception e) {
            e.printStackTrace();

            throw new Error("Failed trying to retrive mails: " + e);
        }
    }

    private static List<Email> convertToEmails(Message[] messages) {
        List<Email> emails = new ArrayList<Email>();

        try {
            for (Message message : messages) {
                emails.add(new Email(message.getSubject(),
                        message.getFrom()[0].toString(),
                        message.getReceivedDate(),
                        message.getContent().toString()) {
                });
            }

            return emails;

        } catch (MessagingException e) {
            e.printStackTrace();

            throw new Error(e);
        } catch (Exception e) {
            e.printStackTrace();

            throw new Error(e);
        }
    }

    // TODO: Improve filter logic
    private static List<Email> filterMessages(List<Email> emails, int sinceWhen, String fromWho, String subject) {
        Instant sinceWhenMoment = new Date().toInstant().minusSeconds(sinceWhen);
        List<Email> filteredEmails = new ArrayList<>();

        for (Email email : emails) {
            if (email.date.toInstant().isAfter(sinceWhenMoment)) {
                if (Validation.doesString1ContainString2(email.from, fromWho)) {
                    if (Validation.doesString1ContainString2(email.subject, subject)) {
                        filteredEmails.add(email);
                    }
                }
            }

        }

        if (filteredEmails.isEmpty()) {
            throw new Error("Mails not found from '" + fromWho + "' sender, after '" + sinceWhenMoment + "' and '" + subject + "' subject.");
        }

        return emails;
    }
}
