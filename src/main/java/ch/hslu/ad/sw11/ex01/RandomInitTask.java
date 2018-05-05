package ch.hslu.ad.sw11.ex01;

import java.util.Random;
import java.util.concurrent.RecursiveAction;

public class RandomInitTask extends RecursiveAction {
    private final int[] array;
    private final int bound;
    private final Random random = new Random();

    public RandomInitTask(final int[] array, final int bound) {
        this.array = array;
        this.bound = bound;
    }

    @Override
    protected void compute() {
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = random.nextInt(this.bound);
        }

    }
}
