package DammAutomationFramework.webElements.component;

import com.github.webdriverextensions.WebComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpotItem extends WebComponent {

    @FindBy(css = ".av-container span") public WebElement location;
    @FindBy(css = ".reallyslow") public WebElement title;
    @FindBy(css = ".lafoto") public WebElement lafoto;
    @FindBy(css = ".favourite span") public WebElement favoriteIcon;
}
