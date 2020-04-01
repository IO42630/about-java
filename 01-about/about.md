## About
| | | |
---|---|---
JDK     | | Java Development Kit : minimum software needed for Java development.
Compiler | `javac` | _Compiles_ from sourcecode contained in `.java` files.<br> _Compiles_ to `bytecode` contained in `.class` files.
Launcher | `java` |Launches the JVM. <br> JVM _interprets_ the bytecode .
 Archiver| `jar` | 
 | | `javadoc` | generates documentation.
| API | | StringBuilder is an API.

* Java_EE
    * Java Enterprise Edition (Currently rebranded as Jakarta EE).
    * Specification that is related to JAVA SE." 
    * It includes all the classes in Java SE, plus a number that are more useful to programs that run on servers as opposed to workstations.";
* Java SE  Java Platform, Standard Edition 
    * Specification of a computing platform for development and deployment.
* Oracle JDK   Java Development Kit
    * Oracle's implementation of Java SE
* String JRE = "Java Runtime Environment" +
    * contains a stand-alone JVM (HotSpot)" +
    * the Java standard library (Java Class Library) and a configuration tool";
* String Android_VM = "Google's implementation" +
    * Incompatible with the JVM spec." +
    * Instad Gooles Dev Kit takes Java programs as input and outputs Dalvik bytecode." +
    * This Dalvik bytecode is then the native input for the Android VM.";

#### Interpreter vs. Compiler

Interpreter | Compiler
--- | ---
Translates program one statement at a time. | Scans the entire program and translates it as a whole into machine code.
It takes less amount of time to analyze the source code but the overall execution time is slower. | It takes large amount of time to analyze the source code but the overall execution time is comparatively faster.
No intermediate object code is generated, hence are memory efficient. |Generates intermediate object code which further requires linking, hence requires more memory.
Continues translating the program until the first error is met, in which case it stops. Hence debugging is easy. | It generates the error message only after scanning the whole program. Hence debugging is comparatively hard.
Programming language like Python, Ruby use interpreters. | Programming language like C, C++ use compilers.

##### Java
* Compiler translates Source Code to Bytecode
* Interpreter (=JVM) translates the Bytecode into Machine Code for the particular OS.
    
#### 8 Benefits
| | |
---|---
Object Oriented | All code is defined in classes.
Encapsualtion | - Access modifiers <br> - Local scope of variables
Platform Independent | bytecode runs in any JVM
Robust| no memory leaks
| Simple | no pointers, no operator overloading
| Secure | JVM creates a sandbox
| Multithreaded | 
| Backward Compatibility | APIs about to be obsolete are flagged as _depreciated_ .

<br>

#### Building Blocks
* _keyword_ word with special meaning. 
* _variables_ hold state
    * have _type_
* _methods_ operate on state
* _member_ all that is inherited
    * _fields_ : variable declared outside of method, but inside class.
    * _methods_ (=functions) (operate on state)
        * methods have parameters
        * _method signature_ = name + parameter types
        * _method declaration_ = full line (?)
    * _nested classes_
    * _interfaces_
    * _enumerated types_
    * NOT _Constructors_ , since those are not inherited.
* Comment
    * `/* */ */` does not compile, as there is one `*/` too much.

| | |
---|---
`Integer integer = new Integer(0);` | `<type>  <name>   = new     <constructor> ;`
`{}` | block
`a=1+1;` , `a++;` | statement
`1+1` , `a++` | expression

                          // a brace is missing == "balanced parantheses problem"
    public class Foo {    // class definition
        {int bar = 1;}    // instance initializer
        void bob(int i){  // method definition
            {i++;}        // inner block
    }   }

<br>

#### Variables


* Variables can't be declared outside of a class or interface.
* Fields
    * Instance Variable: (non-static) , declared within a Class.
    * Class Variable : `static` , declared within a Class.
* Local Variable : declared within a Constructor, Method or Initializer Block.
* Constant : `final` variable.


    int i;       // declaration
    i = 1;       // write access "set"
    i = i + 1;   // read & write access "get & set"

##### Identifier Name
* must begin with letter , $ or _
* can include numbers
* a single _ is not allowed as identifier (since Java 9)
* cannot be reserved
* can't contain non char operators e.g. `+` , `%` , `~`
* unicode letters, e.g. arabic are allowed.

##### Compound Declaration

* may or may not be initialized.
* only one type declaration allowed.


    int i1, i2, i3=0;  // OK
    int a, int b;      // NO , multiple declarations not allowed.
    int i1, String s1; // NO , multiple declarations & not of the same type.
    int a; int b;      // OK , two statements.
    int a; b;          // NO , b is not a statement.


##### Initializing Variables
* Instance Variables have default values:


    boolean                  false
    byte, short, int, long   0
    float, double            0.0
    char                     '\u0000' (NUL)
    Objects                 null
    
    

* Local Variables do not hat a default value
    * compiler will throw error, if the code reads an un-init var
    
    
    int i, x;
    if (check){
        i=0; x=0;
    } else {
        i=1;
    }
    int a = i; // OK // i is initialized either way
    int b = x; // NO // reading uninitialized variable
    
    
##### Parameters (constructor or method)
* are local variables, that have been pre-initialized
* C-Error: `int i; find(i);`

<br>

#### `var` 
* local variable type inference

| yes | no|
---|---
can only be used with local variables | can't be used with fields
must be initialized when declared | can't be used with parameters
can be used for reference types | can't be assigend `null` , <br> since impossible to guess type.
is a _reserved type name_.  <br> can't be used for _class_, _interface_, or _enum_ declarations | is not a _reserved word_.
 - |can't be used in multiple-var declaration





#### Scope
* the scope of the variable is the code block it is declared in
* for parameters the scope is the method/class
    * start: when declared
    * end: when brace is closed
* instance var
    * start: when declared
    * end: lifetime of object ends (object eligible for GC)
* class var
    * start: when declared
    * end: life of the program ends
    
#### GC
 * all Ojbects are stored in _heap_ (_free store_).
    * pool of unuserd memory allocated to the Java application.
*  Object is _eligiblie for GC_ = no longer accessible in program
    * Object no longer has any references pointing to it.
    * all references to the Object have gone out of scope.

        System.gc();
        
* suggests JVM to do GC, JVM may comply.
* example

        String a = new String("a");
        String b = new String("b");
        a=b; // String "a" just went out of scope
        b=null; // String "b" is still in scope
* Side Node:
    * finalize() was intended to run when the object was GCd.
    * it can run only once
    * not part of exam, since deprecated
