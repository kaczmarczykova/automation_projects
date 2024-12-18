import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MallPage {
    WebDriver browser;
    WebDriverWait wait;

    public MallPage(WebDriver browser) {
        this.browser = browser;
        this.wait = new WebDriverWait(browser, Duration.ofMillis(3000));
        browser.manage().window().maximize();
    }

    void mainLogo() {
        browser.findElement(By.cssSelector(".header__big-logo")).click();
    }

    void goToCart() {
        wait.until(s->browser.findElement(By.xpath("//a[@data-sel='nav-widget-cart-link']")).isDisplayed());
        browser.findElement(By.xpath("//a[@data-sel='nav-widget-cart-link']")).click();

        //varianta 2
        /*
        var openCart_element = browser.findElement(By.cssSelector(".cross-sell__button__to-cart__to"));
        openCart_element.click();
         */
    }

    void getLogged(String email, String password) {
        //browser.findElement(By.cssSelector(".desktop-icons__item--user")).click();
        WebElement targetElement = browser.findElement(By.xpath("//div[@data-testid='drop-down-trigger']"));
        // Vytvořit instanci třídy Actions
        Actions actions = new Actions(browser);
        // Přesunout kurzor na prvek
        actions.moveToElement(targetElement).perform();

        browser.findElement(By.xpath("//input[@id='username']")).sendKeys(email);
        browser.findElement(By.xpath("//input[@id='password']")).sendKeys((password));
        browser.findElement(By.xpath("//button[@data-testid='rounded-button']")).click();
    }


}