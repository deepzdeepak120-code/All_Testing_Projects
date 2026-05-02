package testCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.ClientPortalLoginPage;

public class ClientPortalTest extends BaseTestClientPortal {

	ClientPortalLoginPage cp;

	@Test
	@Parameters({"username", "password"})
	public void loginToClientPortal(String username, String password) throws InterruptedException {

		cp = new ClientPortalLoginPage(driver);
		cp.enterUserName(username);
		cp.enterPassword(password); 
		cp.clickLogin();
		System.out.println("Successfully logged in ");
		cp.dismissPasswordLeakWarning();
		cp.clickNewrequestbutton();
		cp.searchclient();
		Thread.sleep(1000);
		System.out.println("Client Portal Login Successful"); 
		cp.ClientLogoclick(); 
		System.out.println("Logo Click Successful");  
		cp.selectState("Tamil Nadu"); 
		cp.selectReportTye("MPR - 3");
	}

}
  

