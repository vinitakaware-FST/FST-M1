package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
        public static void main(String[] args) {
            WebDriver driver = new FirefoxDriver();
            driver.get("https://www.training-support.net/selenium/simple-form");
            String pageTitle = driver.getTitle();
            System.out.println(pageTitle);
            WebElement firstName = driver.findElement(By.id("firstName"));
            WebElement lastName = driver.findElement(By.id("lastName"));
            firstName.sendKeys("Vinita");
            lastName.sendKeys("Kaware");

            driver.findElement(By.id("email")).sendKeys("vinitakaware@gmail.com");
            driver.findElement(By.id("number")).sendKeys("1234512345");
            driver.findElement(By.cssSelector(".ui.green.button")).click();
            driver.close();
        }
}
