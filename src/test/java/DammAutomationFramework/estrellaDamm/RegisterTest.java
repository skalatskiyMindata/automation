package DammAutomationFramework.estrellaDamm;

import DammAutomationFramework.config.Properties;
import DammAutomationFramework.data.enums.MenuOption;
import DammAutomationFramework.driver.ChromeCapabilities;
import DammAutomationFramework.webElements.EstrellaDammSite;
import DammAutomationFramework.webElements.component.EventItem;
import DammAutomationFramework.webElements.component.SpotItem;
import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.*;
import org.junit.*;
import org.junit.runner.RunWith;

import static DammAutomationFramework.config.Properties.General.PAGE_LOAD_TIMEOUT;
import static com.github.webdriverextensions.Bot.driver;
import static java.util.concurrent.TimeUnit.SECONDS;

@RunWith(WebDriverRunner.class)
@Chrome(desiredCapabilitiesClass = ChromeCapabilities.class)
@Firefox
@RemoteAddress(Properties.General.REMOTE_ADDRESS)
@TakeScreenshotOnFailure

public class RegisterTest {

    private EstrellaDammSite estrellaDammSite;
    private String url = "https://www.estrelladamm.com/";

    @Before
    public void configure() {
        driver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, SECONDS);
    }

    public void mainAccessFlow() {
        estrellaDammSite.mainPage.open(url);
        estrellaDammSite.cookiesComponent.clickOnAcceptCookies();
        estrellaDammSite.mainPage.clickOnAccessOnAgeCheck();
        estrellaDammSite.mainPage.assertIsOpen();
    }

    @Test //R1
    public void registerFormOnHomePage() {
        mainAccessFlow();
        estrellaDammSite.topBarComponent.clickOnLoginRegisterIcon();
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

    @Test //R4
    public void registerFormOnPromotions() throws Exception {
        mainAccessFlow();
        estrellaDammSite.topBarComponent.fillAndSelectLocation("Cataluña");
        estrellaDammSite.mainPage.menuBanner.selectMenuOption(MenuOption.AGENDA);
        estrellaDammSite.agendaPage.assertIsOpen();
        EventItem selectedEvent = estrellaDammSite.agendaPage.pickSpecificEvent("participa");
        estrellaDammSite.agendaPage.clickOnActiveButtonOnASpecificEvent(selectedEvent);
        estrellaDammSite.eventDetailsPage.assertIsOpen();
        estrellaDammSite.eventDetailsPage.clickOnParticipateOnBanner();
        estrellaDammSite.accessGenericComponent.failIfIsNotDisplayedOnSorteo();
    }

    @Test //R5
    public void registerFormOnAgendaPage() throws Exception {
        mainAccessFlow();
        estrellaDammSite.topBarComponent.fillAndSelectLocation("Cataluña");
        estrellaDammSite.mainPage.menuBanner.selectMenuOption(MenuOption.AGENDA);
        estrellaDammSite.agendaPage.assertIsOpen();
        EventItem selectedEvent = estrellaDammSite.agendaPage.pickSpecificEvent("first");
        estrellaDammSite.agendaPage.clickOnFavoriteIconOnASpecificEvent(selectedEvent);
        estrellaDammSite.accessGenericComponent.failIfIsNotDisplayedOnAgenda();
    }

    @Test //R6
    public void registerFormOnEventDetails() throws Exception {
        mainAccessFlow();
        estrellaDammSite.topBarComponent.fillAndSelectLocation("Cataluña");
        estrellaDammSite.mainPage.menuBanner.selectMenuOption(MenuOption.AGENDA);
        estrellaDammSite.agendaPage.assertIsOpen();
        EventItem selectedEvent = estrellaDammSite.agendaPage.pickSpecificEvent("first");
        estrellaDammSite.agendaPage.clickOnASpecificEvent(selectedEvent);
        estrellaDammSite.eventDetailsPage.assertIsOpen();
        estrellaDammSite.eventDetailsPage.clickOnFavoriteIconOnBanner();
        estrellaDammSite.accessGenericComponent.failIfIsNotDisplayedOnDetailsPage();
    }

}

