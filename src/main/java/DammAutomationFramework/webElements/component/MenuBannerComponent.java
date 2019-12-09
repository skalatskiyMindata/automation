package DammAutomationFramework.webElements.component;

import DammAutomationFramework.data.enums.Film;
import DammAutomationFramework.data.enums.MenuOption;
import com.github.webdriverextensions.WebRepository;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasProperty;

public class MenuBannerComponent extends WebRepository {

    @FindBy(className = "") private WebElement films;
    @FindBy(id = "es-acto-ii-amantes") private WebElement acto2AmantesButton;
    @FindBy(id = "es-acto-i-alma") private WebElement acto1AlmaButton;
    @FindBy(id = "es-cyrano") private WebElement cyranoButton;
    @FindBy(className = "") private WebElement theBeer;
    @FindBy(css = ".menu_Cómo_la_hacemos a") private WebElement howDoWeMadeItLink;
    @FindBy(css = ".menu_El_día_a_día a") private WebElement dayToDayLink;
    @FindBy(css = ".menu_Sostenibilidad a") private WebElement sustainability;
    @FindBy(css = ".menu_La_Guía a") private WebElement theGuide;
    @FindBy(css = ".menu_La_Agenda a") private WebElement agenda;
    @FindBy(css = ".menu_Tu_Rincón a") private WebElement yourSpot;
    @FindBy(css = ".menu_Visita_la_fábrica a") private WebElement visitBrewery;

    public void selectMenuOption (MenuOption menuOption) {
        switch (menuOption) {
            case FILMS:
                films.click();
                break;
            case THE_BEER:
                theBeer.click();
                break;
            case SUSTAINABILITY:
                sustainability.click();
                break;
            case THE_GUIDE:
                theGuide.click();
                break;
            case AGENDA:
                agenda.click();
                break;
            case YOUR_SPOT:
                yourSpot.click();
                break;
            case VISIT_THE_BREWERY:
                visitBrewery.click();
                break;
            default:
                throw new Error ("The menu option item that you try to select is not implemented yet");
        }
    }

    public void selectFilm (Film filmToSelect) {
        switch (filmToSelect) {
            case ACTI:
                acto1AlmaButton.click();
                break;
            case ACTII:
                acto2AmantesButton.click();
                break;
            case CYRANO:
                cyranoButton.click();
                break;
            default:
                throw new Error ("The film that you try to select is not implemented yet");
        }
    }

    public void selectBeerProcess () {

    }

}
