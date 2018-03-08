package ch.hslu.ad.sw02.ex03;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        Stack stack = new Stack(10);
        String str1 = stack.push("toll");
        String str2 = stack.push("sind ");
        String str3 = stack.push("Datenstrukturen");
        LOG.info(stack.pop());
        LOG.info(stack.pop());
        LOG.info(stack.pop());
    }
}
