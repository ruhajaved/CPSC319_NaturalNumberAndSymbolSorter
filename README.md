# CPSC319_NaturalNumberAndSymbolSorter

## Introduction

### Problem Statement

Design and implement a natural number and sumbol in Java, with additional requirements that transfrom it into a "slightly confused" sorter. Note that only certain symbols are accepted. Refer to the attached description for more details on these additional requirements.

### Project Objectives

The project objectives included:

1. Further understanding of Java and its capabilities.
2. Solidify understanding of the ArrayList data structure.
3. Practice sorting algorithms and selecting the best algorithm for a given application, in this case merge sort.
4. Practice and develop software design and architecture skills.

## Technologies

The technologies used include:

1. Java version 13.0.2 (note this is compatible with versions down to and including 1.8.0_161).

## Launch

To launch the project on your machine, first ensure that you hava a compatible Java compiler installed. 

Then ensure that all the source java files, namely ArrayList.java, IO.java, MergeSort.java, Utility.java, and Runner.java, are in the same directory and at the same level - i.e. not below or above in reference to the current working directory. While this is obvious, do not change the names of the source java files.

To run the program:

1. Ensure the working directory contains all the source files (ArrayList.java, IO.java, MergeSort.java, Utility.java, and Runner.java).
2. Execute the command "javac Runner.java".
3. Execute the command "java Runner myinput myoutput". Here, myinput is the name/address of the input file to read from, and myoutput is the name/address of the output file to either create or overwrite for program output. Note that you MUST provide 2 command line arguments and in this specific order, as specified in the command.

To be completely explicit, a set of successful commands to run the program would be:

javac Runner.java
java Runner input.txt output.txt

Upon execution, you can expect the program to appropriately output to the output file, as specified by the assignment handout. If there is any problem creating a connection with the input file (for example, if it doesn't exist) or the output file, an appropriate error will be printed to the terminal and the program will terminate. This will also happen if there's a problem writing to the output file.

## Things to Note

Note the following additional implicit requirements are implemented:

1. Blank spaces in the input file are not tolerated.
2. Empty lines in the input file are not tolerated.
3. Non-zero natural numbers which have any number of leading zeros are not tolerated.
5. Test input files(inputX.txt) are included with example input, as well as the corresponding output files(outputX.txt), which demostrates the correct and expected output from the program.
