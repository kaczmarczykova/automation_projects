import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MallPage {
    WebDriver browser;
    WebDriverWait wait;

    public MallPage(WebDriver browser) {
        this.browser = browser;
        this.wait = new WebDriverWait(browser, Duration.ofMillis(3000));
    }

    void clickMainLogo() {
        browser.findElement(By.cssSelector(".header__big-logo")).click();
    }

    void goToCart() {
        wait.until(s->browser.findElement(By.xpath("//a[@data-sel='nav-widget-cart-link']")).isDisplayed());
        browser.findElement(By.xpath("//a[@data-sel='nav-widget-cart-link']")).click();
    }

    void getLogged(String email, String password) {
        WebElement targetElement = browser.findElement(By.xpath("//div[@data-testid='drop-down-trigger']"));
        // Vytvořit instanci třídy Actions
        Actions actions = new Actions(browser);
        // Přesunout kurzor na prvek
        actions.moveToElement(targetElement).perform();
        browser.findElement(By.xpath("//input[@id='username']")).sendKeys(email);
        browser.findElement(By.xpath("//input[@id='password']")).sendKeys((password));
        browser.findElement(By.xpath("//button[@data-testid='rounded-button']")).click();
    }

    void goToHomePage() {
        browser.get("https://mall.cz");
    }

    void setWaitTime(int seconds) {
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    void acceptCookies() {
        WebElement cookiesAcceptButton = browser.findElement(By.cssSelector(".legal-consent__button-container"));
        cookiesAcceptButton.click();
    }

    void closeAdvertisement() {
        wait.until(s->browser.findElement(By.id("l-exponea-close")).isDisplayed());
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

    void closeSmartOffer() {
        try {
            var closeButton = browser.findElement(By.id("exponea-close"));
            closeButton.click();
        } catch (NoSuchElementException e) {
            System.out.println("Advertisement close button not found.");
        } catch (Exception e) {
            System.out.println("An unexpected error occurred while closing the advertisement: " + e.getMessage());
        }
    }
}