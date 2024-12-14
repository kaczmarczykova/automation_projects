import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
    }

    @Test
    void pickTheCheapestProduct() {
        oneLastProduct.openTheClearanceSale();
        scrollDown();
        waitFor(3);
        oneLastProduct.sortByLowestPrice();
        oneLastProduct.selectProductWithLastTwoPieces();
        mallPage.goToCart();
        waitFor(3);
        int count = cartPage.howManyItemsInCart();
        Assertions.assertEquals(1, count);
    }

}



