package testCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.ClientPortalLoginPag
import pages.CreateRequestPage;
import utils.ConfigReader;  


// This the main Base class 

public class CreateRequestTest extends BaseTestClientPortal {

	@Test
	@Parameters({"username", "password"})
	public void createNewRequest(String username, String password) throws InterruptedException {

		// ---- Step 1: Login and navigate to the Create Request form ----
		ClientPortalLoginPage cp = new ClientPortalLoginPage(driver); 
	
		
		
		cp.enterUserName(username);
		cp.enterPassword(password);
		cp.clickLogin();
		cp.dismissPasswordLeakWarning();
		cp.clickNewrequestbutton();
		cp.searchclient();
		Thread.sleep(1000);
		cp.ClientLogoclick(); 
		cp.selectState("Tamil Nadu");
		cp.selectReportTye("MPR - 3");  
		
		Thread.sleep(1500); // temporary stability

		// ---- Step 2: Load test data from the property file ----
		ConfigReader data = new ConfigReader(
			"src/test/resources/Propertiesdata/createRequest.properties"
		);

		// ---- Step 3: Fill the form using the data ---- 
		CreateRequestPage request = new CreateRequestPage(driver); 
		System.out.println("Branch value: " + data.getValue("branch"));
		
		request.fillForm(data); 

		System.out.println("Create Request form filled successfully."); 
		
		
		request.ClickCreateRequestButton();
		
     

	}     
	

	
}
