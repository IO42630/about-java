$!/bin/bash
# compile
javac pkg/Core.java
# create the jar with manifest
jar cfm Core.jar pkg/Manifest.txt pkg/*.class
# run the JAR
java -jar Core.jar
