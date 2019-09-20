package 手写Hashmap;

public interface ExtMap<K,V> {
     V put(K key,V value);

     V get(K key);

     public int size();

     interface Entry<K,V>{
         K getKey();

         V getValue();

         V setValue(V value);
     }
}
