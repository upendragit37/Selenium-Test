package Automation_Erail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.metal.MetalBorders.TableHeaderBorder;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ErailTableAnnaCode {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_81.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://erail.in/");
		WebElement Frmst = driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
		Frmst.clear();
		Frmst.sendKeys("MAS", Keys.TAB);

		WebElement Tost = driver.findElement(By.xpath("//input[@id='txtStationTo']"));
		Tost.clear();
		Tost.sendKeys("SA", Keys.TAB);

		driver.findElement(By.id("buttonFromTo")).click();

		WebElement TableRowCount = driver.findElement(By.id("divTrainsList")); // divTrainsList
		List<WebElement> RowCount = TableRowCount.findElements(By.tagName("tr"));
		int size = RowCount.size();
		System.out.println("No.of Rows :" + size);

		WebElement webElement = RowCount.get(0);
		List<WebElement> findElements = webElement.findElements(By.tagName("td"));
		int size2 = findElements.size();
		System.out.println("No. of Columns :" + size2);

		String trainname[] = new String[size];
		for (int i = 0; i < size; i++) {
			
			WebElement webElement2 = RowCount.get(i);

			if (webElement2.getText().contains("Below trains not departing on"))
				System.err.println("Row: " + i + "\t--->" + webElement2.getText());

			else {
				WebElement TrainNameEle = webElement2.findElements(By.tagName("td")).get(1);
				trainname[i] = TrainNameEle.getText();
				String TrainName = "DHN ALAPPUZHA E";

				if (trainname[i].equals(TrainName)) {
					System.out.println("Train Name is : " + trainname[i]);

				}
			}
		}

		driver.quit();
	}

}
