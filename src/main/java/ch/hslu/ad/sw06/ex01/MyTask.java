package ch.hslu.ad.sw06.ex01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public final class MyTask implements Runnable {
    private static final Logger LOG = LogManager.getLogger(MyTask.class);
    private final Object lock;

    public MyTask(final Object lock) {
        this.lock = lock;
    }


    @Override
    public void run() {
        LOG.info("warten...");
        synchronized (lock) {
            try {
                //wait();
                lock.wait();
            } catch (InterruptedException iex) {
                return;
            }
            LOG.info("aufgewacht");
        }
    }
}
