import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Product extends MallPage {

    Product(WebDriver browser) {
        super(browser);
    }

    void addToCart() {
        browser.findElement(By.cssSelector(".info-box__main-btn .add-to-cart-list")).click();
    }

    void openMainMenu() {
        browser.findElement(By.cssSelector(".desktop-menu__item-title")).click();
    }

    void openHairDryers() {
        browser.findElement(By.xpath("//a[@href='/feny']")).click();
    }

    String getNameOfProduct() {
        wait.until(s->browser.findElement(By.cssSelector(".detail__title--desktop")).isDisplayed());
        return browser.findElement(By.cssSelector(".detail__title--desktop")).getText();
        }

    void selectPopularProduct(int idx) {
        wait.until(s->browser.findElements(By.cssSelector(".bs__name")).get(idx).isDisplayed());
        browser.findElements(By.cssSelector(".bs__name")).get(idx).click();
    }

    void openTVs() {
        browser.findElements(By.xpath("//li[@data-testid='desktop-menu__item']")).get(2).click();
        browser.findElement(By.xpath("//a[@href='/televizory']")).click();
    }

    int selectTVs(int number) {
        wait.until(s -> browser.findElement(By.cssSelector(".category-products-wrap")).isDisplayed());

        var totalPrice =0;
        for (int i = 0; i < number; i++) {
            var TV = browser.findElements(By.xpath("//button[@data-sel='add-to-cart-button-main']")).get(i);
            var singlePrice = browser.findElements(By.cssSelector(".pb-price__price")).get(i).getText();
            singlePrice = singlePrice.replaceAll("[^\\d]", "");
            int intSinglePrice = Integer.parseInt(singlePrice);
            totalPrice += intSinglePrice;
            TV.click();
            var pageIsRedirected = browser.findElement(By.cssSelector(".cross-sell__success"));
            wait.until(s -> pageIsRedirected).isDisplayed();
            browser.findElement(By.cssSelector(".cross-sell__button__close")).click();
            }
        return totalPrice;
    }

    void openMobiles() {
        browser.findElements(By.xpath("//li[@data-testid='desktop-menu__item']")).get(1).click();
        browser.findElement(By.xpath("//a[@href='/mobilni-telefony']")).click();
    }

    void selectPhonesOfAllBrands() throws Exception {
        List<WebElement> brandsAvailable = browser.findElements(By.cssSelector(".category-menu-item__wrapper"));
        int number = brandsAvailable.size();

        for (int i = 0; i < number; i++) {
            browser.findElements(By.cssSelector(".category-menu-item__wrapper")).get(i).click();
            closeSmartOffer();
            browser.findElement(By.xpath("//a[@data-sel='category_bestsellers']")).click();
            closeSmartOffer();
            //browser.findElements(By.cssSelector(".add-to-cart-list")).get(0).click();
            List<WebElement> itemsAvailable = browser.findElements(By.cssSelector(".pbcr"));
            WebElement addToCartButton;
            int j = 0;
            String firstChildAttribute = "";
            do {
                if (j >= itemsAvailable.size()) throw new Exception("No product on stock.");
                //var itemAvailable = itemsAvailable.get(j);
                //addToCartButton =itemAvailable.findElement(By.cssSelector(".add-to-cart-list"));

                var itemAvailable = itemsAvailable.get(j); //Blok produktu
                addToCartButton = itemAvailable.findElement(By.cssSelector(".rounded-button__wrapper")); //Najdeme vhodnou tridu ve strukture tlacitka
                var children = addToCartButton.findElements(By.tagName("svg")); //V teto tride je prvni decko ikona, zjistime vsechny ikony (stejne bude jen jedna)
                var firstChild = children.getFirst(); //Zjistime tu prvni ikonu
                firstChildAttribute = firstChild.getAttribute("data-iconname"); //Zjistime hodnotu jejiho atributu (nazev obrazku)

                j++;
            }
            //while (addToCartButton == null);
            while (firstChildAttribute == null || !firstChildAttribute.startsWith("cart-add"));
            addToCartButton.click();


            closeSmartOffer();
            try {
                var pageIsRedirected = browser.findElement(By.cssSelector(".cross-sell__success"));
                wait.until(s -> pageIsRedirected).isDisplayed();
                closeSmartOffer();
                browser.findElement(By.cssSelector(".cross-sell__button__close")).click();
                wait.until(s->browser.findElement(By.xpath("//a[@href='/mobilni-telefony']")).isDisplayed());
                closeSmartOffer();
                browser.findElement(By.xpath("//a[@href='/mobilni-telefony']")).click();
            } catch (NoSuchElementException e) {
                wait.until(s->browser.findElement(By.xpath("//a[@href='/mobilni-telefony']")).isDisplayed());
                closeSmartOffer();
                browser.findElement(By.xpath("//a[@href='/mobilni-telefony']")).click();
            }
        }
    }
}