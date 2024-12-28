import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartAlzaPage extends AlzaPage {

    CartAlzaPage(WebDriver browser) {
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
}