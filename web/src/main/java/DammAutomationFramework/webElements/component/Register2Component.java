package DammAutomationFramework.webElements.component;

import com.github.webdriverextensions.WebRepository;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.github.webdriverextensions.Bot.assertIsDisplayed;
import static com.github.webdriverextensions.Bot.waitForElementToDisplay;

public class Register2Component extends WebRepository {

    // TODO: Temporary until DammID is implemented
    // For results page
    @FindBy(css = "div#modal-login-place") private WebElement resultsAccessContainer;
    @FindBy(css = "div#register-account") private WebElement resultsRegisterForm;

    // For details page
    @FindBy(css = "div#modal-login") private WebElement detailsAccessContainer;
    @FindBy(css = "div#register-account3") private WebElement detailsRegisterForm;


    public void failIfIsNotDisplayedOnResults() {
        assertIsDisplayed(resultsAccessContainer);
        assertIsDisplayed(resultsRegisterForm);
    }

    public void failIfIsNotDisplayedOnDetails() {
        assertIsDisplayed(detailsAccessContainer);
        assertIsDisplayed(detailsRegisterForm);
    }
}
