package testCases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ShedulePage;
import pages.TransactionPage;
import pages.ValuationPage;

public class MRPdrafting extends BaseTest{

	LoginPage lp;
	ShedulePage sp;
	ValuationPage vp;
	TransactionPage tp;
	public String Title="Maatrum 2.0 - Legal";

@Test
@Parameters({"username", "password" , "valuationURL"})

	public void drafting(String username , String password, String valuationURL) throws InterruptedException, IOException {
	

	
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
	Thread.sleep(3000);
	lp.enterSearch();
	Thread.sleep(2000);
	lp.clickMPR();
	Thread.sleep(3000);
	lp.draftingECupload();
	tp = new TransactionPage(driver);
	//tp.close();
	tp.salesDeedDevolution();
	Thread.sleep(2000);
	tp.dropDown();
	//tp.addECofSaleDeedDocument();
	tp.ebReceiptDoc();
	tp.copyData();
	tp.copydataFromDeed();
	tp.fillEmptyFields();
	tp.pattaHeaderClick();
	tp.thiredDocType();
	tp.pattaNumberEnter();
	tp.pattaRegistrationDate();
	tp.pattaOwnerName();		
	tp.copyData();
	tp.copydataForPatta();
	tp.fillEmptyFields();
	tp.pattaUpload();
	tp.issuingAuthoityLocation();
	tp.selectDocumentType();
	
	}
}
