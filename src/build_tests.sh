#!/bin/bash

javac HeapNode.java -d ../MaxHeapTests
javac HeapNode.java -d ../PriorityQueueTests

for test_file in MaxHeapTest_*
do
	javac $test_file -d ../MaxHeapTests
done

for test_file in PriorityQueueTest_*
do
	javac $test_file -d ../PriorityQueueTests
done
