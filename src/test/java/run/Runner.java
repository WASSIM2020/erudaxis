package run;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

    features = "features",

    glue = "stepDefinition",

    monochrome = true,

    plugin = {
        "pretty",                          // Beautiful console output
        "html:target/cucumber-html-report", // Basic HTML report
        "json:target/cucumber.json",       // ← REQUIRED for Jenkins Cucumber Reports plugin
        "junit:target/cucumber.xml"        // Optional: JUnit XML report
    }

)
public class Runner {
}
