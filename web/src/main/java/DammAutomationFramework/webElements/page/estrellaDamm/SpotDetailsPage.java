package DammAutomationFramework.webElements.page.estrellaDamm;

import DammAutomationFramework.webElements.component.SpotItem;
import com.github.webdriverextensions.WebRepository;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static DammAutomationFramework.config.Properties.General.PAGE_LOAD_TIMEOUT;
import static com.github.webdriverextensions.Bot.*;

public class SpotDetailsPage extends WebRepository {

    @FindBy(css = ".page-node-type-place") private WebElement spotDetailsMainBody;
    @FindBy(css = "section.container-fluid.laguia") private WebElement spotBanner;
    @FindBy(css = ".list-rrss a.favourite") private WebElement favouriteIconBanner;
    @FindBy(css = "section.subtitle-jornada") private WebElement subTitle;
    @FindBy(css = "div.laguia") private WebElement spotContent;

    public void assertIsOpen() {
        waitForPageToLoad(PAGE_LOAD_TIMEOUT);
        assertIsDisplayed(spotDetailsMainBody);
        assertIsDisplayed(spotBanner);
        assertIsDisplayed(subTitle);
        assertIsDisplayed(spotContent);
    }

    public void clickOnFavoriteIconOnBanner () {
        favouriteIconBanner.click();
    }
}