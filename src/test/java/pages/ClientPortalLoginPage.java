package pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClientPortalLoginPage { 
	
	

	WebDriver driver;
	WebDriverWait wait; 
	
	String clientname = "Vistaar"; 
	
	String state = "Tamilnadu";

	public ClientPortalLoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='username']")
	WebElement userNameField;

	@FindBy(xpath="//input[@id='password']")
	WebElement pwdField;

	@FindBy(xpath = "//input[@name='login']")
	WebElement btnLogin;     
	
	
	@FindBy(xpath="//button//span[contains(text(), 'New Request / File')]")
	WebElement NewRequestButton;   
	
	@FindBy(xpath="(//input[@type='text'])[1]")
	WebElement searchClient;  
	
	
	
	@FindBy(xpath="//p[contains(text() , 'Vistaar Financial Services Private Limited')]")
	WebElement ClientLogo;  
	
	
	@FindBy(xpath = "//div[contains(@class,'cursor-pointer')]")
	List<WebElement> stateCards;   
	
	
	
	
	
	
	
	 @FindBy(xpath = "//div[contains(@class,'w-[173px]') and contains(@class,'cursor-pointer')]")
	  List<WebElement> reportTypeCards; 
	
	

	public void enterUserName(String username) {
		wait.until(ExpectedConditions.visibilityOf(userNameField));
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

	public void dismissPasswordLeakWarning() {
		try {
			Thread.sleep(2000);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
		} catch (Exception e) {
			System.out.println("No password leak dialog to dismiss: " + e.getMessage());
		}
	}
	
	public void clickNewrequestbutton() {
		
		
		NewRequestButton.click();
		
	}
	public void searchclient() {
	
	searchClient.sendKeys(clientname);
	}
	 
	public void  ClientLogoclick() { 
		
		wait.until(ExpectedConditions.visibilityOf(ClientLogo));
		
		  String clientName = ClientLogo.getText().trim();   
		  
		  
		  System.out.println("Client Name: " + clientName);
		  
		  

		ClientLogo.click();
	}
	
	
	public void selectState(String state) {

	    try {
	        new WebDriverWait(driver, Duration.ofSeconds(3))
	            .until(ExpectedConditions.visibilityOfAllElements(stateCards));
	    } catch (TimeoutException | NoSuchElementException e) {
	        System.out.println("Skipping state selection — not present for this client");
	        return;
	    }

	    if (stateCards == null || stateCards.isEmpty()) {
	        System.out.println("Skipping state selection — no state cards rendered for this client");
	        return;
	    }

	    for (WebElement card : stateCards) {

	        String text = card.getText().trim();
	        System.out.println("State found: " + text);

	        if (text.equalsIgnoreCase(state)) {

	            wait.until(ExpectedConditions.elementToBeClickable(card));
	            card.click();   //  clicking correct element now
	            return;
	        }
	    }

	    throw new RuntimeException("State not found: " + state);
	}
	 
	
	
	public void selectReportTye(String Reportype)  {

		try {
			new WebDriverWait(driver, Duration.ofSeconds(3))
				.until(ExpectedConditions.visibilityOfAllElements(reportTypeCards));
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println("Skipping report-type selection — not present for this client");
			return;
		}

		if (reportTypeCards == null || reportTypeCards.isEmpty()) {
			System.out.println("Skipping report-type selection — no report-type cards rendered for this client");
			return;
		}

		for (WebElement card : reportTypeCards) {
			
			
			String text= card.getText().trim();
			
			
			System.out.println("ReportType Found : " +text);  
			
			
			 String[] parts = text.split("\\r?\\n");
	          String title = parts.length > 0 ? parts[0].trim() : "";
	          String code  = parts.length > 1 ? parts[1].trim() : "";

	          if (title.equalsIgnoreCase(Reportype) || code.equalsIgnoreCase(Reportype)) {
	              wait.until(ExpectedConditions.elementToBeClickable(card));
	              card.click();
	              return;
	          }
			
			
					
		} 
	
	}
	
	
	
	
	
	
	

}
  