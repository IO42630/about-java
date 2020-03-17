# Chapter 1 : About Java
| | | |
---|---|---
JDK     | | Java Development Kit : minimum software needed for Java development.
Compiler | `javac` | Converts `.java` to `.class` files.<br> _compiles_ to `bytecode` , contained in `foo.class`
Launcher | `java` |Creates JVM and executes. <br> JVM _interprets_ the bytecode .
 Archiver| `jar` | 
 - | `javadoc` | generates documentation.
| API | | StringBuilder is an API.
    
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
        
        

### Running a Prog in One Line 
Normal | One Line
---|---
`javac Core.java` | `java Core.java`
`java Core` | 
Produces class file | Fully in memory
For any program | For programs with one class
Can import any library | Can ony import code that came with the JDK.

### Packages
* _Declaration_ : `package pkg;`
* _Fully qualifed class name_ : `java.util.Date foo;`
##### Imports

    import java.util.Random;
    import java.util.* // wildcard
* _wildcard_ : compiler figures out what is needed
    * only imports classes
    * static imports may import methods, see Ch.7
* redundant imports:
    * `java.lang` is auto-imported
    * classes of same package are auto-imported
* invalid imports


    import java.nio.*              // can't match "files.File"
    import java.nio.*.*            // only one * allowed
    import java.nio.file.Paths.*   // can import methods
    
assuming java.util.Date and java.sql.Date
    
    import java.util.*; import java.sql.*;        // causes Date declaration to C-Error 
    import java.util.Date; import java.sql.*;     // OK
    import java.util.Date; import java.sql.Date;  // C-Error (even if not used)
    


##### Creation
* _Default package_ : if nothing is specified
* Example : 
    * `cd ./src/deployment`
    * `javac ./pkg/Core.java ./other/pkg/NotCore.java`
    * with wildcards: `javac ./pkg/*.java ./other/pkg/*.java`
    * `java pkg.Core`
* `-d` : "output" directory
    * `javac -d mytarget ./pkg/Core.java ./other/pkg/NotCore.java `
* _Classpath_ : indicates where .class files are located
    * `java -cp mytarget pkg.Core`
    * also `-classpath` , `--class-path`
* _Sourcepath_
    * `cd ./src/deployment/pkg`
    * `javac -sourcepath ../pkg Main.java`
    * `cd ..`
    * `java pkg.Main`

### JAR