package DammAutomationFramework.estrellaDamm;

import DammAutomationFramework.config.Properties;
import DammAutomationFramework.data.LocationDetails;
import DammAutomationFramework.data.UserDetails;
import DammAutomationFramework.data.enums.MenuOption;
import DammAutomationFramework.drivers.ChromeCapabilities;
import DammAutomationFramework.utils.DataHandler;
import DammAutomationFramework.webElements.EstrellaDammSite;
import DammAutomationFramework.webElements.component.SpotItem;
import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.Chrome;
import com.github.webdriverextensions.junitrunner.annotations.Firefox;
import com.github.webdriverextensions.junitrunner.annotations.ScreenshotsPath;
import com.github.webdriverextensions.junitrunner.annotations.TakeScreenshotOnFailure;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.webdriverextensions.Bot.driver;
import static com.github.webdriverextensions.Bot.takeScreenshot;
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

    @Test //TC60
    public void registerFormOnHomePage() throws Exception {
        estrellaDammSite.mainPage.open(url);
        estrellaDammSite.cookiesComponent.clickOnAcceptCookies();
        estrellaDammSite.mainPage.clickOnAccessOnAgeCheck();
        estrellaDammSite.mainPage.assertIsOpen();
        estrellaDammSite.mainPage.clickOnLoginRegisterIcon();
        estrellaDammSite.registerComponent.failIfIsNotDisplayed();
    }

    @Test //TC61
    public void registerFormOnGuiaPage() throws Exception {
        estrellaDammSite.mainPage.open(url);
        estrellaDammSite.cookiesComponent.clickOnAcceptCookies();
        estrellaDammSite.mainPage.clickOnAccessOnAgeCheck();
        estrellaDammSite.mainPage.assertIsOpen();
        estrellaDammSite.mainPage.menuBanner.selectMenuOption(MenuOption.THE_GUIDE);
        estrellaDammSite.guidePage.assertIsOpen();

        SpotItem selectedSpot = estrellaDammSite.guidePage.pickSpecificResult("first");
        estrellaDammSite.guidePage.clickOnFavoriteIconOnASpecificSpot(selectedSpot);
        estrellaDammSite.register2Component.failIfIsNotDisplayed();
    }

}

