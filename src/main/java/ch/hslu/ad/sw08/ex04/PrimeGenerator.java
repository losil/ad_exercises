package ch.hslu.ad.sw08.ex04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class PrimeGenerator {

    private static final Logger LOG = LogManager.getLogger(PrimeGenerator.class);
    private final ExecutorService executor;
    private AtomicInteger n = new AtomicInteger(1);

    private final Callable<Integer> callable = () -> {
        while (n.get() <= 100) {
            BigInteger bigInt = new BigInteger(1024, new Random());
            if (bigInt.isProbablePrime(Integer.MAX_VALUE)) {
                LOG.info("Prime " + this.n + ": " + bigInt);
                this.n.incrementAndGet();
            }
        }
        return n.get();
    };

    public PrimeGenerator(final int threads) {
        this.executor = Executors.newFixedThreadPool(threads);
    }

    public long generate() {
        LOG.info("Starting");
        long start = System.currentTimeMillis();
        Future<Integer> future = executor.submit(this.callable);

        executor.submit(callable);

        try {
            future.get();
            long time = (System.currentTimeMillis() - start) / 1000;
            LOG.info("Finished in " + ((System.currentTimeMillis() - start) / 1000) + " seconds");
            executor.shutdown();
            return time;
        } catch (InterruptedException | ExecutionException ex) {
            LOG.debug(ex);
        }
        executor.shutdown();
        return 0;




    }
}
