package DammAutomationFramework.utils;

import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import static com.github.webdriverextensions.Bot.scrollTo;

public class DataHandler {

    public static String generateUniqueID () {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("MMdd-HHmm-ss");
        df.setTimeZone(tz);

        return df.format(new Date());
    }

    public static <T extends WebElement> T pickAnOption (String optionToSelect, List<T> options) {
        if (optionToSelect.equalsIgnoreCase("first")) {
            return options.get(0);
        } else {
            for (T option: options) {
                String optionText = option.getAttribute("innerText");
                System.out.println("optionText: " + optionText);

                if (optionText.contains(optionToSelect)) {
                    return option;
                }
            }
        }

        throw new Error("The option '" + optionToSelect + "' that you want to select is not present");
    }
}
