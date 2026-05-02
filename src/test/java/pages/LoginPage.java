package pages;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;

public class LoginPage {
	
	WebDriver driver;
	WebDriverWait wait;
	ConfigReader data;
	 
//	String LoanNumber="HDFC09277";
//	String OwnerName="Arvinth";
//	String ApplicantName="Krish";
//    String DocNumber="1007";
//	String DocYear="2019";
//	String PhoneNumber="8877201994";
//	String Street="5th cross street";
//	String Address="No.29/1A,5th cross street, Aiyur village, Ariyalur";
	public String mprText; 
	
	
	public LoginPage(WebDriver driver) {
		
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



	

	@FindBy (id="username")
	WebElement userNameField;
	
	@FindBy (id="password")
	WebElement pwdField;
	
	@FindBy (xpath="//input[@name='login']")
	WebElement btnLogin;
	
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
	WebElement documentYear; //docYear........deepak
	
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
	
	@FindBy (xpath="//a[contains(text(),'Dashboard')]")
	WebElement dashboard;
	
	@FindBy (xpath="//input[@type='search']")
	WebElement searchBox;
	
	@FindBy (xpath="(//td/a)[1]")
	WebElement mprNumber;
	
	@FindBy(id="continueRequest")
	WebElement continueButton;
	
	@FindBy(xpath="//span[contains(text(),'In-Progress')]")
	WebElement inProgressButton;

	@FindBy(xpath="//label[@for='inprogressCheckbox']")
	WebElement conformButton;

	@FindBy(xpath="//button[@id='inprogress']")
	WebElement okButton;
	
	@FindBy(xpath="//i[@class='fa fa-ellipsis-h']")
	WebElement stopECmenu;
	
	@FindBy(xpath="//a[text()=' STOP EC ']")
	WebElement stopECbutton;
	
	@FindBy(id="stopEC")
	WebElement stopECokbutton;
	
	@FindBy(xpath=" //button[text()=' EC2 '] ")
	WebElement ec2;
	
	@FindBy(xpath=" //a[text()=' Upload EC2 '] ")
	WebElement uploadec2;
	
	@FindBy(id="ecStartDate")
	WebElement ec2StartDate;
	
	@FindBy(xpath="//button[text()='Submit']")
	WebElement ec2Submit;
	
	@FindBy(xpath="//button[contains(text(),' Continue ')] ")
	WebElement drafterContinue;
	
	
	


//ecStartDate
	
public void draftingECupload() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",inProgressButton);	
		inProgressButton.click();
		Thread.sleep(3000);
		if(conformButton.isDisplayed()){
		conformButton.click();
		}
		else {
		   System.out.println("Fresh case");
		}
		js.executeScript("arguments[0].scrollIntoView(true);",okButton);	
		okButton.click();
		Thread.sleep(5000);
	    wait.until(ExpectedConditions.visibilityOf(stopECmenu)).click();
		//stopECmenu.click();
		stopECbutton.click();
		Thread.sleep(5000);
		stopECokbutton.click();
		Thread.sleep(5000);
		ec2.click();
		uploadec2.click();
		ec2StartDate.sendKeys(data.getValue("EC2startDate"));
		Thread.sleep(3000);
		ec2Submit.click();
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView(true);",drafterContinue);
		wait.until(ExpectedConditions.visibilityOf(drafterContinue)).click();
		
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//input[@placeholder='Search Application Number']
	
	
	
	
	
	
	
	public void enterUserName(String username) {
		userNameField.clear();
		userNameField.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		pwdField.clear();
		pwdField.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickAddNew() {
		addNewbtn.click();
	}
	
	public void clickMaatrumLogo() {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",maatrumLogo);	
		maatrumLogo.click();

	}
	
	public void clickTNLogo() {
		tamilnaduLogo.click();
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


		
	}
	
	public void clickSubmit() {
		wait.until(ExpectedConditions.visibilityOf(submitButton));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",submitButton);	
		 submitButton.click();
		//submitButton.click();
	}
	
	public void clickDashboard() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",dashboard);	
		 wait.until(ExpectedConditions.visibilityOf(dashboard)).click();

		//dashboard.click();
	}
	
	public void enterSearch() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", searchBox);	
		searchBox.sendKeys(data.getValue("LoanNumber"));
	}
	
	public void clickMPR(){
        mprText=mprNumber.getText();	
        System.out.println(mprText);
        mprNumber.click();
	}
	public void clickConfirm() {
		conformButton.click();
	}
	
	public void clickOK() {
		wait.until(ExpectedConditions.visibilityOf(okButton));
		okButton.click();
	}

	public void clickInprogress() {
		inProgressButton.click();
	}

	
}
