import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlzaPage {
    WebDriver browser;

    public AlzaPage(WebDriver browser) {
        this.browser = browser;
        browser.manage().window().maximize();
    }

    void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
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


}




