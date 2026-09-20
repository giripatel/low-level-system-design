package Projects.Cache.Executors;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

public class KeyBasedExecutor {

    ExecutorService[] executors;
    int numOfExecutors;

    public KeyBasedExecutor(int numOfExecutors) {
        this.numOfExecutors = numOfExecutors;
        executors = new ExecutorService[numOfExecutors];

        for (int i = 0; i < numOfExecutors; i ++) {
            executors[i] = Executors.newSingleThreadExecutor();
        }
    }

    public <T> CompletableFuture<T> submitTask(Object key, Supplier<T> task) {
        int index = getExecutorIndexForKey(key);
        ExecutorService executor = executors[index];
        return CompletableFuture.supplyAsync(task, executor);
    }

    public int getExecutorIndexForKey(Object key) {
        return Math.abs(key.hashCode() % numOfExecutors);
    }

    public void shutdown() {
        for (ExecutorService executorService: executors) {
            executorService.shutdown();
        }
    }
}
