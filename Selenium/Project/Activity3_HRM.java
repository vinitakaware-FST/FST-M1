package LiveProjectHRM;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class Activity3_HRM extends BaseClass{

    /*Goal: Open the site and login with the credentials provided
    a. Open the browser to the login page of OrangeHRM site.
    b. Find and select the username and password fields
    c. Enter login credentials into the respective fields
    d. Click login
    e. Verify that the homepage has opened.
    f. Close the browser*/

@Test
public void activity3() {
        driver.findElement(By.xpath("//input[@id = 'txtUsername']")).sendKeys("orange");
        driver.findElement(By.xpath("//input[@id = 'txtPassword']")).sendKeys("orangepassword123");
        driver.findElement(By.xpath("//input[@id = 'btnLogin']")).click();
        String Homepage = driver.findElement(By.xpath("//h1")).getText();
        Assert.assertEquals(Homepage,"Dashboard");
        Reporter.log("Homepage has loaded");
        }

    @AfterMethod
    public void closeBrowser()
    {
        try {
            driver.quit();
        }
        catch (Exception ignore) { }
         }
}
