package DammAutomationFramework.webElements.page.estrellaDamm;
import com.github.webdriverextensions.Bot;
import com.github.webdriverextensions.WebPage;
import com.github.webdriverextensions.WebRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.function.Predicate;

import static com.github.webdriverextensions.Bot.*;

public class PeliculasPage extends WebRepository {

    @FindBy(id = "section-video1") private WebElement actoIIAmantesSection;
    @FindBy(id = "section-video2") private WebElement actoIAlmaSection;
    @FindBy(id = "section-video3") private WebElement cyranoSection;
    @FindBy(id = "section-video4") private WebElement alexYJuliaSection;
    @FindBy(id = "section-video5") private WebElement laVidaNuestraSection;
    @FindBy(id = "section-video6") private WebElement laRecetaSection;
    @FindBy(id = "section-video7") private WebElement lasPequeniasCosasSection;
    @FindBy(id = "section-video8") private WebElement valeSection;
    @FindBy(id = "section-video9") private WebElement loveOfLesbianSection;
    @FindBy(id = "section-video10") private WebElement sierraDeTramuntanaSection;
    @FindBy(id = "section-video11") private WebElement elBulliSection;
    @FindBy(id = "section-video12") private WebElement sanJuanSection;
    @FindBy(id = "section-video13") private WebElement formenteraSection;
    @FindBy(css = "#play-button") private WebElement playBtn;




    public void assertIsOpen(Object... arguments) {
        assertIsDisplayed(actoIIAmantesSection);
        waitFor(4);
        scrollTo(actoIAlmaSection);
        assertIsDisplayed(actoIAlmaSection);
        waitFor(4);
        /*assertIsDisplayed(cyranoSection);
        assertIsDisplayed(alexYJuliaSection);
        assertIsDisplayed(laVidaNuestraSection);
        assertIsDisplayed(laRecetaSection);
        assertIsDisplayed(lasPequeniasCosasSection);
        assertIsDisplayed(valeSection);
        assertIsDisplayed(loveOfLesbianSection);
        assertIsDisplayed(sierraDeTramuntanaSection);
        assertIsDisplayed(elBulliSection);
        assertIsDisplayed(sanJuanSection);
        assertIsDisplayed(formenteraSection);*/
    }

    public void clickOnAVideo() {
        scrollTo(actoIAlmaSection);
        waitFor(3);
        playBtn.click();
        waitFor(4);
        //actoIAlmaSection.click();
    }

}
