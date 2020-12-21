package com.olexyn.about.java.examples;

public class TextSquare{
	public static void main(String[] args) {
		//
		String in = args[0];
		int l = in.length();
		String out = "";
		/**
		*"for" of the line count
		*i	line count, starts at 0
		*/ 
		for (int i=0;i<l;i++)	{
			/**
			*"for" of the chars before the main diagonal
			*j  cursor position in line, starts at 0
			*main diagonal at l-i is included in this for
			*action:	shift char by i
			*/
			for (int j=0; j<l-i;j++)	{
				out = ""+ in.charAt(j+i);
				System.out.format("%s ",out);
			}
			/**
			*"for" of the chars after the main diagonal
			*j cursor position after main diagonal, restarts at 0
			*l-2: 	first char to be mirrored (e.g. U in LINUX)
			*action:	as j grows, the cursor travels backwards in the string in
			*/
			for (int j=0;j<i;j++)	{
				out = ""+ in.charAt(l-2-j);
				System.out.format("%s ",out);
			}
			System.out.format("%n");
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		