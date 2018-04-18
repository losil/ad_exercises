package ch.hslu.ad.sw08.ex03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.*;

public class Main {


    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        /*
        Testing with AtomicCounter
         */
        Test testAtomic = new Test(new AtomicCounter(), "AtomicCounter");
        testAtomic.runTest();

        /*
        Testing with SynchronizedCounter
         */
        Test testSynchronized = new Test(new SynchronizedCounter(), "SynchronizedCounter");
        testSynchronized.runTest();

    }
}
