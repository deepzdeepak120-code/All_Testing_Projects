package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MobilePage {
	
	WebDriver driver;
	
	public MobilePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath="(//button[contains(text(),'Login')])[1]")
	public
	WebElement loginButton;
	
	@FindBy (xpath="//input[@name='logIn']")
	WebElement phoneNumber;
	
	@FindBy (xpath="(//div[@class='flex flex-col ']//button[contains(text(),'Send OTP')])[1]")
	WebElement sendOTP;
	
	public void clickLoginButton() {
		loginButton.click();
	}

	public void enterPhoneNumber(String number) {
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300);");

		    // Scroll into view
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", phoneNumber);

		    // Wait until it's visible and clickable
		    wait.until(ExpectedConditions.visibilityOf(phoneNumber));
		    wait.until(ExpectedConditions.elementToBeClickable(phoneNumber));

		    // Optional: add focus and small delay for smoother interaction
		    ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", phoneNumber);
		    try { Thread.sleep(300); } catch (InterruptedException e) {}

		    phoneNumber.sendKeys(number);
	}
	
	public void clickSendOTP() {
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		    // Scroll slightly down manually (simulate a user gesture in mobile view)
		    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300);");

		    // Then scroll the element into view (center)
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", sendOTP);

		    // Wait for visibility and clickability
		    wait.until(ExpectedConditions.visibilityOf(sendOTP));
		    wait.until(ExpectedConditions.elementToBeClickable(sendOTP));

		    // Optional: focus and wait
		    ((JavascriptExecutor) driver).executeScript("arguments[0].focus();", sendOTP);
		    try { Thread.sleep(300); } catch (InterruptedException e) {}

		    sendOTP.click();
		}	}

