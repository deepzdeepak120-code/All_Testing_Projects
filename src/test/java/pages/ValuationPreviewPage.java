package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ValuationPreviewPage {

	WebDriver driver;
	String MTRid= "3561";
	public String CreatedMTR;
	
	
public ValuationPreviewPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}


@FindBy (xpath="//input[@placeholder='Search']")
WebElement mtrSearch;

@FindBy (xpath="//button[text()='In-progress']")
WebElement inProgressButton;

@FindBy (xpath="//button[text()=' Yes']")
WebElement yesButton;



@FindBy (xpath="//a[text()='Edit Preview']")
WebElement editPeview;

   @FindBy (xpath="//input[@placeholder='Select User']")
   WebElement selectUserButton;
   
   @FindBy (xpath="//a[text()='Chandran R']")
   WebElement valuatorName;
   
   @FindBy (xpath="//button[text()=' Submit']")
   WebElement valuatorSubmit;
   
   @FindBy (xpath="//input[@value='Complete Match']")
   WebElement completeMatchRadioButton;
   
   @FindBy (xpath="(//input[@value=\"Complete Match\"])[2]")
   WebElement subDivMatchRadioButton;
   
   @FindBy (xpath="(//td[@class='pb-1 pt-2']//input[@type='checkbox'])")
   List<WebElement> gisAndfmbButton;
   
   @FindBy (xpath="(//div[@class='mb-2']//input[@type='text'])[1]")
   WebElement ownerNameEB;
   
   @FindBy (xpath="(//div[@class='mb-2']//input[@type='text'])[2]")
   WebElement customerNameEB;
   
   @FindBy (xpath="(//div[@class='mb-2']//input[@type='text'])[3]")
   WebElement metreServiceNoEB;
   
   @FindBy (xpath="(//div[@class='mb-2']//input[@type='text'])[4]")
   WebElement billServiceNoEB;
   
   @FindBy (xpath="//td[@class='pb-1 pt-2 small-txt normal']//input[@value='Matching']")
   List<WebElement> matchingEB;   
   
   
    // @FindBy (xpath="(//tr//input[@placeholder='Enter'])[1]")
   //WebElement valuatorValue;
   
   @FindBy (xpath="//button[text()='Expand All']")
   WebElement expandAllButton;
   
    //shedule boundary
 	@FindBy (xpath="//span[text()='Schedule Boundaries']")
 	WebElement sheduleBoundry;
   
   @FindBy (xpath="//input[@name='deedAvailable' and @value='Yes']")
   WebElement deedAvailableRadioButton;
   
   @FindBy (xpath="//input[@name='deedAvailable' and @value='No']")
   WebElement deedNotAvailableRadioButton;
   
   @FindBy (xpath="//input[@name='boundaryPresent' and @value='Yes']")
   WebElement deedBoundaryPresentRadioButton;
   
   @FindBy (xpath="//input[@name='boundaryPresent' and @value='No']")
   WebElement deedBoundaryNotPresentRadioButton;
   
   @FindBy (xpath="//input[@name='vaoCertificate' and @value='Yes']")
   WebElement vaoAvailableRadioButton;
   
   @FindBy (xpath="//input[@name='vaoCertificate' and @value='No']")
   WebElement vaoNotAvailableRadioButton;
 
  
   
   
   
   
   
   
   


@FindBy (xpath="//a[text()='Site Details']")
WebElement siteDetails;
	@FindBy (xpath="//button[@data-bs-target='#Selfie']")
	WebElement selfi;
	
	@FindBy (xpath="//button[@data-bs-target='#BuildingExterior']")
	WebElement buildingExterior;

	@FindBy (xpath="//button[@data-bs-target='#BuildingInterior']")
	WebElement buildingInterior;
	
	@FindBy (xpath="//button[@data-bs-target='#EBBill']")
	WebElement ebBill;
	
	@FindBy (xpath="//button[@data-bs-target='#PropertyTax']")
	WebElement propertyTax;
	
	@FindBy (xpath="//button[@data-bs-target='#EBMeter']")
	WebElement ebMetre;
	
	@FindBy (xpath="//button[@data-bs-target='#DataSheet']")
	WebElement dataSheet;
	
	@FindBy (xpath="//button[@data-bs-target='#GISMap']")
	WebElement gisMap;
	
	@FindBy (xpath="//button[@data-bs-target='#FMBMap']")
	WebElement fmbMap;
	
	@FindBy (xpath="(//input[@id='NumaricTextBox'])[2]")
	WebElement guideLineValue;



//Annexure
	
  //calculations
	 @FindBy (xpath="//div[5]//div[1]//div[2]//input[1]")
	 WebElement  guidelineValue;
  
  //configurational
	@FindBy (xpath="//a[text()='Configurational']")
	WebElement  configurational;
	
  //configurational
	@FindBy (xpath="//a[text()='Building']")
	WebElement  building;
	
	
  //General
	@FindBy (xpath="//a[text()='General']")
	WebElement  general;
	
  //Locality
	@FindBy (xpath="//a[text()='Locality']")
	WebElement  locality;

  //cautional
	@FindBy (xpath="//a[text()='Cautional']")
	WebElement  cautional;
	
	//documents
	@FindBy (xpath="//a[text()='Documents']")
	WebElement  documents;
	
  //unit_Details
	@FindBy (xpath="//a[text()='Unit Details']")
	WebElement  unit_Details;
	
  //Locality
	@FindBy (xpath="//a[text()='NDMA Norms']")
	WebElement  NDMA_Norms;
	
  //dimensions
	@FindBy (xpath="//a[text()='Dimensions']")
	WebElement  dimensions;
	
	 //As per document 
	 @FindBy (xpath="//td[text()='As per Document']/following-sibling::td[1]")
	 WebElement eastDimension;
	 
	 @FindBy (xpath="//td[text()='As per Document']/following-sibling::td[2]")
	 WebElement westDimension;
	
	 @FindBy (xpath="//td[text()='As per Document']/following-sibling::td[3]")
	 WebElement northDimension;
	
	 @FindBy (xpath="//td[text()='As per Document']/following-sibling::td[4]")
	 WebElement southDimension;
	 
	 //As per site
	 @FindBy (xpath="//td[text()='As per Site']/following-sibling::td[1]")
	 WebElement eastDimensionSite;
	 
	 
	 
	 
	 
	
	
  //Valuator value
	@FindBy (xpath="//input[@class='input-anexture text-center']")
	WebElement valuatorValue;
	
//Annexure
	@FindBy (xpath="//button[text()='Publish Report']")
    WebElement publishReportButton;
	
	////body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[4]/div[1]/section[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]
	




public void enterMTR() {
	
	mtrSearch.sendKeys(MTRid);
}

public void  MTRClick() {
	
	String mtrXpath="//span[text()='"+MTRid+"']";
	WebElement mtrid=driver.findElement(By.xpath(mtrXpath));
	mtrid.click();
}

public void  propertyType(String PropertyType) {
	
	String propTypexpath="//option[text()='"+PropertyType+"']";
	WebElement propType=driver.findElement(By.xpath(propTypexpath));
	propType.click();
}






}
