package ch.hslu.ad.sw08.ex04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        int threads1 = 10;
        int threads2 = 1;

        //try (PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(new File("/var/tmp"), Charset.forName("UTF-8")))))
        //} catch (ExecutionException ex) {
        //    LOG.debug(ex);
        //}
        PrimeGenerator primeGen = new PrimeGenerator(threads1);
        long time1 = primeGen.generate();

        PrimeGenerator primeGen1 = new PrimeGenerator(threads2);
        long time2 = primeGen1.generate();

        LOG.info("Runtime with " + threads1 + ": " + time1 + " seconds");
        LOG.info("Runtime with " + threads2 + ": " + time2 + " seconds");

    }

}
