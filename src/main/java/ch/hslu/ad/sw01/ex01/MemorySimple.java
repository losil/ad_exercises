package ch.hslu.ad.sw01.ex01;

import java.util.*;

public class MemorySimple implements Memory {
    private List<Allocation> allocations = new LinkedList<>();
    private Map<Integer, Integer> freeBlocks = new HashMap<>();
    private int size;
    private int startAddress;

    public MemorySimple(final int size) {
        this.allocations = new ArrayList<>();
        this.size = size;
        this.startAddress = 0;
    }

    public Allocation malloc(final int blockSize) {
        if (freeBlocks.containsValue(blockSize)) {
            int start = 0;
            for (Map.Entry<Integer, Integer> entry : freeBlocks.entrySet()) {
                if (entry.getValue().equals(blockSize)) {
                    start = entry.getKey();
                    freeBlocks.remove(entry.getKey());
                    break;
                }
            }
            Allocation alloc = new Allocation(start, blockSize);
            this.allocations.add(alloc);
            return alloc;


        }
        Allocation alloc = new Allocation(this.startAddress, blockSize);
        this.allocations.add(alloc);
        this.startAddress += blockSize;
        return alloc;
    }

    @Override
    public void free(Allocation block) {
        this.freeBlocks.put(block.getStartAddress(),block.getSize());
        this.allocations.remove(block);
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int getUsed() {
        int i = 0;
        for (Allocation alloc : this.allocations) {
            i += alloc.getSize();
        }
        return i;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSize(), getUsed());
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof MemorySimple)) {
            return false;
        }

        MemorySimple other = (MemorySimple) obj;
        return (this.getSize() == other.getSize() && this.getUsed() == other.getUsed());
    }

    @Override
    public String toString() {
        return "MemorySimple[Belegt: " + getUsed() + "; Frei: " + (getSize() - getUsed() ) + "]";
    }
}
