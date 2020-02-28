# Chapter 2 : Java Building Blocks
####Object
    Integer integer = new Integer(0);
    <type>  <name>        <constructor>
* The purpose of a _constructor_ is to initialize fields.

####Variable
* Variables can not be declared outside of a class or interface.
* Fields
    * Instance Variable: (non-static) , defined withing a Class.
    * Class Variable : static , defined within a Class.
* Local Variable : defined within a Constructor , Method or Initializer Block.
* Constant : what ever Variable has a `final` keyword.



    public class Foo {
        int i;
    
        Foo(){
            i = 1;       // write access "set"
            i = i + 1;   // read & write access "get & set"
     }  }



####Code Block
    {}      // code block
            // a brace is missing == "balanced parantheses problem"
    
    public class Foo {      // class definition
    
        {int bar = 1;}     // instance initializer
    
        void bob(int i){  // method definition
            {i++;}       // inner block
    }   }

#### Order of Initialization
    new Foo().bob(1);
1. code outside of constructor
    1. thus instance variables and instance initializers
    1. line by line
2. code inside the constructor
3. what ever method is called


### 8 Primitive Data Types
* Java works with _objects_ that contain collections of primitive data types.
* primitive data types are not objects
* primitive types hold their values in memory
* `null` means pointer is pointing to no object
    * thus primitives can't be null


    int i; // Java just allocated 32 bits of memory.

### Reference Type
* holds pointer to memory address of object
    * unlike other Languages, Java does not allow to know what the physical memory adress is
* a reference can be assigend to another object of the a compatible type


#### Identifier Name
* must begin with letter , $ or _
* can include numbers
* a single _ is not allowed as identifier (since Java 9)
* cannot be reserved
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
    
    
    int i;
    int x;
    if (check){
        i=0;
        x=0;
        } else {
        i=1;
        }
        int a = i; // OK (i is initialized either way)
        int b = x; // NO
    
    
#### Parameters (constructor or method)
* are local variables
* that have been pre-initialized


    public void check(){
        boolean value;
        find(value); // NO
        }



variable type | default init value
--- | ---
boolean | false
byte,short,int,long | 0
float,double | 0.0
char | '\u0000
all objects (e.g. String) | null


### var (local variable type inference)
* since Java 10
* can only be used with local variables
    * var cannot be used with parameters, pick your reason
        * not declared & init on same line
        * special kind of local variable
    * can't be used with instance/class vars
* var must be declared and initialized on the same line.

        var a = 1;
        var b = "name";
        a = b; // NO

* in Java the type of var is resolved at compile time.
* in JavaScript var would be resolved at run time.

        var a = (short)10; // tell 10 to be short
        a = (bype) 5; since byte < short, it is auto. promoted to short

* var can be used for reference types
* however it can not be assigend null (as the compiler would be overburdened to guess the Object type)

        var a = "foo"; // OK
        a = null; // OK
        var b = null; // NO
        var c = 0; //OK
        c = null; // NO
* var is not a _reserved word_.
    * var is a _reserved type name_.
        * cannot be used for _class_, _interface_, or _enum_ declarations.
* var cannot be used in multiple-var declaration


### Scope
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
    
 ### GC
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
    
##### Object vs. Reference
* _variable name_ : name of the var 
* _reference_ : @9999Object : accessed by it's variable name
    * always of same size (=length) 
    * has a _type_
    * `Object` is a type - that is not what we are talking about.
    * may (`new Object();`) or may not cause an Object created on the heap
* _object_ is what the reference points to
    * an object may have multiple references
    