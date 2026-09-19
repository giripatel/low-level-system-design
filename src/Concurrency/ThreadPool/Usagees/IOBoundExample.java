package Concurrency.ThreadPool.Usagees;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IOBoundExample {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                simulateWebRequest();
                System.out.println(Thread.currentThread().getName() + " completed I/O task");
            });
        }
        executor.shutdown();
    }

    public static void simulateWebRequest() {
        try {
            System.out.println(Thread.currentThread().getName() + " waiting for response ......");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }
}
