package Automation_Erail;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.metal.MetalBorders.TableHeaderBorder;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ErailTable {

	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_81.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("https://erail.in/");
		WebElement Frmst = driver.findElement(By.xpath("//input[@id='txtStationFrom']"));
		Frmst.clear();
		// Thread.sleep(1000);
		Frmst.sendKeys("MAS", Keys.TAB);

		WebElement Tost = driver.findElement(By.xpath("//input[@id='txtStationTo']"));
		Tost.clear();
		Tost.sendKeys("SA", Keys.TAB);

		driver.findElement(By.id("buttonFromTo")).click();

		WebElement TableRowCount = driver.findElement(By.xpath("(//div[@id='divTrainsList']//table)[1]")); // divTrainsList
		List<WebElement> RowCount = TableRowCount.findElements(By.tagName("tr"));
		int size = RowCount.size();
		System.out.println("No.of Rows :" + size);

		WebElement webElement = RowCount.get(0);
		List<WebElement> findElements = webElement.findElements(By.tagName("td"));
		int size2 = findElements.size();
		System.out.println("No. of Columns :" + size2);

		String[] trainname = new String[size];
		String TrainName = "NILAGIRI EXP";// "DHN ALAPPUZHA E";

		try {
			for (int i = 0; i < size; i++) {

				WebElement OneRowTakenElem = RowCount.get(i);

				if (OneRowTakenElem.getText().contains("Below trains not departing on"))
					System.err.println("Row: " + i + "\t--->" + OneRowTakenElem.getText());

				else {
					WebElement TrainNameEle = OneRowTakenElem.findElements(By.tagName("td")).get(1);
					System.out.println("Row: " + i + "\t--->" + TrainNameEle.getText());
					trainname[i] = TrainNameEle.getText();
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		for (int i = 0; i < size; i++) {

			if (TrainName.equals(trainname[i])) {
				System.out.println(trainname[i] + "  is available");
				break;
			}
		}

		Thread.sleep(3000);
		driver.quit();

	}

}
