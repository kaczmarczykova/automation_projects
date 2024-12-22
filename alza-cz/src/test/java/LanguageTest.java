import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LanguageTest extends BaseTestAlza {
    ShoppingAlza shoppingAlzaPage;
    CartAlza cartAlzaPage;

    @BeforeEach
    void beforeTest() {
        shoppingAlzaPage = new ShoppingAlza(browser);
        cartAlzaPage = new CartAlza(browser);
    }

    @Test
    void languageMatchTest() {
        alzaPage.goToHomePage();
        alzaPage.waitFor(5);
        alzaPage.scrollDown();
        var option1 = alzaPage.getLanguageVersion();
        alzaPage.scrollUp();
        alzaPage.changeLanguage();
        alzaPage.scrollDown();
        var option2 = alzaPage.getLanguageVersion();

        Assertions.assertNotEquals(option1, option2);
    }

    @Test
    void alzaTest() {
        alzaPage.goToHomePage();
        alzaPage.scrollDown();
        alzaPage.changeLanguageVersion();
    }
}
