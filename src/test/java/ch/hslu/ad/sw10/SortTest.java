package ch.hslu.ad.sw10;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

public class SortTest {

    @Test
    public void testQuickSort() {
        Random random = new Random();
        char[] array = new char[1000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (char) (random.nextInt(26) + 'a');
        }
        Sort.quickSort(array, 0, 19);
        assertThat(array).isSorted();
    }

    @Test
    public void testQuickInsertionSort() {
        char[] array = Sort.randomChars(10);
        Sort.quickInsertionSort(array);
        assertThat(array).isSorted();

    }
}