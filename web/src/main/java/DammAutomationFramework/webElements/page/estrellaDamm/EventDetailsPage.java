package DammAutomationFramework.webElements.page.estrellaDamm;

import com.github.webdriverextensions.WebRepository;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.github.webdriverextensions.Bot.assertIsDisplayed;
import static com.github.webdriverextensions.Bot.waitForPageToLoad;

public class EventDetailsPage extends WebRepository {

    @FindBy(css = ".page-node-type-event") private WebElement eventDetailsMainBody;
    @FindBy(css = "section[data-section-name=\"ficha-agenda\"]") private WebElement eventBanner;
    @FindBy(css = ".banner-main-page button.btn-contest-info") private WebElement participateButton;
    @FindBy(css = ".list-rrss a.favourite") private WebElement favouriteIconBanner;
    @FindBy(css = "section#agenda") private WebElement eventContent;

    public void assertIsOpen() {
        waitForPageToLoad();
        assertIsDisplayed(eventDetailsMainBody);
        assertIsDisplayed(eventBanner);
        assertIsDisplayed(eventContent);
    }

    public void clickOnFavoriteIconOnBanner () {
        favouriteIconBanner.click();
    }

    public void clickOnParticipateOnBanner() {
        participateButton.click();
    }
}