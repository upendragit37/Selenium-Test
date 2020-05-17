package javaPrograms;

import java.io.IOException;
import java.util.Scanner;

public class NoteDenominationSoloLearn {
	
	public static void main(String args[])throws IOException
	{
		Scanner sc =  new Scanner(System.in);
		int denNotes[] = {2000,500,200,100,50,20,10,5,2,1}; // Storing all the denominations
	    System.out.println("Enter the amount: ");
		int amount=sc.nextInt();
    	int tempAmount=amount;
		int totalNotes=0,count=0;
 
		System.out.println("\nDENOMINATIONS: \n");
 
		for(int i=0;i<denNotes.length;i++)
		{
			count=amount/denNotes[i]; // Counting number of denomination notes
			if(count!=0) //Print the denomination if th5543
			{
				System.out.println(denNotes[i]+"\tx\t"+count+"\t= "+denNotes[i]*count);
			}
			totalNotes=totalNotes+count; //Find total number of notes
			amount=amount%denNotes[i]; //Find the remaining amount whose denomination is to be found
		}
 
		System.out.println("--------------------------------");
		System.out.println("TOTAL\t\t\t= "+tempAmount);
		System.out.println("--------------------------------");
		System.out.println("Total Number of Notes\t= "+totalNotes);
	}

}
