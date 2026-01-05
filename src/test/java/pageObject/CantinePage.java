package pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CantinePage {

         WebDriver driver;
         WebDriverWait wait;

    // Sélecteurs (à adapter après inspection réelle de la page staging)
     By ajouter_repas =By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium css-5xrksu']");
     By titre_ajouter_repas = By.xpath("//h5[@class='MuiTypography-root MuiTypography-h5 css-1a1n8nd']"); // Vérifie que la modale s'ouvre
     By nom_du_repas = By.xpath("//input[@placeholder='Ex: Pizza Margherita']"); 
     By description = By.xpath("//textarea[@placeholder='Ex: Délicieuse pizza avec fromage et tomates']");
     By date = By.xpath("//input[@value='2025-12-22']"); // Ou type="date"
     By prix = By.xpath("//input[@placeholder='0.00']");
     By catégorie = By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButton-fullWidth MuiButton-root MuiButton-outlined MuiButton-outlinedPrimary MuiButton-sizeMedium MuiButton-outlinedSizeMedium MuiButton-fullWidth css-mxezaa']");
     By btn_cree_le_repas = By.xpath("//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium css-1ljwhj3']");
     By successMessage = By.xpath("//div[@class='swal2-popup swal2-modal swal2-icon-success swal2-show']"); // Message toast
     By mealListItem = By.xpath("//h6[@class='MuiTypography-root MuiTypography-subtitle1 MuiTypography-noWrap css-5dt4kg']"); // Dernier repas ajouté

    public CantinePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigateToGestionCantine(String url) {
        driver.get(url);
        
    }
    
    public void fillMealForm(String name, String descriptionn, String datee, String prix, String catégorie) {
        driver.findElement(nom_du_repas).sendKeys(name);
        driver.findElement(description).sendKeys(descriptionn);
        driver.findElement(date).sendKeys(datee);
    }
    public void clickAddMeal() {
        wait.until(ExpectedConditions.elementToBeClickable(ajouter_repas)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(titre_ajouter_repas));
    }

   
        
        
        
        
   

    public void clickCreate() {
        wait.until(ExpectedConditions.elementToBeClickable(btn_cree_le_repas)).click();
    }

    public boolean isMealAdded() {
        // Vérifie soit un message de succès, soit le repas dans la liste
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
            return true;
        } catch (Exception e) {
            String lastMeal = wait.until(ExpectedConditions.visibilityOfElementLocated(mealListItem)).getText();
            return lastMeal.contains("Repas du jour test auto"); // Vérifie le nom du repas ajouté
        }
    }
}
