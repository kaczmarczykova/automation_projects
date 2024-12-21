import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class OneLastProduct extends MallPage {

    OneLastProduct(WebDriver browser) {
        super(browser);
    }

    void openTheClearanceSale() {
        browser.findElements(By.cssSelector(".top-icons__item")).get(1).click();
    }

    void sortByLowestPrice() {
        wait.until(s->browser.findElement(By.xpath("//a[@data-sel='sort-lowPrice']")).isDisplayed());
        browser.findElement(By.xpath("//a[@data-sel='sort-lowPrice']")).click();
    }

    void selectProductWithLastTwoPieces() {
        wait.until(s->browser.findElement(By.id("content-anchor")).isDisplayed());
        try {
            // Najdeme všechny produkty na stránce
            List<WebElement> productItems = browser.findElements(By.cssSelector(".pbcr"));

            boolean itemAdded = false;

            for (WebElement product : productItems) {
                try {
                    // Najdeme prvek, který obsahuje informaci o počtu kusů skladem
                    WebElement stockInfo = product.findElement(By.cssSelector(".pb-price__remaining-count"));

                    // Získáme text o skladové dostupnosti (např. "Skladem 2 ks")
                    String stockText = stockInfo.getText();

                    // Zkontrolujeme, zda text obsahuje přesně "2 ks"
                    if (stockText.contains("2")) {

                        // Klikneme na tlačítko "Přidat do košíku"
                        WebElement addToCartButton = product.findElement(By.cssSelector(".rounded-button__wrapper__slot"));
                        addToCartButton.click();

                        System.out.println("Produkt byl přidán do košíku.");
                        itemAdded = true;
                        break; // Přestaneme hledat po přidání prvního produktu
                    }
                } catch (Exception e) {
                    System.out.println("Chyba při zpracování produktu: " + e.getMessage());
                    // Pokud chybí prvek skladem nebo tlačítko, prostě přeskočíme tento produkt
                }
            }

            if (!itemAdded) {
                System.out.println("Nenašel se žádný produkt s přesně 2 ks skladem.");
            }

        } catch (Exception e) {
            System.out.println("Chyba: " + e.getMessage());
        }
    }

    boolean isPlusButtonDisabled() {
        var productField = browser.findElements(By.cssSelector(".cart-overview-item-row")).getFirst();
        var plusButton = productField.findElement(By.cssSelector(".article-counter__btn--plus"));
        var buttonAttribute = plusButton.getAttribute("disabled");
        return buttonAttribute != null && buttonAttribute.equals("true");
    }
}