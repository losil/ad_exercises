package ch.hslu.ad.sw05.ex01;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    final static Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Bank bank = new Bank(10, 500);
        bank.createAccounts();
        bank.startTransfers(10, 100);
        LOG.info(bank.toString());
    }
}
