import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MobilesTest extends BaseTest{
    Product productPage;
    Cart cartPage;

    @BeforeEach
    void beforeTest() {
        productPage = new Product(browser);
        cartPage = new Cart(browser);
    }

    @Test
    void getAllPhonesWithAccessories() throws Exception {
        productPage.openMainMenu();
        productPage.openMobiles();
        mallPage.closeAdvertisement();
        mallPage.closeSmartOffer();
        productPage.selectPhonesOfAllBrands();


    }
}
