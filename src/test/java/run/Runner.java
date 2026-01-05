package run;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    tags = "@tag_cantine",                                          // Your tag
    features = "src/test/features/Ajout_collaborateur.feature",     // Correct path
    glue = {"hooks", "stepDefinition"},                             // Your packages
    monochrome = true,                                              // Clean console output
    dryRun = false,                                                 // Run actual tests
    publish = true,                                                 // Enables Cucumber public reports link in console

    plugin = {
        "pretty",                                                   // Console pretty print
        "html:target/cucumber-html-report",                         // Standard HTML report
        "json:target/cucumber.json",                                // ← CRITICAL: Standard name & location for Jenkins plugin
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"  // ← ExtentReports (keeps your beautiful HTML/PDF reports)
    }
)
public class Runner {
}
