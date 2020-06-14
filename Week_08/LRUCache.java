class LRUCache {

    private Map<Integer, Element> cache;
    private Element head = new Element();
    private Element tail = new Element();
    private int size;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.cache = new HashMap<Integer, Element>();
        this.head.next = tail;
        this.tail.prev = head;
    }
    
    public int get(int key) {
        Element e = cache.get(key);

        if(e == null){
            return -1;
        }

        move2Head(e);

        return e.value;
    }
    
    public void put(int key, int value) {
        Element e = cache.get(key);

        if(e != null){
            e.value = value;
            move2Head(e);
        } else {
            e = new Element(key, value);

            add2Cache(e);
            fallIn(e);

            size++;

            if(size > capacity){
                del4Cache(poll());
                size--;
            }
        }
    }

    private void move2Head(Element e){
        fallOut(e);
        fallIn(e);
    }

    private void fallOut(Element e){
        e.prev.next = e.next;
        e.next.prev = e.prev;
    }

    private void fallIn(Element e){
        e.prev = head;
        e.next = head.next;
        head.next.prev = e;
        head.next = e;
    }

    private Element poll(){
        Element e = tail.prev;
        
        fallOut(e);

        return e;
    }

    private void add2Cache(Element e){
        this.cache.put(e.key, e);
    }

    private void del4Cache(Element e){
        this.cache.remove(e.key);
    }

    class Element {
        int key;
        int value;
        Element prev;
        Element next;

        public Element(){

        }

        public Element(int key, int value){
            this.key = key;
            this.value = value;
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */