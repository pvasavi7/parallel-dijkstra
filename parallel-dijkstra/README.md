# Parallel-Dijkstra-Java
Implementation of Parallel Processing of Dijkstra algorithm using Java  
"input.txt" will be used as Input and "output.txt" contains output;  Execution time is printed in milliseconds in output file as well as in console. Output file gives information about the shortest distance from source node to that particular node.  
Use *-sequential* for sequential or *-parallel* for parallel. Input *numberOfNodes* and *edgeDensity* if you want to generate a new graph (in which case will be written in "input.txt")  
In the scenario of no arguments  given, by default it considers parallel processing and it runs with 4 threads.
Note: *edgeDensity* is represented in percentages and needs to be between 0 and 100.  
### Argument Sample 
**-sequential 100 40**
**-parallel 4**   

Note: The programs works well in IntelliJ. Could not generate a graph with high number of nodes due to system limitations.
