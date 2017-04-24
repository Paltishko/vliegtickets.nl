import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by Paltishko on 23.04.2017.
 */
public class LoginTest {
    LoginPage loginPage;
    WebDriver driver;

    @BeforeMethod
    public void init(){
        System.setProperty("webdriver.chrome.driver", "webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.vliegtickets.nl/mijn");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void positiveLogin (){
        loginPage = new LoginPage(driver);
        loginPage.loginAs("paltishko@gmail.com", "testtest");
        assertEquals(loginPage.getUsernameLabel(), "Test Test");
    }

    @Test
    public void invalidLogin (){
        loginPage = new LoginPage(driver);
        loginPage.loginAs("wrong@gmail.com", "wrongpass");
        assertEquals(loginPage.getErrorMessage().getAttribute("innerHTML"), "Login niet bekend");
        assertEquals(loginPage.getErrorMessage().getCssValue("color"), "rgba(255, 0, 0, 1)");
    }

//    Currently site reloads login page in case no username and password were provided, I would expect to see some error message without page reloading
//    The same happens if I try to enter login less then 3 symbols or password less then 5 symbols
//    @Test
//    public void noEntryLogin (){
//        loginPage = new LoginPage(driver);
//        loginPage.submitLogin();
//        assertEquals(loginPage.getErrorMessage(), "Login niet bekend");
//    }
}
