package ch.hslu.ad.sw08.ex03;

/**
 * Interface Count describes basis behaviour of a Counter.
 */
public interface Count {

    /**
     * Increment a variable.
     */
    void increment();

    /**
     * Decremet a variable.
     */
    void decrement();

    /**
     * Read current value of counter variable.
     *
     * @return current counter value
     */
    int get();
}
