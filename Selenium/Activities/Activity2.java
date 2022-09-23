package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {
    public static void main(String[] args)
    {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");

        String title = driver.getTitle();
        System.out.println("Title of the page is: "+title);

        WebElement element1 = driver.findElement(By.id("about-link"));
        System.out.println("id in element: " + element1.getText());

        WebElement element2 = driver.findElement(By.className("green"));
        System.out.println("class in element: " + element2.getText());

        WebElement element3 = driver.findElement(By.linkText("About Us"));
        System.out.println("linkText in element: " + element3.getText());

        WebElement element4 = driver.findElement(By.cssSelector(".green"));
        System.out.println("CssSelector in element: " + element4.getText());

        driver.close();
    }

}
