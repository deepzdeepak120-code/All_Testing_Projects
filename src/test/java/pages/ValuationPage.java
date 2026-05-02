package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class ValuationPage  {
		WebDriver driver;
		public String MTRid;
		public String CreatedMTR;
	public ValuationPage(WebDriver driver) {
			
			this.driver=driver;
			PageFactory.initElements(driver,this);	
		}
	
	@FindBy (xpath="//span[@class='link badge-dotNo']")
	WebElement mtrID;
	
	@FindBy (xpath="//input[@placeholder='Search']")
	WebElement searchBoxMTR;
	
	@FindBy (xpath="//i[@class='ri-time-line false leading-5']")
	WebElement sheduleIcon;
	
	@FindBy (xpath="//div[@class='css-1xc3v61-indicatorContainer']")
	WebElement selectResponseButton;
	
	@FindBy (xpath="//input[@id='callRecipient']")
	WebElement callRecipientColumn;
	
	
	@FindBy (xpath="//button[text()='Submit']")
	WebElement submitButton;
	
	@FindBy (xpath="//span[text()='Yes']")
	WebElement clickYes;
	
	@FindBy (xpath="//button[@type='submit']")
	WebElement submitShedule;
	
	@FindBy (xpath="//span[text()='Assign']")
	WebElement assignButton;
	
	@FindBy (id="Dropdown5")
	WebElement inspectorSearch;
	
	@FindBy (xpath="//p[text()='7010407616']")
	WebElement inspector;
	
	@FindBy (xpath="//span[text()='Assign Task']")
	WebElement assignTaskButton;
	
	@FindBy (xpath="//div[text()='Answered']")
	WebElement answered;
	
	@FindBy (xpath="//label[text()='Date and Time of call *']")
	WebElement date;
	

	@FindBy (xpath="//span[text()='Assign']")
	WebElement assign;
	
	@FindBy (xpath="//i[@class='ri-arrow-down-s-line mt-[2px] leading-5']")
	WebElement inspectrFilter;
	
	@FindBy (xpath="//div[text()='Inspector']")
	WebElement phoneNoFilter;
	
	@FindBy (id="Dropdown5")
	WebElement phoneNoSearch;
	
	@FindBy (xpath="//div[text()='Inspector']")
	WebElement phoneNoClick;
	
	@FindBy (xpath="//span[text()='Assign Task']")
	WebElement assignTask;
	
	@FindBy (xpath="//input[@placeholder='Search']")
	WebElement controlTowerSearchBox;
	
	@FindBy (xpath="//p[text()='7010407616']")
	WebElement dineshInspector;

	
	
	public void assignInspector() throws InterruptedException {
		controlTowerSearchBox.clear();
		controlTowerSearchBox.sendKeys(MTRid);
		Thread.sleep(2000);
		assign.click();
		Thread.sleep(2000);
		//inspectrFilter.click();
		//Thread.sleep(2000);
		//phoneNoFilter.click();
		//phoneNoSearch.sendKeys("7010407616");
		//Thread.sleep(2000);
		//phoneNoClick.click();
		dineshInspector.click();
		Thread.sleep(1000);
		assignTask.click();
	}
	
	
	
	
	
	
	public void clickYesToggle() {
		clickYes.click();
	}
	
	public String saveMTRid() {
		MTRid= mtrID.getText();
		System.out.println(mtrID);
		return MTRid;

	}
	
	public void clickSheduleIcon() {
		sheduleIcon.click();
	}
	
	public void clickSubmitButton() {
		submitButton.click();
	}
	
	public void sheduleCallDetails() throws InterruptedException {
		
		String dateTime= date.getText();
		System.out.println(dateTime);
		Thread.sleep(2000);
		selectResponseButton.click();
		Thread.sleep(2000);	
		answered.click();
		Thread.sleep(2000);	
		callRecipientColumn.sendKeys("Kumar");
		clickYes.click();
		submitButton.click();
		
	}
	
	
	
	public void searchMPR(String mprText) {
		searchBoxMTR.sendKeys(mprText);
	}
		
	public void searchMTR(String mtrID) {
		searchBoxMTR.sendKeys(mtrID);
	}
	public void clickElementByCapturedId(String mprText) {
		String dynamicXPath1="//span[contains(text(),'" +mprText+ "')]";
		  WebElement element = driver.findElement(By.xpath(dynamicXPath1));
	        element.click();	        
	}
		
	public void clickElementByCapturedMTRId(String mtrID) {
		String dynamicXPath2="//span[text()='" + mtrID + "']";
		  WebElement element = driver.findElement(By.xpath(dynamicXPath2));
	        element.click();	        
	}
	
}
