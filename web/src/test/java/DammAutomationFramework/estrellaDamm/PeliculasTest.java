package DammAutomationFramework.estrellaDamm;

import DammAutomationFramework.config.ChromeCapabilities;
import DammAutomationFramework.config.Properties;
import DammAutomationFramework.data.LocationDetails;
import DammAutomationFramework.data.UserDetails;
import DammAutomationFramework.data.enums.Film;
import DammAutomationFramework.data.enums.MenuOption;
import DammAutomationFramework.utils.DataHandler;
import DammAutomationFramework.webElements.EstrellaDammSite;
import com.github.webdriverextensions.Bot;
import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.Response;
import org.openqa.selenium.remote.http.HttpClient;
import org.openqa.selenium.remote.http.HttpResponse;
import org.openqa.selenium.remote.http.JsonHttpResponseCodec;
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

public class PeliculasTest {

    // Logger
    private static final Logger log = LoggerFactory.getLogger(PeliculasTest.class);
    private DataHandler dataHandler = new DataHandler();
    private EstrellaDammSite estrellaDammSite;
    private String url = "https://www.estrelladamm.com/peliculas";
    private String homeUrl = "https://www.estrelladamm.com/";

    @Before
    public void configure() {
        driver().manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, SECONDS);
        driver().manage().window().maximize();
    }

    public void mainAccessFlow () {
        estrellaDammSite.mainPage.open(url);
        estrellaDammSite.cookiesComponent.clickOnAcceptCookies();
        estrellaDammSite.mainPage.clickOnAccessOnAgeCheck();
    }

    @Test
    public void pixel(){
        mainAccessFlow();
        estrellaDammSite.cervezaPage.assertPixelEnabled();
    }


    @Test //P1
    public void clickPlayPeliculasPage() throws Exception {
        mainAccessFlow();
        estrellaDammSite.peliculasPage.playClick();
        estrellaDammSite.peliculasPage.assertMenuIsHidden();
    }

    @Test //P2
    public void clickMenuPeliculasPage() throws Exception {
        estrellaDammSite.mainPage.open(homeUrl);
        waitFor(30);

        estrellaDammSite.cookiesComponent.clickOnAcceptCookies();
        estrellaDammSite.mainPage.clickOnAccessOnAgeCheck();

        //estrellaDammSite.mainPage.menuBanner.selectMenuOption(MenuOption.FILMS);
        //assertCurrentUrlEquals(url);


        waitFor(30);
        estrellaDammSite.mainPage.menuBanner.selectFilm(Film.ACTII);
        estrellaDammSite.peliculasPage.assertMenuIsHidden();
        estrellaDammSite.mainPage.menuBanner.selectFilm(Film.ACTI);
        estrellaDammSite.peliculasPage.assertMenuIsHidden();
        estrellaDammSite.mainPage.menuBanner.selectFilm(Film.CYRANO);
        estrellaDammSite.peliculasPage.assertMenuIsHidden();

    }


    @Test
    public void menuHide () throws Exception{
        mainAccessFlow();
        estrellaDammSite.peliculasPage.playClick();
        estrellaDammSite.peliculasPage.assertMenuIsHidden();
    }

    @Test //P4
    public void openPeliculas () {
        mainAccessFlow();
        estrellaDammSite.peliculasPage.assertIsOpen();
    }


}

