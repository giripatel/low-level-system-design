package Concurrency.ThreadCreation.Callable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {

    String name;
    public MyCallable(String name) {
        this.name = name;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 5; i++) {
            System.out.println("Thread " + Thread.currentThread().getName() + " running " + i);
            Thread.sleep(500);
        }
        return "Hello world from " + Thread.currentThread().getName();
    }
}
