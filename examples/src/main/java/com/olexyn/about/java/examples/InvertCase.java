
package com.olexyn.about.java.examples;



public class InvertCase {
	public static String invertCase(String s)	{
		String result = "";
		//
		int l = s.length();
		for (int i=0;i<l;i++)	{
			char c = s.charAt(i);
			int ci = (int)c;
			if (95-ci<0)	{
				ci=ci-32;
			}
			else {
				ci=ci+32;
			}
			c= (char)ci;
			result = result + c;
		}
		return result;
	}
	public static void main(String[] args)	{
		for (int i=0; i<args.length; i++)	{
			System.out.println(invertCase(args[i]));
		}
	}
}