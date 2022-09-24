package LiveProjectHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Activity6_HRM extends BaseClass2{

    /*Verify that the “Directory” menu item is visible and clickable
    Goal: Verify that the “Directory” menu item is visible and clickable
    a. Open the OrangeHRM page and login with credentials provided.
    b. Locate the navigation menu.
    c. Verify that the “Directory” menu item is visible and clickable.
    d. If clickable, click on the menu item*/

    @Test
    public void Directory() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement title = driver.findElement(By.id("menu_directory_viewDirectory"));
        title.isDisplayed();
        String dir = title.getText();
        Assert.assertEquals(dir, "Directory");
        System.out.println("Title is: " + dir);

        WebElement el = new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.elementToBeClickable(title));
        System.out.println("Directory menu is clickable");
        title.click();
        String SearchDir = driver.findElement(By.xpath("//h1[contains(text(),'Search')]")).getText();
        Assert.assertEquals(SearchDir, "Search Directory");
        System.out.println("Navigated to Search Directory page");
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

