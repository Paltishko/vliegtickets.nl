import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Paltishko on 24.04.2017.
 */
public class PersonalDataPage {
    private WebDriver driver;
    private By manRadioButton = By.id("passengers-Adult-1-geslacht-m");
    private By firstNameField = By.id("passengers-Adult-1-voornaam");
    private By lastNameField = By.id("passengers-Adult-1-achternaam");
    private By birthDaySelect = By.id("passengers-Adult-1-birthdayDay");
    private By birthMonthSelect = By.id("passengers-Adult-1-birthdayMonth");
    private By birthYearSelect = By.id("passengers-Adult-1-birthdayYear");
    private By countrySelect = By.id("contacts-country");
    private By streetField = By.id("contacts-street");
    private By housenumberField = By.id("contacts-housenumber");
    private By postcodeField = By.id("contacts-postcode");
    private By cityField = By.id("contacts-city");
    private By phoneField = By.id("contacts-phone");
    private By postCodeField = By.id("contacts-email");
    private By combinedInsuranceRadioButton = By.id("insurance-CombinedInsurance");
    private By submitPersonalDataButton = By.id("submit_personal_data");



    public PersonalDataPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillPersonalData(){
        driver.findElement(manRadioButton).click();
        driver.findElement(firstNameField).sendKeys("Anton");
        driver.findElement(lastNameField).sendKeys("Test");
        new Select(driver.findElement(birthDaySelect)).selectByValue("17");
        new Select(driver.findElement(birthMonthSelect)).selectByValue("10");
        new Select(driver.findElement(birthYearSelect)).selectByValue("1989");
    }
}
