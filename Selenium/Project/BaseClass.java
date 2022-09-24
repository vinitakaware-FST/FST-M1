package LiveProjectHRM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

public class BaseClass {

    WebDriver driver;

    @BeforeTest
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        //Open the browser
        driver.get("http://alchemy.hguy.co/orangehrm");
        Reporter.log("Login successfully to HRM website |");
    }
}
