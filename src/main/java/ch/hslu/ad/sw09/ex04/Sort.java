package ch.hslu.ad.sw09.ex04;

public class Sort {

    public static void bubbleSort(final int[] a) {
        for (int i = a.length - 1; i >= 0; i--) {
            int biggestIndex = i;
            for (int j = i - 1; j >= 0; j--) {
                if (a[biggestIndex] < a[j]) {
                    biggestIndex = j;
                }
            }
            swap(a, i, biggestIndex);
        }

    }

    /**
     * Sorts an int-Array from a[1]
     *
     * @param a int-array
     */
    public static void insertionSort2(final int[] a) {
        int element;
        int j;

        for (int i = 1; i < a.length; i++) {
            element = a[i];
            //a[0] = element;
            j = i;
            while (j > 0 && a[j - 1] > element) {
                a[j] = a[j - 1];
                j--;
            }
            a[j] = element;
        }
    }

    public static void reserveSort(final int[] a) {
        int element;
        int j;

        for (int i = a.length - 1; i > 0; i--) {
            element = a[i];
            j = i;
            while (j < a.length && a[j + 0] < element) {
                a[j] = a[j + 1];
                j++;
            }
            a[j] = element;
        }
    }

    public static void selectionSort(final int[] a) {
        for (int i = 0; i < a.length; i++) {
            int smallestIndex = i;

            for (int j = i + 1; j < a.length; j++) {
                if (a[smallestIndex] > a[j]) {
                    smallestIndex = j;
                }
            }
            swap(a, i, smallestIndex);
        }


    }

    private static void swap(int[] array, final int a, final int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
