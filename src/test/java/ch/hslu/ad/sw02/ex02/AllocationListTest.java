package ch.hslu.ad.sw02.ex02;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class AllocationListTest {

    @Test
    public void testAdd() {
        Allocation alloc1 = new Allocation(0, 8);
        Allocation alloc2 = new Allocation(7, 16);
        AllocationList allocList = new AllocationList();
        assertTrue(allocList.add(alloc1));
    }

    @Test
    public void testSize() {
        Allocation alloc1 = new Allocation(0, 8);
        Allocation alloc2 = new Allocation(7, 16);
        AllocationList allocList = new AllocationList();

        assertEquals(0, allocList.size());

        allocList.add(alloc1);
        assertThat(allocList.size()).isEqualTo(1);

        allocList.add(alloc2);
        assertThat(allocList.size()).isEqualTo(2);

    }

    @Test
    public void testContains() {
        Allocation alloc1 = new Allocation(0, 8);
        Allocation alloc2 = new Allocation(7, 16);
        AllocationList allocList = new AllocationList();
        allocList.add(alloc1);
        allocList.add(alloc2);

        assertTrue(allocList.contains(alloc1));
        assertTrue(allocList.contains(alloc2));


    }

    @Test
    public void testRemove() {
        Allocation alloc1 = new Allocation(0, 8);
        Allocation alloc2 = new Allocation(7, 16);
        AllocationList allocList = new AllocationList();
        allocList.add(alloc1);
        allocList.add(alloc2);

        assertTrue(allocList.remove(alloc1));
        assertTrue(allocList.remove(alloc2));
    }

    @Test
    public void testPoll() {
        Allocation alloc1 = new Allocation(0, 8);
        Allocation alloc2 = new Allocation(7, 16);
        AllocationList allocList = new AllocationList();
        allocList.add(alloc1);
        allocList.add(alloc2);

        assertEquals(alloc1, allocList.poll());
        assertEquals(alloc2, allocList.poll());
        assertThat(allocList.size()).isEqualTo(0);

    }
}