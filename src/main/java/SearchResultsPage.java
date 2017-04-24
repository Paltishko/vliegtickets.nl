import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

/**
 * Created by Paltishko on 24.04.2017.
 */
public class SearchResultsPage extends PageObject {

    @FindBy(className = "b-reserv-btn-r")
    private WebElement selectAirFlightButton;
    @FindBy(css = "div.b-resuls__item_right > h3:nth-child(2) > span > span:nth-child(2)")
    private List<WebElement> prices;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public PersonalDataPage selectFirstFlight() {
        selectAirFlightButton.click();
        return new PersonalDataPage(driver);
    }

    public void getPrices() {
//        WebElement dynamicElement = (new WebDriverWait(driver, 30)).
//                until(ExpectedConditions.presenceOfElementLocated(By.id("div.b-resuls__item_right > h3:nth-child(2) > span > span:nth-child(2)")));
        prices.toString();
    }
}
