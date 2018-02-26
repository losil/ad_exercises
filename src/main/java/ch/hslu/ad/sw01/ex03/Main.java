package ch.hslu.ad.sw01.ex03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        LOG.info("Fibonacci-Zahl von 10: " + fiboRec1(10));
        LOG.info("Fibonacci-Zahl von 5: " + fiboRec1(5));
        LOG.info("Fibonacci-Zahl von 13: " + fiboRec1(13));


    }

    public static int fiboRec1(final int i) {

        /*
        Rekursionsbasis
         */
        if (i <= 0) {
            return 0;
        }
        /*
        Rekursionsbasis
         */
        else if (i == 1) {
            return 1;
        }
        /*
        Rekursionsvorschrift
         */
        return fiboRec1(i-2) + fiboRec1(i-1);
    }

    public static int fibRec2(final int i) {

    }
}
