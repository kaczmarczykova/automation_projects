import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class OneLastProductTest extends BaseTest {
    ProductSelection productSelectionPage;
    Product productPage;
    Cart cartPage;
    OneLastProduct oneLastProduct;


    @BeforeEach
    void beforeTest() {
        productSelectionPage = new ProductSelection(browser);
        productPage = new Product(browser);
        cartPage = new Cart(browser);
        oneLastProduct = new OneLastProduct(browser);
        basePage = new BasePage(browser);
    }

    @Test
    void pickTheCheapestProduct() {
        oneLastProduct.openTheClearanceSale();
        basePage.closeAdvertisement();
        basePage.scrollDown();
        oneLastProduct.sortByLowestPrice();
        oneLastProduct.selectProductWithLastTwoPieces();
        mallPage.goToCart();
        int count = cartPage.GetCountOfItemsInCart();
        Assertions.assertEquals(1, count);
    }

    @RepeatedTest(5)
    void getTwoPieces() {
        oneLastProduct.openTheClearanceSale();
        basePage.closeAdvertisement();
        basePage.scrollDown();
        oneLastProduct.sortByLowestPrice();
        oneLastProduct.selectProductWithLastTwoPieces();
        mallPage.goToCart();

        //teprve tady zacina test
        cartPage.increaseCountOfProducts();
        int count2 = cartPage.GetCountOfItemsInCart();
        Assertions.assertEquals(2, count2);
    }

    @Test
    void checkThirdIsNotAvailable() {
        oneLastProduct.openTheClearanceSale();
        basePage.closeAdvertisement();
        basePage.scrollDown();
        oneLastProduct.sortByLowestPrice();
        oneLastProduct.selectProductWithLastTwoPieces();
        mallPage.goToCart();
        cartPage.increaseCountOfProducts();

        //teprve tady zacina test
        var actualStatus = oneLastProduct.identifyThePlusButton();
        Assertions.assertEquals("true", actualStatus);
    }
}