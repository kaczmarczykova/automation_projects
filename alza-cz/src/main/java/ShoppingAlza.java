import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingAlza {
    WebDriver browser;

    public ShoppingAlza(WebDriver browser) {
        this.browser = browser;
    }

    void open() {
        browser.get("https://www.alza.cz");
    }

    void selectTVsPhotoAudio() {
        var tvSidebarItems = browser.findElements(By.cssSelector(".l0-catLink"));
        tvSidebarItems.get(6).click();
    }

    void selectTVs() {
        var tvElement = browser.findElement(By.linkText("Televize"));
        tvElement.click();
    }

    void orderByPrice() {
        var cheapest = browser.findElement(By.id("ui-id-3"));
        cheapest.click();
    }

    void addToCart () {
                browser.findElements(By.cssSelector(".btnk1")).get(0).click();
    }

    int getExpectedPrice() {
        var expectedPrice = browser.findElement(By.cssSelector(".price-box__price")).getText();
        expectedPrice = expectedPrice.replaceAll("[^\\d]", "").replaceAll("\u00A0", ""); // Např. "12 345 Kč" → "12345"
        int number = Integer.parseInt(expectedPrice); // Převod na integer
        return number;
    }

}
