package ch.hslu.ad.sw05.ex03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

public class Main {

    private static Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        Thread t3 = new Thread(() -> {
            try {
                LOG.info(Thread.currentThread().getName() + ": " + Thread.currentThread().getState());
                Thread.sleep(4000);
                LOG.info(Thread.currentThread().getName() + ": " + Thread.currentThread().getState());
                LOG.info("Thread 3 - Ende");

            } catch (InterruptedException iex) {
                LOG.error(iex);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                LOG.info(Thread.currentThread().getName() + ": " + Thread.currentThread().getState());
                t3.join();
                LOG.info(t3.getName() + ": " + t3.getState());
                LOG.info(Thread.currentThread().getName() + ": " + Thread.currentThread().getState());
                Thread.sleep(3000);
                LOG.info(Thread.currentThread().getName() + ": " + Thread.currentThread().getState());
                LOG.info("Thread 2 - Ende");

            } catch (InterruptedException iex) {
                LOG.error(iex);
            }
        });

        Thread t1 = new Thread(() -> {
            try {
                LOG.info(Thread.currentThread().getName() + ": " + Thread.currentThread().getState());
                t2.join();
                LOG.info(Thread.currentThread().getName() + ": " + Thread.currentThread().getState());
                Thread.sleep(2000);
                LOG.info(Thread.currentThread().getName() + ": " + Thread.currentThread().getState());
                LOG.info("Thread-3");
            } catch (InterruptedException iex) {
                LOG.error(iex);
            }
        });

        t1.setName("Thread-1");
        t2.setName("Thread-2");
        t3.setName("Thread-3");

        t1.start();
        t2.start();
        t3.start();

        Random random = new Random();
        int randomThread = random.nextInt(3 - 1 + 1) + 1;
        if (randomThread == 1) {
            while (t1.getState() != Thread.State.TIMED_WAITING) {

            }
            t1.interrupt();
        }
        if (randomThread == 2) {
            while (t2.getState() != Thread.State.TIMED_WAITING) {

            }
            t2.interrupt();
        } else {
            while (t3.getState() != Thread.State.TIMED_WAITING) {

            }
            t3.interrupt();
        }

    }
}
