package ch.hslu.ad.sw06.ex02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Turf {
    private static final Logger LOG = LogManager.getLogger(Turf.class);

    public static void main(String[] args) {
        List<Thread> horses = new ArrayList<>();
        Synch starterBox = new Latch();

        for (int i = 1; i <= 15; i++) {
            Thread t = new Thread(new RaceHorse(starterBox), "Horse-" + i);
            horses.add(t);
            t.start();
        }
        /*
        Block threads to delay the start
         */
        try {
            Thread.sleep(10000);
        } catch (InterruptedException iex) {
            LOG.error(iex);
        }
        LOG.info("Start...");
        starterBox.release();

        LOG.info("Checking if break is required...");

        if (false) {
            LOG.info("False start, interrupting horses");
            horses.stream().forEach(t -> t.interrupt());
        }
    }
}
