import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.*;

import java.util.List;

public class BaseTest {
    WebDriver browser = WebDriverManager.chromedriver().create();
    MallPage mallPage = new MallPage(browser);

    @BeforeEach
    void commonBeforeTest() {
        browser.get("https://mall.cz");
        //accept cookies
        WebElement cookiesAcceptButton = browser.findElement(By.cssSelector(".legal-consent__button-container"));
        cookiesAcceptButton.click();
    }

    @AfterEach
    void commonAfterTest() {
        waitFor(3);
        browser.get("https://www.mall.cz/kosik");
        try {
            // Najdeme všechny produkty na stránce
            List<WebElement> itemsInCart = browser.findElements(By.cssSelector(".cart-overview-item"));

            while (!itemsInCart.isEmpty()) {
                for (WebElement item : itemsInCart) {
                    try {
                        WebElement removeButton = item.findElement(By.cssSelector(".cart-overview-item-row__delete"));
                        removeButton.click();

                    } catch (Exception e) {
                        System.out.println("Chyba při pokusu o odstranění položky: " + e.getMessage());
                    }
                }

                // Aktualizujte seznam položek v košíku
                itemsInCart = browser.findElements(By.cssSelector(".cart-overview-item"));
            }

            System.out.println("Všechny položky byly odstraněny z košíku.");
        } catch (Exception e) {
            System.out.println("Chyba při vymazání košíku: " + e.getMessage());
        }
    }

    void closeAdvertisement() {
        try {
            var closeButton = browser.findElement(By.id("l-exponea-close"));
            closeButton.click();
        } catch (NoSuchElementException e) {
            System.out.println("Advertisement close button not found.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred while closing the advertisement: " + e.getMessage());
        }
    }

    void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        waitFor(3);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollTo(0, 0);");
        waitFor(3);
        js.executeScript("window.scrollTo(0, 0);");
    }


}