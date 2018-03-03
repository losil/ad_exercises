package ch.hslu.ad.sw01.ex03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        LOG.info("Fibonacci-Zahl von 10: " + fiboRec1(10));
        LOG.info("Fibonacci-Zahl von 5: " + fiboRec1(5));
        LOG.info("Fibonacci-Zahl von 40: " + fiboRec1(40));
        LOG.info("Fibo2 von 10: " + fiboRec2(10));

        LOG.info("FiboIter von 10: " + fiboIter(10));


    }

    private static int fiboRec1(final int i) {

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

    private static long fiboRec2(final int n) {
        final long[] interimResults = new long[n];

        //Rekursionsbasis erstellen
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        //Rekursionsvorschrift
        if (interimResults[n - 1] == 0) {
            long result = (fiboRec2(n - 2) + fiboRec2(n - 1));
            interimResults[n - 1] = result;
            return result;
        }

        return interimResults[n - 3] + interimResults[n - 2];
    }

    private static int fiboIter(final int n) {
        int result = 0, y = 1, z = 1;
        for (int i = 0; i < n; i++) {
            result = y;
            y = z;
            z = result + y;
        }
        return result;
    }
}
