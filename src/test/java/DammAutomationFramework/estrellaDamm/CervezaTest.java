package DammAutomationFramework.estrellaDamm;

import DammAutomationFramework.utils.ChromeCapabilities;
import DammAutomationFramework.webElements.EstrellaDammSite;
import com.github.webdriverextensions.junitrunner.WebDriverRunner;
import com.github.webdriverextensions.junitrunner.annotations.*;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(WebDriverRunner.class)
@Chrome(desiredCapabilitiesClass = ChromeCapabilities.class)
@Firefox
@RemoteAddress("http://jenkins.damm.com:4444/wd/hub")
@ScreenshotsPath("/Users/skalatskiy/Develop/Mindata/DAMM/damm-automation-framework/web/screenshots")
@TakeScreenshotOnFailure
public class CervezaTest {

    private EstrellaDammSite estrellaDammSite = new EstrellaDammSite();

    @Test
    public void testPeliculas () { }
}
