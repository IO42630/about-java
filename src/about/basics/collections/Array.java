package basics.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Array {
	/* "length"
	 * .length is a final variable
	 * int[][] is an array of arrays,
	 * in int[][] the length of the individual array is variable.
	 * 
	 * "default values"
	 * int 0, double 0.0, char '0', boolean false, Object null 
	 */

	static boolean b;

	public static void main(String[] args) {

		// index starts at 0
		// length starts at 1

		compareArrays();
		int[] a1D = new int[3];			// [0, 0, 0]
		int[] a1D_2 = { 1, 2, 3 };
		a1D = new int[] { 1, 2, 3 };	// a1D = {1,2,3}; -> error



		int[][] a2D = new int[3][2];	// [[0, 0], [0, 0], [0, 0]]
		a2D = new int[3][];				// [null, null, null]
		for (int i = 0; i < a2D.length; i++) {
			a2D[i] = new int[i + 1];	// [[0], [0, 0], [0, 0, 0]]
		}



		int [][][] a3D = new int [2][2][2];	// [[[0, 0], [0, 0]], [[0, 0], [0, 0]]]



		System.out.println(a2D);
		System.out.println(Arrays.toString(a2D));
		System.out.println(Arrays.deepToString(a2D));
		System.out.println(Arrays.asList(new int[]{1,2}));


		int br = Integer.parseInt("a");
		Character c = "a".charAt(0);
		int is = new Integer(2);
		int iss = Integer.parseInt("1");
		Integer integer =  Integer.parseInt("2");
		is = Integer.valueOf("2");

		List<Integer> list = new ArrayList<>();
		list.add(Integer.parseInt("1"));
		list.add(2);


	}


	public static void compareArrays(){

		int[] a = new int[]{1,2,3};
		int[] b = new int[]{3,2,1};

		int c = Arrays.compare(a, b);


		int[] d = {1,2};

		int e = Arrays.compare(new int[]{1}, new int[]{1}); // 0 (same)
		int f = Arrays.compare(new int[]{1}, new int[]{1,1}); // -1 (first is smaller)
		int g = Arrays.compare(new int[]{2}, new int[]{1,1}); // 1 (first is larger)

		int br = 0;
	}
}
