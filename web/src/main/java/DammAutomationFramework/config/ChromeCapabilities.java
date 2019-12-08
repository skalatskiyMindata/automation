package DammAutomationFramework.config;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeCapabilities extends DesiredCapabilities {

    public ChromeCapabilities() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--start-maximized");
        options.addArguments("incognito");
        options.addArguments("disable-infobars");
/*
        String ublockPath = "/Users/mflip/Library/Application Support/Google/Chrome/Default/Extensions/cjpalhdlnbpafiamejdnhcphjbkeiagm/1.23.0_0";
        String pixelPath = "/Users/mflip/Library/Application Support/Google/Chrome/Default/Extensions/fdgfkebogiimcoedlicjlajpkdmockpc/1.2.0_0";
        options.addArguments("load-extension="+ ublockPath +","+pixelPath);
*/
        // options.addArguments("no-sandbox");
        setCapability(ChromeOptions.CAPABILITY, options);
    }
}