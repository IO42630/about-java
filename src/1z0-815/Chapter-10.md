# Chapter 10 : Exceptions
![](Exceptions.png)

* Exceptions do alter the program flow.
* Since `Throwable` includes `Error` , do not catch `Throwable` directly.
* Examples see `Exceptions.java` .
* _handle_ means `try/catch`
* _declare_ means `throw`
* if attempting to catch `cE` (not relevant for `uE`) that the try-block is unable to throw
    * then Compile-Time Error
* `Errors` Exceptions that the programmer should not attempt to handle.

                        
<br>
    
Type | May be declared | May be handled | Must be declared/handled
---|---|---|---
Unchecked Exception `uE`  |Yes| Yes | No
Checked Exception `cE` |Yes| Yes | Yes
Error  |Yes| No | No

<br>

RuntimeExceptions | -
---| ---
ArithmeticException | Thrown when code attempts to divide by zero
ArrayIndexOutOfBoundsException | Thrown when code uses an illegal index to access an array
ClassCastException | Thrown when an attempt is made to cast an object to a class of which it is not an instance. e.g. `String s; Integer i = (Integer)s;`.
NullPointerException | Thrown when there is a null reference where an object is required
IllegalArgumentException | MANUALLY thrown by the programmer with `throw` to indicate that a method has been passed an inappropriate argument
NumberFormatException | Subclass of IllegalArgumentException! Thrown when an attempt is made to convert a string to a numeric type but the string doesn’t have an appropriate format. e.g. `Integer.parseInt("ab");`.
**Checked Exceptions** |                    
IOException | Thrown programmatically when there’s a problem reading or writing a file
FileNotFoundException | Subclass of IOException! Thrown programmatically when code tries to reference a file that does not exist
**Errors** |                            
ExceptionInInitializerError | Thrown when a static initializer throws an exception and doesn’t handle it
StackOverflowError | Thrown when a method calls itself too many times (infinite recursion)
NoClassDefFoundError |  Thrown when a class that the code uses is available at compile time but not runtime.

###### ExceptionInInitializerError
Java runs static initializers the first time a class is used.

    static { int[] arr = new int[3];  int i = arr[-1];  }

#### Syntax Rules
* try/catch requires all braces to be present
    * only if and loops allow to omit braces for one-liners.
* there may be multiple catch blocks
    * evaluated in the order they appear in
    * only one may run
    * if superclass Exception catch before subclass cat
        * then Compile-Time error 
* multi-catch block see `Exceptions.java` .
    * declaring inheriatance-related Exceptions in a multi-catch will result in a Compile-time error
        * even if child comes before parent.
* order of try/catch/finally matters, either catch OR finally must be present.

#### finally
     int goHome() {
      try {
      // Optionally throw an exception here
      System.out.print("1");
      return -1;
      } catch (Exception e) {
      System.out.print("2");
      return -2;
      } finally {
      System.out.print("3");
      return -3;
      }
     }

* finally is always executed before try/catch return
    * thus here return is always -1
    * print is either 12 or 13 depending if an Exception occurs.
* Special case: finally is not executed


    try {
    System.exit(0);
    } finally {
    System.out.print("Never going to get here"); // Not printed
    }



### try-with-resource
* resources are : databases, webservers, filesystems
resource leak just as bad as memory leak
*  use finnally to close the resources


    try (FileInputStream in = new FileInputStream("foo"); FileInputStream in = new FileInputStream("foo"); ){
        //some code
    } 
    
* does not support compound declaration
* an user `var` since resources are local variables
* catch block is optional (since finally clause exists implicitly)
* a implicit finally block is created that closes the resources in the reverse order they were created
* optional `catch` block runs after implicit finally
* an explicit finally block, if defined by the programmer, is executed after the explicit block
* only Classes that implement the Interface AutoClosable can be used in try-with-resources blocks.
    * because they must implement `.close()`
* scope of resource is only the try block.

##### Overrideing Methods with Exceptions
* this applies only to checked exceptions
    * overridden method in a subclass is allowed to declare fewer exceptions that the superclass or interface.
        * this is legal because callers are already handling then (???)
    * overriden method is allowed to declare a child of the exception the parent method throws






