package testCases;

import org.testng.annotations.Test;

import pages.SiteInspectionPage;

public class SiteInspectionTest extends BaseTestMob {

	@Test
	public void siteInspectionFlow() throws InterruptedException {

		SiteInspectionPage sip = new SiteInspectionPage(driver);

		sip.clickLoginButton();
		sip.enterPhoneNumber();
		sip.clickSendOTPButton();
		sip.ClickLoginButtonAfterOTP(); 
		
		sip.tasksTabClick(); 
		
		sip.Searchbar(); 
		
		sip.CorrespondginButton(); 
		
		sip.CapturelocationButton(); 
		
		sip.StartVetting();
  
		
		sip.AdddocumentButton();

		sip.selectNatureOfDocument();
		sip.enterDocumentNumber();
		sip.enterDocumentDate();
		sip.selectExpectation();
		sip.clickSaveButton();

		sip.selectDocumentAvailableYes();
		sip.selectOriginalityOriginal();
		sip.selectLaminatedNo();
		sip.selectConditionGood();
		sip.enterPagesTotal();
		sip.enterPagesVerified();
		sip.clickSaveChangesButton();
	}

}
