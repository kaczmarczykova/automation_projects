import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {

    WebDriver browser;

    public Cart(WebDriver browser) {
        this.browser = browser;
    }

    void open() {
        browser.get("hhttps://www.alza.cz/Order1.htm");
    }

    void goBack() {
        browser.findElement(By.cssSelector(".arrow left")).click();
    }

    void goCheckOut() {
        browser.findElement(By.cssSelector(".arrow right")).click();
    }

    void deleteItem(int index) {
        browser.findElements(By.cssSelector(".cart-overview-item-row__delete .cart__remove-icon")).get(index).click();
    }

    void checkTheText() {
        var vyberDoruceni = browser.findElement(By.cssSelector(".chooseDeliveryPaymentLabel"));
        vyberDoruceni.getText();
    }
}
