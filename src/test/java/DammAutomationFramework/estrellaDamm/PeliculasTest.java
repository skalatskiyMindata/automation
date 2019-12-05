package DammAutomationFramework.estrellaDamm;

import DammAutomationFramework.drivers.ChromeCapabilities;
import DammAutomationFramework.webElements.EstrellaDammSite;
import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(WebDriverRunner.class)
@Chrome(desiredCapabilitiesClass = ChromeCapabilities.class)
@Firefox
@ScreenshotsPath("/Users/skalatskiy/Develop/Mindata/DAMM/damm-automation-framework/web/screenshots")
@TakeScreenshotOnFailure
public class PeliculasTest {

    private EstrellaDammSite estrellaDammSite = new EstrellaDammSite();

    @Test
    public void testPeliculas () {
        // estrellaDammSite.mainPage.open(url);
        // estrellaDammSite.cookiesComponent.clickOnAcceptCookies();
        estrellaDammSite.mainPage.clickOnAccessOnAgeCheck();
        estrellaDammSite.mainPage.assertIsOpen();

    }
}
