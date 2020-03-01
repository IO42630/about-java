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


## Data Types
* Java works with _objects_ that contain collections of Primitive Data Types.

##### _object_ vs. Reference
* _variable name_ : name of the var 
* _reference_ : @9999Object : accessed by it's variable name
    * always of same size (=length) 
    * has a _type_ (`Object` is such a type - not to be confused with _object_).
    * may cause, e.g. through `new Object();` , an _object_ to be created on the heap
* _object_ is what the reference points to
    * an object may have multiple references

#### 8 Primitive Types
* Contain a pointer to a value in memory.
    * Thus have fixed size.
    * Thus upon declaring a Primitive Type, Java will directly allocate memory according to the size of the Primitive Type.
* Can't contain `null` (as they don´t contain an pointer to an _object_ in the first place).
* _mutable_.

#### Reference Type
* holds pointer to memory address of object
    * unlike other Languages, Java does not allow to know what the physical memory adress is
* a reference can be assigend to another object of the a compatible type
* _immutable_.

## Variables
##### Identifier Name
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

#### `var` (local variable type inference)

* `var` can only be used with local variables
   * thus can't be used with instance/class vars
* `var` must be declared and initialized on the same line.
    * thus cannot be used with parameters
* var can be used for reference types
*   however it can't be assigend `null` , since impossible to guess type.
 

    var a = (short) 1;
    a= "name"; // OK
    var c = 0; // OK
    c = null;  // NO



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
    

    