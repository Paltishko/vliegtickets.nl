import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Paltishko on 24.04.2017.
 */
public class HomePage extends PageObject {
    @FindBy(xpath = "//*[@id=\"roundtrip-block\"]/div/label[1]")
    private WebElement oneWayRButton;
    @FindBy(xpath = "//*[@id=\"autocomplete_arrival1\"]")
    private WebElement arrivalInputField;
    @FindBy(id = "ui-id-23")
    private WebElement autocompleteArival;
    @FindBy(id = "search_btn")
    private WebElement searchButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage lookOneWayTicketTo(String ticketTo) {

        oneWayRButton.click();
        arrivalInputField.click();
        arrivalInputField.sendKeys(ticketTo);
        WebElement dynamicElement = (new WebDriverWait(driver, 5))
                .until(ExpectedConditions.visibilityOf(autocompleteArival));
        arrivalInputField.sendKeys(Keys.DOWN);
        arrivalInputField.sendKeys(Keys.ENTER);
        searchButton.click();
        return new SearchResultsPage(driver);
    }
}
