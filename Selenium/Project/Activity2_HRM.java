package LiveProjectHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Activity2_HRM extends BaseClass {

/*    Goal: Print the url of the header image to the console
        a. Open a browser.
        b. Navigate to ‘http://alchemy.hguy.co/orangehrm’.
        c. Get the url of the header image.
        d. Print the url to the console.
        e. Close the browser.*/

    @Test
    public void activity2() {
        WebElement img = driver.findElement(By.tagName("img"));
        String s = img.getAttribute("src");
        System.out.println("HRM Website header image url is: "+s);
    }
    @AfterTest
    public void closeBrowser() {
        try {
            driver.quit();
        } catch (Exception ignore) { }
    }
}

