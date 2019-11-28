package DammAutomationFramework.estrellaDamm;


import DammAutomationFramework.config.ChromeCapabilities;
import DammAutomationFramework.config.Properties;
import DammAutomationFramework.webElements.EstrellaDammSite;
import DammAutomationFramework.webElements.page.estrellaDamm.PeliculasPage;
import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.*;
import org.junit.runner.RunWith;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.github.webdriverextensions.Bot.waitFor;

@RunWith(WebDriverRunner.class)
//@Chrome(desiredCapabilitiesClass = ChromeCapabilities.class)
@Firefox
@ScreenshotsPath(Properties.General.SCREENSHOT_PATH)
@TakeScreenshotOnFailure
public class PeliculasTest {

    private EstrellaDammSite estrellaDammSite = new EstrellaDammSite();


    @Test
    public void openPeliculasPage () throws Exception {
        String url = "https://www.estrelladamm.com/peliculas";
        estrellaDammSite.mainPage.open(url);
        estrellaDammSite.cookiesComponent.clickOnAcceptCookies();
        estrellaDammSite.mainPage.clickOnAccessOnAgeCheck();
        estrellaDammSite.peliculasPage.assertIsOpen();
        waitFor(4);
        estrellaDammSite.peliculasPage.clickOnAVideo();
    }

    @Test
    public void openAVideo() {
        String url = "https://www.estrelladamm.com/peliculas";
        estrellaDammSite.mainPage.open(url);
        estrellaDammSite.cookiesComponent.clickOnAcceptCookies();
        estrellaDammSite.mainPage.clickOnAccessOnAgeCheck();
    }
}
