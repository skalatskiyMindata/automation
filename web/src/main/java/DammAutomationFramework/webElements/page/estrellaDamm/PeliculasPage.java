package DammAutomationFramework.webElements.page.estrellaDamm;
import com.github.webdriverextensions.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.github.webdriverextensions.Bot.assertIsDisplayed;

public class PeliculasPage extends WebPage {

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
        assertIsDisplayed(actoIIAmantesSection);
        /*assertIsDisplayed(actoIAlmaSection);
        assertIsDisplayed(cyranoSection);
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
        actoIIAmantesSection.click();
    }

}
