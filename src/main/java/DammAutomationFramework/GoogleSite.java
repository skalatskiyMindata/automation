package DammAutomationFramework;

import DammAutomationFramework.page.ResultsPage;
import DammAutomationFramework.page.SearchPage;
import com.github.webdriverextensions.WebSite;
import static com.github.webdriverextensions.Bot.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GoogleSite extends WebSite {

    // Logger
    private static final Logger log = LoggerFactory.getLogger(GoogleSite.class);

    // Url
    public static String url = ".";

    // Pages
    public SearchPage mainPage;
    public ResultsPage resultsPage;
    // ...add your Site's WebPages here

    public void open(Object... arguments) {
        open(url);
    }

    @Override
    public void assertIsOpen(Object... arguments) throws Error {
        assertCurrentUrlStartsWith(url);
    }

}
