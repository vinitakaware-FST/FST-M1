package LiveProjectHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Activity8_HRM extends BaseClass2 {
  /*  Goal: Login and apply for a leave on the HRM site
    a. Open the OrangeHRM page and login with credentials provided
    b. Navigate to the Dashboard page and click on the Apply Leave option.
    c. Select leave type and duration of the leave.
    d. Click Apply.
    e. Navigate to the My Leave page to check the status of the leave application.
    f. Close the browser*/


    @Test
    public void ApplyLeave() {
        Actions at = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//a[@id='menu_leave_viewLeaveModule']")));
        at.moveToElement(link).click().perform();

        WebElement ele = driver.findElement(By.xpath("//a[@id='menu_leave_applyLeave']"));
        ele.click();
        Select s = new Select(driver.findElement(By.xpath("//select[@id='applyleave_txtLeaveType']")));
        s.selectByVisibleText("DayOff");
        WebElement date = driver.findElement(By.xpath("//input[@id='applyleave_txtFromDate']"));
        date.click();
        date.sendKeys("2022-09-09");
        date.sendKeys(Keys.ENTER);
        driver.findElement(By.id("applyleave_txtComment")).sendKeys("Apply for sick leave");
        driver.findElement(By.id("applyBtn")).click();
        System.out.println("Applied for the Leave");
    }

    @Test
    public void MyLeave() {
        driver.findElement(By.xpath("//a[@id=\"menu_leave_viewMyLeaveList\"]")).click();
        WebElement Fdate = driver.findElement(By.xpath("//input[@id=\"calFromDate\"]"));
        Fdate.clear();
        Fdate.sendKeys("2022-09-02");

        WebElement Tdate = driver.findElement(By.xpath("//input[@id=\"calToDate\"]"));
        Tdate.clear();
        Tdate.sendKeys("2022-09-09");
        driver.findElement(By.xpath("//input[@type='checkbox'][1]")).click();
        driver.findElement(By.xpath("//input[@type='checkbox'][4]")).click();
        driver.findElement(By.xpath("//input[@id='btnSearch']")).click();

        WebElement tbl = driver.findElement(By.id("resultTable"));
        List<WebElement> rows = tbl.findElements(By.tagName("tr"));
        System.out.println("Leave application details and status as below - ");

        for (int i = 0; i < rows.size(); i++) {
            //check column each in row, identification with 'td' tag
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            int rowIndex = 0;
            int k=0;
            List<WebElement> Hcols = rows.get(k).findElements(By.tagName("th"));
            //column iteration
            for (int j = 0; j < cols.size(); j++,k++) {
                System.out.println(Hcols.get(k).getText()+": "+ cols.get(j).getText());
            }
        }

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
