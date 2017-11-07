package MyHashMap;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

class MyMap<K, V> {
    private ArrayList<MyEntry<K, V>> myEntryArrayList = new ArrayList<>();

    public V get(Object key) {
        for (MyEntry<K, V> entry : myEntryArrayList) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    V put(K key, V value) {
        for (MyEntry<K, V> entry : myEntryArrayList) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return value;
            }
        }
        myEntryArrayList.add(new MyEntry<>(key, value));
        return value;
    }

    int size() {
        return myEntryArrayList.size();
    }

    V remove(Object key) {
        for (MyEntry<K, V> entry : myEntryArrayList) {
            if (entry.getKey().equals(key)) {
                V value = entry.getValue();
                myEntryArrayList.remove(entry);
                return value;
            }
        }
        return null;
    }

    //get all keys
    Set<K> keySet() {
        return myEntryArrayList.stream().map(MyEntry::getKey).collect(Collectors.toSet());
    }
}
