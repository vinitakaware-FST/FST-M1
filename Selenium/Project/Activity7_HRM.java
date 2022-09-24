package LiveProjectHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7_HRM extends BaseClass2 {
/*    Open the OrangeHRM page and login with credentials provided
    b. Find the “My Info” menu item and click it.
    c. On the new page, find the Qualification option on the left side menu and click it.
    d. Add Work Experience and click Save.
    e. Close the browser.*/

    @Test
    public void MyInfo() throws InterruptedException {
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement myInfo = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.cssSelector("#menu_pim_viewMyDetails > b:nth-child(1)")));
        actions.doubleClick(myInfo).perform();
        myInfo.click();
        Thread.sleep(5000);
    }



    @Test
    public void Qualification()
    {
        WebElement qualification = driver.findElement(By.cssSelector("#sidenav > li:nth-child(9) > a:nth-child(1)"));
        qualification.isDisplayed();
        qualification.click();
        System.out.println("Work Experience page is displayed");
        driver.findElement(By.id("addWorkExperience")).click();
        WebElement Company = driver.findElement(By.id("experience_employer"));
        WebElement JobTitle = driver.findElement(By.id("experience_jobtitle"));
        //Enter text
        Company.sendKeys("ibm");
        JobTitle.sendKeys("test lead");
        driver.findElement(By.id("btnWorkExpSave")).click();
        System.out.println("added work experience successfully");

    }
    @AfterTest
    public void closeBrowser()
    {
        try {
            driver.quit();
        }
        catch (Exception ignore) { }
    }

}
