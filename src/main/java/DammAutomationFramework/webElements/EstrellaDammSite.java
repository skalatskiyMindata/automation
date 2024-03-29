package DammAutomationFramework.webElements;

import DammAutomationFramework.webElements.component.CookiesComponent;
import DammAutomationFramework.webElements.component.AccessGenericComponent;
import DammAutomationFramework.webElements.component.RegisterComponent;
import DammAutomationFramework.webElements.component.TopBarComponent;
import DammAutomationFramework.webElements.page.estrellaDamm.*;
import com.github.webdriverextensions.WebSite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.github.webdriverextensions.Bot.assertCurrentUrlStartsWith;

public class EstrellaDammSite extends WebSite {

    // Logger
    private static final Logger log = LoggerFactory.getLogger(EstrellaDammSite.class);

    // Url
    public static String url = ".";

    // Components
    public CookiesComponent cookiesComponent;
    public RegisterComponent registerComponent;
    public AccessGenericComponent accessGenericComponent;
    public TopBarComponent topBarComponent;

    // Pages
    public HomePage mainPage;
    public GuidePage guidePage;
    public AgendaPage agendaPage;
    public SpotDetailsPage spotDetailsPage;
    public EventDetailsPage eventDetailsPage;

    public void open(Object... arguments) {
        open(url);
    }

    @Override
    public void assertIsOpen(Object... arguments) throws Error {
        assertCurrentUrlStartsWith(url);
    }

}
