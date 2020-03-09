# Chapter 1 : About Java
* Java Development Kit (JDK) : minimum software needed for Java development.
* Compiler : `javac`
    * Converts `.java` to `.class` files.
* Launcher : `java`
    * Creates VM and executes.
* `jar` : archiver.
* `javadoc` : generates documentation.


* `javac` _compiles_ to `bytecode` .
    * contained in `foo.class`
* JVM _interprets_ the bytecode .



* API
    * StringBuilder is an API.
    
#### Benefits
* Object Oriented
* Encapsualtion
    * Access modifiers
    * Local scope of variables
* Platform Independent : bytecode runs in any JVM
* Robust: no memory leaks
* Simple : no pointers, no operator overloading
* Secure : JVM creates a sandbox
* Multithreaded : 
* Backward Compatibility : 
    * APIs about to be obsolete are flagged as _depreciated_ .
    
    
* _member_ all that is inherited
    * _fields_ (=variables) (hold state)
    * _methods_ (=functions) (operate on state)
* _keyword_ word with special meaning.
* variables have _type_
* methods have parameters
* _method signatuer_ = name + parameter types
* _method declaration_ = full line (?)

* Comment
    * `/* */ */` does not compile, as there is one `*/` too much.
    * 
   
   
* only one class is allowed to be public in a file
    * C-Error if filename does not match name of public class.
    * file also must have a .java extension
    
#### Command Line
* Without _package_ :
    * `class Core` in file `Core.java` in directory `/pkg` 
        * `javac pkg/Core.java`
        * `cd ./pkg` then `java Core`

* With _package_ : 
    * `class Core` in file `Core.java` in directory `/pkg`  
    * file contains statement `package pkg;`  
        * `javac pkg/Core.java`
        * `java pkg.Core`
        
        

