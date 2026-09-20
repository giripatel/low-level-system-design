package Projects.Cache;

import Projects.Cache.EvictionStrategyPattern.ConcreteStartegy.LRUEvictionAlgorithm;
import Projects.Cache.EvictionStrategyPattern.EvictionAlgorithm;
import Projects.Cache.Executors.KeyBasedExecutor;
import Projects.Cache.MainCache.Cache;
import Projects.Cache.StorageMechanisms.ConcreteStorages.ConcreteCacheStorage.InMemoryCacheStorage;
import Projects.Cache.StorageMechanisms.ConcreteStorages.ConcreteDBStorage.SampleDBStorage;
import Projects.Cache.StorageMechanisms.Interfaces.CacheStorage;
import Projects.Cache.StorageMechanisms.Interfaces.DBStorage;
import Projects.Cache.WriteStartegyPattern.ConcreteStrategy.WriteThroughPolicy;
import Projects.Cache.WriteStartegyPattern.WritePolicy;

public class Main {
    public static <K, V> void main(String[] args) {

        try {
            CacheStorage<String, String> cacheStorage = new InMemoryCacheStorage<>(5);
            DBStorage<String, String> dbStorage = new SampleDBStorage<>();
            EvictionAlgorithm<String> evictionAlgorithm = new LRUEvictionAlgorithm<>();
            WritePolicy<String, String> writePolicy = new WriteThroughPolicy<>();

            Cache<String, String> cache = new Cache<>(cacheStorage, dbStorage, evictionAlgorithm, writePolicy, 4);

            System.out.println("Initial write operations start");

            // Demonstrate write operations
            cache.updateData("A", "Apple").join();
            System.out.println("Initial write operation A completed");

            cache.updateData("B", "Banana").join();
            cache.updateData("C", "Cherry").join();
            cache.updateData("D", "Durian").join();
            cache.updateData("E", "Elderberry").join();

            System.out.println("Initial write operations completed");
            // At this point, the in-memory cache is at capacity.
            // The next write will trigger eviction (of the least recently used key) from the cache.
            cache.updateData("F", "Fig").join();

            // Demonstrate read operations.
            try {
                String valueA = cache.accessData("A").join();
                System.out.println("A is evicted or not found in the cache.");
            } catch (Exception e) {
                System.out.println("A is evicted or not found in cache");
            }

            String valueF = cache.accessData("F").join();
            System.out.println("F: " + valueF);

            // Update an existing key and then read it to demonstrate read-your-own-writes.
            cache.updateData("B", "Blueberry").join();
            String valueB = cache.accessData("B").join();
            System.out.println("B: " + valueB);

            // Shut down executors when finished.
            cache.shutdown();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
