#!/bin/bash

# compile
javac moduletransit/com/transit/Transit.java moduletransit/module-info.java

# package
jar -cf deployment/modules/moduletransit.jar -C moduletransit/ .

# launch
# can't launch, since no main()
