import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart extends MallPage {

    Cart(WebDriver browser) {
        super(browser);
    }

    int howManyItemsInCart() {
        var element = browser.findElements(By.cssSelector(".article-counter__input")).getFirst();
        var elementText = element.getAttribute("value");
        var counter = Integer.parseInt(elementText);
        return counter;
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
        // var plus = browser.findElement(By.xpath("//span[@data-v-58657a24='+']"));
        // var plus = browser.findElement(By.cssSelector(".cart-overview-item-row__count.article-counter__btn--plus"));
        // var plus = browser.findElement(By.xpath("//button[contains(@class, 'article-counter__btn--plus')]"));
        var productField = browser.findElements(By.cssSelector(".cart-overview-item-row")).getFirst();
        var plus = productField.findElement(By.cssSelector(".article-counter__btn--plus" ));
        plus.click();
    }

    String getNameOfProductInCart() {
        var name = browser.findElement(By.cssSelector(".cart-overview-item-title a")).getText();
        return name;
    }
}
