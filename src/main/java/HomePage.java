import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Paltishko on 24.04.2017.
 */
public class HomePage {
    private final WebDriver driver;
    private By oneWayRButton = By.className("labelEnkel"); //id =roundtrip-single
    private By arrivalInputField = By.id("autocomplete_arrival1");
    private By searchButton = By.id("search_btn");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public SearchResultsPage lookOneWayTicketTo (String ticketTo){
        driver.findElement(oneWayRButton).click();
        driver.findElement(arrivalInputField).clear();
        driver.findElement(arrivalInputField).sendKeys("Kiev (Borispol) (KBP), Oekraïne");
        driver.findElement(searchButton).click();
        return new SearchResultsPage(driver);
    }
}
