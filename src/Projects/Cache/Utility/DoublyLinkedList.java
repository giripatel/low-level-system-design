package Projects.Cache.Utility;

public class DoublyLinkedList<K> {

    DoublyLinkedListNode<K> head;
    DoublyLinkedListNode<K> tail;

    public DoublyLinkedList() {
        this.head = new DoublyLinkedListNode<>(null);
        this.tail = new DoublyLinkedListNode<>(null);

        head.next = tail;
        tail.prev = head;
    }

    public void addNode(DoublyLinkedListNode<K> node) {
        DoublyLinkedListNode<K> temp = tail;

        node.prev = temp.prev;
        temp.prev.next = node;
        node.next = temp;
        tail.prev = node;
    }

    public void detachNode(DoublyLinkedListNode<K> node) {
        DoublyLinkedListNode<K> temp = node.next;

        temp.prev = node.prev;
        node.prev.next = temp;
        node.next = null;
        node.prev = null;
    }

    public DoublyLinkedListNode<K> getHead() {
        return head.next;
    }

    public void removeHead() {
        DoublyLinkedListNode<K> temp = head.next.next;
        temp.prev = head;
        head.next = temp;
    }
 }
