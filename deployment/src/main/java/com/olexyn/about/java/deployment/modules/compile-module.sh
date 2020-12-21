#!/bin/bash

# --module-path , -p
# Location of required .jar(s)
# Must be used when the module to be compiled 'requres' other modules

# -d <directory for .class files> (same as always)

javac -p deployment/modules/ \
       modulemain/com/main/Main.java \
       modulemain/module-info.java


