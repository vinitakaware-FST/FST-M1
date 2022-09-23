package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class Activity11_4 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.training-support.net/selenium/tab-opener");
        System.out.println("Page title is: " + driver.getTitle());

        String parentWindow = driver.getWindowHandle();
        System.out.println("Parent Window: " + parentWindow);
        driver.findElement(By.linkText("Click Me!")).click();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        Set<String> allWindowHandles = driver.getWindowHandles();

        System.out.println("All window handles: " + allWindowHandles);
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        System.out.println("Current window handle: " + driver.getWindowHandle());
        wait.until(ExpectedConditions.titleIs("Newtab"));
        System.out.println("New Tab Title is: " + driver.getTitle());

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.content:nth-child(2)")));
        String newTabText = driver.findElement(By.cssSelector("div.content:nth-child(2)")).getText();

        System.out.println("New tab heading is: " + newTabText);
        driver.findElement(By.linkText("Open Another One!")).click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(3));
        allWindowHandles = driver.getWindowHandles();
        System.out.println("All window handles: " + allWindowHandles);
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }
        System.out.println("New tab handle: " + driver.getWindowHandle());

        wait.until(ExpectedConditions.titleIs("Newtab2"));
        System.out.println("New Tab Title is: " + driver.getTitle());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.content:nth-child(2)")));
        newTabText = driver.findElement(By.cssSelector("div.content:nth-child(2)")).getText();
        System.out.println("New tab heading is: " + newTabText);
        driver.quit();
    }
}