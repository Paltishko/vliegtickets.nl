import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Paltishko on 23.04.2017.
 */
public class LoginPage extends PageObject {
    @FindBy(id = "login")
    private WebElement loginField;
    @FindBy(id = "password")
    private WebElement passwordField;
    @FindBy(id = "submit")
    private WebElement submitButton;
    @FindBy(className = "v3-userName")
    private WebElement userNameLabel;
    @FindBy(className = "errorMessage")
    private WebElement errorMessage;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage typeUsername(String username) {
        loginField.sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage submitLogin() {
        submitButton.click();
        return this;
    }

    public LoginPage loginAs(String username, String password) {
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }

    public String getUsernameLabel() {
        return userNameLabel.getAttribute("innerHTML");
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }
}
