import java.util.NoSuchElementException;

/**
 * SinglyLinkedList class represents a singly linked list data structure.
 * @param <E> the type of element stored in the list
 */
class SinglyLinkedList<E> {
    private Node<E> head; // head node of the list (or null if empty)
    private Node<E> tail; // last node of the list (or null if empty)
    private int size; // number of nodes in the list

    /**
     * Constructs a new empty list.
     */
    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Adds an element to the front of the list.
     * @param element the element to add to the front of the list
     */
    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        newNode.setNext(head);
        head = newNode;

        if (isEmpty())
            tail = head; // special case: new node becomes tail also

        size++;
    }
    public void addLast(E element) { // adds element e to the end of the list
        Node<E> newNode = new Node<>(element); // node will eventually be the tail

        if (isEmpty()) // special case: previously empty list
            head = newNode;
        else
            tail.setNext(newNode); // new node after existing tail
        tail = newNode; // new node becomes the tail
        size++;
    }
    /**
     * Removes and returns the first element from the list.
     * @return the removed element
     * @throws NoSuchElementException if the list is empty
     */
    public E removeFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        Node<E> oldHead = head;
        head = head.getNext();
        size--;
        return oldHead.getData();
    }

    /**
     * Gets the first element in the list without removing it.
     * @return the first element in the list
     * @throws NoSuchElementException if the list is empty
     */
    public E getFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return head.getData();
    }

    /**
     Retrieves the last element of the queue without removing it.
     @return the last element of the queue
     @throws NoSuchElementException if the queue is empty
     */
    public E last() {
// Check if the queue is empty
        if (isEmpty()) {
// If the queue is empty, throw a NoSuchElementException
            throw new NoSuchElementException("Queue is empty");
        }
// If the queue is not empty, return the data of the tail node
        return tail.getData();
    }

    /**
     * Gets the number of elements in the list.
     * @return the number of elements in the list
     */

    public int size() {
        return size;
    }

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }
    public Node<E> getHead() {
        return head;
    }

}
