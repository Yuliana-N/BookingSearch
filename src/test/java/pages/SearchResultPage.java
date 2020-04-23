package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class SearchResultPage {
    WebDriver driver;
    By hotelsName = By.cssSelector(".sr-hotel__name");
    String hotelsScore = "//span[contains(text(),'%s')]/../../../../../div[@class='sr_item_review_block']//*/div[@class='bui-review-score__badge']";
    public SearchResultPage(WebDriver driver) {
        this.driver = driver;

    }
    public void hotelShouldBeInTheList(String hotelName) {
        boolean isFound = false;
        List<WebElement> hotels = driver.findElements(hotelsName);
        for(WebElement element : hotels) {
            isFound = element.getText().equals(hotelName);
            if(isFound) {
                break;
            }
        }
        Assert.assertTrue(isFound, "Отель в списке не найден");
    }
    public void hotelShouldHaveScore(String hotelScore,String hotelsName){
        boolean score1 = driver.findElement(By.xpath(String.format(hotelsScore,hotelsName))).getText().equals(hotelScore);
       // Assert.assertEquals(score1, hotelScore, "разные рейтинги");
        Assert.assertTrue(score1,"разные рейтинги");
    }
}
