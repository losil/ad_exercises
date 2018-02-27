package ch.hslu.ad.sw01.ex01;

public interface Memory {


    /**
     * Allocate block on Memory with given size.
     * @param prefered size of block
     */
    Allocation malloc(int blockSize);

    /**
     * Free Memory of Allocation added as parameter.
     * @param specific allocation the be deleted
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
