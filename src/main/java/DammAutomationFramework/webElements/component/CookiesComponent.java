package DammAutomationFramework.webElements.component;

import com.github.webdriverextensions.WebRepository;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CookiesComponent extends WebRepository {

    // Model
    @FindBy(id = "sliding-popup") private WebElement cookiesSlider;
    @FindBy(className = "eu-cookie-compliance-secondary-button") private WebElement acceptCookies;

    //methods
    public void clickOnAcceptCookies() {
        if (cookiesSlider.isEnabled()) {
            acceptCookies.click();
        }
    }
}
