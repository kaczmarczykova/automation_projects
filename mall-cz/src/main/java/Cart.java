import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart extends MallPage {

    Cart(WebDriver browser) {
        super(browser);
    }

    int getCountOfItemsInCart() {
        wait.until(s->browser.findElement(By.cssSelector(".article-counter__input")).isDisplayed());
        var element = browser.findElements(By.cssSelector(".article-counter__input")).getFirst();
        var elementText = element.getAttribute("value");
        return Integer.parseInt(elementText);
    }

    void goBack() {
        browser.findElement(By.cssSelector(".go_back_btn")).click();
    }

    void goCheckOut() {
        browser.findElement(By.cssSelector(".cart-overview__wrapper .cart-layout__submit .btn--primary")).click();
    }

    void deleteItem(int index) {
        browser.findElements(By.cssSelector(".cart-overview-item-row__delete .cart__remove-icon")).get(index).click();
    }

    void increaseCountOfProducts() {
        wait.until(s->browser.findElement(By.cssSelector(".cart-overview-item-row")).isDisplayed());
        var productField = browser.findElements(By.cssSelector(".cart-overview-item-row")).getFirst();
        var plus = productField.findElement(By.cssSelector(".article-counter__btn--plus" ));
        plus.click();
    }

    String getNameOfProductInCart() {
        wait.until(s->browser.findElement(By.cssSelector(".cart-overview-item-title a")).isDisplayed());
        return browser.findElement(By.cssSelector(".cart-overview-item-title a")).getText();
        }
}