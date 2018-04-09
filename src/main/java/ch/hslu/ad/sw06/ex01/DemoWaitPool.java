package ch.hslu.ad.sw06.ex01;

import com.sun.corba.se.spi.ior.ObjectKey;

public class DemoWaitPool {

    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        final MyTask waiter = new MyTask(lock);
        new Thread(waiter).start();
        Thread.sleep(1000);
        //lock.notifyAll();
        synchronized (lock) {
            lock.notifyAll();
        }

    }
}
