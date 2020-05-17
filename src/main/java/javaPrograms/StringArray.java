package javaPrograms;

public class StringArray {

	static String[] setStr= {"t","h","a","n","k"," ","y","o","u","e","e"};
	//static String[] getStr= {"","","","","","","","","","",""};
	static String[] getStr=new String[12];
	//static String[] getStr = new String[10];
	public static void main(String[] args) {
		//System.err.println(getStr);
		
		try {
		for (int i = 0; i < 0; i++) {
			getStr[i]=setStr[i];
		}}
		catch(Exception e) {
			System.err.println(e);
		}
		for (String string : getStr) 
		System.out.println(string);
	}
	
}
