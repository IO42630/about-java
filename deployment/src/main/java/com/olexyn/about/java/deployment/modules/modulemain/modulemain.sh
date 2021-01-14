#!/bin/bash

# consider this to be the working dir for this example
# cd deployment/src/main/java/com/olexyn/about/java/deployment/modules/
# run with
# modulemain/modulemain.sh

# compile
# since this module requires other modules, the -p option is used to supply path to .jar(s)
javac -p jar modulemain/com/main/Main.java modulemain/module-info.java

# package
jar -cf jar/modulemain.jar -C modulemain/ .

# launch
java -p jar -m modulemain/com.main.Main

