#!/bin/bash
# The deployment process can be divided into 3 steps:
#   1. compile with javac.
#   2. package with jar (optional).
#   3. execute with java.


# COMPILE
#############################################

# The following commands use the -p mods option.
#    This means required (other) modules are fetched from .jar in the mods/ directory.
#    This means a change inside a depenency will not be aviable to the module currently being built
#      until the required module is compiled and packaged.

# compile this module, with empty module-info
# options:
#    -p <module-path>
#    -d <directory for .class files>

javac -p mods \
      -d feeding \
      feeding/zoo/animal/feeding/*.java \
      feeding/module-info.java

javac -p mods \
      -d care \
         care/zoo/animal/care/details/*.java \
         care/zoo/animal/care/medical/*.java \
         care/module-info.java # executed from within zoo/animal/

javac -p mods \
      -d talks \
         talks/zoo/animal/talks/content/*.java \
         talks/zoo/animal/talks/media/*.java \
         talks/zoo/animal/talks/schedule/*.java \
         talks/module-info.java # executed from within zoo/animal/



# This one is tricky because mods is located in animal/

javac -p mods \
      -d ../staff \
         ../staff/zoo/staff/*.java \
         ../staff/module-info.java # executed from within zoo/animal/

javac -p animal/mods \
      -d ../staff \
         ../staff/zoo/staff/*.java \
         ../staff/module-info.java # executed from within zoo/






# PACKAGE
#############################################


# options
#    -C <path> temporarly changes working directory for the execution of the current command.
jar -cvf mods/zoo.animal.feeding.jar -C feeding/ .
jar -cvf mods/zoo.animal.care.jar -C care/ .


jar -cvf mods/zoo.animal.talks.jar -C talks/ .
jar -cvf ../mods/zoo.animal.talks.jar . # eqiuivalent command, without the -C option.






# EXECUTE
#############################################

# options:
#    -p <module-path>  (long version: --module-path)
#    -m <module-name>  (long version: --module)

# Executing a Class directly.
java -p feeding -m zoo.animal.feeding/zoo.animal.feeding.Task # from within zoo/animal



# Executing as a Jar.
java -p mods -m zoo.animal.feeding/zoo.animal.feeding.Task
java -p mods -m zoo.animal.care/zoo.animal.care.details.Diet


