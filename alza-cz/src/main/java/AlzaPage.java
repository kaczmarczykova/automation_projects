import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class AlzaPage {
    WebDriver browser;
    WebDriverWait wait;

    public AlzaPage(WebDriver browser) {
        this.browser = browser;
        this.wait = new WebDriverWait(browser, Duration.ofMillis(3000));
        browser.manage().window().maximize();
    }

    void setTheWaitTime() {
        browser.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
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

    void mainLogo() {
        browser.findElement(By.xpath("//a[@data-testid=\"headerLogo\"]")).click();
    }

    void searchProduct(String keyword) {
        browser.findElement(By.xpath("//a[@data-testid=\"searchInput\"]")).sendKeys(keyword);
        browser.findElement(By.cssSelector(".header-alz-122")).click();
    }

    void findMyOrder() {
        browser.findElement(By.cssSelector(".header-79elbk")).click();
    }

    void openCart() {
        //browser.findElement(By.cssSelector(".header-alz-359")).click();
        wait.until(s->browser.findElement(By.xpath("//a[@data-testid=\"headerBasketIcon\"]")).isDisplayed());
        browser.findElement(By.xpath("//a[@data-testid=\"headerBasketIcon\"]")).click();
        //browser.findElement(By.cssSelector(".header-alz-104")).click();
    }

    void openFavourites() {
        browser.findElement(By.xpath("//a[@data/testid=\"headerCommodityListIcon\"]")).click();
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
            var lng = "EN";
            var confirmButton = browser.findElement(By.cssSelector(".header-alz-98 button"));
            waitFor(3);
            confirmButton.click();

        } else {
            firstOption.click();
            var lng = "CZ";
            var close = "Confirm";
            browser.findElement(By.linkText(close)).click();

            }

    }

    String getLanguageVersion() {

        var lngVersion = browser.findElements(By.cssSelector(".footer-alz-14")).get(0).getText();
        if (lngVersion.contains("Nejspolehlivější internetový obchod v ČR")) {
            var language = "CZ";
            return language;
        } else {
            var language = "EN";
            return language;
        }
    }

    void clearCart() {
        try {
            // Najdeme všechny produkty na stránce
            List<WebElement> itemsInCart = browser.findElements(By.id("o1basket"));

            for (WebElement item : itemsInCart) {
                try {
                    item.findElement(By.cssSelector(".c6")).click();
                    WebElement removeProductButton = item.findElement(By.cssSelector(".js-item-options-del"));
                    removeProductButton.click();
                } catch (Exception e) {
                    System.out.println("Chyba při pokusu o odstranění položky: " + e.getMessage());
                }
            }
            System.out.println("Všechny položky byly odstraněny z košíku.");
        } catch (Exception e) {
            System.out.println("Chyba při vymazání košíku: " + e.getMessage());
        }
    }

    void changeLanguageVersion() {
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
}





