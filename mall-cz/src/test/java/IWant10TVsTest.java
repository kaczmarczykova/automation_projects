import dev.failsafe.internal.util.Assert;
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
        mallPage.closeAdvertisement();
        productPage.selectTVs(10);
        mallPage.clickMainLogo();
        mallPage.scrollUp();
        mallPage.goToCart();
        var actualCount = cartPage.getTheCountOfItemsInCart();
        Assertions.assertEquals(10, actualCount);
    }

    @Test
    void checkThePriceOfProductsInCart() {
        productPage.openMainMenu();
        productPage.openTVs();
        mallPage.closeAdvertisement();
        int expectedPrice = productPage.selectTVs(3);
        mallPage.scrollUp();
        mallPage.clickMainLogo();
        mallPage.goToCart();
        int totalPrice = cartPage.getThePriceItemByItem();
        Assertions.assertEquals(expectedPrice, totalPrice);

    }
}
