# Stack and Queue-Based Expression Parsing

## Table of Contents
1. [Project Overview](#1-overview)
2. [The Shunting Yard Algorithm and Notations](#2-the-shunting-yard-algorithm-and-notations)
3. [Implementation Details/Classes](#3-classes)
    - [Main Class](#main-class)
    - [Node Class](#node-class)
    - [SinglyLinkedList Class](#singlylinkedlist-class)
    - [LinkedQueue Class](#linkedqueue-class)
    - [LinkedStack Class](#linkedstack-class)
4. [How to Use](#4-how-to-use-it)

## 1. Overview

This project showcases an implementation of essential data structures in Java, emphasizing queue and stack management using singly linked lists. It is designed to handle dynamic datasets efficiently, focusing on optimal data manipulation techniques like insertion, deletion, and traversal. Leveraging the concepts of stacks and queues, the project offers practical experience in parsing and computing mathematical expressions. 


## 2. The Shunting Yard Algorithm and Notations

The project features the Shunting Yard Algorithm, a method for converting infix mathematical expressions (such as "3 + 4") into their postfix equivalents ("3 4 +"). This algorithm uses stacks to manage operators and parentheses, ensuring correct precedence and associativity, and is essential for efficient mathematical expression evaluation.

### 1. Infix Notation
In infix notation, operators are placed between operands. For instance, "1 + 2 * 3 - 4 ^ 2". This notation respects operator precedence and may include parentheses to alter the natural precedence of operations.

### 2. Postfix Notation
Also known as reverse polish notation, postfix places the operator after the operands, e.g., "1 2 +". This notation eliminates the need for parentheses and operator precedence.

## 3. Classes

### Main Class

- **Functionality**: Demonstrates the application of stack and queue in expression evaluation.
- **Methods**:
  - `main(String[] args)`: The entry point; it processes infix expressions and uses the shunting yard algorithm for conversion and evaluation.
  - `shuntingYard(String[] stringArray)`: Implements the algorithm to convert infix to postfix notation.
  - `postFix(LinkedQueue<String> stringQueue)`: Evaluates the converted postfix expression.
  - `isNumeric(String strNum)`: Checks if a string is a numeric value.
  - `isOperator(String strOp)`: Determines if a string is an operator.
  - `precedence(String operator)`: Establishes the precedence level of an operator.
  
### Node Class

- **Functionality**: Represents a single element in a linked list.
- **Attributes**:
  - `E data`: The actual data stored in the node.
  - `Node<E> next`: Reference to the next node in the list.
- **Constructor**:
  - `Node(E data)`: Instantiates a new node with provided data.
- **Methods**:
  - `getData()`: Retrieves the data from the node.
  - `setData(E data)`: Sets or updates the node's data.
  - `getNext()`: Obtains the next node in the list.
  - `setNext(Node<E> next)`: Updates the reference to the next node.

### SinglyLinkedList Class

- **Functionality**: Manages the operations of a singly linked list.
- **Attributes**:
  - `Node<E> head`: Starting node of the list.
  - `Node<E> tail`: End node of the list.
  - `int size`: Total number of nodes in the list.
- **Constructor**:
  - `SinglyLinkedList()`: Constructs an empty linked list.
- **Methods**:
  - `addFirst(E element)`: Adds a new element at the beginning of the list.
  - `addLast(E element)`: Appends a new element at the end of the list.
  - `removeFirst()`: Removes and returns the first element of the list.
  - `getFirst()`: Retrieves the first element without removing it.
  - `last()`: Fetches the last element of the list.
  - `size()`: Returns the total number of elements in the list.
  - `isEmpty()`: Checks if the list has no elements.

### LinkedQueue Class

- **Functionality**: Implements queue operations using a singly linked list.
- **Attributes**:
  - `SinglyLinkedList<E> list`: The list that stores the queue elements.
- **Constructor**:
  - `LinkedQueue()`: Initializes an empty queue.
- **Methods**:
  - `enqueue(E element)`: Adds an element to the end of the queue.
  - `dequeue()`: Removes and returns the front element of the queue.
  - `first()`: Retrieves the front element without removing it.
  - `size()`: Provides the count of elements in the queue.
  - `isEmpty()`: Checks if the queue is empty.

### LinkedStack Class

- **Functionality**: Implements stack operations using a singly linked list.
- **Attributes**:
  - `SinglyLinkedList<E> list`: The list that stores the stack elements.
- **Constructor**:
  - `LinkedStack()`: Creates an empty stack.
- **Methods**:
  - `push(E element)`: Adds an element to the top of the stack.
  - `pop()`: Removes and returns the top element of the stack.
  - `peek()`: Retrieves the top element without removing it.
  - `size()`: Counts the elements present in the stack.
  - `isEmpty()`: Verifies if the stack has no elements.



## 4. How to Use It
Run the application with an infix expression as a command-line argument. The expression should be space-separated. The program will parse the expression into postfix notation and compute the result.




