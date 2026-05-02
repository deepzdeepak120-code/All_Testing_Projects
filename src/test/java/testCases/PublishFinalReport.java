package testCases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.FormPage;
import pages.LoginPage;
import utils.FileUtil;
import utils.ScreenshotUtil;

public class PublishFinalReport extends BaseTest {
	
	
	LoginPage loginPage;
	 FormPage formPage;
     String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());


   @Test(dataProvider = "idProvider",retryAnalyzer = RetryAnalyzer.class)
   @Parameters({"username", "password"})
   public void testSubmitAction( String id) throws InterruptedException, IOException {
   	try {	
       driver.get("https://legal.maatrum.com/app/mvr/preview?id="+id);
       formPage = new FormPage(driver);
       Thread.sleep(3000);
       formPage.publishFinalReport();
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-success")));
       Reporter.log(message.getText()+" for ID: " + id);
   	}
    catch (Exception ex){
    	Reporter.log(id+" failed"+ex.getMessage());
    	ScreenshotUtil.takeScreenshot(driver, id);
    	throw ex;
    }
     	
   }

   @DataProvider(name = "idProvider")
   public Object[][] idProvider() {
       List<String> ids = FileUtil.readIdsFromTxt("src/test/resources/ids.txt");

       Object[][] data = new Object[ids.size()][1];
       for (int i = 0; i < ids.size(); i++) {
           data[i][0] = ids.get(i);
       }
       return data;
   }
}