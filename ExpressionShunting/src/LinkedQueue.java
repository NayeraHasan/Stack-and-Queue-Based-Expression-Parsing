import java.util.NoSuchElementException;

/**
 * LinkedQueue class represents a queue implemented using a singly linked list.
 * @param <E> the type of element stored in the queue
 */
class LinkedQueue<E> implements Queue<E> {
    private SinglyLinkedList<E> list;

    /**
     * Constructs a new empty queue.
     */
    public LinkedQueue() {
        list = new SinglyLinkedList<>();  // new queue relies on the initially empty list
    }

    /**
     * Adds an element to the back of the queue.
     * @param element the element to add to the queue
     */
    public void enqueue(E element) {
        list.addFirst(element);
    }


    /**
     * Removes and returns the element at the front of this Queue.
     *
     * @return the element at the front of this Queue
     * @throws NoSuchElementException if this Queue is empty
     */
    public E dequeue() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return list.removeFirst();
    }

    /**
     * Returns the front element of the queue without removing it.
     * @return the front element of the queue
     * @throws NoSuchElementException if the queue is empty
     */
    public E first() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        Node<E> current = list.getHead();
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current.getData();
    }

    /**
     * Gets the number of elements in the queue.
     *
     * @return the number of elements in the queue
     */
    public int size() {
        return list.size();
    }

     /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    public boolean isEmpty() {
        return list.isEmpty();
    }

}
