package Projects.Cache.StorageMechanisms.ConcreteStorages.ConcreteCacheStorage;

import Projects.Cache.StorageMechanisms.Interfaces.CacheStorage;

import java.util.concurrent.ConcurrentHashMap;

public class InMemoryCacheStorage<K, V> implements CacheStorage<K, V> {

    private final ConcurrentHashMap<K, V> cache = new ConcurrentHashMap<>();
    private final int capacity;

    public InMemoryCacheStorage(int capacity) {
        this.capacity = capacity;
    }

    /**
     * @param key
     * @param value
     */
    @Override
    public void put(K key, V value) {
        cache.put(key, value);
    }

    /**
     * @param key
     * @return
     */
    @Override
    public V get(K key) throws Exception{
        if (!cache.containsKey(key)) {
            throw new Exception("Key not found");
        }
        return cache.get(key);
    }

    /**
     * @param key
     * @throws Exception
     */
    @Override
    public void remove(K key) throws Exception {
        cache.remove(key);
    }

    /**
     * @param key
     * @return
     */
    @Override
    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }

    /**
     * @return
     */
    @Override
    public int size() throws Exception{
        return cache.size();
    }

    /**
     * @return
     */
    @Override
    public int getCapacity() {
        return capacity;
    }
}
