package ch.hslu.ad.sw02.ex04;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static Logger LOG = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add('A');
        LOG.info(queue.toString());
        queue.add('A');
        LOG.info(queue.toString());
        queue.add('A');
        LOG.info(queue.toString());
        queue.add('A');
        LOG.info(queue.toString());
        queue.add('A');
        LOG.info(queue.toString());
        queue.add('A');
        LOG.info(queue.toString());
        queue.add('A');
        LOG.info(queue.toString());
        queue.add('A');
        LOG.info(queue.toString());

        LOG.info(queue.poll());
        LOG.info(queue.toString());
        LOG.info(queue.poll());
        LOG.info(queue.toString());
        LOG.info(queue.poll());
        LOG.info(queue.toString());
        LOG.info(queue.poll());
        LOG.info(queue.toString());
        LOG.info(queue.poll());
        LOG.info(queue.toString());
        LOG.info(queue.poll());
        LOG.info(queue.toString());
        LOG.info(queue.poll());
        LOG.info(queue.toString());
        LOG.info(queue.poll());
        LOG.info(queue.toString());


    }
}
