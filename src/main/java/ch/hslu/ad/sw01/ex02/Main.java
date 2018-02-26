package ch.hslu.ad.sw01.ex02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static Logger LOG = LogManager.getLogger(Main.class);
    private static int task1 = 0;
    private static int task2 = 0;
    private static int task3 = 0;

    public static void main(String[] args) {
     task(10);
    }

    private static void task(final int n) {
        LOG.info(System.currentTimeMillis());
        task1();
        task1();
        task1();
        task1();
        LOG.info(System.currentTimeMillis());


        for ( int i = 0 ; i < n ; i++) {
            task2();
            task2();
            task2();
            for (int j = 0 ; j < n ; j++) {
                task3();
                task3();
            }
        }
        LOG.info(System.currentTimeMillis());
        LOG.info("Anzahl Durchlauefe von task1(): " + task1);
        LOG.info("Anzahl Durchlauefe von task2(): " + task2);
        LOG.info("Anzahl Durchlauefe von task3(): " + task3);
    }

    private static void task1() {
        task1++;
        try {
            Thread.sleep(5);
        }
        catch (InterruptedException e) {
            LOG.error(e);
        }

        }

    private static void task2() {
        task2++;
        try {
            Thread.sleep(5);
        }
        catch (InterruptedException e) {
            LOG.error(e);
        }
    }

    private static void task3() {
        task3++;
        try {
            Thread.sleep(5);
        }
        catch (InterruptedException e) {
            LOG.error(e);
        }
    }

    private static int fiboRec1(int i) {
        if (i <= 0) {
            return 0;
        }
        else if ( i == 1) {
            return 1;
        }

        return fiboRec1(i-2) + fiboRec1(i-1);


    }

}
