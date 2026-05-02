package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;

public class PreviewPage {
	

	WebDriver driver;
	WebDriverWait wait;
	ConfigReader data;
	
	
	public  PreviewPage(WebDriver driver) {
		
   		this.driver=driver;
   		PageFactory.initElements(driver,this);	
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        data = new ConfigReader("src/test/resources/Propertiesdata/mprdata.properties");

   	}
	
	@FindBy (xpath="//input[@id='collectedDocumentType_0_Pre-Disbursement']")
	WebElement ECDocumentType;
	
	@FindBy (xpath="//input[@id='collectedDocNo_1_Pre-Disbursement']")
	WebElement EBdocNumber;
	
	@FindBy (xpath="//input[@id='collectedDate_1_Pre-Disbursement']")
	WebElement EBdate;
	
	@FindBy (xpath="//input[@id='collectedDocNo_2_Pre-Disbursement']")
	WebElement SROdocNumber;
	
	@FindBy (xpath="//input[@id='collectedDate_2_Pre-Disbursement']")
	WebElement SROdate;
	
	@FindBy (xpath="//input[@id='collectedDocNo_0_Post-Disbursement']")
	WebElement MortgageDocNumber;
	
	@FindBy (xpath="//input[@id='collectedDate_0_Post-Disbursement']")
	WebElement MortgageDate;
	
	@FindBy (xpath="//input[@id='collectedDocumentType_0_Post-Disbursement']")
	WebElement MortgageDocType;
	
	
	
	public void los() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ECDocumentType);
		ECDocumentType.sendKeys(data.getValue("EcDocTypeLOS"));
		EBdocNumber.sendKeys(data.getValue("EBreceiptNumLOS"));
		EBdate.sendKeys(data.getValue("EBReceiptDateLOS"));
		SROdocNumber.sendKeys(data.getValue("SROdocNumberLOS"));
		SROdate.sendKeys(data.getValue("SRODateLOS"));
		MortgageDocNumber.sendKeys(data.getValue("MortgageDocNumberLOS"));
		MortgageDate.sendKeys(data.getValue("MortgageDateLOS"));
		MortgageDocType.sendKeys(data.getValue("MortgageDocCopyLOS"));

	}
	
	
	
	
	

}
