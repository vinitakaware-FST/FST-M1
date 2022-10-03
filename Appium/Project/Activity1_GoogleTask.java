package LiveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Activity1_GoogleTask {
    WebDriverWait wait;
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //desired capabilities
        UiAutomator2Options caps = new UiAutomator2Options();

        caps.setPlatformName("android");
        caps.setAutomationName("UiAutomator2");
        caps.setAppPackage("com.google.android.apps.tasks");
        caps.setAppActivity(".ui.TaskListsActivity");
        caps.noReset();

        //appium server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        //Initialization of driver
        driver = new AndroidDriver(serverURL, caps);
    }

    @Test
    public void additionOfTask()
    {
        String array [] = {"Complete Activity with Google Tasks","Complete Activity with Google Keep","Complete the second Activity Google Keep"};
        for(int i=0;i<=array.length-1;i++) {
            WebElement plus = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/tasks_fab"));
            //packageName:id/idValue - in this only idValue get change so we cna put only idValue
            plus.click();
            wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            WebElement AddTask = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.tasks:id/add_task_title")));
            AddTask.sendKeys(array[i]);

            WebElement saveBtn = driver.findElement(AppiumBy.id("com.google.android.apps.tasks:id/add_task_done"));
            saveBtn.click();

            }

         String result1 = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Tasks\"]/android.view.ViewGroup/android.widget.TextView")).getText();
        // Assertion
        Assert.assertEquals(result1, array[0]);

        String result2 = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Keep\"]/android.view.ViewGroup/android.widget.TextView")).getText();
        // Assertion
        Assert.assertEquals(result2, array[1]);

        String result3 = driver.findElement(AppiumBy.xpath("//android.widget.FrameLayout[@content-desc=\"Complete the second Activity Google Keep\"]/android.view.ViewGroup/android.widget.TextView")).getText();
        // Assertion
        Assert.assertEquals(result3, array[2]);
    }




    @AfterClass
    public void tearDown()
    {   //close the app
        driver.quit();
    }
}