package javaPrograms;

public class splitStringFunc {

	public static void main(String[] args) {
		
		String var1="", var2="", var3="";
		String text ="Name:Lokesh, Age:20, City:Chennai";   
		
		//Splitting using Regular Expression
		String[] strArray = text.split("[:, ]");    
		System.out.println(strArray.length);
		
		for(String str : strArray){
	        System.out.println(str);    
		}
		
		
		
		for(int i=0; i<strArray.length;i++){
			if(strArray[i].contains("Name")) {
				var1 = strArray[i+1];
				System.out.println("\nvar1 = " + var1);
			}
			
		    if(strArray[i].contains("Age")) {
				var2 = strArray[i+1];
				System.out.println("var2 = " + var2);
			}
			
			if(strArray[i].contains("City")) {
				var3 = strArray[i+1];
				System.out.println("var3 = " + var3);
			}
			
		}
	}
}
