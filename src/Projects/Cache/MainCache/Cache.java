package Projects.Cache.MainCache;

import Projects.Cache.EvictionStrategyPattern.EvictionAlgorithm;
import Projects.Cache.Executors.KeyBasedExecutor;
import Projects.Cache.StorageMechanisms.Interfaces.CacheStorage;
import Projects.Cache.StorageMechanisms.Interfaces.DBStorage;
import Projects.Cache.WriteStartegyPattern.WritePolicy;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;

public class Cache<K, V> {

    private CacheStorage<K, V> cacheStorage;
    private DBStorage<K, V> dbStorage;
    private EvictionAlgorithm<K> evictionAlgorithm;
    private WritePolicy<K, V> writePolicy;
    private KeyBasedExecutor keyBasedExecutor;

    public Cache(CacheStorage<K, V> cacheStorage, DBStorage<K, V> dbStorage, EvictionAlgorithm<K> evictionAlgorithm, WritePolicy<K, V> writePolicy, int numberOfExecutors) {
        this.cacheStorage = cacheStorage;
        this.dbStorage = dbStorage;
        this.evictionAlgorithm = evictionAlgorithm;
        this.writePolicy = writePolicy;
        this.keyBasedExecutor = new KeyBasedExecutor(numberOfExecutors);
    }


    public CompletableFuture<V> accessData(K key) throws Exception {
         return keyBasedExecutor.submitTask(key,() -> {
                try {
                    if (!cacheStorage.containsKey(key)) {
                        throw  new Exception("Key not found");
                    }
                    evictionAlgorithm.keyAccessed(key);
                   return cacheStorage.get(key);
                } catch (Exception e) {
                    throw new CompletionException(e);
                }
        });
    }

    public CompletableFuture<V> updateData(K key, V value) {
        return keyBasedExecutor.submitTask(key, () -> {
            try {
                if (cacheStorage.containsKey(key))  {
                    // Update case: perform concurrent write.
                    writePolicy.write(key, value, cacheStorage, dbStorage);
                    evictionAlgorithm.keyAccessed(key);
                } else {
                    // New Key: If the cache size is full, evict one key
                    if (cacheStorage.getCapacity() <= cacheStorage.size()) {
                        K evictedKey = evictionAlgorithm.evictKey();
                        if (evictedKey == null) {
                            // Removal on the evicted key's executor to maintain ordering.
                            int currentIndex = keyBasedExecutor.getExecutorIndexForKey(key);
                            int evictedIndex = keyBasedExecutor.getExecutorIndexForKey(evictedKey);

                            if (currentIndex == evictedIndex) {
                                cacheStorage.remove(evictedKey);
                            } else {

                                    CompletableFuture<Void> removalFuture = keyBasedExecutor.submitTask(evictedKey, () -> {
                                        try {
                                            cacheStorage.remove(evictedKey);
                                            return null;
                                        } catch (Exception e) {
                                            throw new RuntimeException(e);
                                        }
                                    });
                                    removalFuture.join();
                            }
                        }
                    }
                    writePolicy.write(key,value, cacheStorage, dbStorage);
                    evictionAlgorithm.keyAccessed(key);
                }
                return null;
            } catch (Exception e) {
                throw new RuntimeException();
            }
        });
    }

    public void shutdown() {
        keyBasedExecutor.shutdown();
    }
}
