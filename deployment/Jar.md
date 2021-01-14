## 016 Jar
* Java Archive
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
`<input>` | Can be a file, a list of files, a wildcard or a directory 
`-C`|  input directory. `jar -cf foo.jar -C pkg Main.class` ~ `jar -cf foo.jar pkg/Main.class`
`jar cf foo.jar <input>` | create JAR
`jar cfm jar-file manifest input-file(s)` | create JAR with manifest-addition|
`jar tf jar-file` |view contents
`jar xf jar-file1`|extract contents to current directory|
`jar uf jar-file <input>` |update (add/overwrite)|
`jar cfe Core.jar pkg.Core pkg/Core.class` | set entry point (directly set main class)|
`java -jar app.jar`|run|


#### Manifest Files
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
