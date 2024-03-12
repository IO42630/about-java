#!/bin/bash
version="3.0.0-SNAPSHOT"
packaging="jar"
artifactId="construct"
file="target/${artifactId}-${version}.${packaging}"
groupId="ch.dvbern.oss.construct"




mvn package
mvn install:install-file -Dfile=${file} -DgroupId=${groupId} -DartifactId=${artifactId} -Dversion=${version} -Dpackaging=${packaging} -DgeneratePom=true
