package ch.hslu.ad.sw01.ex01;

import java.util.ArrayList;

public abstract class Memory {

    private int size;
    private int startAddress;
    private ArrayList<Allocation> allocation;

    public Memory(final int size) {
        this.allocation = new ArrayList<>();
        this.size = size;
        this.startAddress = 0;
    }

    public Allocation malloc(final int blockSize) {
        Allocation alloc = new Allocation(this.startAddress, blockSize);
        this.allocation.add(alloc);
        this.startAddress += blockSize;
        return alloc;
    }

    public void free(Allocation block) {
        this.allocation.remove(block);
    }

    protected int getSize() {
        return this.size;
    }

    protected int getUsed() {
        int i = 0;
        for (Allocation alloc : this.allocation) {
            i += alloc.getSize();
        }
        return i;
    }


}
