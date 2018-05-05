package ch.hslu.ad.sw10;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        /*
        Measuring quickSort of array with size of 2000.
         */
        char[] array = Sort.randomChars(2000);
        LOG.info("Starting to quickSort Array with size 2000");
        long start = System.currentTimeMillis();
        Sort.quickSort(array);
        LOG.info("Finished in: " + (System.currentTimeMillis() - start) + "ms.");


        /*
        Measuring quickSort of array with size of 100'000
         */
        char[] array1 = Sort.randomChars(100000);
        LOG.info("Starting to quickSort Array with size 100'000");
        start = System.currentTimeMillis();
        Sort.quickSort(array1);
        LOG.info("Finished in: " + (System.currentTimeMillis() - start) + "ms.");


        /*
        Measuring quickSort of array with size of 500'000
         */
        char[] array2 = Sort.randomChars(500000);
        LOG.info("Starting to quickSort Array with size 1'000'000");
        start = System.currentTimeMillis();
        Sort.quickSort(array2);
        LOG.info("Finished in: " + (System.currentTimeMillis() - start) + "ms.");


        /*
        Measuring quickInsertionSort of array with size of 2000.
         */
        char[] array3 = Sort.randomChars(2000);
        LOG.info("Starting to quickInsertionSort Array with size 2000");
        start = System.currentTimeMillis();
        Sort.quickSort(array3);
        LOG.info("Finished in: " + (System.currentTimeMillis() - start) + "ms.");


        /*
        Measuring quickInsertionSort of array with size of 100'000
         */
        char[] array4 = Sort.randomChars(100000);
        LOG.info("Starting to quickInsertionSort Array with size 100'000");
        start = System.currentTimeMillis();
        Sort.quickSort(array4);
        LOG.info("Finished in: " + (System.currentTimeMillis() - start) + "ms.");


        /*
        Measuring quickInsertionSort of array with size of 500'000
         */
        char[] array5 = Sort.randomChars(500000);
        LOG.info("Starting to quickInsertionSort Array with size 1'000'000");
        start = System.currentTimeMillis();
        Sort.quickSort(array5);
        LOG.info("Finished in: " + (System.currentTimeMillis() - start) + "ms.");

    }
}
