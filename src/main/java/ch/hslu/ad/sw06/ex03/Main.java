package ch.hslu.ad.sw06.ex03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {
    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        BoundedBuffer<Integer> bb = new BoundedBuffer<>(20);
        List<Thread> workers = new ArrayList<>();
        for (int i = 0; i < 20; i++) {

            if (i % 2 == 0) {
                workers.add(new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Random random = new Random();
                        bb.push(random.nextInt(3100000));

                    }
                }));
            } else {
                workers.add(new Thread(new Runnable() {
                    @Override
                    public void run() {
                        bb.get();
                    }
                }));
            }

        }
        for (Thread thread : workers) {
            thread.start();
        }


    }
}
