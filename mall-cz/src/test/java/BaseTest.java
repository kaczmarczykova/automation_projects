import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;


public class BaseTest {
    WebDriver browser = WebDriverManager.chromedriver().create();
    MallPage mallPage = new MallPage(browser);
    BasePage basePage = new BasePage(browser);

    @BeforeEach
    void commonBeforeTest() {
        basePage.setTheWaitTime();
        basePage.goToHomePage();
        //accept cookies
        basePage.acceptCookies();
    }

    @AfterEach
    void commonAfterTest() {
        mallPage.goToCart();
        basePage.clearCart();
    }

}