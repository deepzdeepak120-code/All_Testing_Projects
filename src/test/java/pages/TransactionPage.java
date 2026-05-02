package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import utils.ConfigReader;

public class TransactionPage  {
	
	   WebDriver driver;
	   WebDriverWait wait;
	   LoginPage lp;
	   ShedulePage sp;
	   ConfigReader data;
	   
//	   String MarketValue="300000";
//	   String PreviousDocNO="877";
//	   String sroOption="Aandimadam";
//	   String districtName="Ariyalur";
//	   String village="Aiyur village";
//	   String taluk="Ariyalur";
//	   String PropertyNumberType="Survey Number";
//	   String properType="Land";
//	   
	   
	   
	   public  TransactionPage(WebDriver driver) {
			
	   		this.driver=driver;
	   		PageFactory.initElements(driver,this);	
	        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	        data = new ConfigReader("src/test/resources/Propertiesdata/mprdata.properties");

	   	}
	   
	   String ScheduleTxt ="All that piece and parcel of the Land admeasuring 1200 sqft bearing Survey No. 198/1A situated at Village Aiyur village, Taluka Ariyalur, District Ariyalur,within the Sub-Registration limits of Aandimadam and bounded on the\r\n"
	   		+ "North by: Tempe\r\n"
	   		+ "South by: Passage\r\n"
	   		+ "East by: Road\r\n"
	   		+ "West by: Mani's Property";
	   
	   
	   		
