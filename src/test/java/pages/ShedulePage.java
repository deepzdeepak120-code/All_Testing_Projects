package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ShedulePage {
	
        WebDriver driver;
public ShedulePage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver,this);	
	}

	String SurevyNo="198/1A";
	String PlotNo="E5";
	String HouseNo="6/A";
	String North="Tempe";
	String South="Passage";
	String East="Road";
	String West="Mani's Property";
	String PropertyAddress="No.6/A, 6th street, Ariyalur";
	String sqft="1200 sqft";
	

@FindBy (xpath="//div[@class='form-group clearfix margin-top-10 ng-star-inserted']//button[text()=' Add More ']")
WebElement addShedule;

@FindBy(xpath="//textarea[@id='surveyNo_0']")
WebElement surveyNo;

@FindBy(xpath="//textarea[@id='plot_0']")
WebElement plotNo;

@FindBy(xpath="//textarea[@id='house_0']")
WebElement houseNo;

@FindBy(xpath="//textarea[@id='northBy_0']")
WebElement north;

@FindBy(xpath="//textarea[@id='southBy_0']")
WebElement south;

@FindBy(xpath="//textarea[@id='eastBy_0']")
WebElement east;

@FindBy(xpath="//textarea[@id='westBy_0']")
WebElement west;

@FindBy(xpath="//textarea[@id='propertyAddress_0']")
WebElement propAddress1;

@FindBy(xpath="//button[contains(text(),'Unit')]")
WebElement unit;

@FindBy(xpath="//textarea[@id='extent_0']")
WebElement sqFeet;

@FindBy(xpath="//button[text()=' Exact Size']")
WebElement extractSizeButton;

@FindBy(xpath="//button[@class='btn btn-xs btn-info pull-right ml']")
WebElement addMoreSchedule;

@FindBy(xpath="//button[@class='btn sm-btn green-darken ng-tns-c6-0 ng-star-inserted']")
WebElement saveButton;




public void clickAddSchedule() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView(true);", addShedule);
	Assert.assertTrue(addShedule.isDisplayed(), "Add shedule is not displayed.");

	
	addShedule.click();
}

public void enterSurveyNo() {
	
	surveyNo.sendKeys(SurevyNo);
}

public void enterPlotNo() {
	
	plotNo.sendKeys(PlotNo);
}

public void enterHouseNo() {
	
	houseNo.sendKeys(HouseNo);
}

public void enterNorth() {
	north.clear();
	north.sendKeys(North);
}

public void enterEast() {
	east.clear();
	east.sendKeys(East);
}

public void enterWest() {
	west.clear();
	west.sendKeys(West);
}

public void enterSouth() {
	south.clear();
	south.sendKeys(South);
}

public void enterPropAddress() {
	
	propAddress1.sendKeys(PropertyAddress);
}

public void clickUnit() {
	
    unit.click();
}

public void enterSQFT() {
	
	sqFeet.sendKeys(sqft);
}

public void clickExtractSize() {
	
	extractSizeButton.click();
}

public void clickSaveButton() {
	
	saveButton.click();
}























}
