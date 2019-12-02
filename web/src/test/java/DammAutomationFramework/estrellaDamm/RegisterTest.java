package DammAutomationFramework.estrellaDamm;

import DammAutomationFramework.config.Properties;
import DammAutomationFramework.data.enums.MenuOption;
import DammAutomationFramework.webElements.EstrellaDammSite;
import DammAutomationFramework.webElements.component.EventItem;
import DammAutomationFramework.webElements.component.SpotItem;
import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.Firefox;
import com.github.webdriverextensions.junitrunner.annotations.ScreenshotsPath;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.webdriverextensions.Bot.driver;
import static java.util.concurrent.TimeUnit.SECONDS;

@RunWith(WebDriverRunner.class)
// @Chrome(desiredCapabilitiesClass = ChromeCapabilities.class)
//@Chrome
@Firefox
// @RemoteAddress(Properties.General.REMOTE_ADDRESS)
@ScreenshotsPath(Properties.General.SCREENSHOT_PATH)
//@TakeScreenshotOnFailure

public class RegisterTest {

    // Logger
    private static final Logger log = LoggerFactory.getLogger(RegisterTest.class);
    private EstrellaDammSite estrellaDammSite;
    private String url = "https://www.estrelladamm.com/";

    @Before
    public void configure() {
        driver().manage().timeouts().pageLoadTimeout(30, SECONDS);
    }

    public void mainAccessFlow () {
        estrellaDammSite.mainPage.open(url);
        estrellaDammSite.cookiesComponent.clickOnAcceptCookies();
        estrellaDammSite.mainPage.clickOnAccessOnAgeCheck();
        estrellaDammSite.mainPage.assertIsOpen();
    }

    @Test //R1
    public void registerFormOnHomePage() throws Exception {
        mainAccessFlow();
        estrellaDammSite.mainPage.clickOnLoginRegisterIcon();
        estrellaDammSite.registerComponent.failIfIsNotDisplayed();
    }

    @Test //R2
    public void registerFormOnGuiaPage() throws Exception {
        mainAccessFlow();
        estrellaDammSite.mainPage.menuBanner.selectMenuOption(MenuOption.THE_GUIDE);
        estrellaDammSite.guidePage.assertIsOpen();
        SpotItem selectedSpot = estrellaDammSite.guidePage.pickSpecificResult("first");
        estrellaDammSite.guidePage.clickOnFavoriteIconOnASpecificSpot(selectedSpot);
        estrellaDammSite.accessGenericComponent.failIfIsNotDisplayedOnGuia();
    }

    @Test //R3
    public void registerFormOnSpotDetails() throws Exception {
        mainAccessFlow();
        estrellaDammSite.mainPage.menuBanner.selectMenuOption(MenuOption.THE_GUIDE);
        estrellaDammSite.guidePage.assertIsOpen();
        SpotItem selectedSpot = estrellaDammSite.guidePage.pickSpecificResult("first");
        estrellaDammSite.guidePage.clickOnASpecificSpot(selectedSpot);
        estrellaDammSite.spotDetailsPage.assertIsOpen();
        estrellaDammSite.spotDetailsPage.clickOnFavoriteIconOnBanner();
        estrellaDammSite.accessGenericComponent.failIfIsNotDisplayedOnDetailsPage();
    }

    @Test //R5
    public void registerFormOnAgendaPage() throws Exception {
        mainAccessFlow();
        estrellaDammSite.mainPage.menuBanner.selectMenuOption(MenuOption.AGENDA);
        estrellaDammSite.agendaPage.assertIsOpen();
        EventItem selectedEvent = estrellaDammSite.agendaPage.pickSpecificEvent("first");
        estrellaDammSite.agendaPage.clickOnFavoriteIconOnASpecificEvent(selectedEvent);
        estrellaDammSite.accessGenericComponent.failIfIsNotDisplayedOnAgenda();
    }

    @Test //R6
    public void registerFormOnEventDetails() throws Exception {
        mainAccessFlow();
        estrellaDammSite.mainPage.menuBanner.selectMenuOption(MenuOption.AGENDA);
        estrellaDammSite.agendaPage.assertIsOpen();
        EventItem selectedEvent = estrellaDammSite.agendaPage.pickSpecificEvent("first");
        estrellaDammSite.agendaPage.clickOnASpecificEvent(selectedEvent);
        estrellaDammSite.eventDetailsPage.assertIsOpen();
        estrellaDammSite.eventDetailsPage.clickOnFavoriteIconOnBanner();
        estrellaDammSite.accessGenericComponent.failIfIsNotDisplayedOnDetailsPage();
    }

}

