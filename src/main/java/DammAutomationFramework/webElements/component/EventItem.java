package DammAutomationFramework.webElements.component;

import com.github.webdriverextensions.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EventItem extends WebComponent {

    @FindBy(css = ".favourite span") public WebElement favoriteIcon;
    @FindBy(css = ".h3") public WebElement title;
    @FindBy(css = ".date") public WebElement date;
    @FindBy(css = "button") public WebElement button;
}
