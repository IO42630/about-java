#!/bin/bash

# consider this to be the working dir for this example
# cd deployment/src/main/java/com/olexyn/about/java/deployment/modules/
# run with
# modulehelper/modulehelper.sh

# compile
javac modulehelper/com/helper/Helper.java modulehelper/module-info.java

# package
jar -cf jar/modulehelper.jar -C modulehelper/ .

# launch
# can't launch, since no main()
