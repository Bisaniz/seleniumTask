package smokeTest;
import java.time.Duration;
//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import pageObjects.actions;
import pageObjects.assertions;
@Listeners
public class loginPage extends actions{
	actions action ; 
	assertions assertion;
	String currentUrl ="https://magento.softwaretestingboard.com/";
	String message = "Welcome, cypress user!";

	@BeforeSuite
	public void myBeforeTest() {
		action = new actions();
		assertion = new assertions();
		action.maximizeBrowser();
		// static wait 
		// Thread.sleep(2000); 

		
		// dynamic wait // explicit wait 
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//		
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.className("")));
// 		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className(""))));
//		
		// dynamic wait // implicit wait 
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test(description = "Login functionality")
	public void login() throws InterruptedException {
		extentTest = extentReport.createTest("Login Functionality","to check login functionality");
	    extentTest.log(Status.INFO, "login Test Start");
	    action.visitWebsite();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));	
		wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Sign In")));
		
		action.clickOnSignInButton();
		action.typeInEmailField();
		action.typeInPasswordField();
		action.clickOnSignButton();
		assertion.checkCurrentURLIsContain(currentUrl);
		Thread.sleep(3000);
		assertion.checkHeaderIsContain(message);
	}

	@AfterSuite
	public void myAfterTest() {
		action.closeBrowser();
	}
}