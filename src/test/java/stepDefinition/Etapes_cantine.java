package stepDefinition;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.CantinePage;
import pageObject.LoginPage;

public class Etapes_cantine {
	 WebDriver driver;
     LoginPage loginPage;
     CantinePage cantinePage;


	@Given("je suis connecté en tant qu'utilisateur avec l'email {string} et le mot de passe {string}")
	public void je_suis_connecté_en_tant_qu_utilisateur_avec_l_email_et_le_mot_de_passe(String email, String mdp) {
		driver = new ChromeDriver(); // Ajoutez WebDriverManager si possible
        driver.manage().window().maximize();
        driver.get("https://staging.erudaxis.com/");
        loginPage = new LoginPage(driver);
        loginPage.saisirEmail(email);
        loginPage.saisirMotDePasse(mdp);
        loginPage.cliquerSeConnecter();
        // Attendre redirection (ajoutez wait si besoin)
	}

	@When("je navigue vers la page de gestion de la cantine {string}")
	public void je_navigue_vers_la_page_de_gestion_de_la_cantine(String url) {
	        cantinePage = new CantinePage(driver);
	        cantinePage.navigateToGestionCantine(url);
	}

	@And("je clique sur le bouton {string}")
	public void je_clique_sur_le_bouton(String btn) {
	        cantinePage.clickAddMeal();
	}

	@And("je remplis les champs suivants :")
	public void je_remplis_les_champs_suivants(io.cucumber.datatable.DataTable dataTable) {
		Map<String, String> data = dataTable.asMap(String.class, String.class);
        cantinePage.fillMealForm(
            data.get("Nom du repas"),
            data.get("Description"),
            data.get("Date"),
            data.get("Type de repas"),
            data.get("Prix")
        );
	}
	@And("je clique sur {string}")
    public void clickCreate(String btn) {
        cantinePage.clickCreate();
    }
	
	@Then("le repas est ajouté avec succès et visible dans la liste")
	public void le_repas_est_ajouté_avec_succès_et_visible_dans_la_liste() {
		
	        Assert.assertTrue("Le repas n'a pas été ajouté", cantinePage.isMealAdded());
	        driver.quit();
	    
 }
}