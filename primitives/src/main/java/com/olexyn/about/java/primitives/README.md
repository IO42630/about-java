
  
  >Primitive< types are special data types built into the language; 
  they are not objects created from a class.
  
  word | meaning
  ---|----
  literal | primitive value (e.g. 1 )
  								
  
   type  |  bit |  range | Example 
  ----|----| ---| ---
  boolean | 1 | true / false | true
  byte |  8 | -128 to 127  | 123
  short | 16 | -2^15 to 2^15-1 | 123
  int | 32 | -2^31 to 2^31-1	| 123
  long	|	64			|			|	123L
  float|	32		|IEEE 754		|	123.45f
  double|	64		|			|		123.456
  char	|	16		|Unicode, \u0000 (0) to \uffff (2^16-1) 	|	'a'
  
  
  A >literal< is the source code representation of a fixed value; 
  literals are represented directly in your code without requiring computation.
  null literal that can be used as a value for any reference type, 
  except variables of primitive types.
 
  Strings and Arrays are Objects
	 
	 
	 
  #### Side Note about char
  char is \u0000 in hex thus 16^4 = (2^4)^4 = 2^16 ... this again is like short.  