	   String AutoDevTet ="On the perusal of the Sale Deed dated 12-Feb-2020, it appears that the said Ram sold, assigned and conveyed all that piece and parcel of the Land bearing Survey No. 198/1A admeasuring about 1200 sqft. situated at Village Aiyur village, Taluka Ariyalur, District Ariyalur to and in favour of Krishnan vide Sale Deed dated 12-Feb-2020 registered at Serial No. 1001 of 2020 before the SRO Aandimadam.";
	   		
	   		
@FindBy(xpath="//button[@id='welcome-popup-close']")
WebElement closeIcon;

@FindBy(xpath="(//button[@class='css-29hbmc'])[1]")
WebElement firstDeed;

@FindBy(xpath="//div[@class='accordion-item open']//input[@id='DOCUMENT_TYPE']")

//div[@class='css-19bb58m']//input[@role='combobox' and @id='react-select-2-input']
WebElement firstDocType;

@FindBy(xpath="//div[@class='accordion-item open']//input[@id='isOwnership']")
WebElement ownerCheckBox;

@FindBy(xpath="//div[@class='accordion-item open']//span[text()='Owner']")
WebElement ownerIcon;

@FindBy(xpath="//div[contains(text(),'All that piece and parcel of')]")
WebElement scheduleTxtElement;

@FindBy(xpath="//div[@class='accordion-item open']//div[contains(text(),' perusal of')]")
WebElement devolutionTxtElement;

@FindBy(xpath="//div[@class='accordion-item open']//div[contains(text(),'Electricity Bill Receipt number ')]")
WebElement ebDevolutionText;





@FindBy(xpath="(//input[@id='DATE_OF_REGISTRATION'])[1]")
WebElement dateOfRegistraton;

@FindBy(xpath="(//input[@id='DOC_NO'])[1]")
WebElement documentNumber;

@FindBy(xpath="//input[@id='SRO_NAME']")
WebElement sroMenu;

@FindBy(xpath="//input[@id='DISTRICT_NAME']")
WebElement districtMenu;

@FindBy(xpath="//input[@id='VILLAGE_NAME']")
WebElement selectVillage;

@FindBy(xpath="//input[@id='TALUK_NAME']")
WebElement selectTaluk;

@FindBy(xpath="//div[@class='accordion-item open']//input[@id='PROPERTY_NUMBER_TYPE']")
WebElement selectPropertyNumberType;

@FindBy(xpath="//div[@class='accordion-item open']//input[@id='PROPERTY_TYPE']")
WebElement selectPropertyType;


@FindBy(id="EXECUTANT_NAME")
WebElement executantName;

@FindBy(id="CLAIMANT_NAME")
WebElement claimantName;

@FindBy(id="PROPERTY_NUMBER")
WebElement propertyNumber;

@FindBy(xpath="(//input[@id='DATE_OF_REGISTRATION'])[2]")
WebElement pattaDateOfRegistration;



@FindBy(xpath="//*[text()='Survey Number']")
WebElement surveyNoPropertyType;


@FindBy(css = "#SRO_NAME [role='combobox']")
WebElement sroCombobox;

// React-Select puts a text input inside the control
@FindBy(css = "#SRO_NAME input[type='text']")
 WebElement sroInput;

@FindBy(id="PROPERTY_SIZE")
WebElement propertySize;

@FindBy(id="PLOT_NO")
WebElement plotNumber;

@FindBy(id="HOUSE_NO")
WebElement houseNumber;

@FindBy(id="MARKET_VALUE")
WebElement marketValue;

@FindBy(id="CONSIDERATION_VALUE")
WebElement considerationValue;

@FindBy(id="PREVIOUS_DOC_NO")
WebElement previousDocNumber;

@FindBy(xpath="//div[@class='col-xl-6 col-lg-6 col-md-6 col-sm-12 col-12 p-0']//div//textarea[@id='NorthBy-0']")
WebElement northSchedule;

@FindBy(xpath="//div[@class='col-xl-6 col-lg-6 col-md-6 col-sm-12 col-12 p-0']//div//textarea[@id='SouthBy-0']")
WebElement southSchedule;

@FindBy(xpath="//div[@class='col-xl-6 col-lg-6 col-md-6 col-sm-12 col-12 p-0']//div//textarea[@id='EastBy-0']")
WebElement eastSchedule;

@FindBy(xpath="//div[@class='col-xl-6 col-lg-6 col-md-6 col-sm-12 col-12 p-0']//div//textarea[@id='WestBy-0']")
WebElement westSchedule;

@FindBy(xpath="//span[text()='Add Schedule']")
WebElement addShedule;

@FindBy(xpath="//span[@data-bs-target='#schedule-delete-model-0-1']")
WebElement deleteShedule;

@FindBy(xpath="//div[@id='schedule-delete-model-0-2']//span[text()='Remove entire card']")
WebElement removeEntireCard;

@FindBy(xpath="//div[@id='schedule-delete-model-0-2']//span[text()='Erase/reset data']")
WebElement eraseCard;

@FindBy(xpath="//button[@id='add-new-document-btn']")
WebElement addButton;

@FindBy(xpath="//div[@class='accordion-item open']//button[contains(text(),'Copy Data')]")
WebElement copyData;

@FindBy (xpath="//div[@class='accordion-item open']//button[text()=' Fill Empty Fields']")
WebElement fillEmptyField;

@FindBy(xpath="//div[@class='accordion-item open']//input[@id='DOCUMENT_TYPE']")
WebElement newECDocType;

@FindBy(id="all-docs-1")
WebElement ebBill;

@FindBy (xpath="//div[@class='accordion-item open']//input[@id='DOCUMENT_TYPE']")
WebElement secondDocType;

@FindBy (id="RECEIPT_NUMBER")
WebElement ebReceiptNumber;

@FindBy (id="RECEIPT_DATE")
WebElement ebReceiptDate;

@FindBy (id="OWNER_NAME")
WebElement ownerName;

@FindBy(id="all-docs-2")
WebElement pattaHeader;

@FindBy(xpath="//div[@class='accordion-item open']//input[@id='DOCUMENT_TYPE']")
WebElement thiredDocType;

@FindBy(id="PATTA_NO")
WebElement pattaNumber;

@FindBy(xpath="//div[@id='all-docs-1']//div[text()='Owner Name Is Required.']")
WebElement ebOwnerName;

@FindBy(xpath="//div[@id='all-docs-2']//input[@id='OWNER_NAME']")
WebElement pattaOwnerName;

@FindBy(id="ISSUING_AUTHORITY_LOCATION")
WebElement issuingAuthoityLocation;

@FindBy(id="ec-file-upload")
WebElement pattaUpload;

@FindBy(xpath="//div[@class='uploaded-files-card']")
WebElement uploadedPatta;

@FindBy(xpath="//div[@class='accordion-item open']//input[@id='DOCUMENT_TYPE']")
WebElement selectDocumentType;

@FindBy(xpath="//span[text()='New Document']")
WebElement newDocument;

@FindBy(xpath="//button//span[text()='Preview']")
WebElement previewButton;

@FindBy(xpath="//h2[@id='heading-3']")
WebElement parentDocHeader;

@FindBy(xpath="//div[@class='accordion-item open']//span[@class='mx-2 mb-1']")
WebElement deleteDocument;

@FindBy(xpath="//div[@id='document-delete-model-3']//span[contains(text(),'Remove entire card')]")
WebElement removeParentDeed;

@FindBy(id="property-tab")
WebElement propertyTab;

@FindBy(id="Survey_Number0")
WebElement propertySurveyNo1;

@FindBy(id="GuideLine_Value0")
WebElement guidelineValueNo1;

@FindBy(xpath="//input[@id='Land_Classification0']")
WebElement landClassificationNo1;

@FindBy(id="litigation-tab")
WebElement litigationTab;

@FindBy(xpath="//span[@class='slider round']")
WebElement litigationToggle;

@FindBy(xpath="//input[@id='Case_Details ']")
WebElement caseDetails;

@FindBy(xpath="//input[@id='Court_Name_&_Address']")
WebElement courtNameAndAddress;

@FindBy(xpath="//input[@id='Petitioner']")
WebElement petitioner;

@FindBy(xpath="//input[@id='Responder']")
WebElement responder;

@FindBy(xpath="//input[@id='Current_Status']")
WebElement currentStatus;

@FindBy(id="chain-input-tab")
WebElement chainInputtab;

@FindBy(xpath="(//button[@class='btn btn-primary'])[1]")
WebElement convertToImg;

@FindBy(xpath="//button[text()=' Add More ']")
WebElement addMoreProperty;

@FindBy(xpath="//button[contains(text(),'Devolution V2')]")
WebElement regenerateDevolutionV2;

@FindBy(id="regenrateECTrans")
WebElement regenerateDevolutionOkButton;

@FindBy(id="yes")
WebElement yesUpdatePreview;

@FindBy(id="cancel")
WebElement noKeepExistingPreview;

@FindBy(xpath="//textarea[@id='remark']")
WebElement remark;

@FindBy(xpath="//div[contains(text(),'(Maatrum)')]")
WebElement savePreview;

@FindBy (xpath="//span[text()=' PDF']")
WebElement pdf;

@FindBy (xpath="//div[@class='accordion-item open']//input[@id='DATE_OF_REGISTRATION']")
WebElement mortgageDate;

@FindBy (xpath="//div[@class='accordion-item open']//input[@id='DOC_NO']")
WebElement mortgageDocNumber;








public void saleDeedDevolutionText() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", devolutionTxtElement);
	
