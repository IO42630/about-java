#!/bin/bash

# compile
javac modulehelper/com/helper/Helper.java modulehelper/module-info.java

# package
jar -cf deployment/modules/modulehelper.jar -C modulehelper/ .

# launch
# can't launch, since no main()
