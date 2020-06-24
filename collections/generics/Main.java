package generics;

import java.util.EmptyStackException;
import java.util.ArrayList;
import java.util.List;


public class Main {







	public static void main(String[] args) {


		Dispenser<String> testMyStack = new MyStack<>();
		Dispenser<String> testMyQueue = new MyQueue<>();

		List<Dispenser<String>> dispensers = new ArrayList<>();
		dispensers.add(testMyStack);
		dispensers.add(testMyQueue);





		for (Dispenser<String> d : dispensers) {


			System.out.println("TESTING : " + d);

			try {
				d.put("BLOCK1");
				d.put("BLOCK2");
				d.put("BLOCK3");
				d.print();
				d.remove();
				System.out.println("REMOVED 1 ITEM");
				d.print();
			} catch (EmptyStackException eErr) {
				System.out.println("NOTHING LEFT TO REMOVE : EXIT");
			} catch (StackOverflowError sErr) {
				System.out.println("NO SPACE LEFT : EXIT");
			}

			System.out.println(" ");
		}

	}
}
