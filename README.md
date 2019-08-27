
## Name: Devina Sachin Dhuri

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on the project.
#### Note: build.xml is present in racingdrivers/src folder.
To clean, compile and run, be sure to be in the racingdrivers folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command:  ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=0/1/2/3/4

Note: Arguments accept the absolute path of the files. Darg2 is the debug value


-----------------------------------------------------------------------
## Description: Data Structures used is Arraylist to store the driver positions 

Worst case Time complexity:O(n)
Space complexity:O(n)

For storing the position (rank) a normal array is used 
The method to find the rank runs for O(n2) times.

### References and Citations:
1. Reference for main structure of state classes and context class: Head First Design Patterns
2. Singleton Class: https://www.geeksforgeeks.org/singleton-class-java/
