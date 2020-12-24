package examples;

import java.util.Scanner;

/**
 * shifts {@code text}  text by {@code key}
 */
public class CaesarCipher {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String out = "";

		System.out.println("insert key:");
		int key = Integer.parseInt(s.nextLine());
		key %= 26;

		System.out.println("insert text:");
		String text = s.nextLine();
		

		int l = text.length();
		for (int i = 0; i < l; i++) {
			char c = text.charAt(i);
			int intC = (int) c;
			intC = (intC - 97 + key) % 26 + 97; // a=97 => a-97=0
			c = (char) intC;
			out += c;
		}
		
		System.out.println(out);
	}
}