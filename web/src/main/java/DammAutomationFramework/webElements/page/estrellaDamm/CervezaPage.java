package DammAutomationFramework.webElements.page.estrellaDamm;
import com.github.webdriverextensions.Bot;
import com.github.webdriverextensions.WebPage;
import com.github.webdriverextensions.WebRepository;
import com.github.webdriverextensions.WebSite;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

import static com.github.webdriverextensions.Bot.assertIsDisplayed;
import static com.github.webdriverextensions.Bot.waitFor;

public class CervezaPage extends WebRepository {

   @FindAll({
       @FindBy(className = "historia"),
       @FindBy(className = "block-2"),
       @FindBy(className = "block-3"),
       @FindBy(className = "block-4"),
       @FindBy(className = "block-5"),
       @FindBy(className = "block-6"),
       @FindBy(className = "block-7"),
       @FindBy(className = "block-8")
    })
    private List<WebElement> sections;



    public void assertIsOpen(Object... arguments) {
        for (WebElement item: sections){
            Bot.scrollTo(item);
            assertIsDisplayed(item);
            waitFor(3);
        }
    }
}
