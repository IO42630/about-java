#!/bin/bash

# compile
javac ./pkg/*.java ./other/pkg/*.java -cp "./jar/out/no_main.jar"

# run as .class
# TODO why this runs without -cp is beyond me.
# java pkg.Main


