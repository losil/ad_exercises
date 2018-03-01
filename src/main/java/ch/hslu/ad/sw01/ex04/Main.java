package ch.hslu.ad.sw01.ex04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        LOG.info(ack(3, 2));
        LOG.info(ack(0, 4));
        LOG.info(ack(1, 2));
        LOG.info(ack(2, 2));
        LOG.info(ack(3, 1));
    }

    private static long ack(final long n, final long m) {
        if (n == 0) {
            return m + 1;
        } else if (m == 0) {
            return ack(n - 1, 1);
        } else {
            return ack(n - 1, ack(n, m - 1));
        }
    }
}
