package ch.hslu.ad.sw08.ex04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.util.Random;

public class Main {

    private static final Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        PrimeGenerator primeGen = new PrimeGenerator(10);
        primeGen.generate();

        PrimeGenerator primeGen1 = new PrimeGenerator(1);
        primeGen1.generate();


    }

}
