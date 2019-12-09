package DammAutomationFramework.estrellaDamm;

import DammAutomationFramework.config.Properties;
import DammAutomationFramework.driver.ChromeCapabilities;
import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(WebDriverRunner.class)
@Chrome(desiredCapabilitiesClass = ChromeCapabilities.class)
@Firefox
@RemoteAddress(Properties.General.REMOTE_ADDRESS)
@TakeScreenshotOnFailure

@Suite.SuiteClasses({CervezaTest.class, PeliculasTest.class})
public class SmokeTests {
}
