package LiveProjectHRM;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Activity1_HRM extends BaseClass{

    /*Goal: Read the title of the website and verify the text
    a. Open a browser.
    b. Navigate to ‘http://alchemy.hguy.co/orangehrm’.
    c. Get the title of the website.
    d. Make sure it matches “OrangeHRM” exactly.
    e. If it matches, close the browser.*/
    @Test
    public void activity1() {
        String title = driver.getTitle();
        System.out.println("Title of the website is: " + title);
        Assert.assertEquals(title, "OrangeHRM");

        }

    @AfterTest
    public void closeBrowser() {
        try {
            driver.quit();
        } catch (Exception ignore) { }
        }
}
