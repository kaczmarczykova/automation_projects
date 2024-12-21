import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IWant10TVsTest extends BaseTest{
    Product productPage;
    Cart cartPage;

    @BeforeEach
    void beforeTest() {
        productPage = new Product(browser);
        cartPage = new Cart(browser);
    }

    @Test
    void tenTVsTest() {
        productPage.openMainMenu();
        productPage.openTVs();
        basePage.closeAdvertisement();
        productPage.selectTVs();
        mallPage.goToCart();
        var actualCount = cartPage.getTheCountOfItemsInCart();
        Assertions.assertEquals(10, actualCount);
    }

}
