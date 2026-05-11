package testCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.ClientPortalLoginPage;
import pages.CreateRequestPage;
import utils.ConfigReader;  


// This the main Base class 

public class CreateRequestTest extends BaseTestClientPortal {

	@Test
	@Parameters({"username", "password"})
	public void createNewRequest(String username, String password) throws InterruptedException {

		// ---- Step 1: Load test data from the property file ----
		ConfigReader data = new ConfigReader(
			"src/test/resources/Propertiesdata/createRequest.properties"
		);

		String clientName  = data.getValue("clientName");
		String requestState = data.getValue("requestState");
		String reportType  = data.getValue("reportType");

		// ---- Step 2: Login and navigate to the Create Request form ----
		// Each step below auto-skips when the field/screen is not shown for the
		// signed-in role (e.g. Client Admin scoped to one client) or when the
		// corresponding property is left blank.
		ClientPortalLoginPage cp = new ClientPortalLoginPage(driver);

		cp.enterUserName(username);
		cp.enterPassword(password);
		cp.clickLogin();
		cp.dismissPasswordLeakWarning();
		cp.clickNewrequestbutton();
		cp.searchclient(clientName);
		Thread.sleep(1000);
		cp.ClientLogoclick(clientName);
		cp.selectState(requestState);
		cp.selectReportTye(reportType);

		Thread.sleep(1500); // temporary stability

		// ---- Step 3: Fill the form using the data ---- 
		CreateRequestPage request = new CreateRequestPage(driver); 
		System.out.println("Branch value: " + data.getValue("branch"));
		
		request.fillForm(data); 

		System.out.println("Create Request form filled successfully."); 
		
		
		request.ClickCreateRequestButton();
		
     

	}     
	

	
}
