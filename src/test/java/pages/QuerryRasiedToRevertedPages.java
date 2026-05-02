package pages;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;

public class QuerryRasiedToRevertedPages {
	
	
	WebDriver driver;
	WebDriverWait wait;
	ConfigReader data;
	public String mprText;
	
public  QuerryRasiedToRevertedPages(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);	
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        
        data = new ConfigReader("src/test/resources/Propertiesdata/mprdata.properties");

	}



File f1= new File("src/test/resources/AlumeluDocs_Pledging_APcase.pdf");
String PledgingDoc = f1.getAbsolutePath();

File f2= new File("src/test/resources/AlumeluPatta.pdf");
String Patta= f2.getAbsolutePath();

File f3= new File("src/test/resources/AP_Parent_Doc.pdf");
String ParentDoc  = f3.getAbsolutePath();

File f4= new File("src/test/resources/AlumeluEBtax.pdf");
String EBtax = f4.getAbsolutePath();

File f5= new File("src/test/resources/ravipatta.png");
String PattaUploadDoc= f5.getAbsolutePath();
	
	
	
	
	@FindBy (xpath="//button[contains(text(),'Add New')]")
	WebElement addNewbtn;
	
	@FindBy (xpath="//h6[contains(text(),'Maatrum')]")
	WebElement maatrumLogo;
	
	@FindBy (xpath="//h6[contains(text(),'Tamil Nadu')]")
	WebElement tamilnaduLogo;
	

	@FindBy (xpath="//h6[contains(text(),'Maatrum Property Report - 3')]")
	WebElement mtrReport3;
	
	@FindBy (xpath="//input[@placeholder='Search Application Number']")
	WebElement applicationNumber;
	
	@FindBy (id="ownerName")
	WebElement propertyOwnerName;
	
	@FindBy (id="applicantName")
	WebElement applicantName;
	
	@FindBy (xpath="//span[text()='Select Branch']")
	WebElement branch;
	
	@FindBy (xpath="//li//label[text()='Chennai']")
	WebElement chennaiBranch;
	
	@FindBy (id="docNumber")
	WebElement documentNumber; //docYear
	
	@FindBy (id="docYear")
	WebElement documentYear; //docYear
	
	@FindBy (xpath="//span[text()='Select SRO']")
	WebElement selectSRO;
	
	@FindBy (xpath="//label[text()='Ariyalur - Aandimadam']")
	WebElement sroName;
	
	
	@FindBy (xpath="//span[text()='Select Village']")
	WebElement village;
	
	@FindBy (xpath="//label[text()='Aiyur']")
	WebElement selectAiyurVillage; //ecStreetName
	
	@FindBy (id="ecStreetName")
	WebElement streetName;
	
	@FindBy (id="address")
	WebElement address;
	
	@FindBy (xpath="//input[@id='vPhonenumber']")
	WebElement phoneNumber;
	
	@FindBy (xpath="//span[contains(text(),'Select Case Type')]")
	WebElement caseType; // //label[contains(text(),'LAP')]
	
	@FindBy (xpath="//label[contains(text(),'LAP')]")
	WebElement lap;
	
	@FindBy (xpath="//textarea[@id='vAddress']")
	WebElement postalAddress;
	
	@FindBy (xpath="//input[@id='fileUpload']")
	WebElement documents;
	
	@FindBy (xpath="//button[contains(text(),' Submit & Create New')]")
	WebElement submitButton;
	
	
	@FindBy(id="continueRequest")
	WebElement continueButton;
	
	@FindBy (xpath="//a[contains(text(),'Dashboard')]")
	WebElement dashboard;
	
	@FindBy (xpath="//input[@type='search']")
	WebElement searchBox;
	
	@FindBy (xpath="(//td/a)[1]")
	WebElement mprNumber;
	
	
	@FindBy (xpath="(//button[contains(text(), In-Progress )])[10]")
	WebElement InprogressButton;
	
	
	@FindBy(xpath="//label[@for='inprogressCheckbox']")
	WebElement PleaseConfirmCheckBox;
	
	
	@FindBy(xpath="//button[@id='inprogress']")
	WebElement OkayButton;
	
	
	
	
	@FindBy(xpath="//button[contains(text(),' Mark as query ')]")
	WebElement MarkAsQuerry;
	
	
	@FindBy(xpath="//span[contains(text(),'Select Query Type')]")
	WebElement DropdownForQuerryType;
	
	@FindBy(xpath="//label[contains(text(),'Applicant Name Mismatch')]")
	WebElement DropDownValueSelection;
	
	
	
	@FindBy(xpath="//button[@role='button'and@type='button'][contains(. ,Submit)][2]")
	WebElement SubmitButtonForQuerry;
	
	
	 // Locators using @FindBy annotation
    @FindBy(xpath = "//button[contains(., 'Maatrum Vetting Report')]")
    private WebElement dropDown;

    @FindBy(xpath = "//button[contains(., 'Maatrum Property Report')]")
    private WebElement clickDropDownValue;
    
    @FindBy(xpath = "//input[@placeholder='Search by MPR ID, Loan Account no., or Appl. name...']")
    private WebElement SearchInAdminDev;
    
    @FindBy(xpath="//button[span[text()='View']]")
    WebElement ViewButtonInAdminDev; 
    
