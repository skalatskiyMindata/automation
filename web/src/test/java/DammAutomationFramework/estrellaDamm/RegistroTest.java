package DammAutomationFramework.estrellaDamm;

import DammAutomationFramework.data.LocationDetails;
import DammAutomationFramework.data.UserDetails;
import DammAutomationFramework.drivers.ChromeCapabilities;
import DammAutomationFramework.utils.DataHandler;
import DammAutomationFramework.webElements.EstrellaDammSite;
import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.Chrome;
import com.github.webdriverextensions.junitrunner.annotations.ScreenshotsPath;
import com.github.webdriverextensions.junitrunner.annotations.TakeScreenshotOnFailure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.webdriverextensions.Bot.*;

@RunWith(WebDriverRunner.class)
@Chrome(desiredCapabilitiesClass = ChromeCapabilities.class)
// @Firefox
// @RemoteAddress("http://jenkins.damm.com:4444/wd/hub")
@ScreenshotsPath("/Users/skalatskiy/Develop/Mindata/DAMM/damm-automation-framework/web/screenshots")
@TakeScreenshotOnFailure

public class RegistroTest extends GoogleSite {

    // Logger
    private static final Logger log = LoggerFactory.getLogger(RegistroTest.class);
    private DataHandler dataHandler = new DataHandler();
    private GoogleSite site;
    private EstrellaDammSite estrellaDammSite;

    @Test
    public void openEstrellaDammWebsite() throws Exception {
        String url = "https://www.estrelladamm.com/";
        // String url = "https://www.yandex.com/";
        String uniqueId = dataHandler.generateUniqueID();

        System.out.println("uniqueId: " + uniqueId);

        UserDetails userDetails = new UserDetails();
        userDetails.name = uniqueId;
        userDetails.lastName = "lastname";
        userDetails.email = uniqueId + "+dummytestmindata@gmail.com";
        userDetails.password = "123456";
        userDetails.location = new LocationDetails();
        userDetails.location.postalCode = "08001";

        estrellaDammSite.mainPage.open(url);
        // estrellaDammSite.cookiesComponent.clickOnAcceptCookies();
        estrellaDammSite.mainPage.clickOnAccessOnAgeCheck();
        estrellaDammSite.mainPage.assertIsOpen();
        estrellaDammSite.mainPage.clickOnLoginRegisterIcon();
        // waitFor(10000);
        estrellaDammSite.registerComponent.failIfIsNotDisplayed();
        estrellaDammSite.registerComponent.fillRequiredData(userDetails);
        estrellaDammSite.registerComponent.selectCheckBoxes();
        estrellaDammSite.registerComponent.clickOnSubmitForm();
        estrellaDammSite.registerComponent.failIfConfirmationModalIsNotDisplayed();
        Thread.sleep(1000);
        takeScreenshot("TestPassed-" + uniqueId);
    }
}

