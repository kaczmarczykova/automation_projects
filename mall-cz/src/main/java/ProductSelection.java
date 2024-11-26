import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductSelection extends MallPage {

    ProductSelection(WebDriver browser) {
        super(browser);
    }

  void showMore() {
        browser.findElement(By.cssSelector(".description-accordion__open")).click();
  }

  void selectPopularProduct(int index) {
        browser.findElements(By.cssSelector(".bs__name")).get(index).click();
  }

  void showMorePopularProducts() {
        browser.findElement(By.cssSelector(".bs__show-more-link")).click();
  }

}
