package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;


public class SetUp {

public static WebDriver driver;
	
	//methode before
	@Before
	public void initial() {
		driver=DriverManager.lancer_chrome();
		
	}

	@BeforeStep
	public void afficher_debut_step( ) {
		System.out.println("etape en cours");
	}

	@AfterStep
	public void TakeScreenShot(Scenario scenario) {
		final byte [] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot,"image/png","image");
	}
	
    @After
    public void terminal() {
    	driver.close();
    }
}
