import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Cart extends MallPage {

    Cart(WebDriver browser) {
        super(browser);
    }

    int getCountOfThisItem() {
        wait.until(s -> browser.findElement(By.cssSelector(".article-counter__input")).isDisplayed());
        var element = browser.findElements(By.cssSelector(".article-counter__input")).getFirst();
        var elementText = element.getAttribute("value");
        return Integer.parseInt(elementText);
    }

    void goBack() {
        browser.findElement(By.cssSelector(".go_back_btn")).click();
    }

    void deleteItem(int index) {
        browser.findElements(By.cssSelector(".cart-overview-item-row__delete .cart__remove-icon")).get(index).click();
    }

    void increaseCountOfProducts() {
        wait.until(s -> browser.findElement(By.cssSelector(".cart-overview-item-row")).isDisplayed());
        var productField = browser.findElements(By.cssSelector(".cart-overview-item-row")).getFirst();
        var plus = productField.findElement(By.cssSelector(".article-counter__btn--plus"));
        plus.click();
    }

    String getNameOfProductInCart() {
        wait.until(s -> browser.findElement(By.cssSelector(".cart-overview-item-title a")).isDisplayed());
        return browser.findElement(By.cssSelector(".cart-overview-item-title a")).getText();
    }

    Integer getCountOfItemsInCart() {
        return browser.findElements(By.cssSelector(".cart-overview-item")).size();
    }

    int getThePriceItemByItem() {
        List<WebElement> itemsInCart = browser.findElements(By.cssSelector(".cart-overview-item"));
        int cartPrice = 0;
        for (WebElement item : itemsInCart) {
            WebElement locateItemPrice = item.findElement(By.cssSelector(".cart-overview-item-row__price"));
            var itemPrice = locateItemPrice.getText();
            itemPrice = itemPrice.replaceAll("[^\\d]", "");
            int intItemPrice = Integer.parseInt(itemPrice);
            cartPrice += intItemPrice;
        }
        return cartPrice;
    }

    void clearCart() {
        try {
            // Najdeme všechny produkty na stránce
            List<WebElement> itemsInCart = browser.findElements(By.cssSelector(".cart-overview-item"));

            for (WebElement item : itemsInCart) {
                try {
                    WebElement removeButton = item.findElement(By.cssSelector(".cart-overview-item-row__delete"));
                    removeButton.click();
                } catch (Exception e) {
                    System.out.println("Chyba při pokusu o odstranění položky: " + e.getMessage());
                }
            }
        } catch (Exception e) {
        }
    }

}