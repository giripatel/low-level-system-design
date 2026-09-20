package Projects.Cache.WriteStartegyPattern.ConcreteStrategy;

import Projects.Cache.StorageMechanisms.Interfaces.CacheStorage;
import Projects.Cache.StorageMechanisms.Interfaces.DBStorage;
import Projects.Cache.WriteStartegyPattern.WritePolicy;

import java.util.concurrent.CompletableFuture;

public class WriteThroughPolicy<K,V> implements WritePolicy<K, V> {
    /**
     * @param key
     * @param value
     * @param cacheStorage
     * @param dbStorage
     */
    @Override
    public void write(K key, V value, CacheStorage<K,V> cacheStorage, DBStorage<K,V> dbStorage) {

        // Write both cache db once

        CompletableFuture<Void> cacheFuture = CompletableFuture.runAsync(() -> {
            try {
                cacheStorage.put(key, value);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<Void> databaseFuture = CompletableFuture.runAsync(() -> {
            try {
                dbStorage.write(key, value);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture.allOf(databaseFuture, cacheFuture).join();
    }
}
