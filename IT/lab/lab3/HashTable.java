import java.util.LinkedList;

class HashTable<K, V> {
    private static class Entry<K, V>{
        K key;
        V value;
        
        Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
private LinkedList<Entry<K, V>>[] table;
private int size;

@SuppressWarnings("unchecked")
public HashTable(int cap) {
    table = new LinkedList[cap];
    for (int i = 0; i < cap; i++) {
        table[i] = new LinkedList<>();
    }
    size = 0;
}

private int hash(K key) {
    return Math.abs(key.hashCode())% table.length;
}

public void put(K key, V value) {
    int index = hash(key);
    if (table[index]==null){
        table[index] = new LinkedList <Entry<K, V>>();
    }
    for (Entry<K,V> entry: table[index]){
        if (entry.key.equals(key)){
            entry.value = value;
            return;
        }
    }
    table[index].add(new Entry<K, V>(key, value));
    size++;
}

public V get(K key){
    int index = hash(key);
    LinkedList<Entry<K, V>> buck = table[index];

    for (Entry<K, V> entry : buck){
        if (entry.key.equals(key)){
            return entry.value;
        }
    }
    return null;
}

public void remove(K key) {
    int index = hash(key);
    LinkedList<Entry<K, V>> buck = table[index];

    for (Entry<K, V> entry : buck) {
        if (entry.key.equals(key)){
            buck.remove(entry);
            size--;
            return;
        }
    }
}
public int size(){
    return size;
}

public boolean isEmpty(){
    return size ==0;
}

}
