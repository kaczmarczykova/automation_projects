import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlzaPage {
    WebDriver browser;

    public AlzaPage(WebDriver browser) {
        this.browser = browser;
        browser.manage().window().fullscreen();
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
        browser.findElement(By.xpath("//a[@data-testid=\"headerBasketIcon\"]")).click();
        //browser.findElement(By.cssSelector(".header-alz-104")).click();
    }

    void openFavourites() {
        browser.findElement(By.xpath("//a[@data/testid=\"headerCommodityListIcon\"]")).click();
    }


}
