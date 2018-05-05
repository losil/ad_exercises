package ch.hslu.ad.sw11.ex01;

import ch.hslu.ad.sw10.Sort;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class SortTask extends RecursiveAction {
    private static int THRESHOLD;
    private final int[] array;
    private final int min;
    private final int max;


    public SortTask(final int a[]) {
        this(a, 0, a.length - 1);
    }

    private SortTask(final int[] a, final int min, final int max) {
        this.array = a;
        this.min = min;
        this.max = max;
        THRESHOLD = a.length / 8;
    }

    @Override
    protected void compute() {
        if ((this.max - this.min) < THRESHOLD) {
            sortSequentially(min, max);
        } else {
            final int mid = min + (max - min) / 2;
            invokeAll(
                    new SortTask(this.array, min, mid),
                    new SortTask(this.array, mid, max));
            merge(min, mid, max);

        }

    }

    private void merge(final int min, final int mid, final int max) {
        int[] buff = Arrays.copyOfRange(this.array, min, mid); //copies Array from min to mid-1
        int i = 0;
        int j = min;
        int k = mid;

        while (i < buff.length) {
            if (k == max || buff[i] < this.array[k]) {
                this.array[j] = buff[i];
                i++;
            } else {
                this.array[j] = this.array[k];
                k++;
            }
            j++;
        }
    }

    private void sortSequentially(final int min, final int max) {
        Arrays.sort(this.array, min, max);
    }
}
