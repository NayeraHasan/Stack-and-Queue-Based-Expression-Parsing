import java.util.NoSuchElementException;

public class LinkedStack<E> implements Stack<E> {

    private SinglyLinkedList<E> list;


/**
 * Constructs a new empty stack.
 */
public LinkedStack() {
        list = new SinglyLinkedList<E>();  // new stack relies on the initially empty list
        }

/**
 * Adds an element to the top of the stack.
 * @param element the element to add to the stack
 */
public void push(E element) {
        list.addFirst(element);
        }

/**
 * Removes and returns the top element from the stack.
 * @return the removed element
 * @throws NoSuchElementException if the stack is empty
 */
public E pop() throws NoSuchElementException {
        if (isEmpty()) {
        throw new NoSuchElementException("Stack is empty");
        }
        return list.removeFirst();
        }

/**
 * Returns the top element of the stack without removing it.
 * @return the top element of the stack
 * @throws NoSuchElementException if the stack is empty
 */
public E peek() throws NoSuchElementException {
        if (isEmpty()) {
        throw new NoSuchElementException("Stack is empty");
        }
        return list.getFirst();
        }

/**
 * Gets the number of elements in the stack.

 * @return the number of elements in the stack
 */
public int size() {
        return list.size();
        }

/**
 * Checks if the stack is empty.
 * @return true if the stack is empty, false otherwise
 */
public boolean isEmpty() {
        return list.isEmpty();
        }
}
