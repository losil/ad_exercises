package ch.hslu.ad.sw01.ex01;

public interface Memory {

    Allocation malloc(int blockSize);

    void free(Allocation block);

    int getUsed();

    int getSize();
}