    Reporter.log("Devolution of sale deed "+devolutionTxtElement.getText());
	
}

public void ebReceiptDevolutionText() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ebDevolutionText);
	
    Reporter.log("Devolution of EB receipt "+ebDevolutionText.getText());
	
}

public void pattaDevolutionText() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", devolutionTxtElement);
	
    Reporter.log("Devolution of EB patta "+devolutionTxtElement.getText());
	
}

public void mortgagaeDeedDevolutionText() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", devolutionTxtElement);
	
    Reporter.log("Devolution of Mortgagae Deed "+devolutionTxtElement.getText());
	
}

public void ecOfSaleDeedDevolutionText() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", devolutionTxtElement);
	
    Reporter.log("Devolution of EC of Sale Deed "+devolutionTxtElement.getText());
	
}

public void regenerteV2Devolution() throws InterruptedException {
	wait.until(ExpectedConditions.visibilityOf(regenerateDevolutionV2));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", regenerateDevolutionV2);
	regenerateDevolutionV2.click();
	wait.until(ExpectedConditions.visibilityOf(regenerateDevolutionOkButton));
	regenerateDevolutionOkButton.click();	
	Thread.sleep(3000);
}

public void remark() {
	wait.until(ExpectedConditions.visibilityOf(remark));
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", remark);
	remark.sendKeys("Completed");
	//savePreview.click();
	pdf.click();
}










public void addButton() throws InterruptedException {
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Thread.sleep(2000);
	js.executeScript("arguments[0].scrollIntoView(true);", addButton);
	wait.until(ExpectedConditions.visibilityOf(addButton)).click();
}

public void newDocument() throws InterruptedException {
	Thread.sleep(2000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", newDocument);
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(newDocument)).click();
	Thread.sleep(2000);

}

public void selectDocumentType() throws InterruptedException {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", selectDocumentType);
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(selectDocumentType));
	selectDocumentType.sendKeys("Ec of sale Deed");
	driver.switchTo().activeElement().sendKeys(Keys.ENTER);
}

public void selectDocumentTypeMortgage() throws InterruptedException {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", selectDocumentType);
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(selectDocumentType)).sendKeys("Mortgage Deed");
	driver.switchTo().activeElement().sendKeys(Keys.ENTER);
}

public void mortgageDeedData() {
	wait.until(ExpectedConditions.visibilityOf(mortgageDate)).sendKeys(data.getValue("MortgageDate"));
}

public void mortgageDocNumber() {
	wait.until(ExpectedConditions.visibilityOf(mortgageDocNumber)).sendKeys(data.getValue("MortgageDocNumber"));
}

public void copydataFromDeed() {
	
	String copyDataFromSaleDeed_xpath="//div[@class='accordion-item open']//button[contains(text(),'Sale Deed / "+data.getValue("DocNumber")+"')]";
	driver.findElement(By.xpath(copyDataFromSaleDeed_xpath)).click();	
}

