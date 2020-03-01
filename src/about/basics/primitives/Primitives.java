package about.basics.primitives;



public class Primitives {
	

	 
	
	static int i=26;//in decimal
	
	static long l = 24L;//An integer literal is of type long if it ends with the letter L or l; otherwise it is of type int
	

	
	
	static char c;
	
	//Class<String> c = String.class; // wtf?
	

	void intDemo(){	
		int i = 4;// local variable "stronger than" static variable,	
		this.i = 4;// so use this to change static or instance (but not local) variable?
		i = 0x1a;// in hexadecimal
		i = 0b11010;// in binary
		i = 1_0;// _ just for visibility, =10	
	}



	void charDemo(){
	/* UTF: UniCode Transformation Format
	 * UTF-8  variable length 8 to 32bit, backwards compatible with ASCII, use for web
	 * UTF-16 variable length 1 or 2 char, use for java strings
	 * 
	 * UniCode: unique number for every character
	 * ASCII:	7bit	0 to 127
	 * 
	 * char:	a=97~1, z=122~26
	 * 
	 * special \sequences...
	 * \b (backspace), 
	 * \t (tab), 
	 * \n (line feed), 
	 * \f (form feed), 
	 * \r (carriage return), 
	 * \" (double quote), 
	 * \' (single quote),
	 * \\ (backslash)
	 */
	 
	 	c ='a';
		c = (char) 40;
		c = 'a'+5;
		
		
		i = c+20;
		i = c/2;
		i = (int)c;
		

		// compiler cannot check if the value is within the bounds of a char, so it forces you to store it as int
		i = c+5;
		i= 'a'+i;
		
		
		
		i = 5+'a';
		i = 5+'f';
		
		
		
		

	 for(int i=97;i<=122;i++){
			System.out.print((char)i+" "+i+", ");
		}
		System.out.println();
	}


	public static void main(String[] args) {
		Primitives pri = new Primitives();
		pri.intDemo();
		pri.charDemo();

		
		System.out.println("1==0b1 "+(1==0b1));
		System.out.println("1==1L "+(1==1L));
	}
}



