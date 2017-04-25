import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Paltishko on 24.04.2017.
 */
public class SearchResultsTest {
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;
    private WebDriver driver;

    @BeforeMethod
    public void init() {

        System.setProperty("webdriver.chrome.driver", "webdrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        try {
            driver.get("https://www.vliegtickets.nl");
        } catch (Throwable e) {
            driver.quit();
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void getChipestTickets() {
        homePage = new HomePage(driver);
        searchResultsPage = homePage.lookOneWayTicketTo("Kie");
        boolean dynamicElement = (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.urlContains("https://engine.vliegtickets.nl/results"));
        searchResultsPage.getPrices();
    }
}
