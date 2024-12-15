import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomePageTest extends BaseTest {
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
    void homePageTest() {

        Assertions.assertEquals("MALL.CZ – bílé zboží, elektronika, PC, outdoor, hobby, hračky, kosmetika, chovatelské potřeby", browser.getTitle());
    }

    @Test
    void hairDryerTest() {
        productPage.openMainMenu();
        productPage.openHairDryers();
        waitFor(5);
        productSelectionPage.selectPopularProduct((0));

        waitFor(5);
        var expectedName = productPage.getNameOfTheProduct();

        productPage.addToCart();

        waitFor(5);
        mallPage.goToCart();

        waitFor(5);
        var actualName = cartPage.getNameOfProductInCart();

        Assertions.assertEquals(expectedName, actualName);
    }

    @Test
    void cartOperations() {
        Cart cartPage = new Cart(browser);

        cartPage.goToCart();
        cartPage.goBack();
        cartPage.goToCart();
        cartPage.deleteItem(0);
    }



}
