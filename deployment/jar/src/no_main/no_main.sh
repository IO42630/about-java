#!/bin/bash
javac jar/src/no_main/ClassInJar.java
jar cf ./jar/out/no_main.jar jar/src/no_main/*.class
