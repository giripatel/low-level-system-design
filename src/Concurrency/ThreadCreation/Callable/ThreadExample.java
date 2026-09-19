package Concurrency.ThreadCreation.Callable;

import java.sql.SQLOutput;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable callable = new MyCallable("Task 1");

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Future<String> t1Response = executorService.submit(callable);
        Future<String> t2Response = executorService.submit(callable);
        Future<String> t3Response = executorService.submit(callable);
        Future<String> t4Response = executorService.submit(callable);
        Future<String> t5Response = executorService.submit(callable);
        Future<String> t6Response = executorService.submit(callable);
        System.out.println(t1Response.get());
        System.out.println(t2Response.get());
        System.out.println(t3Response.get());
        System.out.println(t4Response.get());
        System.out.println(t5Response.get());
        System.out.println(t6Response.get());


        System.out.println("After all futures");
        Set<Thread> threads = Thread.getAllStackTraces().keySet();
        executorService.shutdownNow();
        for (Thread thread : threads) {
            System.out.printf("Thread Name: %s | ID: %d | State: %s | Is Alive: %b%n",
                    thread.getName(),
                    thread.getId(),
                    thread.getState(),
                    thread.isAlive()
            );
        }
    }
}
