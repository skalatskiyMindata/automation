package DammAutomationFramework.webElements.component;

import com.github.webdriverextensions.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AgeCheckComponent extends WebComponent {

    @FindBy(css = "button.js-close-prehome")
    public WebElement accessButton;
}
