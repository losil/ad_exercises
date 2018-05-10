package ch.hslu.ad.sw10;

import java.util.Arrays;
import java.util.Random;

public class Sort {

    public static void bubbleSort(final int[] a) {
        ch.hslu.ad.sw09.ex04.Sort.bubbleSort(a);
    }

    /**
     * Sorts an int-Array from a[1]
     *
     * @param a int-array
     */
    public static void insertionSort2(final int[] a) {
        ch.hslu.ad.sw09.ex04.Sort.insertionSort2(a);
    }


    /**
     * Sorts the whole character array.
     *
     * @param a
     */
    public static void quickSort(final char[] a) {
        quickSort(a, 0, (a.length - 1));
    }


    /**
     * Sorts an char Character with quicksort algorithm.
     *
     * @param a     array
     * @param left  left-border
     * @param right right-border
     */
    public static void quickSort(final char[] a, final int left, final int right) {
        int up = left;     //left border
        int down = right - 1; //left border, without separator Element
        char separator = a[right];
        boolean allChecked = false;

        do {
            while (a[up] < separator) {
                up++;
            }
            while ((a[down] >= separator) && (down > up)) {
                down--;
            }
            if (down > up) {
                exchange(a, up, down);
                up++;
                down--;
            } else {
                allChecked = true;
            }
        } while (!allChecked);
        exchange(a, up, right);
        if (left < (up - 1)) quickSort(a, left, (up - 1));
        if ((up + 1) < right) quickSort(a, (up + 1), right);
    }

    public static void quickInsertionSort(final char[] a) {
        quickInsertionSort(a, 0, (a.length - 1));

    }

    /**
     * Sorts an char array with the Quick Insertion Sort Method.
     *
     * @param a
     * @param left
     * @param right
     */
    public static void quickInsertionSort(final char[] a, final int left, final int right) {
        int up = left;     //left border
        int down = right - 1; //left border, without separator Element
        char separator = a[right];
        boolean allChecked = false;

        do {
            while (a[up] < separator) {
                up++;
            }
            while ((a[down] >= separator) && (down > up)) {
                down--;
            }
            if (down > up) {
                exchange(a, up, down);
                up++;
                down--;
            } else {
                allChecked = true;
            }
        } while (!allChecked);
        exchange(a, up, right);

        if (left < (up - 1)) {
            if ((up - 1) - left >= 20) {
                Arrays.sort(a, left, up - 1);
            } else {
                quickSort(a, left, (up - 1));
            }
        }
        if ((up + 1) < right) {
            if ((right - up) >= 20) {
                Arrays.sort(a, right, (up + 1));

            } else {
                quickSort(a, (up + 1), right);
            }
        }
    }


    public static void reserveSort(final int[] a) {
        ch.hslu.ad.sw09.ex04.Sort.reserveSort(a);
    }

    public static void selectionSort(final int[] a) {
        ch.hslu.ad.sw09.ex04.Sort.selectionSort(a);
    }


    public static char[] randomChars(final int length) {
        char[] array = new char[length];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = (char) (random.nextInt(52) + 'A');
        }
        return array;
    }

    /**
     * Swaps two characters in an array.
     *
     * @param firstIndex  first
     * @param secondIndex second
     */
    private static final void exchange(final char[] a, final int firstIndex, final int secondIndex) {
        char tmp;
        tmp = a[firstIndex];
        a[firstIndex] = a[secondIndex];
        a[secondIndex] = tmp;
    }

    private static void swap(int[] array, final int a, final int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}

