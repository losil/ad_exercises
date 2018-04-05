package ch.hslu.ad.sw05.ex01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    final static Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        LOG.info("Starting");
        Bank bank = new Bank(50000, 10000);
        bank.createAccounts();
        bank.startTransfers(50000, 100);
        LOG.info(bank.toString());
    }
}
