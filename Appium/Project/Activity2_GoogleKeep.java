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

public class Activity2_GoogleKeep {
    WebDriverWait wait;
    AndroidDriver driver;

    @BeforeClass
    public void setUp() throws MalformedURLException {
        //desired capabilities
        UiAutomator2Options caps = new UiAutomator2Options();

        caps.setPlatformName("android");
        caps.setAutomationName("UiAutomator2");
        caps.setAppPackage("com.google.android.keep");
        caps.setAppActivity(".activities.BrowseActivity");
        caps.noReset();

        //appium server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");
        //Initialization of driver
        driver = new AndroidDriver(serverURL, caps);
    }

    @Test
    public void CreateNote()
    {
        WebElement plus = driver.findElement(AppiumBy.id("com.google.android.keep:id/new_note_button"));
        plus.click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        driver.findElement(AppiumBy.id("com.google.android.keep:id/editable_title"));
        WebElement title = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.keep:id/editable_title")));
        title.sendKeys("CreateNote-FST");

        WebElement Desc = driver.findElement(AppiumBy.id("com.google.android.keep:id/edit_note_text"));
        Desc.sendKeys("FST45 -Appium Automation");

        driver.findElement(AppiumBy.accessibilityId("Navigate up")).click();
    }
    @Test
    public void ValidateAddedNote()
    {
        String titleResult = driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_title")).getText();
        Assert.assertEquals(titleResult, "CreateNote-FST");

        String DescResult = driver.findElement(AppiumBy.id("com.google.android.keep:id/index_note_text_description")).getText();
        Assert.assertEquals(DescResult, "FST45 -Appium Automation");

    }
    @AfterClass
    public void tearDown()
    {   //close the app
        driver.quit();
    }
}
