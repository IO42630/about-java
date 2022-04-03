#!/bin/bash

# options
# -cf : create file (jar)
# -C <path> : temporarly changes working directory for the execution of the current command.
jar -cf deployment/modules/moduletransit.jar -C moduletransit/ .

# eqiuivalent command, without the -C option.
cd moduletransit
jar -cf ../deployment/modules/moduletransit.jar .
