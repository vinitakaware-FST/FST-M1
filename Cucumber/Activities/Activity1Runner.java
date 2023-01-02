package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features",
        glue = {"stepDefinitions"},
        tags = "@activity1",
        plugin = {
        "pretty",
        "html:reports/HTML_report.html",
        "json:reports/JSON_report.json",
        "junit:reports/XML_report.xml"
},
        publish = true
)

public class Activity1Runner {
}
