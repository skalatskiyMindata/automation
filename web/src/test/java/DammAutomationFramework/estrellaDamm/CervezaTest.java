package DammAutomationFramework.estrellaDamm;

import DammAutomationFramework.config.ChromeCapabilities;
import DammAutomationFramework.config.Properties;
import DammAutomationFramework.webElements.EstrellaDammSite;
import DammAutomationFramework.webElements.page.estrellaDamm.CervezaDiaADiaPage;
import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.*;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import static com.github.webdriverextensions.Bot.waitFor;

@RunWith(WebDriverRunner.class)
//@Chrome(desiredCapabilitiesClass = ChromeCapabilities.class)
@Firefox
// @RemoteAddress("http://jenkins.damm.com:4444/wd/hub")
@ScreenshotsPath(Properties.General.SCREENSHOT_PATH)
@TakeScreenshotOnFailure


public class CervezaTest {

    private EstrellaDammSite estrellaDammSite = new EstrellaDammSite();
    private CervezaDiaADiaPage cervezaDiaADiaPage = new CervezaDiaADiaPage();
    private static final Logger log = LoggerFactory.getLogger(RegistroTest.class);

    @Test
    public void openCervezaPage () throws Exception {


        String url = "https://www.estrelladamm.com/cerveza-mediterranea";
        estrellaDammSite.mainPage.open(url);

        estrellaDammSite.mainPage.accessButton.click();
        estrellaDammSite.cookiesComponent.clickOnAcceptCookies();
        estrellaDammSite.cervezaPage.assertIsOpen();
        waitFor(4);

    }

    @Test
    public void openCervezaDiaADiaPage(){
        String url = "https://www.estrelladamm.com/dia-a-dia";
        estrellaDammSite.mainPage.open(url);

        cervezaDiaADiaPage.assertIsOpen();

    }
}
