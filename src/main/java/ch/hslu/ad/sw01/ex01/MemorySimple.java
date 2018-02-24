package ch.hslu.ad.sw01.ex01;

import java.util.Objects;

public class MemorySimple extends Memory {

    public MemorySimple(final int size) {
        super(size);
    }

    public int hashCode() {
        return Objects.hash(getSize(), getUsed());
    }

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

    public String toString() {
        return "MemorySimple[Belegt: " + getUsed() + "; Frei: " + (getSize() - getUsed() ) + "]";
    }
}
