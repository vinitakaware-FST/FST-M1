package LiveProject;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class Activity3_GoogleChrome {
    WebDriverWait wait;
    AndroidDriver driver;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.android.chrome");
        options.setAppActivity("com.google.android.apps.chrome.Main");
        options.noReset();

        // Server URL
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        // Driver initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Open Selenium page
        driver.get("https://www.training-support.net/selenium");

    }
    @Test
    public void scrollToDoList () {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        // Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View")));
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".flingForward()"));
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollTextIntoView(\"To-Do List\")")).click();
    }
    @Test()
    public void taskAdd() {

        String array[] = {"Appium Test", "JAVA Test", "Python Test"};
        for (int i = 0; i <= array.length - 1; i++) {
            WebElement input = driver.findElement(AppiumBy.className("android.widget.EditText"));
            input.sendKeys(array[i]);
            driver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text, 'Add Task')]")).click();
        }
    }
    @Test()
    public void taskList() {

        List<WebElement> listOfElements = driver.findElements(AppiumBy.xpath("//android.view.View[2]//android.widget.TextView"));
        System.out.println(listOfElements.size());
    }
    @Test()
    public void taskStrike() {

        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text = 'Appium Test']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text = 'JAVA Test']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text = 'Python Test']")).click();
//        driver.findElement(AppiumBy.xpath("//android.view.View[3]/android.widget.TextView[2]")).click();
        try {
            WebElement el = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.view.View[3]/android.widget.TextView[2]")));
            el.click();
            System.out.println("Task list cleared and Test passed!");

        } catch (Exception e) {
            System.out.println("Error from code - " + e.getMessage());
        }


    }

    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}

