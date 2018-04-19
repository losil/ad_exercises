package ch.hslu.ad.sw08.ex02;

import java.util.Random;

public enum CarType {
    FIRST_AND_WAIT, FIRST_AND_NEXT, FIRST_WAITING_NEXT, MOST_FREE;


    public static CarType getRandomCarType() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

}
