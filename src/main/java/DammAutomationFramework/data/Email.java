package DammAutomationFramework.data;

import lombok.Data;

import java.util.Date;
import java.util.Locale;

@Data
public class Email {

    public String subject;
    public String from;
    public Date date;
    public String text;

    public Email (String subject, String from, Date date, String text) {
        this.subject = subject;
        this.from = from;
        this.date = date;
        this.text = text;
    }
}
