package ch.hslu.ad.sw11.ex03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        LOG.info(FibonacciCalculator.fiboRecursive(40));
        LOG.info(FibonacciCalculator.fiboRecursive1(40));
        LOG.info(FibonacciCalculator.fiboIterative(40));
        FibonacciCalculator fib = new FibonacciCalculator(40);
        LOG.info(fib.compute());
    }
}
