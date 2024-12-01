import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AlzaPage {
    WebDriver browser;

    public AlzaPage(WebDriver browser) {
        this.browser = browser;
        browser.manage().window().maximize();
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

    String changeLanguage() {
        browser.findElements(By.cssSelector(".header-alz-20")).get(0).click();

        //get language locators
        var firstOption = browser.findElements(By.cssSelector(".PrivateSwitchBase-root")).get(0);
        var secondOption = browser.findElements(By.cssSelector("PrivateSwitchBase-root")).get(1);

        //check which option is selected
        try {
            if (firstOption.isSelected()) {
                secondOption.click();
                var lng = "EN";
                var close = "Potvrdit / Confirm";
                browser.findElement(By.linkText(close)).click();
                return lng;
            } else {
                firstOption.click();
                var lng = "CZ";
                var close = "Confirm";
                browser.findElement(By.linkText(close)).click();
                return lng;
            }
        }

    }

    String getLanguageVersion() {

        /*var lngVersion = browser.findElement(By.xpath("//span[@data-testid=\"footerLanguageSwitcher\"]")).getAttribute("alt");
        if (lngVersion == "CZ") {
            var language = "CZ";
            return language;
        } else {
            var language = "EN";
            return language;*/

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