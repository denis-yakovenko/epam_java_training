package MyHashMap;

class MyEntry<K, V> {
    private final K key;
    private V value;

    MyEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    final K getKey() {
        return key;
    }

    final V getValue() {
        return value;
    }

    final V setValue(V newValue) {
        V oldValue = value;
        value = newValue;
        return oldValue;
    }
}
