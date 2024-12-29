import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends AlzaPage {

    CartPage(WebDriver browser) {
        super(browser);
    }

    int getTheCount() {
        var countPieces = browser.findElement(By.cssSelector(".countEdit input")).getAttribute("value");
        int count = Integer.parseInt(countPieces);
        return count;
    }

    void increaseNumber() {
        wait.until(s->browser.findElement(By.cssSelector(".countPlus")).isDisplayed());
        var increaseButton = browser.findElement(By.cssSelector(".countPlus"));
        increaseButton.click();
    }

    int getActualPrice() {
        wait.until(s->browser.findElement(By.cssSelector(".o1sum .price")).isDisplayed());
        var actualPrice = browser.findElement(By.cssSelector(".o1sum .price")).getText();
        actualPrice = actualPrice.replaceAll("[^\\d]", "");// "12 345 Kč" → "12345"
        int number = Integer.parseInt(actualPrice); // Convert to integer
        return number;
    }

    void clearCart() {
        try {
            // Identify all items on the page
            List<WebElement> itemsInCart = browser.findElements(By.id("o1basket"));

            for (WebElement item : itemsInCart) {
                try {
                    item.findElement(By.cssSelector(".c6")).click();
                    WebElement removeProductButton = item.findElement(By.cssSelector(".js-item-options-del"));
                    removeProductButton.click();
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
        }
    }
}