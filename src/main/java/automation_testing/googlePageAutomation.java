package automation_testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class googlePageAutomation {

	public static void main(String args[]) {
		System.setProperty("webdriver.ie.driver", "C:\\Users\\HOMEHP\\Downloads\\IEDriverServer_Win32_3.150.1\\IEDriverServer_32_Sel.exe");
//		System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer_32_Sel.exe");
		WebDriver driver = new InternetExplorerDriver();
//		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_80.exe");
//		ChromeDriver driver = new ChromeDriver();
		

		
		driver.manage().window().maximize();  
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("http://www.google.co.in/");
		driver.navigate().to("https://www.google.co.in/");
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("hello google",Keys.ENTER);
		
	}
}
