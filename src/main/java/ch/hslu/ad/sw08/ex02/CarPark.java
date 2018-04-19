package ch.hslu.ad.sw08.ex02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class CarPark {
    private static final Logger LOG = LogManager.getLogger(CarPark.class);
    private int capacity;
    private AtomicInteger freeParkingSpots;
    private String name;
    private BlockingDeque<Car> parkedCars;

    public CarPark(final int capacity, final String name) {
        this.capacity = capacity;
        this.freeParkingSpots = new AtomicInteger(capacity);
        this.parkedCars = new LinkedBlockingDeque<>();
        this.name = name;
    }

    public synchronized void park(Car car) {

        while (this.freeParkingSpots.get() == 0) {
            try {
                this.wait();
            } catch (InterruptedException iex) {
                return;
            }

            if (freeParkingSpots.get() == 0) {
                return;
            }
        }
        try {
            this.parkedCars.put(car);
            this.freeParkingSpots.decrementAndGet();
            LOG.info("Car " + Thread.currentThread().getName() + " has parked successfully in " + this.name);
        } catch (InterruptedException iex) {
            LOG.debug(iex);
        }

    }

    public synchronized void leave(Car car) {

        while (!this.parkedCars.contains(car)) {
            try {
                this.wait();
            } catch (InterruptedException iex) {
                return;
            }
        }

        if (this.parkedCars.contains(car)) {
            this.freeParkingSpots.incrementAndGet();
            parkedCars.remove(car);
            this.notifyAll();
        } else {
            LOG.error(Thread.currentThread().getName() + " is not parked in " + this.name + " and cannot leave");
        }
    }
}
