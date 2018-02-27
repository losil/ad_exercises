package ch.hslu.ad.sw01.ex01;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class MemoryDemo {
    private static Logger LOG = LogManager.getLogger(MemoryDemo.class);

    public static void main(String[] args) {
        final Memory memory = new MemorySimple(1024);
        LOG.info(memory);
        final Allocation block1 = memory.malloc(16);
        LOG.info(block1);
        LOG.info(memory);
        final Allocation block2 = memory.malloc(8);
        LOG.info(block2);
        LOG.info(memory);
        memory.free(block1);
        LOG.info(memory);
        final Allocation block3 = memory.malloc(18);
        LOG.info(block3);
        LOG.info(memory);
    }
}
