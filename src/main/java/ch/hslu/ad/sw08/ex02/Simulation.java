package ch.hslu.ad.sw08.ex02;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Simulation {
    private static final Logger LOG = LogManager.getLogger(Simulation.class);
    private CarPark carPark1 = new CarPark(10, "CarPark 1");
    private CarPark carPark2 = new CarPark(200, "CarPark 2");
    private CarPark carPark3 = new CarPark(300, "CarPark 3");
    private List<Car> cars;
    private int numberOfCars;


    public Simulation(final int numberOfCars) {
        this.cars = new ArrayList<>();
        this.numberOfCars = numberOfCars;
        generateCars();
    }

    private void generateCars() {
        for (int i = 1; i <= numberOfCars; i++) {
            cars.add(new Car());
        }
    }

    public void startSimulation() {
        ExecutorService executor = Executors.newFixedThreadPool(this.numberOfCars);
        int id = 1;
        for (Car car : cars) {
            final int finID = id;
            executor.execute(() -> {
                Thread.currentThread().setName("Car" + finID);
                carPark1.park(car);
                if (Thread.currentThread().getState() == Thread.State.WAITING && car.getCarType() == CarType.FIRST_AND_NEXT) {
                    Thread.currentThread().interrupt();
                    carPark2.park(car);
                    try {
                        Thread.sleep(car.getParkDuration());
                    } catch (InterruptedException iex) {
                        LOG.debug(iex);
                    }

                }
                try {
                    Thread.sleep(car.getParkDuration());
                } catch (InterruptedException iex) {
                    LOG.debug(iex);
                }
                carPark1.leave(car);
            });
            id++;
        }
        executor.shutdown();
        LOG.info("Simulation ended");
    }

}
