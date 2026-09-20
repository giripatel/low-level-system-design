package Projects.Cache.StorageMechanisms.ConcreteStorages.ConcreteDBStorage;

import Projects.Cache.StorageMechanisms.Interfaces.DBStorage;

import java.util.concurrent.ConcurrentHashMap;

public class SampleDBStorage<K, V> implements DBStorage<K, V> {

    private final ConcurrentHashMap<K, V> database = new ConcurrentHashMap<>();

    /**
     * @param key
     * @param value
     */
    @Override
    public void write(K key, V value) {
        database.put(key, value);
    }

    /**
     * @param key
     * @return
     */
    @Override
    public V read(K key) throws Exception{
        if (!database.containsKey(key)) {
            throw new Exception("Key not found in DB " + key);
        }
        return database.get(key);
    }

    /**
     * @param key
     */
    @Override
    public void delete(K key) throws Exception {
        if (!database.containsKey(key)) {
            throw new Exception("Key not found in DB " + key);
        }
        database.remove(key);
    }
}
