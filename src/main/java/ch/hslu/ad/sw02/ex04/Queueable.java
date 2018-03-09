package ch.hslu.ad.sw02.ex04;

/**
 * This interface describes a Queue.
 */
public interface Queueable<E> {

    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.
     *
     * @param c character to add to queue
     * @return true upon success
     * @throws IllegalArgumentException if no space is available
     */
    boolean add(E c);

    /**
     * Retrives, but does not remove, the head of this queue.
     *
     * @return head of queue
     */
    E element();

    /**
     * Inserts the specified chart into this queue, or returns null if queue is empty.
     *
     * @param c
     * @return head or null
     */
    boolean offer(E c);

    /**
     * Retrives, but does not remove the head of queue or returns null if is empty.
     *
     * @return head or null
     */
    E peek();

    /**
     * Retrives and removes the head of this queue, or returns null if empty.
     *
     * @return head or null
     */
    E poll();

    /**
     * retrieves and removes the head of this queue.
     *
     * @return head of queue
     */
    E remove();


}
