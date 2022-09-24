package LiveProjectHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Activity5_HRM extends BaseClass2{

/*    Goal: Edit a user’s information
    a. Open the OrangeHRM page and login with credentials provided
    b. Find the “My Info” menu item and click it.
    c. On the new page, click the Edit button
    d. Fill in the Name, Gender, Nationality, and the DOB fields.
    e. Click Save.
    f. Close the browser.*/

    @Test
    public void activity5() {

        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement myInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.cssSelector("#menu_pim_viewMyDetails > b:nth-child(1)")));
        actions.doubleClick(myInfo).perform();
        myInfo.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@id='btnSave' or @value = \"Edit\"]")).click();

        driver.findElement(By.xpath("//*[@id='personal_txtEmpFirstName']")).clear();
        driver.findElement(By.xpath("//*[@id='personal_txtEmpLastName']")).clear();

        WebElement FirstName = driver.findElement(By.id("personal_txtEmpFirstName"));
        WebElement LastName = driver.findElement(By.id("personal_txtEmpLastName"));
        //Enter text
        FirstName.sendKeys("Jony");
        LastName.sendKeys("Don");
        driver.findElement(By.xpath("//*[@id='personal_optGender_1']")).click();
        Select s = new Select(driver.findElement(By.id("personal_cmbNation")));
        s.selectByVisibleText("Honduran");
        driver.findElement(By.xpath("//input[@id='personal_DOB']")).sendKeys("2000-01-01");

        driver.findElement(By.id("btnSave")).click();
        Reporter.log("Edited a user’s information successfully");

    }
    @AfterTest
    public void closeBrowser() {
        try {
            driver.quit();
        } catch (Exception ignore) {
        }
    }
}

