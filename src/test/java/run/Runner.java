package run;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    // This will run ALL feature files inside src/test/resources/features/
    // Highly recommended – you won't need to update this when adding new features
    features = "features",

    // Alternative: run only one specific feature
    // features = "features/Ajout_collaborateur.feature",

    // Package where your step definition classes are located
    // Change this if your steps are in a different package (case-sensitive!)
    glue = "stepDefinition",

    // Nice formatted output in console
    monochrome = true,

    // Plugins for reports
    plugin = {
        "pretty",                          // Beautiful console output
        "html:target/cucumber-html-report", // Basic HTML report
        "json:target/cucumber.json",       // ← REQUIRED for Jenkins Cucumber Reports plugin
        "junit:target/cucumber.xml"        // Optional: JUnit XML report
    }

    // Optional useful options (uncomment if needed)
    // tags = "@tag_cantine",
    // dryRun = false,
    // publish = true   // Gives a public shareable link in console when running locally
)
public class Runner {
}
