package DammAutomationFramework.webElements.page.estrellaDamm;

import com.github.webdriverextensions.Bot;
import com.github.webdriverextensions.WebPage;
import com.github.webdriverextensions.WebRepository;
import com.github.webdriverextensions.WebSite;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

import static com.github.webdriverextensions.Bot.*;

public class CervezaDiaADiaPage extends WebRepository {

   @FindAll({
       @FindBy(xpath = "//a[contains(text(),'30 ene.')]"),
       @FindBy(xpath = "//a[contains(text(),'26 feb.')]"),
       @FindBy(xpath = "//a[contains(text(),'20 mar.')]"),
       @FindBy(xpath = "//a[contains(text(),'13 abr.')]"),
       @FindBy(xpath = "//a[contains(text(),'16 may.')]"),
       @FindBy(xpath = "//a[contains(text(),'27 jun.')]"),
       @FindBy(xpath = "//a[contains(text(),'24 jul.')]"),
       @FindBy(xpath = "//a[contains(text(),'3 ago.')]"),
       @FindBy(xpath = "//a[contains(text(),'28 sep.')]"),
       @FindBy(xpath = "//a[contains(text(),'25 oct.')]"),
       @FindBy(xpath = "//a[contains(text(),'23 nov.')]"),
       @FindBy(xpath = "//a[contains(text(),'26 dic.')]")
    })
    private List<WebElement> sections;

    @FindBy (className = "row row-no-padding") private List<WebElement> section;

    @FindBy(css = "button.js-close-prehome")
    public WebElement accessButton;


    public void assertIsOpen(Object... arguments) {
        for (WebElement item: sections){
            scrollTo(item);
            assertIsDisplayed(item);
            waitFor(3);
        }
    }

}
