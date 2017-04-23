import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Paltishko on 24.04.2017.
 */
public class SearchResultsPage {
    WebDriver driver;
    private By selectAirFlightButton = By.className("b-reserv-btn-r");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public PersonalDataPage selectFirstFlight(){
        driver.findElement(selectAirFlightButton).click();
        return new PersonalDataPage(driver);
    }
}