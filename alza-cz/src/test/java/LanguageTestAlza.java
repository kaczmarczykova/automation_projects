import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LanguageTestAlza extends BaseTestAlza {
    ShoppingAlzaPage shoppingAlzaPage;
    CartAlzaPage cartAlzaPage;

    @BeforeEach
    void beforeTest() {
        shoppingAlzaPage = new ShoppingAlzaPage(browser);
        cartAlzaPage = new CartAlzaPage(browser);
    }

    @Test
    void languageMatchTest() {
        alzaPage.goToHomePage();
        alzaPage.scrollDown();
        var option1 = alzaPage.getLanguageVersion();
        alzaPage.scrollUp();
        alzaPage.changeLanguage();
        alzaPage.scrollDown();
        var option2 = alzaPage.getLanguageVersion();

        Assertions.assertNotEquals(option1, option2);
    }
}
