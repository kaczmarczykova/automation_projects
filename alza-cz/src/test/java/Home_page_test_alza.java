import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home_page_test_alza {

    WebDriver browser = WebDriverManager.chromedriver().create();
    AlzaPage alzaPage = new AlzaPage(browser);
    /*void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }*/

    void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        alzaPage.waitFor(3);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    void scrollUp() {
        JavascriptExecutor js = (JavascriptExecutor) browser;
        js.executeScript("window.scrollTo(0, 0);");
        alzaPage.waitFor(3);
        js.executeScript("window.scrollTo(0, 0);");
    }

    @BeforeEach
    void beforeTest() {
        browser.get("https://alza.cz");
        //accept cookies
        WebElement cookiesAcceptButton = browser.findElement(By.cssSelector(".cookies-info__button--white"));
        cookiesAcceptButton.click();
        browser.manage().window().maximize();
    }

    @Test
    void homePageTest() {

        ShoppingAlza shoppingAlza = new ShoppingAlza(browser);
        CartAlza cartAlza = new CartAlza(browser);


        //click on TVs
        shoppingAlza.open();
        shoppingAlza.selectTVsPhotoAudio();
        alzaPage.waitFor(5);
        shoppingAlza.selectTVs();

        //find the cheapest one and add to cart
        shoppingAlza.orderByPrice();
        alzaPage.waitFor(5);
        shoppingAlza.openProductPage();
        int expected = shoppingAlza.getExpectedPrice();
        alzaPage.waitFor(5);
        shoppingAlza.addToCart();

        //open cart and increase the number of TVs
        alzaPage.waitFor(5);
        alzaPage.openCart();
        alzaPage.waitFor(5);
        cartAlza.increaseNumber();
        alzaPage.waitFor(5);
        int actual = cartAlza.getActualPrice();

        //assert there are 2 TVs in the cart and that the expected price and actual price are equal
        Assertions.assertEquals(cartAlza.getTheCount(), 2);
        Assertions.assertEquals(expected * 2, actual);
    }

    @Test
    void LanguageTest() {

        ShoppingAlza shoppingAlza = new ShoppingAlza(browser);
        CartAlza cartAlza = new CartAlza(browser);
        AlzaPage alzaPage = new AlzaPage(browser);

        alzaPage.waitFor(5);
        scrollDown();
        var option1 = alzaPage.getLanguageVersion();
        scrollUp();
        alzaPage.changeLanguage();
        scrollDown();
        var option2 = alzaPage.getLanguageVersion();

        Assertions.assertNotEquals(option1, option2);


    }

    /*@Test
    void alzaTest() {
        browser.get("https://alza.cz");

        JavascriptExecutor js = (JavascriptExecutor) browser;

        //Slooowly scroll to the bottom
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        waitFor(2);
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        browser.findElement(By.xpath("//span[@data-testid='footerLanguageSwitcher']")).click();
        waitFor(2);

        if (browser.findElement(By.xpath("//input[@value='cs-CZ']")).getAttribute("checked") == null) {
            browser.findElement(By.xpath("//input[@value='cs-CZ']")).click();
        } else {
            browser.findElement(By.xpath("//input[@value='en-GB']")).click();
        }

        //Click the button to change the language
        browser.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
    }*/
}