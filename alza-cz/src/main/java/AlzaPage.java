import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class AlzaPage {
    WebDriver browser;
    JavascriptExecutor js;
    WebDriverWait wait;


    public AlzaPage(WebDriver browser) {
        this.browser = browser;
        this.js = (JavascriptExecutor)browser;
        this.wait = new WebDriverWait(browser, Duration.ofMillis(3000));
    }

    void setWaitTime(int seconds) {
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void goToHomePage() {
        browser.get("https://alza.cz");
    }

    void acceptCookies() {
        WebElement cookiesAcceptButton = browser.findElement(By.cssSelector(".cookies-info__button--white"));
        cookiesAcceptButton.click();
    }

    void scrollDown() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        waitFor(3);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    void scrollUp() {
        js.executeScript("window.scrollTo(0, 0);");
        waitFor(3);
        js.executeScript("window.scrollTo(0, 0);");
    }

    void openCart() {
        wait.until(s->browser.findElement(By.xpath("//a[@data-testid=\"headerBasketIcon\"]")).isDisplayed());
        browser.findElement(By.xpath("//a[@data-testid=\"headerBasketIcon\"]")).click();
    }

    void changeLanguage() {
        browser.findElements(By.cssSelector(".header-alz-20")).get(0).click();

        //get language locators
        var firstOption = browser.findElements(By.cssSelector(".header-1m9pwf3")).getFirst();
        var secondOption = browser.findElements(By.cssSelector(".header-1m9pwf3")).get(1);

        //check which option is selected
        var firstIsChecked = firstOption.getAttribute("checked");

        if (firstIsChecked != null) {
            secondOption.click();
            var confirmButton = browser.findElement(By.cssSelector(".header-alz-98 button"));
            waitFor(3);
            confirmButton.click();
        } else {
            firstOption.click();
            var close = "Confirm";
            browser.findElement(By.linkText(close)).click();
            }
    }

    String getLanguageVersion() {
        wait.until(s->browser.findElements(By.cssSelector(".footer-alz-14")).get(0).isDisplayed());
        var lngVersion = browser.findElements(By.cssSelector(".footer-alz-14")).get(0).getText();
        if (lngVersion.contains("Nejspolehlivější internetový obchod v ČR")) {
            var language = "CZ";
            return language;
        } else {
            var language = "EN";
            return language;
        }
    }

    void changeLanguageVersion() {
        scrollDown();
        browser.findElement(By.xpath("//span[@data-testid='footerLanguageSwitcher']")).click();
        wait.until(s-> browser.findElement(By.xpath("//input[@value='cs-CZ']")).isDisplayed());

        if (browser.findElement(By.xpath("//input[@value='cs-CZ']")).getAttribute("checked") == null) {
            browser.findElement(By.xpath("//input[@value='cs-CZ']")).click();
        } else {
            browser.findElement(By.xpath("//input[@value='en-GB']")).click();
        }
        //Click the button to change the language
        browser.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
    }

    String getLanguageVersionInHeader() {
        return browser.findElement(By.cssSelector(".header-alz-20")).getAttribute("alt");
    }

    String getLanguageVersionInFooter() {
        return browser.findElement(By.cssSelector(".footer-alz-7")).getAttribute("alt");
    }
}





