package Automation_Erail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Erail {

	
	public static void main(String args[]) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_80.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		WebElement fromStatElem = driver.findElementById("txtStationFrom");
		fromStatElem.clear();
		fromStatElem.sendKeys("MSB",Keys.TAB);
		
		WebElement toStatElem = driver.findElementById("txtStationTo");
		toStatElem.clear();
		toStatElem.sendKeys("SA", Keys.TAB);
		driver.findElementById("buttonFromTo").click();
		
		List<WebElement> tableHeaderElem = driver.findElementsByXPath("//div[@id='divTrainsListHeader']//table//tr");
		
		//System.err.println(tableHeaderElem.get(0).getText());
		
		WebElement TableRowCount = driver.findElement(By.xpath("(//div[@id='divTrainsList']//table)[1]")); // divTrainsList
		List<WebElement> allRowElem = TableRowCount.findElements(By.tagName("tr"));
		for (WebElement aRowElem : allRowElem) {
			System.out.println(aRowElem.getText());
		}
		
		Thread.sleep(10000);
		driver.quit();
	}
}
