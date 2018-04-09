package ch.hslu.ad.sw06.ex02;

/**
 * Interface for accesses management for protected areas.
 */
public interface Synch {

    /**
     * Get access to a protected area,
     * if no access is possible wait for access.
     *
     * @throws InterruptedException
     */
    void acquire() throws InterruptedException;

    /**
     * Freeing protected area.
     */
    void release();


}
