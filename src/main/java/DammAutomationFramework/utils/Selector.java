package DammAutomationFramework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Selector {
    private WebElement select;

    public Selector (WebElement selectElement) {
        this.select = selectElement;
    }

    public List<WebElement> returnAllOptions () {
        this.select.click();

        return this.select.findElements(By.cssSelector("option"));
    }

    public WebElement selectAnOption (String optionToSelect) {
        System.out.println("optionToSelect: " + optionToSelect);
        List<WebElement> options = this.returnAllOptions();

        if (optionToSelect.equalsIgnoreCase("first")) {
            return options.get(0);
        } else {
            for (WebElement option: options) {
                String optionText = option.getText();
                String optionValue = option.getAttribute("value");
                System.out.println("optionText: " + optionText);
                System.out.println("optionValue: " + optionValue);

                if (optionText.contains(optionToSelect)) {
                    return option;
                }
            }
        }

        throw new Error("The option '" + optionToSelect + "' that you want to select is not present");
    }
}
