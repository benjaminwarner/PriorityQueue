***************************
* Project 2: Priority Queue
* 2019-09-19
* Benjamin Warner
***************************

# OVERVIEW

This project implemented two data structures: a MaxHeap and a PriorityQueue. 
The project definitions and requirements can be found here: http://cs.boisestate.edu/~cs321/projects/p-queue/2-PQueue.html.

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

Of course, none of the above (aside from the CPUScheduler) have a main method, 
so you won't be able to run anything with the binaries.

You can test the data structures (assuming all the test cases have been compiled) using the following commands:

- `java org.testng.TestNG maxHeap.xml`
- `java org.testng.TestNG pQueue.xml`

## PROGRAM DESIGN AND IMPORTANT CONCEPTS

The main concept to understand here, is how a max-heap works. A max-heap is a tree, with each parent having no more
than two children, and the value of the parent is greater than that of the two children. The root node 
is the maximum of all the values. The MaxHeap class contains the maxHeapify method, which is the main algorithm of 
the data structure. Basically, this method takes an index, and max-heapifies the subtree with the index given 
acting as the root (i.e takes the position at index and determines where it should be located in the heap). 

Anytime an element gets added to the heap or a key for a value changes, maxHeapify is called.

Additionally, MaxHeap maintains the value-key pair using the HeapNode class. HeapNode is incredibly
simple, and just maintains the value, and its associated key.

The PQueue data structure is just a light wrapper for the MaxHeap class. The reason being, the MaxHeap *is* the
implementation of the priority queue, and so nothing new needed to be added.

Process and ProcessGenerator are rather simple. Process models a process running on a CPU, using a psuedo random number generator
to determine some attributes. The ProcessGenerator just builds new Process objects.

## TESTING

The maxHeap.xml and pQueue.xml files were provided. After the implementations for the MaxHeap
and PQueue classes were complete, TestNG was run using the appropriate xml files. The implementations
were considered complete once all test cases were passing.

Some testing was done manually using a light-weight command line tool that would print the contents
of the max-heap after data was added/removed.

As for ensuring the functionality of the Process and ProcessGenerator classes, running the CPUScheduler
and inspecting the output was really the only testing that could be performed. Sample output was provided
at the link listed in the overview section, and the output of the CPUScheduler using the ProcessGenerator 
of this project were compared to see if the implementation was correct.

**NOTE**: Negative keys were not used (to my knowledge) for the testing of the max-heap. I have no reason
to believe that a negative key would impact anything (I mean, seriously, why would a negative number 
have any effect on the comparisons) but just be aware of that.

# DISCUSSION

This project was actually surprising easy. I was quite worried initially, because it seemed like there
was going to be a ton of work for it, but that was not the case. 

I did struggle with the increaseKey tests, because the tests assumed that indexing was 1-based. Now, 
generally this wouldn't be a big deal. Whether or not to use 1-based indexing or 0-based is an 
arbitrary decision (although, in the context of Java, it would be better and more correct use 0-based; 
everything else is 0-based in the language, making the MaxHeap 1-based will just cause confusion), 
however, the project spec *didn't mention anywhere* that the method was supposed to be 1-based. 
This is quite frustrating, and an important detail for the implementation.

The UML diagrams proved to be vague for the Process and ProcessGenerator classes, and I sort of
just guessed as to what they were supposed to do and how they should work. Code is more than just
a diagram listing the methods and variables for several classes. Desired behavior is just as important
(and I would argue *more important* than how a class should be structured). I understand why the project
used UML diagrams, because they're something that will pop up in industry, but seriously? There's no description
as to what the methods should actually do? Based on the diagrams, I could have realistically made them do anything
(and justified that behavior), because the project didn't state how they should behave.
