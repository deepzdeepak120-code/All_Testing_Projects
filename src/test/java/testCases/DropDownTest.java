package testCases;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ShedulePage;
import pages.TransactionPage;
import pages.ValuationPage;

public class DropDownTest extends BaseTest{
	
	
	LoginPage lp;
	ShedulePage sp;
	ValuationPage vp;
	TransactionPage tp;
	public String Title="Maatrum 2.0 - Legal";
//	String MTRid;

	
	

	@Test
	 @Parameters({"username", "password"})

	public void devolution(String username , String password) throws InterruptedException, IOException {
		
		driver.get("https://legaldev.maatrum.com/v2/mpr/270739/edit-transactions");
		Thread.sleep(7000);
		tp = new TransactionPage(driver);
		tp.close();
		//tp.parentDocClick();
		//tp.deleteDocument();
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
		//tp.parentDocClick();
		//tp.deleteDocument();
		tp.addButton();
		tp.newDocument();
		tp.selectDocumentType();
		tp.copyData();
		tp.copydataFromDeed();
		tp.fillEmptyFields();
		Thread.sleep(2000);
		//tp.previewButton();
		tp.propertiesTab();
		tp.litiationTab();
		tp.chainInputTab();
		Thread.sleep(3000);
		tp.previewButton();
	
	}

}
