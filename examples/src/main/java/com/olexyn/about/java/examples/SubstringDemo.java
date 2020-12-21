package com.olexyn.about.java.examples;


public class SubstringDemo	{
	public static void main(String[] args)	{
		if (args.length != 3)	{
			System.out.println("give 3 arguments");
			System.out.println("String start end");
		}	
		else	{
			System.out.format("%s%n",args[0]);
			String string = args[0];
			int sta = Integer.parseInt(args[1]);
			int end = Integer.parseInt(args[2]);
			String s = args[0].substring(sta, end);
			//
			for (int i=0; i<sta;i++)	{
				System.out.format(" ");
				}
			System.out.format("^");
			//
			if (end-sta-2>0)	{
				System.out.format("");
				for (int i=0; i<(end-sta-2);i++)	{
					System.out.format(" ");
					}
				
			}
			System.out.format("^%n");
			//
			for (int i=0; i<sta;i++)	{
				System.out.format(" ");
				}
			System.out.format("%s%n",s);
		}
	}
}