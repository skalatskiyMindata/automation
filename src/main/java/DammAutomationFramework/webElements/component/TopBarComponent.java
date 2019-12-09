package DammAutomationFramework.webElements.component;

import DammAutomationFramework.data.enums.Film;
import DammAutomationFramework.data.enums.MenuOption;
import DammAutomationFramework.utils.DataHandler;
import DammAutomationFramework.utils.Selector;
import com.github.webdriverextensions.WebRepository;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TopBarComponent extends WebRepository {

    @FindBy(css = "input#location") private WebElement locationInput;
    @FindBy(css = ".result-item") private List<WebElement> locationResults;
    @FindBy(css = "#btn-open-canvas-login-register span") private WebElement loginRegister;
    @FindBy(css = ".menu button") private WebElement menu;

    public void clickOnLoginRegisterIcon() {
        loginRegister.click();
    }

    public void fillAndSelectLocation(String location) {
        locationInput.clear();
        locationInput.sendKeys(location);

        WebElement selectedLocation = DataHandler.pickAnOption(location, locationResults);

        selectedLocation.click();
    }

}
