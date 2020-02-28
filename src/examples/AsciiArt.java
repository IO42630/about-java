package examples;

public class AsciiArt {
	public static void main(String[] args) {
		/*
		 *
		 */

		int h = 31;// high
		int l = 4;// large
		int n = 4;// numerous
		//
		for (int c = 0; c < n; c++) {// count
			for (int j = 1; j <= l; j++) {
				for (int i = 1; i <= j * h / l; i++) {
					System.out.format("#");
				}
				System.out.format("%n");
			}
			for (int j = 1; j < l; j++) {
				for (int i = 1; i <= h - (j * h / l); i++) {
					System.out.format("#");
				}
				System.out.format("%n");
			}
		}
	}
}