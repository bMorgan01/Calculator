javac *.java
IF EXIST Calc.jar DEL /F Calc.jar
jar cfm Calc.jar manifest.txt *.class
echo off
DEL /F *.class
DEL /F *.ctxt
cls
java -jar Calc.jar
