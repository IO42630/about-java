#!/bin/bash

# compile
# since this module requires other modules, the -p option is used to supply path to .jar(s)
javac -p deployment/modules/ modulemain/com/main/Main.java modulemain/module-info.java


# package
jar -cf deployment/modules/modulemain.jar -C modulemain/ .

# launch
java -p deployment/modules -m modulemain/com.main.Main

