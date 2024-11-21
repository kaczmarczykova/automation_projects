import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_page_test {

    @Test
    void homePageTest() {

        WebDriver browser = WebDriverManager.chromedriver().create();
        browser.get("https://alza.cz");

        // accept cookies
        browser.findElement(By.cssSelector(".cookies-info__button--white")).click();

        //click on TVs
        var tvSidebarItems = browser.findElements(By.cssSelector(".l0-catLink"));
        tvSidebarItems.get(6).click();

        //Proc nefunguje?
        //var productsList = browser.findElements(By.cssSelector("a.catalogLocalTitlePage-alz-4"));

        var tvElement = browser.findElement(By.linkText("Televize"));
        tvElement.click();

        //find the cheapest one
        browser.findElement(By.id("ui-id-3")).click();
        browser.findElement(By.cssSelector(".inStockAvailability bf first firstRow")).click();

        //add to cart
        var expected_price = browser.findElement(By.cssSelector(".price-box__price")).getText();

        browser.findElement(By.cssSelector(".btnx new green buy js-buy-button")).click();

        //open cart
        browser.findElement(By.cssSelector(".header-alz-103")).click();

        /*/increase number of TVs to 2
        //browser.findElement(By.cssSelector(".header-alz-103")).click();
        browser.findElement(By.id("last price")).sendKeys(2);*/
        String s = "3";
        int a = Integer.parseInt(s);


        var actual_price = browser.findElement(By.cssSelector(".last price")).getText();

        Assertions.assertEquals(expected_price, actual_price);

    }

}