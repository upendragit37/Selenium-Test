package automation_testing;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import testng.api.base.Color;
//import testng.api.base.ConsoleColors;

public class Leafgrounds_table {
	static int columns_count;
	static int rows_count;
	static List<Integer> listObj;
	static Map<Integer, Integer> obj;
	static List<WebElement> Columns_row;
	static List<WebElement> rows_table;
	static WebElement tableElem;
	static String Progress[];
	static int minRow;

	public static void main(String args[]) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_80.exe");
		ChromeDriver driver = new ChromeDriver();
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("http://www.leafground.com");
//		driver.navigate().to("www.leafground.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElementByXPath("//img[@alt='Table']").click();
		
		// Getting the table
		tableElem = driver.findElementById("table_id");

		// Getting all the rows in the table
		rows_table = tableElem.findElements(By.tagName("tr"));
		rows_count = rows_table.size();

		for (int row = 0; row < rows_count; row++) {

			// Getting all the data in a particular row
			Columns_row = rows_table.get(row).findElements(By.tagName("td"));
			columns_count = Columns_row.size();
		}
		// 1. Get the count of number of columns
		System.out.println("1. The Count of Columns is :" + columns_count);

		// 2. Get the count of number of rows
		System.out.println("2. The Count of Rows is :" + rows_count);

		// 3. Get the progress value of 'Learn to interact with Elements'
		System.out.println("3. The Progress value of 'Learn to interact with Elements'");
		List<WebElement> row2Datas = rows_table.get(2).findElements(By.tagName("td"));
		WebElement index0Data = row2Datas.get(1);
		System.out.println(index0Data.getText());

		// 4. Check the vital task for the least completed progress.
		System.out.println("4. Check the vital task for the least completed progress");
		Progress = new String[rows_count - 1];
		for (int i = 1; i < rows_count; i++) {
			List<WebElement> specificRows = rows_table.get(i).findElements(By.tagName("td"));
			System.out.println(specificRows.get(1).getText());
			String temp = specificRows.get(1).getText();
			Progress[i - 1] = temp;
		}
		System.out.println("-----Progress result-----");
		for (String print : Progress)
			System.out.println(print);

		int count = 1, min;
		obj = new LinkedHashMap<Integer, Integer>();
		listObj = new ArrayList<Integer>();

		System.out.println("-----Replace % with nothing-----");
		for (String fetch : Progress) {
			String replace = fetch.replace("%", "");
			//System.out.println(replace);
			int a = Integer.parseInt(replace);
			obj.put(count, a);
			count++;
		}

		System.out.println("-----LinkedHashMap-----");
		System.out.println("Printing LinkedHashMap Obj: " + obj);
		Set<Entry<Integer, Integer>> mappings = obj.entrySet();
		for (Entry<Integer, Integer> mapping : mappings) {
			System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
			listObj.add(mapping.getValue());
		}

		System.out.println();
		// Finding Minimum
		min = listObj.get(0);
		for (int i = 0; i < listObj.size(); i++) {
			System.out.println("Getting oneByOne ListObj: " + listObj.get(i));
			if (listObj.get(i) < min) {
				min = listObj.get(i);
			}
		}
		System.out.println("\n" + "Minimum value is:" + min);

		for (Entry<Integer, Integer> mapping : mappings) {
			if (mapping.getValue() == min)
				minRow = mapping.getValue();
		}

		List<WebElement> specificRows = rows_table.get(minRow).findElements(By.tagName("td"));
		WebElement webElement = specificRows.get(2);
		WebElement findElement = webElement.findElement(By.tagName("input"));
		boolean selected = findElement.isSelected();
		if (selected != true)
			findElement.click();
	}
}
