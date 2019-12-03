package DammAutomationFramework.webElements.page.estrellaDamm;
import DammAutomationFramework.data.enums.Film;
import com.github.webdriverextensions.Bot;
import com.github.webdriverextensions.WebPage;
import com.github.webdriverextensions.WebRepository;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.function.Predicate;

import static com.github.webdriverextensions.Bot.*;

public class PeliculasPage extends WebRepository {

    @FindAll({
            @FindBy(id = "section-video1"),
            @FindBy(id = "section-video2"),
            @FindBy(id = "section-video3"),
            @FindBy(id = "section-video4"),
            @FindBy(id = "section-video5"),
            @FindBy(id = "section-video6"),
            @FindBy(id = "section-video7"),
            @FindBy(id = "section-video8"),
            @FindBy(id = "section-video9"),
            @FindBy(id = "section-video10"),
            @FindBy(id = "section-video11"),
            @FindBy(id = "section-video12"),
            @FindBy(id = "section-video13")
    })
    private List<WebElement> films;
    @FindBy(css = "#play-button")
    private WebElement playBtn;
    @FindBy(className = "btn-menu")
    private WebElement menu;


    public void assertIsOpen(Object... arguments) {

        for (WebElement item : films) {
            scrollTo(item);
            assertIsDisplayed(item);
        }
    }

    public void playClick() {
        waitForElementToDisplay(playBtn);
        playBtn.click();
    }


    public void menuIsHidden() throws Exception {
        waitFor(5);
        assertIsNotDisplayed(menu);
      }
}
