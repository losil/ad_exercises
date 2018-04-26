package ch.hslu.ad.sw09.ex04;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class SortTest {

    @Test
    public void testInsertionSort2() {
        int[] array1 = new int[]{4, 93, 199, 1, 33, 78};
        int[] array2 = new int[]{4, 93, 199, 1, 33, 78};
        Arrays.sort(array1);
        Sort.insertionSort2(array2);
        assertThat(Arrays.toString(array2)).isEqualTo(Arrays.toString(array1));

    }

    @Test
    public void testBubbleSort() {
        int[] array1 = new int[]{4, 93, 199, 1, 33, 78};
        int[] array2 = new int[]{4, 93, 199, 1, 33, 78};
        Arrays.sort(array1);
        Sort.insertionSort2(array2);
        assertThat(Arrays.toString(array2)).isEqualTo(Arrays.toString(array1));
    }

    @Test
    public void testReserveSort() {
        int[] array1 = new int[]{4, 93, 199, 1, 33, 78};
        int[] array2 = new int[]{4, 93, 199, 1, 33, 78};
        Arrays.sort(array1);
        Sort.insertionSort2(array2);
        assertThat(Arrays.toString(array2)).isEqualTo(Arrays.toString(array1));
    }

    @Test
    public void testSelectionSort() {
        int[] array1 = new int[]{4, 93, 199, 1, 33, 78};
        int[] array2 = new int[]{4, 93, 199, 1, 33, 78};
        Arrays.sort(array1);
        Sort.insertionSort2(array2);
        assertThat(Arrays.toString(array2)).isEqualTo(Arrays.toString(array1));
    }
}