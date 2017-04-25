import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Paltishko on 24.04.2017.
 */
public class PageObject {

    WebDriver driver;
    public PageObject(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
