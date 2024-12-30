import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;


public class BaseTest {
    WebDriver browser = WebDriverManager.chromedriver().create();
    MallPage mallPage = new MallPage(browser);
    Cart cartPage = new Cart(browser);

    @BeforeEach
    void commonBeforeTest() {
        mallPage.setWaitTime(5);
        mallPage.goToHomePage();
        browser.manage().window().maximize();
        //accept cookies
        mallPage.acceptCookies();
    }

    @AfterEach
    void commonAfterTest() {
        mallPage.scrollUp();
        mallPage.goToHomePage();
        mallPage.goToCart();
        cartPage.clearCart();
    }

}