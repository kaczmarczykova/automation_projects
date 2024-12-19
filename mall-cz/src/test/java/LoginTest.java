import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    ProductSelection productSelectionPage;
    Product productPage;
    Cart cartPage;


    @BeforeEach
    void beforeTest() {
        productSelectionPage = new ProductSelection(browser);
        productPage = new Product(browser);
        cartPage = new Cart(browser);
    }

    @Test
    void loginTest() {
        cartPage.getLogged("blbec", "blbec");
        WebElement message = browser.findElement(By.cssSelector(".login-form__error-message"));

        Assertions.assertTrue(message.isDisplayed());
    }
}