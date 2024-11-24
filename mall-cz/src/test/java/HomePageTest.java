import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageTest {
    WebDriver browser = WebDriverManager.chromedriver().create();

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
    }

    @Test
    void homePageTest() {



        //click a button based on its index (0, 1 or 2)
       // browser.findElements(By.cssSelector(".legal-consent__button-container")).get(0).click();

        Assertions.assertEquals("MALL.CZ – bílé zboží, elektronika, PC, outdoor, hobby, hračky, kosmetika, chovatelské potřeby", browser.getTitle());
    }

    @Test
    void hairDryerTest() {

        browser.findElement(By.cssSelector(".desktop-menu__item-title")).click();

        //click on hair dryers
        browser.findElement(By.xpath("//a[@href='/feny']")).click();
        waitFor(5);
        browser.findElement(By.cssSelector(".bs__name")).click();

        waitFor(5);
        var expectedName = browser.findElement(By.cssSelector(".detail__title--desktop")).getText();

        //Add to cart
        browser.findElement(By.cssSelector(".info-box__main-btn .add-to-cart-list")).click();

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

}
