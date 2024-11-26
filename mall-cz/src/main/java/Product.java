import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Product extends MallPage {

    Product(WebDriver browser) {
        super(browser);
    }

    void addToCart() {
        browser.findElement(By.cssSelector(".info-box__main-btn .add-to-cart-list")).click();
    }
}
