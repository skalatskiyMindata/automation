package DammAutomationFramework.webElements.component;

import com.github.webdriverextensions.WebComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuBannerComponent extends WebComponent {

    @FindBy(css = "div.menu-banner")
    private WebElement menu;

    private WebElement films = this.menu.findElement(By.className("lovers"));


}
