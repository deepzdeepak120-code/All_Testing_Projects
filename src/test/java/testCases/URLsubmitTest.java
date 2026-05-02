package testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.FormPage;
import pages.LoginPage;
import utils.CSVReaderUtil;

import java.util.List;

public class URLsubmitTest extends BaseTest {
	
	LoginPage lp;
	FormPage formPage;

    @Test(dataProvider = "urlProvider")
    @Parameters({"username", "password"})
    public void testSubmitAction(String url, String username, String password) throws InterruptedException {
    	
    	driver.get("https://legaldev.maatrum.com/");
		lp= new LoginPage(driver);
		lp.enterUserName(username);
		lp.enterPassword(password);
		lp.clickLogin();
		Thread.sleep(3000);
		
        driver.get("https://legaldev.maatrum.com/app/mvr/preview?id=" + url);
        formPage = new FormPage(driver);
        Thread.sleep(2000);
         formPage.publishFinalReport();
        
    }

    @DataProvider(name = "urlProvider")
    public Object[][] urlProvider() {
        String filePath = "src/test/resources/urls.csv";
        List<String> urls = CSVReaderUtil.getUrlsFromCSV(filePath);
        Object[][] data = new Object[urls.size()][1];
        for (int i = 0; i < urls.size(); i++) {
            data[i][0] = urls.get(i);
        }
        return data;
    }
}