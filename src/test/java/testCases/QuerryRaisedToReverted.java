package testCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.QuerryRasiedToRevertedPages;

public class QuerryRaisedToReverted extends BaseTest{
	
	

	
	private QuerryRasiedToRevertedPages QR;
	
	
	@Test
//	@Parameters({"username", "password"})
	public void QuerryRaisedFromLegal() throws InterruptedException
	
	{
		
	
		
		
		
		QR= new QuerryRasiedToRevertedPages(driver);
		
	
		QR.clickAddNew();
		Thread.sleep(1000);
		QR.clickMaatrumLogo();
		Thread.sleep(1000);
		QR.clickTNLogo();
		Thread.sleep(1000);
		QR.clickMTRreport3();
		Thread.sleep(5000);
		QR.enterApplicationNumber();
		Thread.sleep(1000);
		QR.enterPropertyOwnerName();
		Thread.sleep(1000);
		QR.enterApplicantName();
		Thread.sleep(1000);
		QR.selectBranch();
		Thread.sleep(1000);
		QR.enterDocumentNumber();
		Thread.sleep(1000);
		QR.enterDocumentYear();
		Thread.sleep(1000);
		QR.selectSRO();
		Thread.sleep(1000);
		QR.selectVillage();
		Thread.sleep(1000);
		Thread.sleep(1000);
		QR.enterStreetName();
		Thread.sleep(1000);
		QR.enterAddress();
		Thread.sleep(1000);
		QR.enterPhoneNumber();
		Thread.sleep(1000);
		QR.selectCaseType();
		Thread.sleep(1000);
		QR.enterPostalAddress();
		Thread.sleep(1000);
		QR.uploadDocument();
		Thread.sleep(1000);
		QR.clickSubmit();
		Thread.sleep(10000);
		QR.clickContinue();
		Thread.sleep(10000);
		driver.get("https://legaldev.maatrum.com/");
		Thread.sleep(3000);
		QR.enterSearch();
		Thread.sleep(2000);
		QR.clickMPR();
		Thread.sleep(2000);
		QR.clickInprogressButton();
		Thread.sleep(2000);
		QR.PleaseConfirmCheckBox();
		Thread.sleep(2000);
		QR.ClickMarkAsQuerryButton();
		Thread.sleep(2000);
		QR.DrpdownForQuerry();
		Thread.sleep(2000);
		QR.DropDownValueSelection();
		QR.SubmitButtonForQuery();
		
		Thread.sleep(10000);
		QR.AdminPortalSwitch();
		Thread.sleep(1000);
		QR.SearchAdmindev();
		QR.uploadDocumentInAdminDev();
		QR.QuerryRevert();
		
		
	
	}
	

}
