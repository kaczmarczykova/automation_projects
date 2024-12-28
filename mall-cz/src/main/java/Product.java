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

    String getNameOfProduct() {
        wait.until(s->browser.findElement(By.cssSelector(".detail__title--desktop")).isDisplayed());
        return browser.findElement(By.cssSelector(".detail__title--desktop")).getText();
        }

    void selectPopularProduct(int index) {
        wait.until(s->browser.findElements(By.cssSelector(".bs__name")).get(index).isDisplayed());
        browser.findElements(By.cssSelector(".bs__name")).get(index).click();
    }

    void openTVs() {
        browser.findElements(By.xpath("//li[@data-testid='desktop-menu__item']")).get(2).click();
        browser.findElement(By.xpath("//a[@href='/televizory']")).click();
    }

    int selectTVs(int number) {
        wait.until(s -> browser.findElement(By.cssSelector(".category-products-wrap")).isDisplayed());

        var totalPrice =0;
        for (int i = 0; i < number; i++) {
            var TV = browser.findElements(By.xpath("//button[@data-sel='add-to-cart-button-main']")).get(i);
            var singlePrice = browser.findElements(By.cssSelector(".pb-price__price")).get(i).getText();
            singlePrice = singlePrice.replaceAll("[^\\d]", "");
            int intSinglePrice = Integer.parseInt(singlePrice);
            totalPrice += intSinglePrice;
            TV.click();
            var pageIsRedirected = browser.findElement(By.cssSelector(".cross-sell__success"));
            wait.until(s -> pageIsRedirected).isDisplayed();
            browser.findElement(By.cssSelector(".cross-sell__button__close")).click();
            }
        return totalPrice;
        }
}