//    @FindBy(xpath="//input[starts-with(@id,form)and@type='file']")  
//    WebElement FileUploadInAdmindev;
    
    
    
    @FindBy(xpath="//input[@id='message']") 
    WebElement SendMessageWithFile;
    
    @FindBy(xpath="//input[@id='message']/following::button")
    WebElement SendButtonAdmindev;
 
    
    @FindBy(xpath="//button[contains(normalize-space(.),'Mark as resolved')]")
    WebElement Querryreverted;
    
    @FindBy(id="resolved")
    
    WebElement QuerryrevertedPopup;
  

	
	public void clickAddNew() {
		wait.until(ExpectedConditions.visibilityOf(addNewbtn)).click();
	
	}
	
	public void clickMaatrumLogo() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    
	    
	    wait.until(ExpectedConditions.visibilityOf(maatrumLogo)); // ensures it's in DOM
	    js.executeScript("arguments[0].scrollIntoView(true);", maatrumLogo);
	    js.executeScript("arguments[0].click();", maatrumLogo);
	    System.out.println("Clicked Maatrum logo using JS after wait.");
	}
	
	public void clickTNLogo() {
		
		wait.until(ExpectedConditions.visibilityOf(tamilnaduLogo)).click();
	
	}
	
	public void clickMTRreport3() {
		 wait.until(ExpectedConditions.visibilityOf(mtrReport3)).click();
	}
	
	public void enterApplicationNumber() {
		 wait.until(ExpectedConditions.visibilityOf(applicationNumber));

		//applicationNumber.clear();
		applicationNumber.sendKeys(data.getValue("LoanNumber"));
	}
			
	public void enterPropertyOwnerName() {
		propertyOwnerName.clear();
		propertyOwnerName.sendKeys(data.getValue("OwnerName"));
	}
	
	public void enterApplicantName() {
		applicantName.clear();
		applicantName.sendKeys(data.getValue("ApplicantName"));
	}
	
	public void selectBranch() {
		branch.click();
		chennaiBranch.click();		
	}
	
	public void enterDocumentNumber() {
		documentNumber.clear();
		documentNumber.sendKeys(data.getValue("DocNumber"));
	}
	
	public void enterDocumentYear() {
		documentYear.clear();
		documentYear.sendKeys(data.getValue("DocYear"));
	}
	
	public void selectSRO() {
		selectSRO.click();
		sroName.click();

	}
	
	public void selectVillage() {
		village.click();
		selectAiyurVillage.click();

	}
	
	
	public void enterStreetName() {
		streetName.clear();
		streetName.sendKeys(data.getValue("Street"));
	}
	
	public void enterAddress() {
		address.clear();
		address.sendKeys(data.getValue("Address"));
	}
	
	public void enterPhoneNumber() {
		//phoneNumber.clear();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", phoneNumber);
		phoneNumber.sendKeys(data.getValue("PhoneNumber"));
	}
	
	public void selectCaseType() {
		caseType.click();
		lap.click();		
	}
	
	public void enterPostalAddress() {
		//postalAddress.clear();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", postalAddress);	
		postalAddress.sendKeys(data.getValue("Address"));
	}
	
	public void uploadDocument() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",documents);	
		documents.sendKeys(PledgingDoc);
		documents.sendKeys(EBtax);
		documents.sendKeys(Patta);
		documents.sendKeys(ParentDoc);  
		
		//////////////////////////////////


		
	}
	
	public void clickSubmit() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(submitButton));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",submitButton);	
		 submitButton.click();
		 Thread.sleep(10000);
		//submitButton.click();
	}
	
	public void clickDashboard() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",dashboard);	
		 wait.until(ExpectedConditions.visibilityOf(dashboard)).click();

		//dashboard.click();
	}
	
	public void enterSearch() throws InterruptedException {
		Thread.sleep(10000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", searchBox);	
		searchBox.sendKeys(data.getValue("LoanNumber"));
	}
	
	public void clickMPR(){
        mprText=mprNumber.getText();	
        System.out.println(mprText);
        mprNumber.click();
	}
	
	public void clickContinue() throws InterruptedException {
		
		 if (continueButton.isDisplayed()) {
				continueButton.click();

	           // continueButton.click();
	            System.out.println("Continue button clicked.");
	        } else {
	            System.out.println("Continue button is not displayed.");
	        }	   
	}
	
	
	
	
	public void clickInprogressButton(){
	
		
		wait.until(ExpectedConditions.visibilityOf(InprogressButton)).click();
        
	}
	
	

//	public void PleaseConfirmCheckBox(){
//		
//		wait.until(ExpectedConditions.visibilityOf(PleaseConfirmCheckBox));
//		PleaseConfirmCheckBox.click();
//		OkayButton.click();
//	}
	
	public void PleaseConfirmCheckBox() {
	    try {
	        // Wait for a few seconds only, not the full global wait
	        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
	        
	        // Check if the element is visible within 5 seconds
	        shortWait.until(ExpectedConditions.visibilityOf(PleaseConfirmCheckBox));
	        
	        // If visible, click both elements
	        PleaseConfirmCheckBox.click();
	        OkayButton.click();
	        System.out.println("Checkbox and OK button clicked successfully.");
	        
	    } catch (Exception e) {
	        // Element not found or not visible — skip step
	        System.out.println("PleaseConfirmCheckBox not found — skipping this step.");
	    }
	}

	
	
	public void ClickMarkAsQuerryButton(){
		MarkAsQuerry.click();
	}
	
	public void DrpdownForQuerry() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    try {
	        if (DropdownForQuerryType.isDisplayed() && DropdownForQuerryType.isEnabled()) {
	            try {
	                DropdownForQuerryType.click();
	                System.out.println("Clicked dropdown normally.");
	            } catch (org.openqa.selenium.ElementClickInterceptedException e) {
	                js.executeScript("arguments[0].click();", DropdownForQuerryType);
	                System.out.println("Popup detected — clicked dropdown using JavaScript.");
	            }
	        } else {
	            js.executeScript("arguments[0].click();", DropdownForQuerryType);
	            System.out.println("Dropdown not clickable directly — clicked using JavaScript.");
	        }
	    } catch (Exception e) {
	        js.executeScript("arguments[0].click();", DropdownForQuerryType);
	        System.out.println("Dropdown was hidden or blocked — clicked with JavaScript fallback.");
	    }
	}

	
	public void DropDownValueSelection() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    try {
	        // Wait for dropdown list to render and become visible
	        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        shortWait.until(ExpectedConditions.visibilityOf(DropDownValueSelection));

	        try {
	            // Try normal Selenium click first
	            DropDownValueSelection.click();
	            System.out.println("Dropdown value clicked normally.");
	        } catch (org.openqa.selenium.ElementClickInterceptedException e) {
	            // If something blocks it, use JS click
	            js.executeScript("arguments[0].click();", DropDownValueSelection);
	            System.out.println("Dropdown value clicked using JavaScript (fallback).");
	        }

	    } catch (Exception e) {
	        // If still not clickable, scroll and force JS click
	        js.executeScript("arguments[0].scrollIntoView(true);", DropDownValueSelection);
	        js.executeScript("arguments[0].click();", DropDownValueSelection);
	        System.out.println("Dropdown value was hidden — clicked with scroll + JS fallback.");
	    }
	}
	
	
	public void SubmitButtonForQuery()
	
	{
		wait.until(ExpectedConditions.visibilityOf(SubmitButtonForQuerry)).click();
	}
	
	public void AdminPortalSwitch() throws InterruptedException {
		
		Thread.sleep(10000);
		
	driver.get("https://admindev.maatrum.com/v2/");	
	
	
//	WebElement UsernameForAdminDevV2 = driver.findElement(By.xpath("//input[@id='username']"));
//	UsernameForAdminDevV2.sendKeys("sreenath.p@maatrum.com");
//	WebElement PassWordForAdminDevV2=driver.findElement(By.xpath("//input[@id='password']"));
//	PassWordForAdminDevV2.sendKeys("Maatrum@123");
//	WebElement SubmitButtonForAdminDevV2 = driver.findElement(By.xpath("//input[@name='login']"));
//	SubmitButtonForAdminDevV2.click();
	
	wait.until(ExpectedConditions.visibilityOf(dropDown)).click();
    
	wait.until(ExpectedConditions.visibilityOf(clickDropDownValue)).click();
   
	}
	
	
	public void SearchAdmindev() {
		
		wait.until(ExpectedConditions.visibilityOf(SearchInAdminDev)).sendKeys(data.getValue("LoanNumber"));
		wait.until(ExpectedConditions.visibilityOf(ViewButtonInAdminDev)).click();
	
	}
	
	
	public void uploadDocumentInAdminDev() throws InterruptedException {
	    // Wait for Upload button to appear
	    WebElement uploadButton = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//button[.//span[text()='Upload']]")));
	    uploadButton.click();

	    // Wait for input[type='file'] to be present in DOM
	    By fileInputLocator = By.xpath("//input[starts-with(@id,'form') and @type='file']");
	    WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(fileInputLocator));

	    // Send the actual file path
	    fileInput.sendKeys(PledgingDoc);

	    // Add message
	    wait.until(ExpectedConditions.visibilityOf(SendMessageWithFile)).sendKeys("Okay");

	    // Click Send
	    wait.until(ExpectedConditions.elementToBeClickable(SendButtonAdmindev)).click();

	    System.out.println(" File uploaded successfully in AdminDev");
	}

	
	public void QuerryRevert() throws InterruptedException
	
	{
		
		
		Thread.sleep(10000);
		driver.get("https://legaldev.maatrum.com/");
		Thread.sleep(1000);
		clickDashboard();
		Thread.sleep(2000);
		enterSearch();
		Thread.sleep(3000);
		clickMPR();
		
		wait.until(ExpectedConditions.elementToBeClickable(Querryreverted)).click();
		wait.until(ExpectedConditions.elementToBeClickable(QuerryrevertedPopup)).click();
		 System.out.println(" QuerryReverted Successfully");
		
		
	}
	
	
	
}
