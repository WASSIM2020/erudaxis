package stepDefinition;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.LoginPage;
import pageObject.PageCollaborateur;

public class Etapes_ajout_collaborateur {

	 WebDriver driver;
     PageCollaborateur pageCollaborateur;

     @Before
     public void setUp() {
         WebDriverManager.chromedriver().setup();
         ChromeOptions options = new ChromeOptions();
         options.addArguments("--start-maximized");
         // options.addArguments("--headless"); // Décommenter pour Jenkins
         driver = new ChromeDriver(options);
         
         
         pageCollaborateur = new PageCollaborateur(driver);
     }
         
     @Given("je suis authentifié")
	public void je_suis_authentifié() {
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.ouvrirPageConnexion();
	    loginPage.saisirEmail("ghanmi.wassim58@gmail.com");
	    loginPage.saisirMotDePasse("Wassim@123!");
	    loginPage.cliquerSeConnecter();
	   
	    // Attendre que la page dashboard ou collaboration soit chargée
	    }
		

	@When("je clique sur Administration puis Utilisateurs puis Collaboration puis sur l'icône Ajouter collaborateur")
	public void je_clique_sur_administration_puis_utilisateurs_puis_collaboration_puis_sur_l_icône_ajouter_collaborateur() {
	    
		pageCollaborateur.naviguerVersCollaboration(); // si pas déjà sur la page
		pageCollaborateur.cliquerSurAjouterCollaborateur();
	}

	@Then("la page ajouter un collaborateur s'affiche")
	public void la_page_ajouter_un_collaborateur_s_affiche() {
	 
		assertTrue("La page d'ajout n'est pas affichée", pageCollaborateur.titrePageAjoutAffiché());
}
}