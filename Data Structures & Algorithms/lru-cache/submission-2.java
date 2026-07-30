class LRUCache {

    private static class DLinkedList {
        int key;
        int value;
        DLinkedList next;
        DLinkedList prev;
        DLinkedList(int key, int value, DLinkedList next, DLinkedList prev) {
            this.key = key;
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    private int capacity;
    private Map<Integer, DLinkedList> cacheMap;
    private DLinkedList head;
    private DLinkedList tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new HashMap<>();
        this.head = null;
        this.tail = null;
    }
    
    public int get(int key) {
        if(!cacheMap.containsKey(key)) {
            return -1;
        }
        DLinkedList curr = cacheMap.get(key);
        updateHead(curr);
        return curr.value;
    }
    
    public void put(int key, int value) {
        DLinkedList curr = null;
        if(!cacheMap.containsKey(key)) {
            curr = new DLinkedList(key, value, null, null);
            if (cacheMap.size() == capacity) {
                removeTail();
            }
        } else {
            curr = cacheMap.get(key);
            curr.value = value;
        }
        updateHead(curr);
        cacheMap.put(key, curr);
    }

    private void updateHead(DLinkedList curr) {
        if (head == null) {
            head = curr;
            tail = curr;
            return;
        }
        if (curr == head) {
            return;
        } else if (curr == tail) {
            tail = curr.prev;
            tail.next = null;
        } else if (curr.next != null && curr.prev != null){
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
        }
        curr.prev = null;
        curr.next = head;
        head.prev = curr;
        head = curr;
    }

    private void removeTail() {
        if (tail == null) {
            return;
        }
        int tailKey = tail.key;
        cacheMap.remove(tailKey);
        if (tail == head) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
        }
    }
}
