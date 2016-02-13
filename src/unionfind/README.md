# Union Find

These files use the Stopwatch class from the performance package. You will need to compile that folder as well if you would like to run this program.

To compile these java files, run the following from the parent directory in your Terminal:
```
javac -d bin -sourcepath src -classpath bin src/unionfind/*.java
```
Be sure to create a 'bin' directory in your 'algorithms' directory for all of the compiled .class files.

To run the program, run the following from your Terminal:
```
java -classpath bin unionfind.WeightedQuickUnion < mediumUF.txt
```