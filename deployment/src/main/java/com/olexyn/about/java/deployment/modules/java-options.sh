#!/bin/bash

# --describe-module , -d
# java -p <location-of-jar> -d <name-of-jar>
# output : description of module-info.java contents
java -p mods -d zoo.animal.care
jar -f mods/zoo.animal.feeding.jar -d

# --list-modules
java --list-modules
#
java -p mods --list-modules



# --show-module-resolution
# prints debug info, then runs module
java --show-module-resolution -p feeding -m zoo.animal.feeding/zoo.animal.feeding.Task

