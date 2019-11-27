package DammAutomationFramework.estrellaDamm;

import DammAutomationFramework.config.Properties;
import DammAutomationFramework.data.LocationDetails;
import DammAutomationFramework.data.UserDetails;
import DammAutomationFramework.drivers.ChromeCapabilities;
import DammAutomationFramework.utils.DataHandler;
import DammAutomationFramework.webElements.EstrellaDammSite;
import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.webdriverextensions.Bot.*;

@RunWith(WebDriverRunner.class)
@Chrome(desiredCapabilitiesClass = ChromeCapabilities.class)
@Firefox
// @RemoteAddress(Properties.General.REMOTE_ADDRESS)
@ScreenshotsPath(Properties.General.SCREENSHOT_PATH)
@TakeScreenshotOnFailure

public class RegisterFlowTest {

    // Logger
    private static final Logger log = LoggerFactory.getLogger(RegisterFlowTest.class);
    private DataHandler dataHandler = new DataHandler();
    private EstrellaDammSite estrellaDammSite;

    @Test
    public void openEstrellaDammWebsite() throws Exception {
        String url = "https://www.estrelladamm.com/";
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
        estrellaDammSite.cookiesComponent.clickOnAcceptCookies();
        estrellaDammSite.mainPage.clickOnAccessOnAgeCheck();
        estrellaDammSite.mainPage.assertIsOpen();
        estrellaDammSite.mainPage.clickOnLoginRegisterIcon();
        estrellaDammSite.registerComponent.failIfIsNotDisplayed();
        estrellaDammSite.registerComponent.fillRequiredData(userDetails);
        estrellaDammSite.registerComponent.selectCheckBoxes();
        estrellaDammSite.registerComponent.clickOnSubmitForm();
        estrellaDammSite.registerComponent.failIfConfirmationModalIsNotDisplayed();
        Thread.sleep(1000);
        takeScreenshot("TestPassed-" + uniqueId);
    }
}

