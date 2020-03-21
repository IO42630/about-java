#!/bin/bash

# compile
javac ./jar/src/yes_main/*.java

# run as .class
# TODO why this runs without -cp is beyond me.
java jar.src.yes_main.Main

# create jar with manifest (the manifest is optional)
# the "source" of the manifest is Manifest.txt
# this will create META-INF/MANIFES.MF in the .jar
jar cfm ./jar/out/yes_main.jar ./jar/src/yes_main/Manifest.txt ./jar/src/yes_main/*.class

# run as .jar
java -jar ./jar/out/yes_main.jar

