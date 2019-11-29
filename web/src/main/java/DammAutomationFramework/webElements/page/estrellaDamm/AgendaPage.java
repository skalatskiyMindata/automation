package DammAutomationFramework.webElements.page.estrellaDamm;

import DammAutomationFramework.utils.DataHandler;
import DammAutomationFramework.webElements.component.EventItem;
import com.github.webdriverextensions.WebRepository;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.github.webdriverextensions.Bot.*;

public class AgendaPage extends WebRepository {

    @FindBy(className = "page-node-type-agenda") private WebElement agendaMainContainer;
    @FindBy(css = "a[id*=event-]") private List<EventItem> eventResults;

    public void assertIsOpen() {
        waitForPageToLoad();
        assertIsDisplayed(agendaMainContainer);
    }

    public int getEventsNumber() {
        return eventResults.size();
    }

    public EventItem pickSpecificEvent (String textToSearch) {
        EventItem selectedOption = DataHandler.pickAnOption(textToSearch, eventResults);

        String location = selectedOption.title.getAttribute("innerText");
        System.out.println("event title: " + location);

        return selectedOption;
    }

    public void clickOnASpecificEvent (EventItem eventItem) {
        eventItem.click();
    }

    public void clickOnFavoriteIconOnASpecificEvent (EventItem eventItem) {
        eventItem.favoriteIcon.click();
    }
}
