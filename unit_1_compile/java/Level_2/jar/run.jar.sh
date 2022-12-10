#!/bin/sh

javac -sourcepath ./src -d build/classes/ -cp ./lib/JColor-5.5.1.jar src/com/artem/util/Aloha.java src/com/artem/Hello.java
cd lib
jar xf commons-lang3-3.12.0.jar
cp -rf com ../build/classes
cd ..
jar cvfm build/jar/Hoy.jar resources/MANIFEST.MF -C build/classes .
jar tf build/jar/Hoy.jar
java -jar build/jar/Hoy.jar
