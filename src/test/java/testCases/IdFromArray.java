package testCases;

import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.FormPage;
import pages.LoginPage;
//import utils.CSVReaderUtil;
import utils.DataUtils;

public class IdFromArray extends BaseTest{

	LoginPage lp;
	FormPage formPage;

    @Test(dataProvider = "idProvider")
    @Parameters({"username", "password"})
    public void testSubmitAction(String id, String username, String password) throws InterruptedException {
    	
    try {	
    	driver.get("https://legaldev.maatrum.com/");
		lp= new LoginPage(driver);
		lp.enterUserName(username);
		lp.enterPassword(password);
		lp.clickLogin();
		Thread.sleep(3000);
		
        driver.get("https://legaldev.maatrum.com/app/mvr/preview?id=" + id);
        formPage = new FormPage(driver);
        Thread.sleep(2000);
        formPage.publishFinalReport();
        Thread.sleep(3000);
        System.out.println("Report is published");
        
    }
    catch (Exception ex){
    	System.out.println(id+"fail");
    }
   
    }

    @DataProvider(name = "idProvider")
    public Object[][] idProvider() {
        List<String> ids = DataUtils.getIdList(); // ← from your ArrayList source

        Object[][] data = new Object[ids.size()][1];
        for (int i = 0; i < ids.size(); i++) {
            data[i][0] = ids.get(i);
        }
        return data;
    }
}
