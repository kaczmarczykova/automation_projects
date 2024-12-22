import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    void selectTVs(int number) {
        wait.until(s -> browser.findElement(By.cssSelector(".category-products-wrap")).isDisplayed());

        //this commented part is my version

        //List<WebElement> productItems = browser.findElements(By.cssSelector(".pbcr"));
        for (int i = 0; i < number; i++) {
            browser.findElements(By.xpath("//button[@data-sel='add-to-cart-button-main']")).get(i).click();
            var pageIsRedirected = browser.findElement(By.cssSelector(".cross-sell__success"));
            wait.until(s -> pageIsRedirected).isDisplayed();
            browser.findElement(By.cssSelector(".cross-sell__button__close")).click();
            }
        }

        // this version is chatGPT
        /*List<WebElement> productItems = browser.findElements(By.xpath("//button[@data-sel='add-to-cart-button-main']"));
        int limit = Math.min(10, productItems.size());  // Omezíme na max. 10 produktů
        for (int i = 0; i < limit; i++) {
            productItems.get(i).click();
            try {
                WebElement pageIsRedirected = wait.until(driver ->
                        driver.findElement(By.cssSelector(".cross-sell__success")));
                pageIsRedirected.isDisplayed();
                browser.findElement(By.cssSelector(".cross-sell__button__close")).click();
            } catch (Exception e) {
                //continue
            }
        }*/

}