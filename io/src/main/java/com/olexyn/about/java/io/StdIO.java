package com.olexyn.about.java.io;

import java.util.Scanner;

public class StdIO {

	public static void main(String[] args) {
		// Create a Scanner object to read from stdin
		Scanner scanner = new Scanner(System.in);

		// Prompt the user for input
		System.out.print("Enter something: ");

		// Read a line of input from stdin
		String userInput = scanner.nextLine();


		while (scanner.hasNext())

		// Print the input
		System.out.println("You entered: " + userInput);

		// Don't forget to close the scanner when you're done
		scanner.close();
	}
}
