package ch.hslu.ad.sw02.ex03;

/**
 * Interface Stackable describes main functions of a stack.
 */
public interface Stackable {

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
    String peek();

    /**
     * Removes the object at the top.
     *
     * @return the object as value of this function
     */
    String pop();

    /**
     * Pushes the object on the top of the stack.
     *
     * @param str
     * @return returns the object pushed
     */
    String push(String str);

    /**
     * Returns the 1-based position where an object is on this stack.
     *
     * @param str
     * @return position in the stack
     */
    int search(String str);
}
