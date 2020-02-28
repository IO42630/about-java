# ABOUT JAR
JAR (Java Archive)
* Security: You can digitally sign the contents of a JAR file. Users who recognize your signature can then optionally grant your software security privileges it wouldn't otherwise have.
* Packaging for extensions: The extensions framework provides a means by which you can add functionality to the Java core platform, and the JAR file format defines the packaging for extensions. By using the JAR file format, you can turn your software into extensions as well.

|Operation|Command|
| --- | --- |
|create JAR| `jar cf jar-file input-file(s)`|
|create JAR with manifest-addition | `jar cfm jar-file manifest-addition input-file(s)`|
|view contents|`jar tf jar-file`|
|extract contents|`jar xf jar-file1`|
|update (add/overwrite)|`jar uf jar-file input-file(s)`|
| set entry point (directly set main class)|`jar cfe Core.jar pkg.Core pkg/Core.class`|
|run|`java -jar app.jar`|


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