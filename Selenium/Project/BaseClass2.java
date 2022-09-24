package LiveProjectHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;

public class BaseClass2 {
    WebDriver driver;

    @BeforeTest
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open the browser
        driver.get("http://alchemy.hguy.co/orangehrm");

        driver.findElement(By.xpath("//input[@id = 'txtUsername']")).sendKeys("orange");
        driver.findElement(By.xpath("//input[@id = 'txtPassword']")).sendKeys("orangepassword123");
        driver.findElement(By.xpath("//input[@id = 'btnLogin']")).click();
    }
}
