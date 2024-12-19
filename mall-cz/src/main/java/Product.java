import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Product extends MallPage {

    Product(WebDriver browser) {
        super(browser);
    }

    void addToCart() {
        browser.findElement(By.cssSelector(".info-box__main-btn .add-to-cart-list")).click();
    }

    void openMainMenu() {
        browser.findElement(By.cssSelector(".desktop-menu__item-title")).click();
    }

    void openHairDryers() {
        browser.findElement(By.xpath("//a[@href='/feny']")).click();
    }

    String getNameOfTheProduct() {
        wait.until(s->browser.findElement(By.cssSelector(".detail__title--desktop")).isDisplayed());
        var name = browser.findElement(By.cssSelector(".detail__title--desktop")).getText();
        return name;
    }
}