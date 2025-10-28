# Lab04 - Doubly Linked List Based Data Structures

This lab implements Queue and Stack data structures using doubly linked lists.

## Structure

### Package: `agh.ii.prinjava.lab04.exc04_02`

#### Main Classes:
- **DemoMain.java** - Main demonstration class that tests Queue and Stack implementations
- **EmptyStructureException.java** - Custom exception for empty structure operations
- **MyQueue.java** - Queue interface (FIFO - First In First Out)
- **MyStack.java** - Stack interface (LIFO - Last In First Out)

#### Implementation Package: `impl`
- **MyQueueDLLBImpl.java** - Doubly linked list based Queue implementation
- **MyStackDLLBImpl.java** - Doubly linked list based Stack implementation
- **DLinkList.java** - Helper doubly linked list class

#### Tests:
- **MyQueueTest.java** - JUnit tests for Queue implementation
- **MyStackTest.java** - JUnit tests for Stack implementation

## Running the Demo

To run the demonstration:

```bash
cd lab04/src/main/java
javac agh/ii/prinjava/lab04/exc04_02/*.java agh/ii/prinjava/lab04/exc04_02/impl/*.java
java agh.ii.prinjava.lab04.exc04_02.DemoMain
```

## Expected Output

The demo demonstrates:
1. **Queue (FIFO)**: Elements are dequeued in the same order they were enqueued
2. **Stack (LIFO)**: Elements are popped in reverse order of how they were pushed
3. **Exception Handling**: Proper exceptions when operations are attempted on empty structures

## Features Demonstrated

### MyQueue
- `enqueue(E x)` - Add element to the end
- `dequeue()` - Remove and return element from the front
- `peek()` - View element at the front without removing
- `numOfElems()` - Get queue size
- `isEmpty()` - Check if queue is empty

### MyStack
- `push(E x)` - Add element to the top
- `pop()` - Remove and return element from the top
- `peek()` - View element at the top without removing
- `size()` - Get stack size
- `isEmpty()` - Check if stack is empty
