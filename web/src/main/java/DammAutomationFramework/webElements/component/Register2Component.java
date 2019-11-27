package DammAutomationFramework.webElements.component;

import com.github.webdriverextensions.WebRepository;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.github.webdriverextensions.Bot.assertIsDisplayed;
import static com.github.webdriverextensions.Bot.waitForElementToDisplay;

public class Register2Component extends WebRepository {

    // Model
    @FindBy(css = "div#modal-login-place") private WebElement registerContainer;
    @FindBy(id = "btn-fb-login") private WebElement registerByFacebookButton;

    @FindBy(id = "register-account") private WebElement registerForm;


    //methods
    public void failIfIsNotDisplayed() {
        assertIsDisplayed(registerContainer);
        assertIsDisplayed(registerForm);
    }
}
