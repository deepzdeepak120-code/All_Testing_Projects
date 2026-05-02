package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ConfigReader;
 




// Create a request 
public class CreateRequestPage {

	WebDriver driver;
	WebDriverWait wait;

	public CreateRequestPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		PageFactory.initElements(driver, this);
	}

	// ---------- Text inputs ----------
	@FindBy(id = "applicationNumber")  
	WebElement applicationNumber;
	@FindBy(id = "applicantName")  
	WebElement applicantName;
	@FindBy(id = "applicantPhoneNumber")
	WebElement applicantPhoneNumber;
	@FindBy(id = "ownerName")  
	WebElement ownerName;
	@FindBy(id = "docNumber")  
	WebElement docNumber;
	@FindBy(id = "docYear")  
	WebElement docYear;
	@FindBy(id = "ecStreetName")
	WebElement streetName;
	@FindBy(id = "address")              
	WebElement address;

	@FindBy(xpath = "//textarea[@placeholder='Comments']")
	WebElement comments;

	@FindBy(xpath = "//input[@type='file']")
	WebElement fileInput; 
	
	@FindBy(xpath ="//textarea[@id='app-valuation-address']") 
	WebElement PostalAddressoftheProperty; 
	
	@FindBy(xpath="//input[@id='app-valuation-phone-number']") 
	WebElement ApplicantMobileNumber;  
	
	
	@FindBy(xpath="//button[.//span[normalize-space()='Create Request'] or normalize-space()='Create Request']")
	WebElement CreateRequestButton;
	
	
	
	
	
	// ==================================================================
	//  Public entry point: fillForm
	// ==================================================================
	public void fillForm(ConfigReader data) {

		// ---- Request Details ----
		setToggle("Valuation", yes(data.getValue("valuation")));
		typeText(applicationNumber,    data.getValue("applicationNumber"));
		typeText(applicantName,        data.getValue("applicantName"));
		typeText(applicantPhoneNumber, data.getValue("applicantPhoneNumberPayment"));
		selectReactDropdown("Branch",     data.getValue("branch"));
		selectReactDropdown("Case Type",  data.getValue("caseType"));

		// ---- Policy Details (section may not exist for every client) ----
		selectPolicy(data.getValue("policyType"));

		// ---- Property Details ----
		typeText(ownerName, data.getValue("ownerName"));
		setToggle("Is Document Number Available?", yes(data.getValue("isDocumentNumberAvailable")));
		typeText(docNumber, data.getValue("docNumber"));
		typeText(docYear,   data.getValue("docYear")); 
		typeText(PostalAddressoftheProperty, data.getValue("PostalAddress"));
		typeText(ApplicantMobileNumber, data.getValue("ApplicantMobile"));

		// State is typically auto-filled / disabled, so select only if enabled
		selectReactDropdownIfEnabled("State", data.getValue("state"));
		selectReactDropdown("SRO",            data.getValue("sro"));
		selectReactDropdown("Village",        data.getValue("village"));

		typeText(streetName, data.getValue("streetName"));
		typeText(address,    data.getValue("address"));

		// ---- Additional Information ----
		selectYesNo("Is this a purchase case",        data.getValue("purchaseCase"));
		selectYesNo("Is this a balance transfer case", data.getValue("balanceTransferCase"));
		selectYesNo("Is this a top-up case",          data.getValue("topUpCase"));
		selectYesNo("Are there multiple schedules",   data.getValue("multipleSchedules"));
		selectYesNo("Does this property have a building", data.getValue("hasBuilding"));  
		
		
		
		// ---- Documents (skip first input — that's the default; upload to row 2 onwards) ----
		uploadAllDocuments(data.getValue("documentPath"));

		// ---- Comments ----
		typeText(comments, data.getValue("comments"));
	}

	// ==================================================================
	//  Reusable field helpers
	// ==================================================================
	private void typeText(WebElement field, String value) {
		if (value == null) return;
		value = value.trim();
		if (value.isEmpty()) return;
		try {
			new WebDriverWait(driver, Duration.ofSeconds(3))
				.until(ExpectedConditions.visibilityOf(field));
			field.clear();
			field.sendKeys(value);
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println("Skipping field — not present for this client");
		}
	}

	private void selectReactDropdown(String labelText, String optionText) {
	    if (optionText == null) {
	        System.out.println("Skipping " + labelText);
	        return;
	    }
	    optionText = optionText.trim();
	    if (optionText.isEmpty()) {
	        System.out.println("Skipping " + labelText);
	        return;
	    }

	    System.out.println("Selecting: " + labelText + " -> " + optionText);

	    // Step 1: Find the placeholder by its visible text, then walk UP to
	    // the actual react-select control wrapper. React-select listens to
	    // mousedown (not click), so we use Actions to fire real mouse events.
	    By controlLocator = By.xpath(
	        "//div[contains(@class,'custom-dropdown__placeholder')]" +
	        "//div[normalize-space()='Select " + labelText + "']" +
	        "/ancestor::div[contains(@class,'custom-dropdown__control')][1]"
	    );

	    // If this dropdown isn't on the page for the current client, skip silently.
	    if (driver.findElements(controlLocator).isEmpty()) {
	        System.out.println("Skipping dropdown — not present for this client: " + labelText);
	        return;
	    }

	    WebElement control = wait.until(ExpectedConditions.elementToBeClickable(controlLocator));

	    ((JavascriptExecutor) driver).executeScript(
	        "arguments[0].scrollIntoView({block:'center'});", control
	    );

	    new Actions(driver).moveToElement(control).click().perform();

	    // Step 2: Wait for dropdown options. If the click was swallowed by a
	    // re-render/overlay (seen on cascade fields like SRO), fall back to
	    // the keyboard path: focus the hidden input + ARROW_DOWN, which
	    // react-select handles natively to open the menu.
	    By listbox = By.xpath("//div[@role='listbox']");
	    try {
	        new WebDriverWait(driver, Duration.ofSeconds(2))
	            .until(ExpectedConditions.visibilityOfElementLocated(listbox));
	    } catch (TimeoutException e) {
	        System.out.println(labelText + ": click didn't open menu, trying keyboard fallback");
	        WebElement input = control.findElement(By.cssSelector("input"));
	        input.sendKeys(Keys.ARROW_DOWN);
	        wait.until(ExpectedConditions.visibilityOfElementLocated(listbox));
	    }

	    // Step 3: Select option
	    By optionLocator = By.xpath(
	        "//div[@role='option']//span[normalize-space()='" + optionText + "']"
	    );

	    WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
	    option.click();
	}
		
	
	
		
	private void selectReactDropdownIfEnabled(String labelText, String optionText) {
		By controlLocator = By.xpath(
			"//div[contains(@class,'custom-dropdown__placeholder')]" +
			"//div[normalize-space()='Select " + labelText + "']");

		// If the "Select <Label>" placeholder isn't present, the field is already filled or disabled — skip
		if (driver.findElements(controlLocator).isEmpty()) {
			System.out.println(labelText + " dropdown is already filled or disabled — skipping.");
			return;
		}
		selectReactDropdown(labelText, optionText);
	}

	private void setToggle(String labelText, boolean turnOn) {
		By toggleLocator = By.xpath(
			"//div[normalize-space(text())='" + labelText + "']" +
			"/ancestor::div[contains(@class,'bg-[#f2f0e8]')]" +
			"//div[contains(@class,'cursor-pointer') and contains(@class,'rounded-full')]");

		// Toggle may not exist for this client — skip silently if so.
		if (driver.findElements(toggleLocator).isEmpty()) {
			System.out.println("Skipping toggle — not present for this client: " + labelText);
			return;
		}

		try {
			WebElement toggle = new WebDriverWait(driver, Duration.ofSeconds(3))
				.until(ExpectedConditions.elementToBeClickable(toggleLocator));
			String style = toggle.getAttribute("style");
			boolean isOn = style != null && style.contains("55, 93, 251");

			if (isOn != turnOn) {
				toggle.click();
			}
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println("Skipping toggle — not clickable for this client: " + labelText);
		}
	}

	private void selectYesNo(String question, String answer) {
		if (answer == null) return;
		answer = answer.trim();
		if (answer.isEmpty()) return;

		By btnLocator = By.xpath(
			"//label[contains(normalize-space(.), '" + question + "')]" +
			"/following-sibling::div[1]" +
			"//button[.//span[normalize-space()='" + answer + "']]");

		// Question may not be present for this client — skip silently.
		if (driver.findElements(btnLocator).isEmpty()) {
			System.out.println("Skipping Yes/No — not present for this client: " + question);
			return;
		}

		System.out.println("Selecting Yes/No: " + question + " -> " + answer);

		try {
			WebElement btn = new WebDriverWait(driver, Duration.ofSeconds(3))
				.until(ExpectedConditions.elementToBeClickable(btnLocator));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", btn);
			btn.click();
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println("Skipping Yes/No — not clickable for this client: " + question);
		}
	}

