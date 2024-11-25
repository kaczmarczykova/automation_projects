import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_page_test_alza {

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
        browser.get("https://alza.cz");
        //accept cookies
        WebElement cookiesAcceptButton = browser.findElement(By.cssSelector(".cookies-info__button--white"));
        cookiesAcceptButton.click();
    }

    @Test
    void homePageTest() {

        ShoppingAlza shoppingAlza = new ShoppingAlza(browser);
        CartAlza cartAlza = new CartAlza(browser);

        //click on TVs
        shoppingAlza.open();
        shoppingAlza.selectTVsPhotoAudio();
        waitFor(5);
        shoppingAlza.selectTVs();

        //find the cheapest one and add to cart
        shoppingAlza.orderByPrice();
        int expected = shoppingAlza.getExpectedPrice();
        waitFor(5);
        shoppingAlza.addToCart();

        //open cart and increase the number of TVs
        cartAlza.openCart();
        waitFor(5);
        cartAlza.increaseNumber();
        int actual = cartAlza.getActualPrice();

        //assert there are 2 TVs in the cart and that the expected price and actual price are equal
        Assertions.assertEquals(cartAlza.getTheCount(), 2);
        Assertions.assertEquals(expected * 2, actual);
    }

}