package LiveProjectHRM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;


public class Activity9_HRM extends BaseClass2 {
/*  Goal: Login and retrieve the emergency contacts for the user
    a. Open the OrangeHRM page and login with credentials provided.
    b. Navigate to the “My Info” page.
    c. Locate the left hand menu.
    d. Click on the “Emergency Contacts” menu item.
    e. Retrieve information about all the contacts listed in the table.
    f. Print all the information to the console.
    g. Close the browser.*/

    @Test(priority = 0)
    public void MyInfo()
    {   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement myinfo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("#menu_pim_viewMyDetails > b:nth-child(1)")));
        Actions at = new Actions(driver);
        at.moveToElement(myinfo).click().perform();
        System.out.println("Navigated to the “My Info” page");
    }
    @Test(priority = 1)
    public void EmergencyCnt()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement EmergencyCnt_Link = wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.linkText("Emergency Contacts")));
        Actions at = new Actions(driver);
        at.moveToElement(EmergencyCnt_Link).click().perform();
        System.out.println("Clicked on the “Emergency Contacts” menu");
    }

    @Test(priority = 2)
    public void EContactList()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement tbl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id= 'emgcontact_list']")));
        List<WebElement> rows = tbl.findElements(By.tagName("tr"));
        System.out.println("Emergency contacts listed in the table below: ");

        for (int i = 0; i < rows.size(); i++) {
            //check column each in row, identification with 'td' tag
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            System.out.println(rows.get(i).getText()+"\n");

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
