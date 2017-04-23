import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Paltishko on 23.04.2017.
 */
public class LoginPage {
    private final WebDriver driver;
    private By loginField = By.id("login");
    private By passwordField = By.id("password");
    private By submitButton = By.id("submit");
    private By userNameLabel = By.className("v3-userName");
    private By errorMessage = By.className("errorMessage");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage typeUsername(String username){
        driver.findElement(loginField).sendKeys(username);
        return this;
    }

    public LoginPage typePassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    public LoginPage submitLogin(){
        driver.findElement(submitButton).click();
        return this;
    }

    public LoginPage loginAs(String username, String password){
        typeUsername(username);
        typePassword(password);
        return submitLogin();
    }

    public String getUsernameLabel() {
        return driver.findElement(userNameLabel).getAttribute("innerHTML");
    }
    public WebElement getErrorMessage() {
        return driver.findElement(errorMessage);
    }
}
