package testCases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ShedulePage;
import pages.TransactionPage;
import pages.ValuationPage;

public class ChainIssue extends BaseTest{
	
	LoginPage lp;
	ShedulePage sp;
	ValuationPage vp;
	TransactionPage tp;
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
		Thread.sleep(20000);
		lp.clickContinue();
		Thread.sleep(15000);
		driver.get("https://legal.maatrum.com/");
		//lp.clickDashboard();
		Thread.sleep(3000);
		lp.enterSearch();
		Thread.sleep(5000);
		lp.clickMPR();


}}
