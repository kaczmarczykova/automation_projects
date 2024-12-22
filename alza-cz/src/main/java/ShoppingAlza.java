import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingAlza extends AlzaPage {

    ShoppingAlza(WebDriver browser) {
        super(browser);
    }

    void open() {
        browser.get("https://www.alza.cz");
    }

    void selectTVsPhotoAudio() {
        var tvSidebarItems = browser.findElements(By.cssSelector(".l0-catLink"));
        tvSidebarItems.get(6).click();
    }

    void selectTVs() {
        wait.until(s->browser.findElement(By.linkText("Televize")).isDisplayed());
        var tvElement = browser.findElement(By.linkText("Televize"));
        tvElement.click();
    }

    void orderByPrice() {
        var cheapest = browser.findElement(By.id("ui-id-3"));
        cheapest.click();
    }

    void addToCart () {
        wait.until(s->browser.findElement(By.cssSelector(".price-detail__buy-actions")).isDisplayed());
        browser.findElement(By.cssSelector(".price-detail__buy-actions")).click();
    }

    void openProductPage() {
        wait.until(s->browser.findElements(By.cssSelector(".pc.browsinglink.js-box-link")).get(0).isDisplayed());
        browser.findElements(By.cssSelector(".pc.browsinglink.js-box-link")).get(0).click();
    }

    int getExpectedPrice() {
        var expectedPrice = browser.findElements(By.cssSelector(".price-box__price")).get(0).getText();
        expectedPrice = expectedPrice.replaceAll("[^\\d]", ""); // Např. "12 345 Kč" → "12345"
        int number = Integer.parseInt(expectedPrice); // Převod na integer
        return number;
    }

}
