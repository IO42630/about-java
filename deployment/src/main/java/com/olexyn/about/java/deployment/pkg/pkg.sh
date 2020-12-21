#!/bin/bash

# compile
javac ./pkg/*.java

# run as .class
# TODO why this runs without -cp is beyond me.
java pkg.Main


