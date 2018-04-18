package ch.hslu.ad.sw08.ex04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.*;

public class PrimeGenerator {

    private static final Logger LOG = LogManager.getLogger(PrimeGenerator.class);
    private final ExecutorService executor;
    private final Callable<Integer> callable = () -> {
        int n = 1;
        while (n <= 100) {
            BigInteger bigInt = new BigInteger(1024, new Random());
            if (bigInt.isProbablePrime(Integer.MAX_VALUE)) {
                LOG.info("Prime " + n + ": " + bigInt);
                n++;
            }
        }
        return n;
    };

    public PrimeGenerator(final int threads) {
        this.executor = Executors.newFixedThreadPool(threads);
    }

    public void generate() {
        LOG.info("Starting");
        long start = System.currentTimeMillis();
        Future<Integer> future = executor.submit(this.callable);
        try {
            future.get();
            LOG.info("Finished in " + ((System.currentTimeMillis() - start) / 1000) + " seconds");
            executor.shutdown();
        } catch (InterruptedException | ExecutionException ex) {
            LOG.debug(ex);
        }


    }
}
