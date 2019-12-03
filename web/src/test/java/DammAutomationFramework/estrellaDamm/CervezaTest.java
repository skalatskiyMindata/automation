package DammAutomationFramework.estrellaDamm;

import DammAutomationFramework.config.ChromeCapabilities;
import DammAutomationFramework.config.Properties;
import DammAutomationFramework.data.enums.MenuOption;
import DammAutomationFramework.webElements.EstrellaDammSite;
import DammAutomationFramework.webElements.component.EventItem;
import DammAutomationFramework.webElements.component.SpotItem;
import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static DammAutomationFramework.config.Properties.General.PAGE_LOAD_TIMEOUT;
import static com.github.webdriverextensions.Bot.*;
import static java.util.concurrent.TimeUnit.SECONDS;

@RunWith(WebDriverRunner.class)
@Chrome(desiredCapabilitiesClass = ChromeCapabilities.class)
@Firefox
// @RemoteAddress(Properties.General.REMOTE_ADDRESS)
@ScreenshotsPath(Properties.General.SCREENSHOT_PATH)
@TakeScreenshotOnFailure

public class CervezaTest {

    // Logger
    private static final Logger log = LoggerFactory.getLogger(RegisterTest.class);
    private EstrellaDammSite estrellaDammSite;
    String url = "https://www.estrelladamm.com/cerveza-mediterranea";
    String homeUrl = "https://www.estrelladamm.com/";

    @Before
    public void configure() {
        driver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, SECONDS);
    }

    public void mainAccessFlow () {
        estrellaDammSite.mainPage.open(url);
        estrellaDammSite.cookiesComponent.clickOnAcceptCookies();
        estrellaDammSite.mainPage.clickOnAccessOnAgeCheck();
    }

    @Test //C1
    public void clickMenuCervezaPage() throws Exception {
        estrellaDammSite.mainPage.open(homeUrl);
        estrellaDammSite.cookiesComponent.clickOnAcceptCookies();
        estrellaDammSite.mainPage.clickOnAccessOnAgeCheck();
        estrellaDammSite.mainPage.menuBanner.selectMenuOption(MenuOption.THE_BEER);
        waitFor(2);
estrellaDammSite.cervezaPage.assertIsOpen();
        //waitForPageToLoad(2);
        //assertCurrentUrlEquals(url);
        //estrellaDammSite.cervezaPage.assertIsOpen();
        //waitFor(4);
    }

    @Test //C2
    public void checkElementsOnCervezaPage() throws Exception {
        mainAccessFlow();
        estrellaDammSite.cervezaPage.assertIsOpen();
        //waitFor(4);
    }

    @Test //C3
    public void checkElementsOnCervezaDiaADiaPage() throws Exception {
        mainAccessFlow();
        estrellaDammSite.cervezaDiaADiaPage.assertIsOpen();
        //waitFor(4);
    }

}