//	private void uploadDocument(String absolutePath) {
//		fileInput.sendKeys(absolutePath);
//	}

	private boolean yes(String value) {
		return value != null && value.trim().equalsIgnoreCase("Yes");
	}

	private void uploadAllDocuments(String filePath) {
		if (filePath == null) return;
		filePath = filePath.trim();
		if (filePath.isEmpty()) return;

		java.util.List<WebElement> fileInputs = driver.findElements(By.xpath("//input[@type='file']"));

		// First input is the page-default upload — never touch it.
		// We need at least 2 inputs (default + 1 row) to do any work.
		if (fileInputs.size() < 2) {
			System.out.println("Skipping documents — no upload rows present for this client (found " + fileInputs.size() + " file input(s))");
			return;
		}

		for (int i = 1; i < fileInputs.size(); i++) {
			try {
				fileInputs.get(i).sendKeys(filePath);
				System.out.println("Uploaded document to row " + i + ": " + filePath);
			} catch (Exception e) {
				System.out.println("Failed to upload to row " + i + ": " + e.getMessage());
			}
		}
	}

	private void selectPolicy(String policyName) {
		if (policyName == null) return;
		policyName = policyName.trim();
		if (policyName.isEmpty()) return;

		// Section-level check: skip silently if "Policy Details" isn't on the page for this client.
		By containerLocator = By.xpath("//h6[normalize-space()='Policy Details']");
		if (driver.findElements(containerLocator).isEmpty()) {
			System.out.println("Skipping Policy Details — not present for this client");
			return;
		}

		By policyLocator = By.xpath(
			"(//h6[normalize-space()='Policy Details']/following::div[normalize-space()='"
			+ policyName + "'])[1]");

		try {
			WebElement policy = new WebDriverWait(driver, Duration.ofSeconds(5))
				.until(ExpectedConditions.elementToBeClickable(policyLocator));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", policy);
			policy.click();
			System.out.println("Selected Policy: " + policyName);
		} catch (TimeoutException | NoSuchElementException e) {
			System.out.println("Policy not clickable / not found: " + policyName);
		}
	}       
	
	
	
	public void ClickCreateRequestButton() throws InterruptedException {
		String urlBefore = driver.getCurrentUrl();

		Thread.sleep(10000);

		enumerateCreateRequestButtons();

		WebElement btn = wait.until(ExpectedConditions.elementToBeClickable(CreateRequestButton));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", btn);

		System.out.println("Picked button -> tag=" + btn.getTagName()
			+ " | enabled=" + btn.isEnabled()
			+ " | type=" + btn.getAttribute("type")
			+ " | aria-disabled=" + btn.getAttribute("aria-disabled")
			+ " | disabled=" + btn.getAttribute("disabled")
			+ " | class=" + btn.getAttribute("class"));

		try {
			btn.click();
		} catch (Exception e) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
		}

		try {
			new WebDriverWait(driver, Duration.ofSeconds(15))
				.until(ExpectedConditions.not(ExpectedConditions.urlToBe(urlBefore)));
			System.out.println("Create Request submitted — URL changed to: " + driver.getCurrentUrl());
		} catch (TimeoutException te) {
			logValidationErrors();
			throw new AssertionError(
				"Create Request click did not trigger a navigation. URL still: " + urlBefore);
		}
	}

	private void enumerateCreateRequestButtons() {
		java.util.List<WebElement> all = driver.findElements(By.xpath(
			"//button[.//span[normalize-space()='Create Request'] or normalize-space()='Create Request']"));
		System.out.println("---- Found " + all.size() + " 'Create Request' button(s) on page ----");
		int i = 0;
		for (WebElement b : all) {
			i++;
			try {
				System.out.println("  [" + i + "] displayed=" + b.isDisplayed()
					+ " | enabled=" + b.isEnabled()
					+ " | type=" + b.getAttribute("type")
					+ " | aria-disabled=" + b.getAttribute("aria-disabled")
					+ " | disabled=" + b.getAttribute("disabled")
					+ " | class=" + b.getAttribute("class")
					+ " | text='" + b.getText().trim() + "'");
			} catch (Exception ex) {
				System.out.println("  [" + i + "] (stale or unreadable: " + ex.getMessage() + ")");
			}
		}
		System.out.println("-------------------------------------------------");
	}

	private void logValidationErrors() {
		String[] errorXpaths = {
			"//*[contains(@class,'error') or contains(@class,'Error')]",
			"//*[contains(@class,'text-red') or contains(@class,'text-danger')]",
			"//*[@role='alert']",
			"//small[contains(@class,'invalid')]",
			"//p[contains(@class,'error')]"
		};
		System.out.println("---- Validation messages on page ----");
		java.util.Set<String> seen = new java.util.HashSet<>();
		for (String xp : errorXpaths) {
			for (WebElement el : driver.findElements(By.xpath(xp))) {
				try {
					if (!el.isDisplayed()) continue;
					String txt = el.getText().trim();
					if (!txt.isEmpty() && seen.add(txt)) {
						System.out.println("  • " + txt);
					}
				} catch (Exception ignored) {}
			}
		}
		if (seen.isEmpty()) {
			System.out.println("  (no visible validation messages found — button may be a wrong match, or errors use a non-standard class)");
		}
		System.out.println("-------------------------------------");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	  
	
	
}  

