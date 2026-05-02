package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class FormPage {
	
	WebDriver driver;
	
	public FormPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}
	
	@FindBy(xpath="//button[contains(text(),' Publish final report ')]")
	WebElement finalReportButton;




	public void publishFinalReport() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", finalReportButton);
		//Assert.assertTrue(finalReportButton.isDisplayed(), "Add shedule is not displayed.");		
		Thread.sleep(5000);
		finalReportButton.click();
	}



}
