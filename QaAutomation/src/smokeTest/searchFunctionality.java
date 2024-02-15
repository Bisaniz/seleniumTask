package smokeTest;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

//import com.aventstack.extentreports.Status;

import pageObjects.actions;
import pageObjects.assertions;
@Listeners
public class searchFunctionality extends actions{
actions action;
String productName = "bag";
String title = "Search results for: "+"'"+productName+"'";
assertions assertion ; 

@BeforeSuite
public void myBeforeTest()throws InterruptedException {
	action = new actions();
	assertion = new assertions();
	action.visitWebsite();
	action.maximizeBrowser();
	Thread.sleep(2000);
}

	  @Test(description = "search")
      public void searchItems() {
		  extentTest = extentReport.createTest("search functionality");
		    extentTest.log(Status.INFO, "search Test Start");

		  action.typeInSearchField(productName);
     	action.printPageTitle();
     	assertion.checkPageTitleIsContain(title);
      }

@AfterSuite
public void myAfterTest() {
	action.closeBrowser();
}
}