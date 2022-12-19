#!/bin/sh

echo 'run level 1'

echo 'run simple'
cd ./level_1/simple
javac Hoy.java
java Hoy

cd ../

echo 'run package'
cd ./package
javac ua/com/alevel/Hoy.java
java ua.com.alevel.Hoy

cd ../

echo 'run separate packages'
cd ./separate_packages
javac ua/com/alevel/Hoy.java
java ua.com.alevel.Hoy

cd ../

echo 'run minimal proj'
cd ./minimal_proj
javac -sourcepath ./src -d build/classes ./src/ua/com/alevel/Hoy.java
java -cp build/classes ua.com.alevel.Hoy

cd ../

echo 'run med proj a'
cd ./med_proj
javac -sourcepath ./src -d build/classes ./src/ua/com/alevel/Hoy.java
jar cvfm build/jar/Hoy.jar resources/MANIFEST.MF -C build/classes .
java -jar build/jar/Hoy.jar

cd ../../