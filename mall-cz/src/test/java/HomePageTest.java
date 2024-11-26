import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageTest {
    WebDriver browser = WebDriverManager.chromedriver().create();
    ProductSelection productSelectionPage;
    Product productPage;
    Cart cartPage;

    void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeEach
    void beforeTest() {
        browser.get("https://mall.cz");
        //accept cookies
        WebElement cookiesAcceptButton = browser.findElement(By.cssSelector(".legal-consent__button-container"));
        cookiesAcceptButton.click();

        productSelectionPage = new ProductSelection(browser);
        productPage = new Product(browser);
        cartPage = new Cart(browser);
    }

    @Test
    void homePageTest() {

        Assertions.assertEquals("MALL.CZ – bílé zboží, elektronika, PC, outdoor, hobby, hračky, kosmetika, chovatelské potřeby", browser.getTitle());
    }

    @Test
    void hairDryerTest() {

        browser.findElement(By.cssSelector(".desktop-menu__item-title")).click();

        //click on hair dryers
        browser.findElement(By.xpath("//a[@href='/feny']")).click();
        waitFor(5);
        productSelectionPage.selectPopularProduct((0));

        waitFor(5);
        var expectedName = browser.findElement(By.cssSelector(".detail__title--desktop")).getText();

        //Add to cart
        productPage.addToCart();

        //Open cart
        waitFor(5);
        var openCart_element = browser.findElement(By.cssSelector(".cross-sell__button__to-cart__to"));
        openCart_element.click();

        waitFor(5);
        var actualName = browser.findElement(By.cssSelector(".cart-overview-item-title a")).getText();

        Assertions.assertEquals(expectedName, actualName);
    }

    @Test
    void cartOperations() {
        Cart cartPage = new Cart(browser);

        cartPage.open();
        cartPage.goBack();
        cartPage.open();
        cartPage.deleteItem(0);
    }

    @Test
    void loginTest() {
        productPage.getLogged("blbec", "blbec");
    }
}
