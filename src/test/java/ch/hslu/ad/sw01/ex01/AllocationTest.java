package ch.hslu.ad.sw01.ex01;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mutabilitydetector.unittesting.MutabilityAssert.assertImmutable;

public class AllocationTest {

    @Test
    public void testGetSize() {
        Allocation allo = new Allocation(0,8);
        assertEquals(8, allo.getSize());
    }

    @Test
    public void testHashCode() {
        Allocation allo = new Allocation(0,8);
        Allocation allo1 = allo;

        assertEquals(allo1.hashCode(), allo.hashCode());
    }

    @Test
    public void testCompareTo() {
        Allocation allo = new Allocation(0,8);
        Allocation allo1 = new Allocation(8,16);
        Allocation allo2 = allo;
        assertEquals(-1, allo.compareTo(allo1));
        assertEquals(0, allo.compareTo(allo2));
    }

    @Test
    public void testToString() {
        Allocation allo = new Allocation(0,8);
        assertNotNull(allo.toString());
    }

    @Test
    public void testEquals() {
        EqualsVerifier.forClass(Allocation.class);

    }

    @Test
    public void testImmutability() {
        assertImmutable(Allocation.class);
    }
}