package ch.hslu.ad.sw01.ex01;

public class MemorySimple extends Memory {

    public MemorySimple(final int size) {
        super(size);
    }

    public String toString() {
        return "MemorySimple[Belegt: " + getUsed() + "; Frei: " + (getSize() - getUsed() ) + "]";
    }
}
