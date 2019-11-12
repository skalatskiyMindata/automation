package DammAutomationFramework.page;

import com.github.webdriverextensions.WebRepository;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.webdriverextensions.Bot.assertTextContains;
import static com.github.webdriverextensions.Bot.waitFor;
import static java.util.concurrent.TimeUnit.SECONDS;

public class ResultsPage extends WebRepository {

    // Logger
    private static final Logger log = LoggerFactory.getLogger(ResultsPage.class);

    // Model
    @FindBy(id = "search")
    private WebElement searchResult;

    public void failIfResultsDoesNotContainsText(String textToCheck) {
        waitFor(3, SECONDS);
        assertTextContains(textToCheck, searchResult);
    }
}
