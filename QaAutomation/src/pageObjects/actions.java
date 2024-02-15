package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;

import support.constants;
import support.extentReportsClass;

public class actions extends extentReportsClass implements constants{
	public static int productQty = 0; 
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	public void visitWebsite() {
		driver.get("https://magento.softwaretestingboard.com");
	}
	
	public void clickOnSignInButton() {
		driver.findElement(By.linkText("Sign In")).click();
	}
	
	public void typeInEmailField() {
	driver.findElement(By.name("login[username]")).sendKeys(email);
		
	}
	
	public void typeInPasswordField() {
		driver.findElement(By.name("login[password]")).sendKeys(password);
	}
	
	public void clickOnSignButton() {
		driver.findElement(By.id("send2")).click();
	}
	
	public void closeBrowser() {
		driver.close();
	}
	
	public void typeInSearchField(String prodcut) {
		driver.findElement(By.id("search")).sendKeys(prodcut+Keys.ENTER);
	}
	
	public void printPageTitle() {
		WebElement element  = driver.findElement(By.className("page-title"));
     	System.out.println(element.getText());
	}
	
	public void clickOnCategory(String categoryName) {
		driver.findElement(By.linkText(categoryName)).click();
	}
	
	public void clickOnProductLink(String productName) {
		driver.findElement(By.linkText(productName)).click();
	}
	
	public void selectProductByItsIndex(int index){
        WebElement dropdownElement = driver.findElement(By.id("sorter"));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByIndex(index);
	}
	
	public void clickOnAddToCartButton() {
		driver.findElement(By.className("tocart")).click();
	}
	
	public void chooseItem(String product) {
		driver.findElement(By.linkText(product)).click();
	}
	
	public void chooseListMode() {
		driver.findElement(By.id("mode-list")).click();
	}
	
	public void addWatchToCompareList() {
	List<WebElement> watches = driver.findElements(By.cssSelector(".product.product-item"));
     	 
		for(int i =0 ; i<watches.size();i++) {
     		try {
    	    		 	
     	        WebElement watchPrice = watches.get(i).findElement(By.cssSelector(".price-box .price"));
     	        String watchPriceText = watchPrice.getText().substring(1, 3);
     	        int watchPriceInteger = Integer.parseInt(watchPriceText);
     	        if (watchPriceInteger > 50) {
     	            watches.get(i).findElement(By.className("tocompare")).click();
     	            productQty++;
     	        }
     	        // i =1 

     	    } catch (StaleElementReferenceException e) {
     	        // Re-locate the watches list as it might have become stale
     	        watches = driver.findElements(By.cssSelector(".product.product-item"));
   	            i--; // Re-try the current iteration
   	            
   	            //i=0 
     	    }
     		
     		// i =2 
     		
     		//i = 1 
     		
      	}
	}
	
}

