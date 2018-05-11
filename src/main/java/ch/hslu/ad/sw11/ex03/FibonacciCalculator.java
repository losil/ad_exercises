package ch.hslu.ad.sw11.ex03;

import java.util.concurrent.RecursiveTask;

public class FibonacciCalculator extends RecursiveTask<Integer> {

    private int fiboMax;

    public FibonacciCalculator(final int n) {
        this.fiboMax = n;
    }

    public static int fiboRecursive(final int n) {
        return n > 1 ? fiboRecursive(n - 1) + fiboRecursive(n - 2) : n;
    }

    public static int fiboRecursive1(final int n) {

        if (n == 1 || n == 0) {
            return n;
        }

        return fiboRecursive1(n - 1) + fiboRecursive1(n - 2);
    }

    public static int fiboIterative(final int n) {

        int x = 0;
        int y = 1;
        int z = 1;

        for (int i = 0; i < n ; i++) {
            x = y;
            y = z;
            z = x + y;
        }
        return x;
    }

    @Override
    protected Integer compute() {
        if (this.fiboMax <= 1) {
            return this.fiboMax;
        }

        else{
            FibonacciCalculator fibo1 = new FibonacciCalculator(fiboMax -1);
            fibo1.fork();
            FibonacciCalculator fibo2 = new FibonacciCalculator(fiboMax -2);
            return fibo2.compute() + fibo1.join();
        }
    }
}
