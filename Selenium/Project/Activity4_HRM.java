package LiveProjectHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;


public class Activity4_HRM extends BaseClass2{
    /*    Goal: Add an employee and their details to the site
    a. Open the OrangeHRM page and login with credentials provided
    b. Find the PIM option in the menu and click it.
    c. Click the Add button to add a new Employee.
    d. Fill in the required fields and click Save.
    e. Navigate back to the PIM page (Employee List tab) and verify the creation of your
    employee.
    f. Close the browser.*/

@Test
    public void Addemp() {
    System.out.println("Login successful");
    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    WebElement ele = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='menu_pim_viewPimModule']/b[1]")));
    actions.doubleClick(ele).perform();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='btnAdd']"))).click();
    System.out.println("Under the PIM option Clicked the Add button to add a new Employee");
    WebElement fname = driver.findElement(By.xpath("//input[@id='firstName']"));
    fname.sendKeys("Vinita");
    System.out.println("First name entered as: " + fname.getAttribute("value"));

    WebElement lname = driver.findElement(By.xpath("//input[@id='lastName']"));
    lname.sendKeys("Kaware");
    System.out.println("Last name entered as: " + lname.getAttribute("value"));

    WebElement save = driver.findElement(By.xpath("//input[@id='btnSave']"));
    save.click();
    System.out.println("required fields entered and clicked on Save");
}
    @Test
    public void Searchemp()
    {
        driver.findElement(By.linkText("Employee List")).click();
        System.out.println("Navigated to Employee List tab");
        WebElement search = driver.findElement(By.id("empsearch_employee_name_empName"));
        search.click();
        search.sendKeys("Vinita Kaware");
        search.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//input[@id= 'searchBtn']")).click();
        System.out.println("Search for added employee details");

        String a = driver.findElement(By.cssSelector("td.left:nth-child(3)")).getText();
        String b = driver.findElement(By.cssSelector("td.left:nth-child(4) > a:nth-child(1)")).getText();
        String result = a.concat(b);
        Assert.assertEquals(result, "VinitaKaware");
    }

    @AfterTest
    public void closeBrowser() {
        try {
            driver.quit();
        } catch (Exception ignore) { }

    }

}
