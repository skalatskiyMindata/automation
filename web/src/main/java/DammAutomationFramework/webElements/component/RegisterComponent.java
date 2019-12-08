package DammAutomationFramework.webElements.component;

import DammAutomationFramework.data.UserDetails;
import com.github.webdriverextensions.WebRepository;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.github.webdriverextensions.Bot.*;

public class RegisterComponent extends WebRepository {

    // Model
    @FindBy(id = "register") private WebElement registerContainer;
    @FindBy(id = "btn-fb-register") private WebElement registerByFacebookButton;
    @FindBy(xpath = "//a[@data-id-show=\"#login\"]") private WebElement loginButton;
    @FindBy(className = "register-email") private WebElement registerForm;
    @FindBy(id = "edit-field-name-0-value") private WebElement nameInput;
    @FindBy(id = "edit-field-last-name-0-value") private WebElement lastnameInput;
    @FindBy(id = "edit-mail") private WebElement emailInput;
    @FindBy(id = "edit-pass--2") private WebElement passwordInput;
    @FindBy(id = "edit-field-codigo-postal-0-value") private WebElement postalCodeInput;
    @FindBy(id = "edit-field-provincia") private WebElement regionSelect;
    @FindBy(id = "edit-field-pais-0-value") private WebElement countrySelect;
    @FindBy(xpath = "//label[@for=\"edit-field-condiciones-value\"]") private WebElement conditionsCheckbox;
    @FindBy(id = "edit-field-communication-profiling-value") private WebElement communicationCheckbox;
    @FindBy(id = "edit-field-acepta-rrss-value") private WebElement socialMediaSharingCheckbox;
    @FindBy(id = "edit-field-others-value") private WebElement shareDataWithCompaniesCheckbox;
    @FindBy(id = "edit-submit--2") private WebElement submitFormButton;
    @FindBy(id = "user-modal-registre") private WebElement modalRegistered;
    @FindBy(css = "#user-modal-registre a.btn-primary") private WebElement continueButton;

    @FindBy(xpath = "//div[@class='register-email']//div[2]//div[1]//div[1]//div[2]") private WebElement emailError;


    //methods
    public void failIfIsNotDisplayed() {
        assertIsDisplayed(registerContainer);
        assertIsDisplayed(registerForm);
        // assertIsDisplayed(submitFormButton);
    }

    public void clickOnFacebookRegister() {
        registerByFacebookButton.click();
    }

    public void clickOnLogin() {
        loginButton.click();
    }

    public void fillRequiredData(UserDetails userDetails) {
        nameInput.sendKeys(userDetails.name);
        lastnameInput.sendKeys(userDetails.lastName);
        emailInput.sendKeys(userDetails.email);
        passwordInput.sendKeys(userDetails.password);
        postalCodeInput.sendKeys(userDetails.location.postalCode);
    }

    public void selectCheckBoxes(){
        if (!conditionsCheckbox.isSelected()) {
            System.out.println("Checkbox is not selected");
            conditionsCheckbox.click();
        };
        System.out.println("Checkbox should be selected");
    }

    public void clickOnSubmitForm(){
        submitFormButton.click();
    }

    public void failIfConfirmationModalIsNotDisplayed() {
        waitForElementToDisplay(modalRegistered);
        assertIsDisplayed(modalRegistered);
    }
    public void failEmailInUse() {
        waitForElementToDisplay(emailError);
        assertIsDisplayed(emailError);
    }
}
