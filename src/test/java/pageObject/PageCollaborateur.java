package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageCollaborateur {

	public WebDriver driver;
    public WebDriverWait wait;

    // Locators
     By Menu_administration = By.xpath("//body[1]/div[1]/div[1]/div[1]/ul[1]/a[2]/li[1]/div[1]");
     By SousMenu_utilisateurs = By.xpath("//body[1]/div[1]/div[1]/div[1]/ul[1]/a[2]/div[1]/div[1]/div[1]/ul[2]/li[1]");
     By SousMenu_collaboration = By.xpath("//a[@href='/administration/collaborator']//li[@class='MuiListItem-root MuiListItem-padding css-jejtns']");
     By boutonAjouterCollaborateur = By.xpath("//span[@class='material-icons-round notranslate MuiIcon-root MuiIcon-fontSizeDefault css-pz79tj']");
     By titrePageAjout = By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 css-1nabw55']");
  
   
	public PageCollaborateur(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    public void naviguerVersCollaboration() {
        wait.until(ExpectedConditions.elementToBeClickable(Menu_administration)).click();
        wait.until(ExpectedConditions.elementToBeClickable(SousMenu_utilisateurs)).click();
        wait.until(ExpectedConditions.elementToBeClickable(SousMenu_collaboration)).click();
    }

    public void cliquerSurAjouterCollaborateur() {
        wait.until(ExpectedConditions.elementToBeClickable(boutonAjouterCollaborateur)).click();
    }
    
    public boolean titrePageAjoutAffiché() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titrePageAjout)).isDisplayed();
 
    }
}  
    	
    

