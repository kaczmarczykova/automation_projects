import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LanguageTestAlza extends BaseTestAlza {
    ProductPage productPage;
    CartPage cartPage;

    @BeforeEach
    void beforeTest() {
        productPage = new ProductPage(browser);
        cartPage = new CartPage(browser);
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

    @Test
    void changeLanguageTest() {
        alzaPage.goToHomePage();
        alzaPage.changeLanguageVersion();
        var newLngHeader = alzaPage.getLanguageVersionInHeader();
        alzaPage.scrollDown();
        var newLngFooter = alzaPage.getLanguageVersionInFooter();
        Assertions.assertEquals(newLngFooter, newLngHeader);

    }
}
