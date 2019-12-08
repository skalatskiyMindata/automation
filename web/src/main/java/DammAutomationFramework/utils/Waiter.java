package DammAutomationFramework.utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static DammAutomationFramework.config.Properties.General.PAGE_LOAD_TIMEOUT;
import static com.github.webdriverextensions.Bot.driver;
import static com.github.webdriverextensions.Bot.waitForPageToLoad;

public class Waiter {

    public static void waitForPageToBeLoaded() {
        waitForPageToLoad(PAGE_LOAD_TIMEOUT);
    }

    public static void waitUntilElementIsNotDisplayed (WebElement element) {
        new WebDriverWait(driver(), PAGE_LOAD_TIMEOUT).until(ExpectedConditions.invisibilityOf(element));
    }
}
