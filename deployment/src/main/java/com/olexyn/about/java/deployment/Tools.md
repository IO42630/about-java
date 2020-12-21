### Ant
* define build/deploy procedure in `build.xml`
* run with `ant -f build.xml`
* problem `jar` need to be predefined directory before `ant` is run.

### Maven
* solves the beforementioned problem
    * by introducing conventions
        * archetypes
        * according to POM (Project Object Model)
* described in `pom.xml`
* run with `mvn package` from within a directory that contains the `pom.xml`
* upload your `jar` to the maven repo
    * or your local repo

mvn install:install-file \
   -Dfile=<path-to-file> \
   -DgroupId=<group-id> \
   -DartifactId=<artifact-id> \
   -Dversion=<version> \
   -Dpackaging=<packaging> \
   -DgeneratePom=true
   
   <path-to-file>: the path to the file to load e.g → c:\kaptcha-2.3.jar
   
   <group-id>: the group that the file should be registered under e.g → com.google.code
   
   <artifact-id>: the artifact name for the file e.g → kaptcha
   
   <version>: the version of the file e.g → 2.3
   
   <packaging>: the packaging of the file e.g. → jar
   
   
   
##### Maven `war` (`maven-archetype-webapp`)
mvn archetype:generate -DgroupId=com.olexyn.app.sub -DartifactId=aub-app -DarchetypeArtifactId=maven-archetype-webapp -DarchetypeVersion=1.4 -DinteractiveMode=false


mvn archetype:generate -DgroupId=com.olexyn.misp.fwd -DartifactId=misp-fwd -DarchetypeArtifactId=maven-archetype-webapp -DarchetypeVersion=1.4 -DinteractiveMode=false
