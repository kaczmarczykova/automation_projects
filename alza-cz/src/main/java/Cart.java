import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Cart {

    WebDriver browser;

    public Cart(WebDriver browser) {
        this.browser = browser;
    }

    void open() {
        browser.get("https://www.alza.cz/Order1.htm");
    }

    void goBack() {
        var tlacitkoZpet = browser.findElement(By.cssSelector(".arrow left"));
        tlacitkoZpet.click();
    }

    void goCheckOut() {
        var tlacitkoPokladna = browser.findElement(By.cssSelector(".arrow right"));
        tlacitkoPokladna.click();
    }

    void deleteItem(int index) {
        var sipka = browser.findElement(By.cssSelector(".js-item-options-trigger"));
        sipka.click();
        var tlacitkoOdstranit = browser.findElement(By.cssSelector(".js-item-options-del"));
        tlacitkoOdstranit.click();
    }

    void checkTheText() {
        var vyberDoruceni = browser.findElement(By.cssSelector(".chooseDeliveryPaymentLabel"));
        vyberDoruceni.getText();
    }

    int checkCount() {
        var countPieces = browser.findElement(By.cssSelector(".countEdit")).getText();
        int count = Integer.parseInt(countPieces);
        return count;
    }

    void increaseNumber() {
        var increaseButton = browser.findElement(By.cssSelector(".countPlus"));
        increaseButton.click();
    }

    int getActualPrice() {
        var actualPrice = browser.findElement(By.cssSelector(".last price")).getText();
        actualPrice = actualPrice.replaceAll("[^\\d]", ""); // Např. "12 345 Kč" → "12345"
        int number = Integer.parseInt(actualPrice); // Převod na integer
        return number;
    }

}
