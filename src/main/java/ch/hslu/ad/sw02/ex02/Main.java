package ch.hslu.ad.sw02.ex02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        AllocationList alloList = new AllocationList();
        Allocation alloc1 = new Allocation(32, 16);
        Allocation alloc2 = new Allocation(0, 32);
        alloList.add(alloc1);
        alloList.add(alloc2);
        LOG.info("Size of list: " + alloList.size());
        LOG.info("Removal from 2nd object is: " + alloList.remove(alloc2));
        LOG.info("Removal from 1st object is: " + alloList.remove(alloc1));
        LOG.info("Size of List: " + alloList.size());


    }
}
