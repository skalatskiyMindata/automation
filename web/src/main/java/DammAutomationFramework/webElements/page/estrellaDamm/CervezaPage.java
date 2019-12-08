package DammAutomationFramework.webElements.page.estrellaDamm;
import com.github.webdriverextensions.Bot;
import com.github.webdriverextensions.WebRepository;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.github.webdriverextensions.Bot.*;

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

    @FindBy(id = "Wifrm")
    private WebElement pixel;

    public void assertIsOpen(Object... arguments) {
        for (WebElement item: sections){
            scrollTo(item);
            assertIsDisplayed(item);
            //waitFor(3);
        }
    }

    public void assertPixelEnabled() {

        assertIsEnabled(pixel);
    }
}
