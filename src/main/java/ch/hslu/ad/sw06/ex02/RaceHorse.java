package ch.hslu.ad.sw06.ex02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public final class RaceHorse implements Runnable {

    private static final Logger LOG = LogManager.getLogger(RaceHorse.class);
    private final Synch startSignal;
    private final Random random;
    private volatile Thread runThread;

    public RaceHorse(Synch startSignal) {
        this.startSignal = startSignal;
        this.random = new Random();
    }

    @Override
    public void run() {
        this.runThread = Thread.currentThread();
        LOG.info("Race Horse " + this.runThread.getName() + " gets to box.");
        try {
            startSignal.acquire();
            LOG.info("Race Horse " + this.runThread.getName() + " starts running.");
            Thread.sleep(random.nextInt(3000));
            LOG.info("Race Horse " + this.runThread.getName() + " arrived target.");
        } catch (InterruptedException iex) {
            LOG.debug(iex);
            LOG.info("Race Horse " + this.runThread.getName() + " breaks off the run.");
        }

    }
}
