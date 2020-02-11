public class Entry<K, V> {

    final K key;

    V value;

    Entry<K, V> next;

    public Entry(K key, V value, Entry next){
    this.key = key;
    this.value = value;
    }

    static class MyMap<K, V> {
        private Entry<K, V>[] buckets;
        private static final int initialcapacity = 16;
        int size;

        public MyMap() {
            this(initialcapacity);
        }

        public MyMap(int initialcapacity) {
            this.buckets = new Entry[initialcapacity];
        }

        public void put(K key, V value) {
            Entry<K, V> newEntry = new Entry<K, V>(key, value, null);
            int index = key.hashCode() % buckets.length;
            Entry<K, V> existing = buckets[index];
            if(existing == null){
                buckets[index] = newEntry;
                size++;
            }else{
                while (existing.next!= null) {
                    if (existing.key.equals(key)) {
                        existing.value = value;
                    }
                    existing = existing.next;
                }

                if(existing.key.equals(key)){
                    existing.value = value;
                }else{
                    existing.next = newEntry;
                    size++;
                }
            }
        }

        public V get(K key){
            int index = key.hashCode() % buckets.length;
            return buckets[index].value;
        }
    }
}