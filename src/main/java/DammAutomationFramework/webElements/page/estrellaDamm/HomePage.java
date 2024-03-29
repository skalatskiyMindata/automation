package DammAutomationFramework.webElements.page.estrellaDamm;

import DammAutomationFramework.webElements.component.AgeCheckComponent;
import DammAutomationFramework.webElements.component.MenuBannerComponent;
import com.github.webdriverextensions.WebPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static DammAutomationFramework.config.Properties.General.PAGE_LOAD_TIMEOUT;
import static com.github.webdriverextensions.Bot.*;
import static java.lang.String.format;

public class HomePage extends WebPage {

    @FindBy(className = "menu-banner") private MenuBannerComponent menu;
    @FindBy(id = "pano_home-intro-video") private WebElement introVideoSection;
    @FindBy(id = "pano_damm") private WebElement dammInfoSection;
    @FindBy(id = "pano_slider") private WebElement laGuiaSection;
    @FindBy(id = "pano_agenda") private WebElement agendaSection;
    @FindBy(id = "pano_welcome") private WebElement tuRinconSection;

    @FindBy(css = "div.block-main-prehome")
    public AgeCheckComponent ageCheckComponent;

    @FindBy(css = "button.js-close-prehome")
    public WebElement accessButton;

    public MenuBannerComponent menuBanner;

    @Override
    public void open(Object... arguments) {
        String webURL = (String) arguments[0];
        System.out.println("webURL =" + webURL);
        // Define how to open this page, e.g.
        open(webURL);
    }

    @Override
    public void assertIsOpen(Object... arguments) {
        waitForPageToLoad(PAGE_LOAD_TIMEOUT);
        assertIsDisplayed(introVideoSection);
//        assertIsDisplayed(dammInfoSection);
//        assertIsDisplayed(laGuiaSection);
//        assertIsDisplayed(agendaSection);
//        assertIsDisplayed(tuRinconSection);
    }

    public void clickOnAccessOnAgeCheck() {
        accessButton.click();
    }
}
