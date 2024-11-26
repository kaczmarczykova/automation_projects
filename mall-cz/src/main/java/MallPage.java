import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MallPage {
    WebDriver browser;

    public MallPage(WebDriver browser) {
        this.browser = browser;
        }

    void mainLogo() {
        browser.findElement(By.cssSelector(".header__big-logo")).click();
        }

    void goToCart() {
        browser.findElement(By.cssSelector(".cart__link > div:nth/child(1)")).click();
        }

    void LogIn() {
        browser.findElement(By.cssSelector(".desktop-icons__item--user")).click();
    }

    void getLogged(String email, String password) {
        browser.findElement(By.cssSelector(".desktop-icons__item--user")).click();
        browser.findElements(By.id("#username")).get(0).click();
        browser.findElement(By.id("#username")).sendKeys(email);
        browser.findElement(By.id("#password")).click();
        browser.findElement(By.id("#password")).sendKeys((password));
        browser.findElement(By.cssSelector(".rounded-button__wrapper__slot")).click();
    }
}

