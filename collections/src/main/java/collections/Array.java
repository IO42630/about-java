package collections;

import java.util.Arrays;

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
    static int i;

    static int[] a1D;
    static int[][] a2D;
    static int[][][] a3D;

    public static void main(String[] args) {

        methods();
        // index starts at 0
        // length starts at 1

        compareArrays();
        a1D = new int[3];            // [0, 0, 0]


        // anonymous array, type and size are deduced.
        int[] a1D_local = {1, 2, 3};  // only allowed when declaring
        // a1D = {1,2,3};				// cErr


        a1D = new int[]{1, 2};
        a2D = new int[3][2];        // [[0, 0], [0, 0], [0, 0]]
        a2D = new int[3][];            // [null, null, null]
        a3D = new int[2][2][2];    // [[[0, 0], [0, 0]], [[0, 0], [0, 0]]]


        System.out.println(a2D);
        System.out.println(Arrays.toString(a2D));
        System.out.println(Arrays.deepToString(a2D));
        System.out.println(Arrays.asList(new int[]{1, 2}));


    }


    static void legalDeclarations() {
        int[] n1;
        int[] n2;
        int n3[];
        int n4[]; // are all legal


    }


    public static void compareArrays() {

        i = Arrays.compare(new int[]{1}, new int[]{1}); // 0 (same)
        i = Arrays.compare(new int[]{1}, new int[]{1, 1}); // -1 (first is smaller)
        i = Arrays.compare(new int[]{2}, new int[]{1, 1}); // 1 (first is larger)
    }



    static void special(){

		int[] a, b; // two int arrays
		int c[], d; // c is array , d is just int , deal with it.

		String[] stringS = { "stringValue" };
		Object[] objectS = stringS;
		String[] againStringS = (String[]) objectS;
        objectS[0] = new StringBuilder(); // rErr

		int e = new int[4].length; // .length is not a method

	}


	static void methods(){
        int i[] = new int[]{3,2,1};
        Arrays.sort(i); // i = {1,2,3}

        int pos = Arrays.binarySearch(i, 4); // searches a sorted array and returns theh index of a match
        // if no match is found, it negates the position where the element would need to be inserted and sutracts 1
        boolean b = (pos == -4);
        Arrays.mismatch(i,i); // checks wether two arrays are equivalent
    }
}
