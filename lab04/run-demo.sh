#!/bin/bash
# Script to compile and run the DemoMain class

echo "Compiling Java files..."
cd "$(dirname "$0")/src/main/java"

javac agh/ii/prinjava/lab04/exc04_02/*.java agh/ii/prinjava/lab04/exc04_02/impl/*.java

if [ $? -eq 0 ]; then
    echo "Compilation successful!"
    echo ""
    echo "Running DemoMain..."
    echo "===================="
    java agh.ii.prinjava.lab04.exc04_02.DemoMain
    
    # Clean up
    find . -name "*.class" -delete
else
    echo "Compilation failed!"
    exit 1
fi
