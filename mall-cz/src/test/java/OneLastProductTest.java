import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

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
        waitFor(3);
        closeAdvertisement();
        scrollDown();
        waitFor(3);
        oneLastProduct.sortByLowestPrice();
        waitFor(3);
        oneLastProduct.selectProductWithLastTwoPieces();
        mallPage.goToCart();
        waitFor(3);
        int count = cartPage.howManyItemsInCart();
        Assertions.assertEquals(1, count);
    }

    @Test
    void getTwoPieces() {

        browser.findElement(By.cssSelector(".desktop-menu__item-title")).click();
        //click on hair dryers
        browser.findElement(By.xpath("//a[@href='/feny']")).click();
        waitFor(3);
        closeAdvertisement();
        waitFor(3);
        productSelectionPage.selectPopularProduct((0));
        waitFor(3);
        var expectedName = browser.findElement(By.cssSelector(".detail__title--desktop")).getText();
        //Add to cart
        productPage.addToCart();
        //Open cart
        waitFor(5);
        var openCart_element = browser.findElement(By.cssSelector(".cross-sell__button__to-cart__to"));
        openCart_element.click();

        //teprve tady zacina test
        cartPage.increaseCountOfProducts();
        waitFor(3);
        int count2 = cartPage.howManyItemsInCart();
        Assertions.assertEquals(2, count2);
    }

    @Test
    void ThirdIsNotAvailable() {
        /*
        oneLastProduct.openTheClearanceSale();
        scrollDown();
        waitFor(3);
        oneLastProduct.sortByLowestPrice();
        oneLastProduct.selectProductWithLastTwoPieces();
        mallPage.goToCart();
        waitFor(3);*/

        var productField = browser.findElements(By.cssSelector(".cart-overview-item-row")).getFirst();
        var plusButton = productField.findElement(By.cssSelector(".article-counter__btn--plus" ));
        waitFor(3);
        var actualStatus = plusButton.getAttribute("disabled");
        Assertions.assertEquals("true", actualStatus);
    }
}