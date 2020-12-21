package com.olexyn.about.java.examples;

import java.util.concurrent.atomic.AtomicLong;

public class LongNeo4j {

	public static void main(String args[]) {
		
	    AtomicLong nextFreeId = new AtomicLong( 4294967294l );
		
		
		long ls = 2147483648l;
		long lb = 4294967295l;
		System.out.println("long ls " + ls);
		System.out.println("long lb " + lb);
		System.out.println("int ls " + (int) ls);
		System.out.println("int lb " + (int) lb);
	}
}
