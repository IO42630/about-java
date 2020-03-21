# Chapter 1 : About Java
| | | |
---|---|---
JDK     | | Java Development Kit : minimum software needed for Java development.
Compiler | `javac` | Converts `.java` to `.class` files.<br> _compiles_ to `bytecode` , contained in `foo.class`
Launcher | `java` |Creates JVM and executes. <br> JVM _interprets_ the bytecode .
 Archiver| `jar` | 
 | | `javadoc` | generates documentation.
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
* `-d` : overwrite target directory for .class files
    * `javac -d ./out ./pkg/Core.java ./other/pkg/NotCore.java `
* _Classpath_ : indicates where .class files are located
    * `java -cp ./out pkg.Core`
    * also `-classpath` , `--class-path`
    * possible to use multiple paths
        * look in current dir and in ./out and in foo.jar
        * Win: `java -cp ".;./out;./foo.jar`
        * Unix: `java -cp ".:./out:./foo.jar`
* _Sourcepath_
    * `cd ./src/deployment/pkg`
    * `javac -sourcepath ../pkg Main.java`
    * `cd ..`
    * `java pkg.Main`
* _Modulepath_
    * `-p , --module-path`
    
 
    

### JAR

# ABOUT JAR
JAR (Java Archive)
* Security: 
You can digitally sign the contents of a JAR file. 
Users who recognize your signature can then optionally grant your software security privileges it wouldn't otherwise have.
* Packaging for extensions: 
The extensions framework provides a means by which you can add functionality to the Java core platform, and the JAR file format defines the packaging for extensions. By using the JAR file format, you can turn your software into extensions as well.



|Operation|Command|
| --- | --- |
`c`| create
`f`| file : a jar file description will follow
`m`| manifest : a manifest will follow, manifest/file must be in same order as `mf`.
`t`| table of contents : prints table of contents
`x`| extract
`u`| update
`e`| entry point : overrides the main-class set in the manifest
`jar cf jar-file input-file(s)` | create JAR
`jar cfm jar-file manifest input-file(s)` | create JAR with manifest-addition|
`jar tf jar-file` |view contents
`jar xf jar-file1`|extract contents|
`jar uf jar-file input-file(s)` |update (add/overwrite)|
`jar cfe Core.jar pkg.Core pkg/Core.class` | set entry point (directly set main class)|
`java -jar app.jar`|run|


### Manifest Files
JAR files support a wide range of functionality, including electronic signing, version control, package sealing, and others. What gives a JAR file this versatility? The answer is the JAR file's manifest.

The manifest is a special file that can contain information about the files packaged in a JAR file. By tailoring this "meta" information that the manifest contains, you enable the JAR file to serve a variety of purposes.

This lesson will explain the contents of the manifest file and show you how to work with it, with examples for the basic features:

app.jar/META-INF/MANIFEST.MF

Default manifest:
Manifest-Version: 1.0
Created-By: 1.7.0_06 (Oracle Corporation)

##### Class-Path
When a JAR (i.e. Applet) references other JARs (equiv. to using `java -classpath`).
 
`Class-Path: jar1-name jar2-name directory-name/jar3-name`


##### Package Version
|Header 	|Definition| 
| --- | --- |
|Name 	The name of the specification.
|Specification-Title| 	The title of the specification.|
|Specification-Version |	The version of the specification.|
|Specification-Vendor |	The vendor of the specification.|
|Implementation-Title |	The title of the implementation.|
|Implementation-Version |	The build number of the implementation.|
|Implementation-Vendor 	|The vendor of the implementation.|

##### Sealing a pkg
all classes defined in that package must be archived in the same JAR file.
Name: myCompany/firstPackage/
Sealed: true

Name: myCompany/secondPackage/
Sealed: true


or just seal the entire JAR

Sealed: true