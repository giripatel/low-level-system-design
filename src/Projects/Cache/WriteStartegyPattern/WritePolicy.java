package Projects.Cache.WriteStartegyPattern;

import Projects.Cache.StorageMechanisms.Interfaces.CacheStorage;
import Projects.Cache.StorageMechanisms.Interfaces.DBStorage;

public interface WritePolicy<K,V> {
    void write(K key, V value, CacheStorage<K, V> cacheStorage, DBStorage<K, V> dbStorage);
}
