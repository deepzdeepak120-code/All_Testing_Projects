package drivers;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
	
	 public static WebDriver createMobileDriver() {
	       // System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Update path
		 
	        Map<String, String> mobileEmulation = new HashMap<>();
	        mobileEmulation.put("deviceName", "iPhone 14 Pro"); // Emulate iPhone 14

	        ChromeOptions options = new ChromeOptions();
	        options.setExperimentalOption("mobileEmulation", mobileEmulation);

	        return new ChromeDriver(options);
	    }

}
