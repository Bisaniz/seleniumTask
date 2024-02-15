package smokeTest;

import org.testng.annotations.AfterSuite;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.actions;
import pageObjects.assertions;
@Listeners
public class filterProductFunctionality extends actions{
	assertions assertion;
	actions action ; 
	String productName = "Jackets";
	String option = "Product Name";

	@BeforeSuite
	public void myBeforeTest()  throws InterruptedException{
		action = new actions();
		assertion = new assertions();
		action.visitWebsite();
		action.maximizeBrowser();
		Thread.sleep(1500);
	}
	
	 @Test(description = "filte functionality")
     public void filterProduct() {
		 extentTest = extentReport.createTest("filte functionality");
		 action.clickOnCategory("What's New");
    	 action.clickOnProductLink(productName);
    	action.selectProductByItsIndex(1);
    	assertion.checkSelectIsContain(option);
    	assertion.checkOutputOfFilterIsSortedByAscendingOrder();
//    	 dropdown.selectByVisibleText("Price");
//    	 dropdown.selectByIndex(1);
    	 
    	}

@AfterSuite
public void myAfterTest() {
	action.closeBrowser();
}
}
