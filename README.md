***************************
* Project 2: Priority Queue
* 2019-09-19
* Benjamin Warner
***************************

# OVERVIEW

This project implemented two data structures: a MaxHeap and a PriorityQueue. The project definitions and requirements can be found here: http://cs.boisestate.edu/~cs321/projects/p-queue/2-PQueue.html.

A command line simulator is provided through the CPUScheduler.java source file.

## INCLUDED FILES

- MaxHeap.java - the implementation of the max-heap data structure
- PQueue.java - the implementation of the priority queue data structure
- Process.java - a class that models a CPU process
- ProcessGenerator.java - a class that generates new Process objects
- README.md - this file

## COMPILING AND RUNNING

Build the scheduler simulator:

`javac CPUScheduler.java`

Run the compiled simulation:

`java CPUScheduler maxProcessTime maxPriorityLevel timeToIncrementPriority simulationTime processArrivalRate`. 

To compile just the data structures:

- `javac MaxHeap.java`
- `javac PQueue.java`

To compile the CPU process simulators:

`javac ProcessGenerator.java`

Of course, none of the above (aside from the CPUScheduler) have a main method, so you won't be able to run anything with the binaries.

## PROGRAM DESIGN AND IMPORTANT CONCEPTS

The main concept to understand here, is how a max-heap works. A max-heap is a tree, with each node having no more than two children, and the parent of two children is greater than both of them. The root node is the maximum value of all the values.

# PriorityQueue
Second project for CS321 where a PriorityQueue is implemented using a MaxHeap
