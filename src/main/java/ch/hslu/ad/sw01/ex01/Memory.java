package ch.hslu.ad.sw01.ex01;

public interface Memory {


    /**
     * Allocate block on Memory with given size.
     * @param blockSize prefered size of block
     */
    Allocation malloc(int blockSize);

    /**
     * Free Memory of Allocation added as parameter.
     * @param block specifix allocation to be deleted
     */
    void free(Allocation block);

    /**
     * Get usage of memory
     * @return integer value of used
     */
    int getUsed();

    /**
     * Returns the size of the memory
     * @return memory size
     */
    int getSize();
}
