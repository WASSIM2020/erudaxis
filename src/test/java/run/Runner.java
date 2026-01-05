package run;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "features/Ajout_collaborateur.feature",  // parfait, car sous src/test/resources/features
    // ou features = "features" pour exécuter tous les .feature du dossier

    glue = "StepDef",  // à ajuster si ton package de steps est différent (ex: "stepdef" ou "stepDefinition")

    monochrome = true,

    plugin = {
        "pretty",
        "html:target/cucumber-html-report",
        "json:target/cucumber.json",         
        "junit:target/cucumber.xml"
    }
)
public class Runner {
}
