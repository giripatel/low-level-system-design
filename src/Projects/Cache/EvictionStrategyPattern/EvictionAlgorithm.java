package Projects.Cache.EvictionStrategyPattern;

public interface EvictionAlgorithm <K>{
    K evictKey();
    void keyAccessed(K key);
}
