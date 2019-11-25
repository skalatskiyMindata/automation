package DammAutomationFramework.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DataHandler {

    public String generateUniqueID () {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("MMdd-HHmm-ss");
        df.setTimeZone(tz);

        return df.format(new Date());
    }
}
