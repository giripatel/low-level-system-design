package Concurrency.ThreadPool.Usagees;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CPUIntensiveExample {

    private static final int NUM_CORES = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(NUM_CORES);
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                int result = performCompute();
                System.out.println(Thread.currentThread().getName() + " computed result " + result);
            });
        }
        executor.shutdown();
    }

    public static int performCompute() {
        int sum = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sum += Math.sqrt(i);
        }

        return sum;
    }
}
