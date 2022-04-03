package examples;


/* 
i probably forgot to click the final "save your file" button 
on the submission interface, 
and you didn't receive my AsciiArt.java .
i'm attaching it to RepRemover.java and hope 
you would still like to review it.
best regards
*/
//c		arguments count
//s		string
//l		string length
//p		cursor position
//c0,c1	cursor char values
public class RepRemover {
	public static void main(String[] args) {
		String s="";
		int c = args.length;
		for (int i=0; i<c; i++)	{s += args[i] +" ";}	
		//unfortunately ; | ' still wreck the program :(
		//didn't find a way to force input as one string yet.
		int l = s.length();
		String out = "" + s.charAt(0);
		for (int p=0;p<l-1;p++)	{	
			char c0 = s.charAt(p);
			char c1 = s.charAt(p+1);
			if (c0 != c1)	{out = out + c1;}
		}
    	System.out.format("%s%n",out);
	} 
}
/*
public class AsciiArt {
	public static void main(String[] args) {
		int h = Integer.parseInt(args[0]);//high
		int l = Integer.parseInt(args[1]);//large
		int n = Integer.parseInt(args[2]);//numerous
		//
		for (int c=0;c<n;c++){//count
			for (int j=1; j<=l;j++){
				for (int i=1; i<=j*h/l;i++){
					System.out.format("#");
				}
				System.out.format("%n");
			}
			for (int j=1; j<l;j++){
				for (int i=1; i<=h-(j*h/l);i++){
					System.out.format("#");
				}
				System.out.format("%n");
			}
		}
	}
}
*/
