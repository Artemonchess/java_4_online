#!/bin/sh

cd work_1
mvn clean package
java -jar ./target/work_1.jar

cd ../

cd work_2
mvn clean package
java -jar ./target/work_2.jar

cd ../

cd work_3
mvn clean package
java -jar target/work_3.jar