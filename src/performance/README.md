* Performance package
These classes were created to help compare various algorithms. All terminal commands are run from the parent directory ('algorithms').

** Stopwatch
Used to calculate runtime.

** SortCompare
Used to compare to sorting methods. To use:
```
java -classpath bin performance.SortCompare <sorting algorithm 1> <sorting algorithm 2> <length of array to sort> <number of trials>
```
For example, to test Selection sort against Insertion sort on an array of size 1000 with 100 trials:
```
java -classpath bin performance.SortCompare Selection Insertion 1000 100
```