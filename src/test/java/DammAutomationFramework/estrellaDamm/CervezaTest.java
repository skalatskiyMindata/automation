package DammAutomationFramework.estrellaDamm;

import DammAutomationFramework.config.Properties;
import DammAutomationFramework.driver.ChromeCapabilities;
import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(WebDriverRunner.class)
@Chrome(desiredCapabilitiesClass = ChromeCapabilities.class)
@Firefox
@RemoteAddress(Properties.General.REMOTE_ADDRESS)
@TakeScreenshotOnFailure

public class CervezaTest {

    @Test
    public void testPeliculas() {
    }
}
