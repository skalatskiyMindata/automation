package DammAutomationFramework.webElements.page.estrellaDamm;
import com.github.webdriverextensions.Bot;
import com.github.webdriverextensions.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

import static com.github.webdriverextensions.Bot.assertIsDisplayed;
import static com.github.webdriverextensions.Bot.waitFor;

public class CervezaPage extends WebPage {

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

    @FindBy(css = "button.js-close-prehome")
    public WebElement accessButton;


    @Override
    public void open(Object... arguments) {
        String webURL = (String) arguments[0];
        System.out.println("webURL =" + webURL);
        open(webURL);
    }

    @Override
    public void assertIsOpen(Object... arguments) {
        for (WebElement items: sections){
            Bot.scrollTo(items);
            assertIsDisplayed(items);
            //waitFor(3);
        }
    }
}
