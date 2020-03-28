

# looks at module-info.java and code contents
jdeps mods/zoo.animal.feeding.jar
# -summary -s
# short version
jdeps -s mods/zoo.animal.feeding.jar


# when with dependencies to other jars need to specify -m
jdeps -m mods mods/zoo.animal.feeding.jar

# JMOD advanced JAR
jmod create
extract
describe
list
hash