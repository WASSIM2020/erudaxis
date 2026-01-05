package Runner;


import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(

		features = {"features/Ajout_collaborateur.feature"},

		glue="StepDef",

		plugin = {"pretty",
				  "html:target/Cucumber-report.html",
				  "json:target/cucumber.json",
				  "junit:target/cucumber-report.xml"
				 }
		)
public class Runner {

}
