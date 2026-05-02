package testCases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.PreviewPage;
import pages.ShedulePage;
import pages.TransactionPage;
import pages.ValuationPage;

public class AutoDevolutionFlow extends BaseTest {

	LoginPage lp;
	ShedulePage sp;
	ValuationPage vp;
	TransactionPage tp;
	PreviewPage pp;
	public String Title="Maatrum 2.0 - Legal";
//	String MTRid;

	
	

	@Test
	 @Parameters({"username", "password" , "valuationURL"})

	public void devolution(String username , String password, String valuationURL) throws InterruptedException, IOException {
	
		
	//try {	
		
		lp= new LoginPage(driver);
		lp.clickAddNew();
		lp.clickMaatrumLogo();
		lp.clickTNLogo();
		lp.clickMTRreport3();
		Thread.sleep(5000);
		lp.enterApplicationNumber();
		lp.enterPropertyOwnerName();
		lp.enterApplicantName();
		lp.selectBranch();
		lp.enterDocumentNumber();
		lp.enterDocumentYear();
		lp.selectSRO();
		lp.selectVillage();
		lp.enterStreetName();
		lp.enterAddress();
		lp.enterPhoneNumber();
		lp.selectCaseType();
		lp.enterPostalAddress();
		lp.uploadDocument();
		lp.clickSubmit();
		Thread.sleep(10000);
		lp.clickContinue();
		Thread.sleep(10000);
		driver.get("https://legaldev.maatrum.com/");
		Thread.sleep(5000);
		lp.enterSearch();
		Thread.sleep(2000);
		lp.clickMPR();
		Thread.sleep(3000);
		lp.draftingECupload();
		tp= new TransactionPage(driver);
		tp.parentDocClick();
		tp.deleteDocument();
		tp.salesDeedDevolution();
		Thread.sleep(3000);
		tp.dropDown();
		tp.saleDeedDevolutionText();
		tp.ebReceiptDoc();
		tp.copyData();
		tp.copydataFromDeed();
		tp.fillEmptyFields();
		tp.ebReceiptDevolutionText();
		tp.pattaHeaderClick();
		tp.thiredDocType();
		tp.ownerCheckBoxClick();
		tp.pattaNumberEnter();
		tp.pattaRegistrationDate();
		tp.pattaOwnerName();		
		tp.copyData();
		tp.copydataForPatta();
		tp.fillEmptyFields();
		//tp.pattaUpload();
		tp.issuingAuthoityLocation();
		tp.pattaUpload();
		tp.pattaDevolutionText();
		tp.close();
		Thread.sleep(3000);
		tp.addButton();
		Thread.sleep(3000);
		//tp.newDocument();
//		Thread.sleep(5000);
		tp.selectDocumentType();
		tp.copyData();
		tp.copydataFromDeed();
		tp.fillEmptyFields();
		tp.ecOfSaleDeedDevolutionText();
		tp.addButton();
		//tp.newDocument();
		tp.selectDocumentTypeMortgage();
		tp.mortgageDeedData();
		tp.mortgageDocNumber();
		tp.copyData();
		tp.copydataFromDeed();
		tp.fillEmptyFields();	
		tp.mortgagaeDeedDevolutionText();
        tp.propertiesTab();
        tp.litiationTab();
		tp.chainInputTab();
		Thread.sleep(3000);
		tp.previewButton();
     	tp.regenerteV2Devolution();
     	pp= new PreviewPage(driver);
     	pp.los();
		tp.remark();

}
}
