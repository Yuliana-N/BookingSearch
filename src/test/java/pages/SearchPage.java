package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage {
    WebDriver driver;
    By hotelInput = By.id("ss");
    By searchButton = By.cssSelector(".sb-searchbox__button");
    SearchResultPage searchResultPage;
    public SearchPage(WebDriver driver){
        this.driver = driver;
    }
    public void openPage(){
        driver.get("https://www.booking.com/searchresults.en-gb.html");
    }
    public SearchResultPage searchHotel(String hotelName){
        driver.findElement(hotelInput).sendKeys(hotelName);
        driver.findElement(searchButton).click();
        return new SearchResultPage(driver);
    }
}
