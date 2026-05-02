package testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pages.LoginPage;

public class BaseTest {
	 WebDriver driver;
	LoginPage lp;
	@BeforeClass
	@Parameters({"username", "password"})
	public void setup(String username, String password) throws InterruptedException {
		
		driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://legaldev.maatrum.com/");
//		driver.get("https://admindev.maatrum.com/");
		//driver.get("https://legal.maatrum.com/");
		lp= new LoginPage(driver);
		lp.enterUserName(username);
		lp.enterPassword(password);
		lp.clickLogin();
		Thread.sleep(5000);
				
	}
	
	@AfterClass
	public void teardown() throws InterruptedException {
		
	//driver.quit();
	}
	
	@AfterSuite
	public void archiveReports() throws IOException {
	    String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	    File src = new File("test-output");
	    File dest = new File("reports_archive/test-output_" + timestamp);
	    FileUtils.copyDirectory(src, dest);
	}

}
