## Deployment

#### Command Line
`class Core` in file `Core.java` in directory `/pkg` 
        
| no package | with package
---|---
| | file contains statement `package pkg;`  
`javac pkg/Core.java` | `javac pkg/Core.java`
`cd ./pkg` then `java Core` | `java pkg.Core`
 
 
        

#### One Line 
Normal | One Line
---|---
`javac Core.java` | `java Core.java`
`java Core` | 
Produces class file | Fully in memory
For any program | For programs with one class
Can import any library | Can ony import code that came with the JDK.

* One Line ignores packages, thus a `Main.java` in `package one.line.pkg;` can be called as:
    * `java ./one/line/pkg/Main.java`
    * `java Main.java`






#### Packages
* _Declaration_ : `package pkg;`
* _Fully qualifed class name_ : `java.util.Date foo;`

#### Imports

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
    



#### `javac`
* _Directory_ 
    * `-d` : overwrite target directory for .class files 
    * `javac -d ./out ./pkg/Core.java ./other/pkg/NotCore.java `
* _Sourcepath_ , `-sourcepath`
    * `cd ./src/deployment/pkg`
    * `javac -sourcepath ../pkg Main.java`
    * `cd ..`
    * `java pkg.Main`


#### `java`
* _Classpath_ : indicates where .class files are located
    * `java -cp ./out pkg.Core`
    * also `-classpath` , `--class-path`
    * possible to use multiple paths
        * look in current dir and in ./out and in foo.jar
        * Win: `java -cp ".;./out;./foo.jar`
        * Unix: `java -cp ".:./out:./foo.jar`


    
 
#### Examples
##### no.pkg
* _Default package_ : if nothing is specified
##### pkg

* Example : 
    * `cd ./src/deployment`
    * `javac ./pkg/Core.java ./other/pkg/NotCore.java`
    * with wildcards: `javac ./pkg/*.java ./other/pkg/*.java`
    * `java pkg.Core`
