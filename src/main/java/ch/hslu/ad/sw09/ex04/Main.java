package ch.hslu.ad.sw09.ex04;

import com.sun.deploy.util.ArrayUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        int[] array = new int[10];
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
        }

        LOG.info(Arrays.toString(array));
        Sort.insertionSort2(array);
        LOG.info(Arrays.toString(array));


        /*
        Testing revers
         */
        int[] revArray = new int[10];
        for (int i = 0; i < array.length; i++) {
            revArray[i] = random.nextInt(100);
        }
        Sort.reserveSort(revArray);
        LOG.info(Arrays.toString(revArray));



        /*
         * Runtime Testing
         */
        int[] bigArray = new int[20000];
        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = random.nextInt(10000);
        }
        //Arrays.sort(bigArray);
        //Arrays.sort(bigArray, Collections.reverseOrder());
        //Arrays.sor
        long start = System.currentTimeMillis();
        Sort.insertionSort2(bigArray);
        LOG.info("Sort of Array took " + (System.currentTimeMillis() - start) + "ms");



        /*
        Testing selection sort
         */

        int[] selSortArray = new int[10];
        for (int i = 0; i < selSortArray.length; i++) {
            selSortArray[i] = random.nextInt(100);
        }
        LOG.info("Sorting with selectionSort");
        LOG.info(Arrays.toString(selSortArray));
        Sort.selectionSort(selSortArray);
        LOG.info(Arrays.toString(selSortArray));


        /*
        Testing bubbleSort
         */
        int[] bubSort = new int[10];
        for (int i = 0; i < bubSort.length; i++) {
            bubSort[i] = random.nextInt(100);
        }
        LOG.info("Sorting with bubbleSort");
        LOG.info(Arrays.toString(bubSort));
        Sort.bubbleSort(bubSort);
        LOG.info(Arrays.toString(bubSort));

    }
}
