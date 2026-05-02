package testCases;

import org.testng.annotations.Test;

import pages.ValuationPreviewPage;

public class ValuationFlow extends BaseTest{
	ValuationPreviewPage vf;

	
	
	@Test
	public void valuationCompletion() {
		
		driver.get("https://valuation-uat.maatrum.com/list");
		vf= new ValuationPreviewPage(driver);
		vf.enterMTR();
		vf.MTRClick();

		
		
		
		
		
		
		
		
			}
	

}