public void copydataForPatta() {
	
	String copyDataFromSaleDeed_xpath="(//button[contains(text(),'Sale Deed / "+data.getValue("DocNumber")+"')])[2]";
	driver.findElement(By.xpath(copyDataFromSaleDeed_xpath)).click();	
}

public void previewButton() throws InterruptedException {
	Thread.sleep(2000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", previewButton);
	wait.until(ExpectedConditions.visibilityOf(previewButton)).click();
}






public void salesDeedDevolution() throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	Thread.sleep(5000);
	wait.until(ExpectedConditions.visibilityOf(firstDeed)).click();
	wait.until(ExpectedConditions.visibilityOf(firstDocType)).sendKeys(data.getValue("DocumentType"));
	driver.switchTo().activeElement().sendKeys(Keys.ENTER);
	wait.until(ExpectedConditions.visibilityOf(ownerCheckBox)).click();
	String  OwnerIcon=ownerIcon.getText();
	System.out.println(OwnerIcon);
	
	js.executeScript("arguments[0].scrollIntoView(true);", dateOfRegistraton);
	wait.until(ExpectedConditions.visibilityOf(dateOfRegistraton)).sendKeys(data.getValue("RegistrationDate"));
	
	Thread.sleep(2000);
	wait.until(ExpectedConditions.visibilityOf(documentNumber));
	lp= new LoginPage(driver);
	documentNumber.sendKeys(data.getValue("DocNumber"));

}



public void dropDown() throws InterruptedException {
	sp= new ShedulePage(driver);
	
	
	    wait.until(ExpectedConditions.visibilityOf(sroMenu)).click();
		sroMenu.sendKeys(data.getValue("sroOption"));
		Thread.sleep(2000);
		//driver.switchTo().activeElement().sendKeys(Keys.ENTER);
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();
		wait.until(ExpectedConditions.visibilityOf(districtMenu)).click();
		districtMenu.sendKeys(data.getValue("districtName"));
		Thread.sleep(2000);
		actions.sendKeys(Keys.ENTER).perform();
		wait.until(ExpectedConditions.visibilityOf(selectVillage)).click();
		selectVillage.sendKeys(data.getValue("village"));
		Thread.sleep(2000);
		actions.sendKeys(Keys.ENTER).perform();
		wait.until(ExpectedConditions.visibilityOf(selectTaluk)).click();
		selectTaluk.sendKeys(data.getValue("taluk"));
		Thread.sleep(2000);
		actions.sendKeys(Keys.ENTER).perform();
		lp= new LoginPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", executantName);
		executantName.sendKeys(data.getValue("OwnerName"));
		claimantName.sendKeys(data.getValue("ApplicantName"));
		wait.until(ExpectedConditions.visibilityOf(selectPropertyNumberType)).click();
		selectPropertyNumberType.sendKeys(data.getValue("PropertyNumberType"));
		Thread.sleep(2000);
		actions.sendKeys(Keys.ENTER).perform();
		propertyNumber.sendKeys(data.getValue("SurveyNo"));
		wait.until(ExpectedConditions.visibilityOf(selectPropertyType)).click();
		selectPropertyType.sendKeys(data.getValue("PropertyType"));
		Thread.sleep(2000);
		actions.sendKeys(Keys.ENTER).perform();
		propertySize.sendKeys(data.getValue("sqft"));
		plotNumber.sendKeys(data.getValue("PlotNo"));
		houseNumber.sendKeys(data.getValue("HouseNo"));
		marketValue.sendKeys(data.getValue("MarketValue"));	
		considerationValue.sendKeys(data.getValue("ConsideredValue"));
		
		previousDocNumber.sendKeys(data.getValue("PreviousDocNo"));
		northSchedule.sendKeys(data.getValue("North"));
		southSchedule.sendKeys(data.getValue("South"));
		eastSchedule.sendKeys(data.getValue("East"));
		westSchedule.sendKeys(data.getValue("West"));
		
		//js.executeScript("arguments[0].scrollIntoView(true);", scheduleTxtElement);
		//String ScheduleText=scheduleTxtElement.getText();
		//String DevolutionText=devolutionTxtElement.getText();
		//System.out.println(ScheduleText);
		//System.out.println(DevolutionText);	
 }

