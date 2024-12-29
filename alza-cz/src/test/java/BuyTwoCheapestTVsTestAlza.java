import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/* Na alza.cz si vlož do košíku nejlevnější produkt z kategorie Televize, ověř že se zde nachází (v košíku) a
že při navýšení počtu na 2 ks se zdvojnásobí jeho cena.*/

public class BuyTwoCheapestTVsTestAlza extends BaseTestAlza {
    AlzaPage alzaPage;
    ProductPage productPage;
    CartPage cartPage;

    @BeforeEach
    void beforeTest() {
        productPage = new ProductPage(browser);
        cartPage = new CartPage(browser);
    }

    @Test
    void buyTwoCheapestTVsTest() {

        //click on TVs
        alzaPage.goToHomePage();
        productPage.selectTVsPhotoAudio(4);
        productPage.selectTVs();

        //find the cheapest one and add to cart
        productPage.orderByPrice();
        productPage.openProductPage();
        int expected = productPage.getExpectedPrice();
        productPage.addToCart();

        //open cart and increase the number of TVs
        alzaPage.openCart();
        cartPage.increaseNumber();
        int actual = cartPage.getActualPrice();

        //assert there are 2 TVs in the cart and that the expected price and actual price are equal
        Assertions.assertEquals(2, cartPage.getTheCount());
        //assert the total price is correct
        Assertions.assertEquals(expected * 2, actual);
    }
}