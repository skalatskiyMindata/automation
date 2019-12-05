package DammAutomationFramework.webElements.page.estrellaDamm;

import DammAutomationFramework.utils.DataHandler;
import DammAutomationFramework.webElements.component.SpotItem;
import com.github.webdriverextensions.WebRepository;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static DammAutomationFramework.config.Properties.General.PAGE_LOAD_TIMEOUT;
import static com.github.webdriverextensions.Bot.*;

public class GuidePage extends WebRepository {

    @FindBy(css = "div.laguia") private WebElement guideMainContainer;
    @FindBy(css = "div.grid-item") private List<SpotItem> spotResults;

    public void assertIsOpen() throws Exception{
        waitForPageToLoad(PAGE_LOAD_TIMEOUT);
        waitForElementToDisplay(guideMainContainer, PAGE_LOAD_TIMEOUT);
        assertIsDisplayed(guideMainContainer);
    }

    public int getSpotsNumber() {
        return spotResults.size();
    }

//    public WebElement pickSpecificResult (String textToSearch) {
//        WebElement selectedOption = DataHandler.pickAnOption(textToSearch, spotResults);
//        System.out.println("selectedOption: " + selectedOption.getText());
//
//        String location = selectedOption.getText();
//        System.out.println("location: " + location);
//
//        scrollTo(selectedOption);
//
//        return selectedOption;
//    }

    public SpotItem pickSpecificResult (String textToSearch) {
        SpotItem selectedOption = DataHandler.pickAnOption(textToSearch, spotResults);
        scrollTo(selectedOption);

        String location = selectedOption.location.getAttribute("innerText");
        System.out.println("location: " + location);

        return selectedOption;
    }

    public void clickOnASpecificSpot (SpotItem spotItem) {
        spotItem.click();
    }

    public void clickOnFavoriteIconOnASpecificSpot (SpotItem spotItem) {
        spotItem.favoriteIcon.click();
    }
}
