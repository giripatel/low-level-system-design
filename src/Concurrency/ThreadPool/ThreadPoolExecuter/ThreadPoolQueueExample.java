package Concurrency.ThreadPool.ThreadPoolExecuter;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolQueueExample {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 6,10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2),new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i <= 10; i++) {
            final int taskId = i;
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName() + "is processing task " + taskId);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executor.shutdown();
    }
}
