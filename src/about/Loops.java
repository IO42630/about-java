

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Loops {
	public static void main(String[] args) {


		incrementTest();
		int[][] a = new int[3][3];
		a[0][1] = 1;

		for (int[] a1 : a) {
		}

		for (int i = 0; i < 10; i++) {
			// initialization => condition => code => increment
		}

		String[] words = {"hello", "this", "is", "bot"};

		for (String w: words){

        }


		int b = 0;

		while (b == 0) {// check then do
		}

		do {// do once then check
		} while (b == 0);





	}

	static void incrementTest(){
		for (int i=0;i<3;i++){
			System.out.println(i);
		}
		System.out.println("-----");
		for (int i=0;i<3;++i){
			System.out.println(i);
		}
	}




	static void forTest(){

		int x = 0;
		for (long y=0, z=4; x<5 && y < 10 ; x++ , y++)
			System.out.print(x+ " ");
		System.out.print(x);
		// will print: "0 1 2 3 4 5"


		// enhanced for loop
		// either array or Object of type Iterable

		String[] array = new String[3];
		for (String entry : array){
			entry = "foo";
		}
		// equiv to
		for (int i=0; i<array.length;i++){
			String entry = array[i];
			entry = "foo";
		}

		List<String> list = new ArrayList<String>();
		for (String entry : list){
			entry = "foo";
		}
		// equiv to
		for (Iterator<String> i = list.iterator(); i.hasNext();){
			String entry = i.next();
			entry = "foo";
		}

		Object obj = "String";
		int i = 3;
		obj = 3;
		obj = i;

		for (Object object : list){

		}

	}


	static void breakTest(){

		List<String> list = new ArrayList<>();
		label : for (String entry : list){
			for (String foo :list){
				break label;
				//int i = 0; // DOES NOT COMPILE
			}
		}
	}



}
