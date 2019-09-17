#!/bin/bash

for test_file in MaxHeapTest_*
do
	javac $test_file -d ../TestNG
done
