package ch.hslu.ad.sw02.ex03;

/**
 * Interface Stackable describes main functions of a stack.
 */
public interface Stackable<E> {

    /**
     * Tests if the stack is empty.
     *
     * @return true if empty
     */
    boolean empty();

    /**
     * Looks at the object at the top of this stack, without removing it.
     *
     * @return the object at the top of the stack
     */
    E peek();

    /**
     * Removes the object at the top.
     *
     * @return the object as value of this function
     */
    E pop();

    /**
     * Pushes the object on the top of the stack.
     *
     * @param e
     * @return returns the object pushed
     */
    E push(E e);

    /**
     * Returns the 1-based position where an object is on this stack.
     *
     * @param e
     * @return position in the stack
     */
    int search(E e);
}
