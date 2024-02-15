package smokeTest;

import java.util.List;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageObjects.actions;
@Listeners
public class homePage extends actions{
	WebDriver driver = new ChromeDriver();
	String email = "CypressUser@gmail.com";
	String password = "test@123";
         @BeforeSuite
         public void myBeforeTest() {
        	 driver.manage().window().maximize();
        	 driver.get("https://magento.softwaretestingboard.com");
        	 
         }
         @Test(description = "test1", priority = 0, enabled = true)
         public void myTest() {
        	  extentTest = extentReport.createTest("test1");
        	 System.out.println("hello");
         }
         
         
         @Test(description = "printCategoryName", priority = 2, enabled = true)
         public void myTest3() {
        	 driver.findElements(By.cssSelector(".category-item.level0"));
        	List<WebElement> elements = driver.findElements(By.cssSelector(".category-item.level0"));
        	for (int i=0;i< elements.size(); i++) {
        		System.out.println(elements.get(i).getText());
        	}
         }
         
         
         
         @AfterSuite
         public void myAfterTest() {
//        	 driver.close();
         }
}
