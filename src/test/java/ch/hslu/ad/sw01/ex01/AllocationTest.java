package ch.hslu.ad.sw01.ex01;

import org.junit.Test;

import static org.junit.Assert.*;

public class AllocationTest {

    @Test
    public void testGetSize() {
        Allocation allo = new Allocation(8);
        assertEquals(8, allo.getSize());
    }

    @Test
    public void testHashCode() {
        Allocation allo = new Allocation(8);
        Allocation allo1 = allo;

        assertEquals(allo1.hashCode(), allo.hashCode());
    }

    @Test
    public void testCompareTo() {
        Allocation allo = new Allocation(8);
        Allocation allo1 = new Allocation(16);
        Allocation allo2 = allo;
        assertEquals(1, allo.compareTo(allo1));
        assertEquals(0, allo.compareTo(allo2));
    }

    @Test
    public void testToString() {
        Allocation allo = new Allocation(8);
        assertNotNull(allo.toString());
    }
}