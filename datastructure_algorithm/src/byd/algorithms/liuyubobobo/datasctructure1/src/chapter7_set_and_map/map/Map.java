package byd.algorithms.liuyubobobo.datasctructure1.src.chapter7_set_and_map.map;

public interface Map<K, V> {

    void add(K key, V value);

    V remove(K key);

    boolean contains(K key);

    V get(K key);

    void set(K key, V newValue);

    int getSize();

    boolean isEmpty();
}
