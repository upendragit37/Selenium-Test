package automation_testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class webtable {

	public static void main(String[] args) {
		
//		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver_78.exe");
		System.setProperty("webdriver.ie.driver", "C:\\Users\\HOMEHP\\Downloads\\IEDriverServer_Win32_3.150.1\\IEDriverServer_32_Sel.exe");		// To launch chrome

		InternetExplorerDriver driver = new InternetExplorerDriver();
//		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/WebTable.html");
		
		WebElement nameEle = driver.findElementByXPath("(//i[@class='fa fa-pencil'])[1]");
		String read = nameEle.getText();
		System.out.println(read);
		nameEle.click();
		System.out.println("clicked");
		
	}
}
