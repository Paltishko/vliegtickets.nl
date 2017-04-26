import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
    @FindBy(css = "ul.ui-autocomplete > li")
    private WebElement autocompleteArival;
    @FindBy(id = "search_btn")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage lookOneWayTicketTo(String ticketTo) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        oneWayRButton.click();
        arrivalInputField.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.id("autocomplete_arrival1"))).sendKeys(ticketTo, Keys.ENTER);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("autocomplete_arrival1"))).sendKeys(ticketTo, Keys.ENTER); //this workaround to be fixed
        return new SearchResultsPage(driver);
    }
}
