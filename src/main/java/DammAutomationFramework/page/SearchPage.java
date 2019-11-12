package DammAutomationFramework.page;

import DammAutomationFramework.GoogleSite;
import DammAutomationFramework.component.ExampleWebComponent;
import com.github.webdriverextensions.WebRepository;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.Key;

public class SearchPage extends WebRepository {

    // Logger
    private static final Logger log = LoggerFactory.getLogger(SearchPage.class);

    // Url
    public String url = GoogleSite.url;

    // Model
    @FindBy(css = "cssselector")
    public WebElement exampleWebElement;
    @FindBy(css = "cssselector")
    public ExampleWebComponent exampleWebComponent;
    // ...add your Page's WebElements and WebComponents here

    // Model
    @FindBy(name = "q")
    private WebElement queryInput;
    @FindBy(name = "btnK")
    private WebElement searchButton;
    @FindBy(id = "search")
    WebElement searchResult;

    public void searchByText(String textToSearch) {
        // type(textToSearch, queryInput);
        queryInput.sendKeys(textToSearch);
        queryInput.sendKeys(Keys.ENTER);
        // click(searchButton);
        //searchButton.click();

    }
}
