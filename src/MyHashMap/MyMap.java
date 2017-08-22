package MyHashMap;

import java.util.HashSet;
import java.util.Set;

public class MyMap<K, V>{
    private MyEntry<K, V>[] table;

    public MyMap() {
        MyEntry<K, V>[] newTab = (MyEntry<K, V>[]) new MyEntry[0];
        table = newTab;
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public V get(Object key) {
        MyEntry<K, V> e;
        return (e = table[hash(key)]) == null ? null : e.value;
    }

    public V put(K key, V value) {
        for (MyEntry<K, V> entry : table) {
            if (entry != null) {
                if (entry.key == key) {
                    entry.value = value;
                    return value;
                }
            }
        }
        MyEntry<K, V>[] newTab = (MyEntry<K, V>[]) new MyEntry[table.length + 1];
        System.arraycopy(table, 0, newTab, 0, table.length);
        table = newTab;
        table[table.length - 1] = new MyEntry<>(hash(key), key, value);
        return value;
    }

    int size() {
        return table.length;
    }

    V remove(Object key) {
        MyEntry<K, V> e;
        e = table[hash(key)];
        table[hash(key)] = null;
        return e.value;
    }

    //get all keys
    public Set<K> keySet() {
        Set<K> ks = new HashSet<>();
        for (int i = 0; i < table.length; i++) {
            ks.add(table[i].getKey());
        }
        return ks;
    }


}
