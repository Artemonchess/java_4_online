#!/bin/sh

javac -sourcepath ./src -d build/classes/ -cp ./lib/commons-lang3-3.12.0.jar src/com/artem/util/Aloha.java src/com/artem/Hoy.java
cd lib || exit
jar xf commons-lang3-3.12.0.jar
cp -rf com ../build/classes
cd ..
jar cvfm build/jar/Hoy.jar resources/MANIFEST.MF -C build/classes .
jar tf build/jar/Hoy.jar
java -jar build/jar/Hoy.jar

echo 'variant 2'
rm -rf lib/com
rm -rf lib/META-INF
javac -sourcepath ./src -d build/classes/ -cp ./lib/commons-lang3-3.12.0.jar src/com/artem/util/Aloha.java src/com/artem/Hoy.java
cp -r lib/*.jar build/jar
jar cvfm build/jar/hoy.jar resources/MANIFEST.MF -C build/classes .
java -jar build/jar/hoy.jar