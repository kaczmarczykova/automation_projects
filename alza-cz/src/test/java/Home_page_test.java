import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_page_test {

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

        Shopping shopping = new Shopping(browser);
        Cart cart = new Cart(browser);

        //click on TVs
        shopping.open();
        shopping.selectTVsPhotoAudio();
        waitFor(5);
        shopping.selectTVs();

        //find the cheapest one and add to cart
        shopping.orderByPrice();
        int expected = shopping.getExpectedPrice();
        waitFor(5);
        shopping.addToCart();

        //open cart and increase the number of TVs
        cart.open();
        waitFor(5);
        cart.increaseNumber();
        int actual = cart.getActualPrice();

        //assert there are 2 TVs in the cart and that the expected price and actual price are equal
        Assertions.assertEquals(cart.checkCount(), 2);
        Assertions.assertEquals(expected * 2, actual);
    }

}