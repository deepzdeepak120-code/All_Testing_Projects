package testCases;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.MobilePage;

public class MobileLogin  extends BaseTestMob{

	
	@Test()
	public void loginmobile() throws InterruptedException {
		
		MobilePage mob= new MobilePage(driver);
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		    // Step 1: Wait and click the Login button (opens phone number field)
		    wait.until(ExpectedConditions.visibilityOf(mob.loginButton));
		    wait.until(ExpectedConditions.elementToBeClickable(mob.loginButton));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", mob.loginButton);
		    mob.clickLoginButton();

		    // Step 2: Enter phone number
		    mob.enterPhoneNumber("7010407616");

		    // Step 3: Send OTP (with updated scroll logic)
		    mob.clickSendOTP();		
	}
}
