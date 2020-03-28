#!/bin/bash

# options:
#    -p <module-path>  (long version: --module-path)
#    -m <module-name>/<package-name>.<class-name>  (long version: --module)

# Executing a Class directly.
# only possible when no dependencies
java -p feeding -m zoo.animal.feeding/zoo.animal.feeding.Task # from within zoo/animal



# Executing as a Jar.
java -p mods -m zoo.animal.feeding/zoo.animal.feeding.Task
java -p mods -m zoo.animal.care/zoo.animal.care.details.Diet