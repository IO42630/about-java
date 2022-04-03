package com.olexyn.about.java.other.advanced;

import java.util.logging.*;

public class Logging {
	private static Logger theLogger = Logger.getLogger(" HelloLogging ");

	public static void main(String argv[]) {
		theLogger.setLevel(Level.ALL);
		theLogger.fine("Program started ");
		theLogger.info("This app uses java. util .logging");
		theLogger.warning("Oops, I did it again");
	}
}
