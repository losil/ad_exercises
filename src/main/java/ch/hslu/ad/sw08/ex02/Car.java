package ch.hslu.ad.sw08.ex02;

import java.util.Random;

public class Car {

    private int parkDuration;
    private CarType carType;

    public Car() {
        this.parkDuration = 2000 + new Random().nextInt(3000);
        this.carType = CarType.getRandomCarType();
    }

    public int getParkDuration() {
        return this.parkDuration;
    }

    public CarType getCarType() {
        return this.carType;
    }



}
