package testCases;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTestMob {

	
	  WebDriver driver;

	    @BeforeMethod
	    public void setup() {
	    	
	    	Map<String, Object> deviceMetrics = new HashMap<>();
	        deviceMetrics.put("width", 280);        // Small mobile width
	        deviceMetrics.put("height", 500);       // Small mobile height
	        deviceMetrics.put("pixelRatio", 1.0);

	        Map<String, Object> mobileEmulation = new HashMap<>();
	        mobileEmulation.put("deviceMetrics", deviceMetrics);
	        mobileEmulation.put("userAgent", "Mozilla/5.0 (iPhone; CPU iPhone OS 16_0 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/16.0 Mobile/15E148 Safari/604.1");

	        ChromeOptions options = new ChromeOptions();
	        options.setExperimentalOption("mobileEmulation", mobileEmulation);

		     driver=new ChromeDriver(options);
	        driver.get("https://site-inspection-uat.maatrum.com/register");
	        
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	    }

	    @AfterMethod
	    public void teardown() {
	        if (driver != null) {
	            //driver.quit();
	        }
	    }
}
