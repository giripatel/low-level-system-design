package Projects.Cache.Utility;

public class DoublyLinkedListNode<K>{
    K data;
    DoublyLinkedListNode<K> next;
    DoublyLinkedListNode<K> prev;

    public DoublyLinkedListNode(K data, DoublyLinkedListNode<K> next, DoublyLinkedListNode<K> prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public DoublyLinkedListNode(K data) {
        this.data = data;
    }

    public K getValue() {
        return data;
    }
}
