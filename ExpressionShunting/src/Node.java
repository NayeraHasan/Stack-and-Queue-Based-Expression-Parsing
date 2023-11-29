/**
 * Node class represents a node in a singly linked list.
 * @param <E> the type of element stored in the node
 */
class Node<E> {
    private E data;
    private Node<E> next;

    /**
     * Constructs a new node with the given element.
     * @param data the element to store in the node
     */
    public Node(E data) {
        this.data = data;
        this.next = null;
    }

    /**
     * Gets the element stored in the node.
     *
     * @return the element stored in the node
     */
    public E getData() {
        return data;
    }

    /**
     * Sets the element stored in the node.
     *
     * @param data the element to store in the node
     */
    public void setData(E data) {
        this.data = data;
    }

    /**
     * Gets the next node in the linked list.
     *
     * @return the next node in the linked list
     */
    public Node<E> getNext() {
        return next;
    }

    /**
     * Sets the next node in the list.
     *
     * @param next the next node in the linked list
     */
    public void setNext(Node<E> next) {
        this.next = next;
    }
}