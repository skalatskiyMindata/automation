package DammAutomationFramework.webElements.component;

import com.github.webdriverextensions.WebRepository;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.github.webdriverextensions.Bot.assertIsDisplayed;

public class AccessGenericComponent extends WebRepository {

    // TODO: Temporary until DammID is implemented
    // For results page
    @FindBy(css = "div#modal-login-place") private WebElement resultsAccessContainer;
    @FindBy(css = "div#register-account") private WebElement resultsRegisterForm;

    // For details page
    @FindBy(css = "div#modal-login") private WebElement detailsAccessContainer;
    @FindBy(css = "div#register-account3") private WebElement detailsRegisterForm;

    // For sorteo
    @FindBy(css = "div#modal-login-sorteo") private WebElement sorteoAccessContainer;
    @FindBy(css = "div#register-account4") private WebElement sorteoRegisterForm;

    public void failIfIsNotDisplayedOnGuia() {
        assertIsDisplayed(resultsAccessContainer);
        assertIsDisplayed(resultsRegisterForm);
    }

    public void failIfIsNotDisplayedOnDetailsPage() {
        assertIsDisplayed(detailsAccessContainer);
        assertIsDisplayed(detailsRegisterForm);
    }

    public void failIfIsNotDisplayedOnAgenda() {
        assertIsDisplayed(detailsAccessContainer);
        assertIsDisplayed(resultsRegisterForm);
    }

    public void failIfIsNotDisplayedOnSorteo() {
        assertIsDisplayed(sorteoAccessContainer);
        assertIsDisplayed(sorteoRegisterForm);
    }
}
