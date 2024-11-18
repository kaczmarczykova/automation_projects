import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageTest {

    @Test
    void homePageTest() {
        WebDriver browser = WebDriverManager.firefoxdriver().create();
        browser.get("https://mall.cz");
        //1. accept cookies
        WebElement cookiesAcceptButton = browser.findElement(By.cssSelector(".legal-consent__button-container"));
        cookiesAcceptButton.click();

        //click a button based on its index (0, 1 or 2)
       // browser.findElements(By.cssSelector(".legal-consent__button-container")).get(0).click();

        Assertions.assertEquals("MALL.CZ – bílé zboží, elektronika, PC, outdoor, hobby, hračky, kosmetika, chovatelské potřeby", browser.getTitle());
    }

    @Test
    void hairDryerTest() {

        WebDriver browser = WebDriverManager.firefoxdriver().create();
        browser.get("https://mall.cz");
        //1. accept cookies
        WebElement cookiesAcceptButton = browser.findElement(By.cssSelector(".legal-consent__button-container"));
        cookiesAcceptButton.click();

        browser.findElement(By.cssSelector(".desktop-menu__item-title")).click();

        //click on hair dryers
        browser.findElement(By.xpath("//a[@href='/feny']")).click();
        browser.findElement(By.cssSelector(".bs__name")).click();

        var expectedName = browser.findElement(By.cssSelector(".detail__title--desktop")).getText();

        //Add to cart
        browser.findElement(By.cssSelector(".info-box__main-btn .add-to-cart-list")).click();

        //Open cart
        browser.findElement(By.cssSelector(".cross-sell__button__to-cart__to")).click();

        var actualName = browser.findElement(By.cssSelector(".cart-overview-item-title a")).getText();

        Assertions.assertEquals(expectedName, actualName);



    }


}
