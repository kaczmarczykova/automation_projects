import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomePageTestAlza extends BaseTestAlza {
    ShoppingAlza shoppingAlzaPage;
    CartAlza cartAlzaPage;

    @BeforeEach
    void beforeTest() {
        shoppingAlzaPage = new ShoppingAlza(browser);
        cartAlzaPage = new CartAlza(browser);
    }

    @Test
    void homePageTest() {

        //click on TVs
        shoppingAlzaPage.open();
        shoppingAlzaPage.selectTVsPhotoAudio();
        shoppingAlzaPage.selectTVs();

        //find the cheapest one and add to cart
        shoppingAlzaPage.orderByPrice();
        shoppingAlzaPage.openProductPage();
        int expected = shoppingAlzaPage.getExpectedPrice();
        shoppingAlzaPage.addToCart();

        //open cart and increase the number of TVs
        alzaPage.openCart();
        cartAlzaPage.increaseNumber();
        int actual = cartAlzaPage.getActualPrice();

        //assert there are 2 TVs in the cart and that the expected price and actual price are equal
        Assertions.assertEquals(2, cartAlzaPage.getTheCount());
        //assert the total price is correct
        Assertions.assertEquals(expected * 2, actual);
    }
}