import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paltishko on 24.04.2017.
 */
public class SearchResultsPage extends PageObject {

    @FindBy(className = "b-reserv-btn-r")
    private WebElement selectAirFlightButton;
    By cheapestPrice = By.cssSelector("div.i-ta_l > h3:nth-child(3) >span> span:nth-child(2)");
    By prices = By.cssSelector("div.i-ta_l > h3:nth-child(2) >span> span:nth-child(2)");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public PersonalDataPage selectFirstFlight() {
        selectAirFlightButton.click();
        return new PersonalDataPage(driver);
    }

    public void getPrices() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.b-results>div.new")));
        List<WebElement> prices = new ArrayList<>();
        prices.add(driver.findElement(cheapestPrice));
        prices.addAll(driver.findElements(this.prices));
        try(PrintWriter out = new PrintWriter( "Logging\\log.txt", "UTF-8")){ //filename to be changed according to current TimeStamp
            out.println("The two cheapest prices:");
            out.println(prices.get(0).getText());
            out.println(prices.get(1).getText());
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
