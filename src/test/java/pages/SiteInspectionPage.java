package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SiteInspectionPage {

	WebDriver driver;
	WebDriverWait wait;

	public SiteInspectionPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}

	// Locators
	@FindBy(xpath = "(//button[text()='Login'])[1]")
	WebElement loginButton;

	@FindBy(xpath = "//input[@name='logIn']")
	WebElement phoneNumberInput; 
	
	
	@FindBy(xpath = "(//button[text()='Send OTP'])[2]") 
	WebElement SendOTPButton; 
	
	
	
	@FindBy(xpath="(//button[text()='Login'])[1]")
	WebElement LoginbuttonAferOTP; 
	
	
	
	@FindBy(xpath = "//a[@href='/gig/gig-tasks']")
	WebElement tasksTab; 
	
	
	@FindBy(xpath = "//input[@placeholder='Search for a case...']")
	WebElement Searchbar;  
	
	
	@FindBy(xpath="//div[@class='px-4 pt-3']/child::div/child::button") 
	WebElement CorrespondingButton; 
	
	
	
	
	@FindBy(xpath="//button//span[text()='Capture location']") 
	
	WebElement capturelocationButton; 
	
	
	@FindBy(xpath="//button[text()=' Start Vetting']") 
	
	WebElement StartVettingButton;   
	
	
	@FindBy(xpath = "//button[.//h4[text()='Add another document']]")
	WebElement addDcoumentButton;

	@FindBy(id = "react-select-2-input")
	WebElement natureOfDocumentInput;

	@FindBy(xpath = "//input[@name='DocumentNumber']")
	WebElement documentNumberInput;

	@FindBy(xpath = "//input[@placeholder='DD-MMM-YYYY']")
	WebElement documentDateInput;

	@FindBy(id = "react-select-3-input")
	WebElement expectationInput;

	@FindBy(xpath = "//button/child::div[text()='Save']")
	WebElement saveButton;

	@FindBy(xpath = "//div[text()='Is the document available?']/following::div[text()='Yes'][1]")
	WebElement documentAvailableYes;

	@FindBy(xpath = "//div[@data-type='Originality']//div[text()='Original']")
	WebElement originalityOriginal;

	@FindBy(xpath = "//div[@data-type='Lamination']//div[text()='No']")
	WebElement laminatedNo;

	@FindBy(xpath = "//div[@data-type='Condition']//div[text()='Good']")
	WebElement conditionGood;

	@FindBy(xpath = "//div[text()='verified']/preceding-sibling::input")
	WebElement pagesVerifiedInput;

	@FindBy(xpath = "//div[text()='total']/preceding-sibling::input")
	WebElement pagesTotalInput;

	@FindBy(xpath = "//button[.//div[text()='Save changes']]")
	WebElement saveChangesButton;

	// Action methods
	public void clickLoginButton() {
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", loginButton);
		loginButton.click(); 
		
		
		
	}

	public void enterPhoneNumber() {
		wait.until(ExpectedConditions.visibilityOf(phoneNumberInput));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", phoneNumberInput);
		phoneNumberInput.sendKeys("9962541178"); 
		
	} 
	
	
	public void clickSendOTPButton() { 
		
		wait.until(ExpectedConditions.visibilityOf(SendOTPButton));  
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", SendOTPButton); 
		
		SendOTPButton.click(); 
		
	}  
	
public void ClickLoginButtonAfterOTP() { 
		
		wait.until(ExpectedConditions.visibilityOf(LoginbuttonAferOTP));  
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", LoginbuttonAferOTP); 
		
		LoginbuttonAferOTP.click();  
		
		System.out.println("Login Button clicked");
		
	}
	
public void tasksTabClick() {

    wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.elementToBeClickable(tasksTab)
    ));

    tasksTab.click();
}  


public void Searchbar() throws InterruptedException {
    Thread.sleep(2000);
    PageFactory.initElements(driver, this);
    wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.elementToBeClickable(Searchbar)
    ));
    Searchbar.sendKeys("MPR-20260224-006791");
}
	
public void CorrespondginButton() {

    wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.elementToBeClickable(CorrespondingButton)
    ));

    CorrespondingButton.click(); 
}  



public void CapturelocationButton() {

    wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.elementToBeClickable(capturelocationButton)
    ));

    capturelocationButton.click(); 
}  


public void StartVetting() {

    wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.elementToBeClickable(StartVettingButton)
    ));

    StartVettingButton.click(); 
}  
  


public void AdddocumentButton() {

    wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.elementToBeClickable(addDcoumentButton)
    ));

    addDcoumentButton.click();
}

public void selectNatureOfDocument() {
    wait.until(ExpectedConditions.elementToBeClickable(natureOfDocumentInput));
    natureOfDocumentInput.sendKeys("Sale Deed");
    try { Thread.sleep(1000); } catch (InterruptedException e) {}
    natureOfDocumentInput.sendKeys(Keys.ENTER);
}

public void enterDocumentNumber() {
    wait.until(ExpectedConditions.visibilityOf(documentNumberInput));
    documentNumberInput.sendKeys("12345");
}

public void enterDocumentDate() {
    wait.until(ExpectedConditions.visibilityOf(documentDateInput));
    documentDateInput.sendKeys("15-Mar-2026");
}

public void selectExpectation() {
    wait.until(ExpectedConditions.elementToBeClickable(expectationInput));
    expectationInput.sendKeys("Original");
    try { Thread.sleep(1000); } 
    
    catch (InterruptedException e) {
    	
    	
    }
    
       
    expectationInput.sendKeys(Keys.ENTER);
}

public void clickSaveButton() {
    wait.until(ExpectedConditions.refreshed(
            ExpectedConditions.elementToBeClickable(saveButton)
    ));
    saveButton.click();
}

public void selectDocumentAvailableYes() {
    wait.until(ExpectedConditions.elementToBeClickable(documentAvailableYes));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", documentAvailableYes);
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", documentAvailableYes);
}

public void selectOriginalityOriginal() {
    wait.until(ExpectedConditions.elementToBeClickable(originalityOriginal));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", originalityOriginal);
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", originalityOriginal);
}

public void selectLaminatedNo() {
    wait.until(ExpectedConditions.elementToBeClickable(laminatedNo));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", laminatedNo);
    laminatedNo.click();
}

public void selectConditionGood() {
    wait.until(ExpectedConditions.elementToBeClickable(conditionGood));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", conditionGood);
    conditionGood.click();
}

public void enterPagesVerified() {
    wait.until(ExpectedConditions.visibilityOf(pagesVerifiedInput));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", pagesVerifiedInput);
    pagesVerifiedInput.sendKeys("12");
}

public void enterPagesTotal() {
    wait.until(ExpectedConditions.visibilityOf(pagesTotalInput));
    pagesTotalInput.sendKeys("12");
}

public void clickSaveChangesButton() {
    wait.until(ExpectedConditions.elementToBeClickable(saveChangesButton));
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", saveChangesButton);
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", saveChangesButton);
}

}    








