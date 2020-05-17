package JavaTestLeafCoding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.Test;

public class FileReading {
	String str = "";
	int i;
	@Test(invocationCount = 6, priority = 2, enabled=false)
	public void readUsingBuffer() throws IOException {
		File file = new File("./sample.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		while ((str = br.readLine()) != null)
			System.out.print(str);
		br.close();

	}
	@Test(invocationCount = 6, priority = 1,enabled=true)
	public void readUsingReader() throws IOException {
		FileReader file = new FileReader("./sample.txt");
		while((i=file.read())!=-1)
			System.out.print((char)i);
		file.close();
		
	}
}
