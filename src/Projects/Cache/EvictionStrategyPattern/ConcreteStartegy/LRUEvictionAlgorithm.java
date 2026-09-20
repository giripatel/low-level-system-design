package Projects.Cache.EvictionStrategyPattern.ConcreteStartegy;

import Projects.Cache.EvictionStrategyPattern.EvictionAlgorithm;
import Projects.Cache.Utility.DoublyLinkedList;
import Projects.Cache.Utility.DoublyLinkedListNode;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LRUEvictionAlgorithm<K> implements EvictionAlgorithm<K> {

    DoublyLinkedList<K> dll;
    Map<K, DoublyLinkedListNode<K>> keyToNodeMap;

    public LRUEvictionAlgorithm() {
        this.dll = new DoublyLinkedList<>();
        this.keyToNodeMap = new ConcurrentHashMap<>();
    }

    /**
     * @return 
     */
    @Override
    public synchronized K evictKey() {
        DoublyLinkedListNode<K> nodeToEvict = dll.getHead();
        K key = nodeToEvict.getValue();
        dll.detachNode(nodeToEvict);
        keyToNodeMap.remove(key);
        return key;
    }

    /**
     * @param key 
     */
    @Override
    public synchronized void keyAccessed(K key) {
        if (keyToNodeMap.containsKey(key)) {
            DoublyLinkedListNode<K> node = keyToNodeMap.get(key);
            dll.detachNode(node);
            dll.addNode(node);
        } else {
            DoublyLinkedListNode<K> newNode = new DoublyLinkedListNode<>(key);
            dll.addNode(newNode);
            keyToNodeMap.put(key, newNode);
        }
    }
}
