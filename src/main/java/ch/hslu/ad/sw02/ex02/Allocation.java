package ch.hslu.ad.sw02.ex02;

public final class Allocation implements Comparable<Allocation> {
    private final int startAddress;
    private final int memoryBlockSize;

    public Allocation(final int startAddress, final int memoryBlockSize) {
        this.startAddress = startAddress;
        this.memoryBlockSize = memoryBlockSize;
    }

    public int getSize() {
        return this.memoryBlockSize;
    }

    public int getStartAddress() {
        return this.startAddress;
    }

    public int hashCode() {
        return Integer.hashCode(this.startAddress);
    }

    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Allocation)) {
            return false;
        }

        final Allocation other = (Allocation) obj;
        return (this.startAddress == other.startAddress);
    }

    public int compareTo(Allocation other) {
        if (other == this) {
            return 0;
        }

        return Integer.compare(this.startAddress, other.startAddress);
    }

    public String toString() {
        return "Allocation[Address: " + this.startAddress + "; Size: " + this.memoryBlockSize + "]";
    }

}
