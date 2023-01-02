package testRunner;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"stepDefinitions"},
        tags = "@activity2",
        plugin = {
        "pretty",
        "html:reports/HTML_report.html",
        "json:reports/JSON_report.json",
        "junit:reports/XML_report.xml"
        },
        publish = true
)
public class Activity2Runner {

}
