package DammAutomationFramework.estrellaDamm;

import DammAutomationFramework.drivers.ChromeCapabilities;
import DammAutomationFramework.webElements.EstrellaDammSite;
import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.Chrome;
import com.github.webdriverextensions.junitrunner.annotations.Firefox;
import com.github.webdriverextensions.junitrunner.annotations.ScreenshotsPath;
import com.github.webdriverextensions.junitrunner.annotations.TakeScreenshotOnFailure;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.testng.annotations.Test;

@RunWith(Suite.class)
@Chrome(desiredCapabilitiesClass = ChromeCapabilities.class)
@Firefox
// @RemoteAddress("http://jenkins.damm.com:4444/wd/hub")
@ScreenshotsPath("/Users/skalatskiy/Develop/Mindata/DAMM/damm-automation-framework/web/screenshots")
@TakeScreenshotOnFailure
@Suite.SuiteClasses({CervezaTest.class, PeliculasTest.class, RegistroTest.class})
public class SmokeTests {
}
