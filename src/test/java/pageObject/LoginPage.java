package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	public WebDriver driver;
	public WebDriverWait wait;

	@FindBy(xpath = "//input[@placeholder='Enter your email address']")      
    WebElement entree_email;

    @FindBy(xpath = "//input[@placeholder='.................']")  
    WebElement entree_mdp;

    @FindBy(xpath = "//div[@class='MuiBox-root css-1xu9e0d']")  
     WebElement btn_seconnecter;

    
    @FindBy(xpath = "//div[@class='MuiBox-root css-dplg0k']//div[1]//div[1]//div[1]//div[1]//div[1]//div[3]")  
    WebElement selectionner_departement;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void ouvrirPageConnexion() {
        driver.get("https://staging.erudaxis.com/");
    }

    public void saisirEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(entree_email));
        entree_email.clear();
        entree_email.sendKeys(email);
    }

    public void saisirMotDePasse(String password) {
       entree_mdp.clear();
        entree_mdp.sendKeys(password);
    }

    public void cliquerSeConnecter() {
        btn_seconnecter.click();
    }

    public boolean estConnecte() {
        try {
            wait.until(ExpectedConditions.visibilityOf(selectionner_departement));
            return selectionner_departement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
