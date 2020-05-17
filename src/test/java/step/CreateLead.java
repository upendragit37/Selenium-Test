package step;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateLead {
//	ChromeDriver driver;
	InternetExplorerDriver driver;
	@Given("Open the chromebrowser")
	public void openTheChromebrowser() {
//		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_80.exe");
//		driver = new ChromeDriver();
//		System.setProperty("webdriver.ie.driver", "C:\\Users\\HOMEHP\\Downloads\\IEDriverServer_Win32_3.150.1\\IEDriverServer_32_Sel.exe");		// To launch chrome
		System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer_32_Sel.exe");		
		driver = new InternetExplorerDriver();
	}

	@Given("Maximise the Browser")
	public void maximiseTheBrowser() {
		// To maximize the browser
		driver.manage().window().maximize();
		
	}

	@Given("Set the Implicit Timeouts")
	public void setTheImplicitTimeouts() {
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Given("Load the leaftaps URL")
	public void loadTheLeaftapsURL() {
		driver.get("http://leaftaps.com/opentaps/control/main");
	}

	@Given("Enter the Username as Demosalesmanager")
	public void enterTheUsernameAsDemosalesmanager() {
//		driver.findElementById("username").sendKeys("demosalesmanager");
	    driver.findElementByXPath("//input[@id='username']").sendKeys("demosalesmanager");
	}

	@Given("Enter the Password as crmsfa")
	public void enterThePasswordAsCrmsfa() {
		driver.findElementById("password").sendKeys("crmsfa");
	}

	@When("Click on the Login Button")
	public void clickOnTheLoginButton() {
		driver.findElementByClassName("decorativeSubmit").sendKeys(Keys.SPACE);
	}

	@Then("Verify Login Successful")
	public void verifyLoginSuccessful() {
		System.out.println("Login successful");
	}

	@Then("Click on the CRM\\/SFA")
	public void clickOnTheCRMSFA() {
		driver.findElementByLinkText("CRM/SFA").sendKeys(Keys.ENTER);
	}

	@Then("Click on the CreateLead LinkText")
	public void clickOnTheCreateLeadLinkText() {
		driver.findElementByXPath("//a[text()='Create Lead']").sendKeys(Keys.ENTER);

	}

	@Then("Enter the Companyname as (.*)")
	public void enterTheCompanynameAsTestLeaf(String companyname) {
		driver.findElementById("createLeadForm_companyName").sendKeys(companyname);

	}

	@Then("Enter the Firstname as (.*)")
	public void enterTheFirstnameAsUpendranath(String firstname) {
		driver.findElementById("createLeadForm_firstName").sendKeys(firstname);

	}

	@Then("Enter the Lastname as (.*)")
	public void enterTheLastnameAsM(String lastname) {
		driver.findElementById("createLeadForm_lastName").sendKeys(lastname);

	}

	@When("Click on the CreateLead button")
	public void clickOnTheCreateLeadButton() {
		driver.findElementByXPath("//input[@value='Create Lead']").sendKeys(Keys.ENTER);

	}

	@Then("Verify the name")
	public void verifyTheName() {
		WebElement viewLead_firstName_spElemID = driver.findElementById("viewLead_firstName_sp");
		if(viewLead_firstName_spElemID.getText().equals("Upendranath"))
			System.out.println("The First name is verified to be true as given");
		else
			System.out.println("The First name is false and does not match as given");	
	}

}
