import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart extends MallPage {

    Cart(WebDriver browser) {
        super(browser);
    }

    int howManyItemsInCart() {
        var element = browser.findElements(By.cssSelector(".article-counter__input")).get(0);
        var elementText = element.getAttribute("value");
        int counter = Integer.parseInt(elementText);
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
}
