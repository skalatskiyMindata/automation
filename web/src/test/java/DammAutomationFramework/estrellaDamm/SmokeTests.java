package DammAutomationFramework.estrellaDamm;

import DammAutomationFramework.drivers.ChromeCapabilities;
import com.github.webdriverextensions.junitrunner.annotations.Chrome;
import com.github.webdriverextensions.junitrunner.annotations.Firefox;
import com.github.webdriverextensions.junitrunner.annotations.ScreenshotsPath;
import com.github.webdriverextensions.junitrunner.annotations.TakeScreenshotOnFailure;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Chrome(desiredCapabilitiesClass = ChromeCapabilities.class)
@Firefox
// @RemoteAddress("http://jenkins.damm.com:4444/wd/hub")
@ScreenshotsPath("/Users/skalatskiy/Develop/Mindata/DAMM/damm-automation-framework/web/screenshots")
@TakeScreenshotOnFailure
@Suite.SuiteClasses({CervezaTest.class, PeliculasTest.class})
public class SmokeTests {
}
