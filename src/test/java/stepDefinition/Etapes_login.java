package stepDefinition;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.LoginPage;

public class Etapes_login {
	
	
		   public WebDriver driver;
		    public LoginPage loginPage;

		    @Before
		    public void setup() {
		        WebDriverManager.chromedriver().setup();
		        driver = new ChromeDriver();
		        driver.manage().window().maximize();
		    }
   
	@Given("j'accède à la page de connexion")
	public void j_accède_à_la_page_de_connexion() {
		loginPage = new LoginPage(driver);
        loginPage.ouvrirPageConnexion();
	}

	@When("je saisis un email valide {string} et un mot de passe valide {string} et je clique sur se connecter")
	public void je_saisis_un_email_valide_un_mot_de_passe_valide_et_je_clique_sur_se_connecter(String email, String mdp) {
		 loginPage.saisirEmail(email);
	        loginPage.saisirMotDePasse(mdp);
	        loginPage.cliquerSeConnecter();
	}

	@Then("je suis connecté avec succès")
	public void je_suis_connecté_avec_succès() {
		WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.not(ExpectedConditions.urlContains("login")));
}
}