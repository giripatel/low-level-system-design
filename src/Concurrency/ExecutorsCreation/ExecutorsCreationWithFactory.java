package Concurrency.ExecutorsCreation;

import java.util.concurrent.*;

public class ExecutorsCreationWithFactory {
    public static void main(String[] args) {

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        ExecutorService fixedPoolExecutor = Executors.newFixedThreadPool(2);
        ExecutorService cachedPoolExecutor = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledExecutor = Executors.newScheduledThreadPool(2);

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 6, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2),new ThreadPoolExecutor.AbortPolicy());
    }
}
