package testCases;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ShedulePage;
import pages.ValuationPage;

public class RequestCreation extends BaseTest{
	
	
	LoginPage lp;
	ShedulePage sp;
	ValuationPage vp;
	public String Title="Maatrum 2.0 - Legal";
//	String MTRid;

	
	

	@Test
	 @Parameters({"username", "password" , "valuationURL"})

	public void request(String username , String password, String valuationURL) throws InterruptedException, IOException {
	
		
	//try {	
		
		lp= new LoginPage(driver);
		lp.clickAddNew();
		lp.clickMaatrumLogo();
		lp.clickTNLogo();
		lp.clickMTRreport3();
		Thread.sleep(3000);
		
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
		Thread.sleep(3000);

		sp = new ShedulePage(driver);
		lp.clickContinue();
		Thread.sleep(3000);
		lp.clickDashboard();
		Thread.sleep(3000);
		lp.enterSearch();
		Thread.sleep(3000);
		lp.clickMPR();
		driver.get(valuationURL);
		Thread.sleep(3000);
		vp = new ValuationPage(driver);
		String mprtext=lp.mprText;
		vp.clickElementByCapturedId(mprtext);
		Thread.sleep(3000);
		String currentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();

        for (String window : allWindows) {
            driver.switchTo().window(window);
           if (driver.getTitle().equals(Title)) {
        Thread.sleep(1000)     ;
		lp.clickInprogress();
		lp.clickConfirm();
		Thread.sleep(1000);

		lp.clickOK();
		Thread.sleep(2000);
		sp.clickAddSchedule();
		sp.enterSurveyNo();
		sp.enterPlotNo();
		sp.enterHouseNo();
		sp.enterNorth();
		sp.enterEast();
		sp.enterWest();
		sp.enterSouth();
		sp.enterPropAddress();
		Thread.sleep(1000);
		sp.enterSQFT();
		sp.clickSaveButton();
		driver.switchTo().window(currentWindow);		
		}	
        }
		Thread.sleep(2000);
        vp.searchMPR(mprtext);
		Thread.sleep(1000);

        vp.saveMTRid();
	//}
	//catch(Exception e) {
	//	System.out.println("failed");
	//}
		
		
		
	}
	
	@Test(dependsOnMethods = "request")
    @Parameters("controlTowerURL")
	public void ControlTowerAssign(String controlTowerURL) throws InterruptedException {
		driver.get(controlTowerURL);
		String MTR= vp.MTRid;
		vp.searchMTR(MTR);
		Thread.sleep(1000);
		vp.clickSheduleIcon();
		Thread.sleep(2000);
		vp.sheduleCallDetails();
		Thread.sleep(2000);
		vp.assignInspector();
		
	}
	
	
	

}
