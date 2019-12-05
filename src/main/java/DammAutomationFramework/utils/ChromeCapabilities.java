package DammAutomationFramework.utils;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeCapabilities extends DesiredCapabilities {

    public ChromeCapabilities() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--start-maximized");
        options.addArguments("incognito");
        options.addArguments("disable-infobars");
        // options.addArguments("no-sandbox");
        setCapability(ChromeOptions.CAPABILITY, options);
    }
}