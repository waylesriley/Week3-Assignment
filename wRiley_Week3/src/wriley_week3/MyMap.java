package wriley_week3;

/**
 * @Course: SDEV 450 ~ Java Programming III
 * @Author Name: Riley Laptop
 * @Assignment Name: wriley_week3
 * @Date: Sep 16, 2016
 * @Subclass MyMap Description: Subclass used as an interface Ref: Intro to
 * Java, 10th Liang
 */
//Imports
//Begin Subclass MyMap
public interface MyMap<K, V> {

    /**
     * Remove all of the entries from this map
     */
    public void clear();

    /**
     * Return true if the specified key is in the map
     *
     * @param key
     * @return
     */
    public boolean containsKey(K key);

    /**
     * Return true if this map contains the specified value
     *
     * @param value
     * @return
     */
    public boolean containsValue(V value);

    /**
     * Return a set of entries in the map
     *
     * @return
     */
    public java.util.Set<Entry<K, V>> entrySet();

    /**
     * Return the first value that matches the specified key
     *
     * @param key
     * @return
     */
    public V get(K key);

    /**
     * Return true if this map contains no entries
     *
     * @return
     */
    public boolean isEmpty();

    /**
     * Return a set consisting of the keys in this map
     *
     * @return
     */
    public java.util.Set<K> keySet();

    /**
     * Add an entry (key, value) into the map
     *
     * @param key
     * @param value
     * @return
     */
    public V put(K key, V value);

    /**
     * Remove the entries for the specified key
     *
     * @param key
     */
    public void remove(K key);

    /**
     * Return the number of mappings in this map
     *
     * @return
     */
    public int size();

    /**
     * Return a set consisting of the values in this map
     *
     * @return
     */
    public java.util.Set<V> values();

    /**
     * Define inner class for Entry
     *
     * @param <K>
     * @param <V>
     */
    public static class Entry<K, V> {

        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "[" + key + ", " + value + "]";
        }
    }
} //End Subclass MyMap
