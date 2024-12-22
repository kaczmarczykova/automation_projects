import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTestAlza {
    WebDriver browser = WebDriverManager.chromedriver().create();
    AlzaPage alzaPage = new AlzaPage(browser);

    @BeforeEach
    void commonBeforeTest() {
        alzaPage.setTheWaitTime();
        alzaPage.goToHomePage();
        //accept cookies
        alzaPage.acceptCookies();
    }

    @AfterEach
    void commonAfterTest() {
        alzaPage.scrollUp();
        alzaPage.openCart();
        alzaPage.clearCart();
    }

}