public void addECofSaleDeedDocument() throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", addButton);
	wait.until(ExpectedConditions.visibilityOf(addButton)).click();
	wait.until(ExpectedConditions.visibilityOf(newDocument)).click();
	Thread.sleep(2000);
	//wait.until(ExpectedConditions.visibilityOf(newDocument)).click();
	wait.until(ExpectedConditions.visibilityOf(newECDocType)).sendKeys("Ec of Sale deed");
	driver.switchTo().activeElement().sendKeys(Keys.ENTER);
	Thread.sleep(2000);
	copyData.click();
	fillEmptyField.click();
		
}

public void ebReceiptDoc() {
	
	wait.until(ExpectedConditions.visibilityOf(ebBill)).click();
	wait.until(ExpectedConditions.visibilityOf(secondDocType)).sendKeys("Electricity Bill");
	driver.switchTo().activeElement().sendKeys(Keys.ENTER);
	wait.until(ExpectedConditions.visibilityOf(ebReceiptNumber)).sendKeys(data.getValue("EBreceiptNumber"));
	wait.until(ExpectedConditions.visibilityOf(ebReceiptDate)).sendKeys(data.getValue("EBreceiptDate"));
	
}
public void close() {	
	closeIcon.click();	
}

public void copyData() {
wait.until(ExpectedConditions.visibilityOf(copyData)).click();
}

public void fillEmptyFields() {
wait.until(ExpectedConditions.visibilityOf(fillEmptyField)).click();
}

public void pattaHeaderClick() {
wait.until(ExpectedConditions.visibilityOf(pattaHeader)).click();
}

public void thiredDocType() {
wait.until(ExpectedConditions.visibilityOf(thiredDocType)).sendKeys("Patta");
driver.switchTo().activeElement().sendKeys(Keys.ENTER);
}

public void pattaNumberEnter() {
wait.until(ExpectedConditions.visibilityOf(pattaNumber)).sendKeys("1046");
driver.switchTo().activeElement().sendKeys(Keys.ENTER);
}

public void pattaOwnerName() {
wait.until(ExpectedConditions.visibilityOf(pattaOwnerName)).sendKeys(data.getValue("OwnerName"));
}

public void pattaRegistrationDate() {
wait.until(ExpectedConditions.visibilityOf(pattaDateOfRegistration)).sendKeys(data.getValue("RegistrationDate"));
}

public void issuingAuthoityLocation() {
wait.until(ExpectedConditions.visibilityOf(issuingAuthoityLocation)).sendKeys(data.getValue("LocationOfIssuingAuthoity"));
}

public void pattaUpload() throws InterruptedException {
	lp = new LoginPage(driver);
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", pattaUpload);
	Thread.sleep(2000);
	pattaUpload.sendKeys(lp.PattaUploadDoc);
	Thread.sleep(2000);
	Assert.assertTrue(uploadedPatta.isDisplayed(), "Element is NOT present on the page!");
	Thread.sleep(3000);
}

public void parentDeedHeader() throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", pattaUpload);
	Thread.sleep(2000);
}

public void deleteDocument() {
	
	wait.until(ExpectedConditions.visibilityOf(deleteDocument)).click();	
	wait.until(ExpectedConditions.visibilityOf(removeParentDeed)).click();	
	
}

public void parentDocClick() throws InterruptedException {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", parentDocHeader);
	Thread.sleep(2000);
	parentDocHeader.click();
	
}

public void propertiesTab() {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", propertyTab);
	propertyTab.click();
	addMoreProperty.click();
	propertySurveyNo1.sendKeys("122");
	guidelineValueNo1.sendKeys("300000");
	landClassificationNo1.sendKeys("Residential");
	driver.switchTo().activeElement().sendKeys(Keys.ENTER);	
}

public void litiationTab() {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", litigationTab);
	litigationTab.click();
	wait.until(ExpectedConditions.visibilityOf(litigationToggle));
	litigationToggle.click();
	caseDetails.sendKeys("Land problem");
	courtNameAndAddress.sendKeys("High court chennai");
	petitioner.sendKeys("Kumar");
	responder.sendKeys(data.getValue("OwnerName"));
	currentStatus.sendKeys("Pending");
	//driver.switchTo().activeElement().sendKeys(Keys.ENTER);	
}

public void ownerCheckBoxClick() {
	
	wait.until(ExpectedConditions.visibilityOf(ownerCheckBox)).click();
	String  OwnerIcon=ownerIcon.getText();
	System.out.println(OwnerIcon);
}

public void chainInputTab() {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", chainInputtab);
	wait.until(ExpectedConditions.visibilityOf(chainInputtab));
	chainInputtab.click();
	//wait.until(ExpectedConditions.visibilityOf(convertToImg));
	//convertToImg.click();
	
	//driver.switchTo().activeElement().sendKeys(Keys.ENTER);	
}

}
