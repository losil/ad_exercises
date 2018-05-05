package ch.hslu.ad.sw11.ex01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class Main {

    private static Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        final int size = 200000000;
        final int[] array = new int[size];
        final ForkJoinPool pool = new ForkJoinPool();

        final RandomInitTask initTask = new RandomInitTask(array, 100);
        pool.invoke(initTask);
        //LOG.info(Arrays.toString(array));
        final SortTask sortTask = new SortTask(array);
        long start = System.currentTimeMillis();
        LOG.info("Starting to Sort Array with size: " + size);
        pool.invoke(sortTask);
        LOG.info("Sorted Array with " + size + " elements in: " + (System.currentTimeMillis() - start) + "ms");

    }
}
