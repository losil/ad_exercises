package ch.hslu.ad.sw10.ex04;

/**
 * Defines basic methods of a integer heap.
 */
public interface IntegerHeap {

    /**
     * Get biggest integer in heap strucure.
     *
     * @return biggest value
     */
    int getMax();


    /**
     * Add new value to heap.
     */
    void insert(int i);

    /**
     * Returns size of heap
     *
     * @return size of heap
     */
    int getSize();

    /**
     * Return full state.
     *
     * @return true if heap is full.
     */
    boolean isFull();
}
