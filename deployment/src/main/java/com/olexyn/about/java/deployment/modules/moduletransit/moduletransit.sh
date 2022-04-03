#!/bin/bash

# consider this to be the working dir for this example
# cd deployment/src/main/java/com/olexyn/about/java/deployment/modules/
# run with
# moduletransit/moduletransit.sh

# compile
javac moduletransit/com/transit/Transit.java moduletransit/module-info.java

# package
jar -cf jar/moduletransit.jar -C moduletransit/ .

# launch
# can't launch, since no main()
