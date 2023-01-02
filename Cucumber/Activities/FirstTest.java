package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FirstTest extends BaseClass{

    @Given("^user is on the TS Homepage$")
    public void user_is_on_the_ts_homepage()

    {
       driver.get("https://www.training-support.net");
    }
    @When("^user clicks on About Us link$")
    public void clickAboutUsLink()
    {
        driver.findElement(By.linkText("About Us")).click();
    }
    @Then("^they are redirected to about us page$")
    public void redirectToAboutUs()
    {
        String pageTitle = driver.getTitle();
        //Assertions
        assertEquals(pageTitle, "About Training Support");
    }

   // @Then("close browser")
    //public void close_browser() {
        // Write code here that turns the phrase above into concrete actions
      //  throw new io.cucumber.java.PendingException();
    //}
}
