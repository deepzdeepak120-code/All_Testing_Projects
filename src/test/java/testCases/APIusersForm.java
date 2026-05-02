package testCases;


	
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utils.ApiUtils;

	public class APIusersForm {
		/*WebDriver driver;

	    @DataProvider(name = "userData")
	    public Object[][] fetchUserData() throws Exception {
	        List<String[]> credentials = ApiUtils.getAllUserCredentials();
	        Object[][] data = new Object[credentials.size()][2];
	        for (int i = 0; i < credentials.size(); i++) {
	            data[i][0] = credentials.get(i)[0]; // username
	            data[i][1] = credentials.get(i)[1]; // password
	        }
	        return data;
	    }

	    @Test(dataProvider = "userData")
	    public void loginWithMultipleUsers(String username, String password) {
	        LoginPage loginPage = new LoginPage(driver);
	        loginPage.login(username, password);
	        // add your assertions here
	    }*/

}
