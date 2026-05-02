package testCases;


	
	import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pages.FormPage;
import pages.LoginPage;

	public class SingleForm extends BaseTest {
		
		
		LoginPage lp;
		 FormPage formPage;

	   @Test()
	
	   public void testSubmitAction() throws InterruptedException {
	   	try {		
	       driver.get("https://legal.maatrum.com/app/mvr/preview?id=6656");
	       formPage = new FormPage(driver);
	       Thread.sleep(2000);
	       formPage.publishFinalReport();
	       Thread.sleep(2000);
	       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	       WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-success")));
	       //System.out.println(message.getText()+"for ID: 330");
	       Reporter.log(message.getText()+"for ID: 11355");


	   }
	   	
	    catch (Exception ex){
	    	System.out.println("fail");
	    }
	   
	   }
	   


	}


