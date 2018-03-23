package ch.hslu.ad.sw04;


import ch.hslu.ad.sw04.ex01.HashSet;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class HashSetTest {

    @Test
    public void testAdd() {
        HashSet hs = new HashSet();
        hs.add(2);
        hs.add(3);
        assertThat(hs.add(4)).isEqualTo(true);

    }

    @Test
    public void testAddDuplicate() {
        HashSet hs = new HashSet();
        hs.add(2);
        hs.add(3);
        assertThat(hs.add(3)).isEqualTo(false);

    }

    @Test
    public void testContains() {
        HashSet hs = new HashSet();
        hs.add(2);
        hs.add(3);
        assertThat(hs.contains(2)).isEqualTo(true);
    }

    @Test
    public void testContainsMissing() {
        HashSet hs = new HashSet();
        hs.add(2);
        hs.add(3);
        assertThat(hs.contains(5)).isEqualTo(false);
    }

    @Test
    public void testRemove() {
        HashSet hs = new HashSet();
        hs.add(2);
        hs.add(4);
        assertThat(hs.remove(4)).isEqualTo(true);
    }

    @Test
    public void testRemoveMissing() {
        HashSet hs = new HashSet();
        hs.add(2);
        hs.add(4);
        assertThat(hs.remove(3)).isEqualTo(false);
    }

    @Test
    public void testIsEmptyContains() {
        HashSet hs = new HashSet();
        hs.add(2);
        hs.add(4);
        assertThat(hs.isEmpty()).isEqualTo(false);
    }

    @Test
    public void testIsEmpty() {
        HashSet hs = new HashSet();
        assertThat(hs.isEmpty()).isEqualTo(true);
    }
}

