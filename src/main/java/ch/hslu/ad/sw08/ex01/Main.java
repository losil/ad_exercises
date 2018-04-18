package ch.hslu.ad.sw08.ex01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {

    public static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        BoundedBlockingBuffer<Integer> bb = new BoundedBlockingBuffer<>(40);
        List<Thread> workers = new ArrayList<>();
        int sumProduced = 0;
        int sumConsumed = 0;
        for (int i = 0; i < 20; i++) {

            if (i % 2 == 0) {
                workers.add(new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Random random = new Random();
                        int rand = random.nextInt(3000);
                        try {
                            bb.put(rand);
                        } catch (InterruptedException iex) {
                            LOG.debug(iex);
                        }

                    }
                }));
            } else {
                workers.add(new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            bb.get();
                        } catch (InterruptedException iex) {
                            LOG.debug(iex);
                        }
                    }
                }));
            }

        }
        for (Thread thread : workers) {
            thread.start();
            //SLOG.info(bb.toString());
        }
        LOG.info(bb.toString());




    }
}
