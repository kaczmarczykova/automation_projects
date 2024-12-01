import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartAlza extends AlzaPage {

    CartAlza(WebDriver browser) {
        super(browser);
    }

    void goBack() {
        var buttonBack = browser.findElement(By.cssSelector(".btnx.left"));
        buttonBack.click();
    }

    void goCheckOut() {
        var buttonCheckOut = browser.findElement(By.cssSelector(".arrow right"));
        buttonCheckOut.click();
    }

    void deleteItem(int index) {
        var buttonMinus = browser.findElement(By.cssSelector(".js-item-options-trigger"));
        buttonMinus.click();
        var buttonRemove = browser.findElement(By.cssSelector(".js-item-options-del"));
        buttonRemove.click();
    }

    void getTheText() {
        var selectDelivery = browser.findElement(By.cssSelector(".chooseDeliveryPaymentLabel"));
        selectDelivery.getText();
    }

    int getTheCount() {
        var countPieces = browser.findElement(By.cssSelector(".countEdit input")).getAttribute("value");
        int count = Integer.parseInt(countPieces);
        return count;
    }

    void increaseNumber() {
        var increaseButton = browser.findElement(By.cssSelector(".countPlus"));
        increaseButton.click();
    }

    int getActualPrice() {
        var actualPrice = browser.findElement(By.cssSelector(".o1sum .price")).getText();
        actualPrice = actualPrice.replaceAll("[^\\d]", "");// Např. "12 345 Kč" → "12345"
        int number = Integer.parseInt(actualPrice); // Převod na integer
        return number;
    }

}