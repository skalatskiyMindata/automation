package DammAutomationFramework;

import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.*;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.openqa.selenium.Dimension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;

import static com.github.webdriverextensions.Bot.*;

@RunWith(WebDriverRunner.class)
@Chrome
@Firefox
@RemoteAddress("http://jenkins.damm.com:4444/wd/hub")
@ScreenshotsPath("/Users/skalatskiy/Develop/Mindata/DAMM/automation-framework/damm-automation-framework/screenshots")
@TakeScreenshotOnFailure

public class MainPageTest extends GoogleSite {

    // Logger
    private static final Logger log = LoggerFactory.getLogger(MainPageTest.class);
    private GoogleSite site;

    @Before
    public void configure() {
        driver().manage().window().setSize(new Dimension(1920,1080));
    }

    @Test
    public void openMainPageTest() throws Exception {
        GetWorkingDirectory.main();
        open("http://www.google.es");
        assertCurrentUrlContains("google");

        String textToSearch = "Estrella Damm";

        site.mainPage.searchByText(textToSearch);
        site.resultsPage.failIfResultsDoesNotContainsText(textToSearch);

        takeScreenshot("bubu-" + Instant.now().toString());
    }

    @Test
    public void openAndFailMainPageTest() throws Exception {
        GetWorkingDirectory.main();
        open("http://www.google.es");
        assertCurrentUrlContains("yahoo");
    }
}

