package DammAutomationFramework.estrellaDamm;

import DammAutomationFramework.config.ChromeCapabilities;
import DammAutomationFramework.webElements.EstrellaDammSite;
import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.Chrome;
import com.github.webdriverextensions.junitrunner.annotations.Firefox;
import com.github.webdriverextensions.junitrunner.annotations.ScreenshotsPath;
import com.github.webdriverextensions.junitrunner.annotations.TakeScreenshotOnFailure;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import static DammAutomationFramework.config.Properties.General.SCREENSHOT_PATH;

@RunWith(Suite.class)
@Chrome(desiredCapabilitiesClass = ChromeCapabilities.class)
@Firefox
// @RemoteAddress("http://jenkins.damm.com:4444/wd/hub")
@ScreenshotsPath(SCREENSHOT_PATH)
@TakeScreenshotOnFailure
@Suite.SuiteClasses({CervezaTest.class, PeliculasTest.class})
public class SmokeTests {
}
