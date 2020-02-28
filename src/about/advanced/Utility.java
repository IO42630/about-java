package about.advanced;

import java.util.Random;
import java.util.Scanner;

public class Utility {
	
	void randomDemo(){
		Random rand = new Random();
		rand.nextInt(5);// between 0 and 4
	}
	
	void scannerDemo(){
		Scanner scan = new Scanner(System.in);
		//int i = scan.nextInt();
		String s = scan.nextLine();	//?
		System.out.println(s);
	}

	void timeDemo(){
		long t = System.currentTimeMillis();
	}
	
	void generalDemo(){
		// packaage => also possible
		java.util.ArrayList<String> asdf =  new java.util.ArrayList<String>();
		
		/*
		* little endian : small digit first
		* big endian : big digit first
		*
		* jar = zip with structure and path to main
		* 
		* easier to program vm then  commpiler  
		* 
		* variables live only inside {}
		*/
		
		
		
	}
	
	
	// Main - - - - - -
	public static void main(String args[]){
		Utility util = new Utility();
		util.scannerDemo();
	}
}
