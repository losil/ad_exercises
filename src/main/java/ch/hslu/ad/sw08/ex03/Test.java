package ch.hslu.ad.sw08.ex03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.*;

public class Test {
    private static final Logger LOG = LogManager.getLogger(Test.class);
    private Count counter;
    private String name;

    public Test(Count counter, String name) {
        this.counter = counter;
        this.name = name;
    }

    public void runTest() {
        final ExecutorService executor = Executors.newFixedThreadPool(10);
        final Callable<Integer> callable = () -> {
            for (int i = 0; i < 10000000; i++) {
                this.counter.increment();
            }
            return this.counter.get();
        };

        LOG.info("Starting " + this.name + "...");
        long start = System.currentTimeMillis();
        Future<Integer> future = executor.submit(callable);

        try {
            LOG.info("Finshed with a count of: " + future.get());
            LOG.info("Runtime of " + this.name + ": " + (System.currentTimeMillis() - start) + " ms");
        } catch (ExecutionException | InterruptedException ex) {
            LOG.debug(ex);
        }
        executor.shutdown();
    }
}

