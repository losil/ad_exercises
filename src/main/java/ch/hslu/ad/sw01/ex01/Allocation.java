package ch.hslu.ad.sw01.ex01;

public class Allocation implements Comparable<Allocation>{
    private static int START_ADDRESS = 0;
    private final int startAddress;
    private final int memoryBlockSize;

    public Allocation(final int memoryBlockSize) {
        this.startAddress = START_ADDRESS;
        this.memoryBlockSize = memoryBlockSize;
        START_ADDRESS += memoryBlockSize;
    }

    public int getSize() {
        return this.memoryBlockSize;
    }

    public int hashCode() {
        return Integer.hashCode(this.startAddress + this.memoryBlockSize);
    }

    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }

        if (! (obj instanceof Allocation)) {
            return false;
        }

        final Allocation other = (Allocation) obj;
        return (this.memoryBlockSize == other.memoryBlockSize && this.startAddress == other.startAddress);
    }

    public int compareTo(Allocation other){
        if (this.startAddress < other.startAddress) {
            return 1;
        }

        else if(this.startAddress < other.startAddress) {
            return -1;
        }

        else {
            return 0;
        }
    }

    public String toString() {
        return "Allocation[Address: " + this.startAddress + "; Size: " + this.memoryBlockSize + "]";
    }

}


