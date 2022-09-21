package bimap;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

/**
 * A very Simple class provides two way map
 * delivers sorted lists for keys and values
 * sorted lists are cached and re-init when new element is added or removed
 * and keyListSorted or valueListSorted is called.
 *
 * Note: values should be unique otherwise put method will throw NotUniqueKeyValueException
 *
 * @param <K>
 * @param <V>
 * @author Alvin Avanessian
 * @version 0.1
 *
 */
public class BiMap<K,V> implements Serializable, Cloneable {
    private Map<K,V> map = new HashMap<>();
    private Map<V,K> reverseMap = new HashMap<>();
    private List<K> keyListSorted;
    private List<V> valueListSorted;

    private boolean changed = true;

    /**
     *
     * @param key
     * @param value
     * @throws NotUniqueKeyValueException
     */
    public void put(K key,V value) throws NotUniqueKeyValueException {
        if (reverseMap.get(value)==null) {
            reverseMap.remove(map.get(key));
            map.put(key, value);
            reverseMap.put(value, key);
            changed = true;
        }else {
            throw new NotUniqueKeyValueException(key,value);
        }
    }

    public void removeByKey(K key){
        V value = map.remove(key);
        reverseMap.remove(value);
        changed = true;
    }

    public void removeByValue(V value) {
        K key = reverseMap.remove(value);
        map.remove(key);
        changed = true;
    }

    public V getByKey(K key){
        return map.get(key);
    }

    public K getByValue(V value){
        return reverseMap.get(value);
    }

    public int size(){
        return map.size();
    }

    public Set<K> ketSet(){
        return map.keySet();
    }

    private void sortLists(){
        if (changed) {
            keyListSorted = map.keySet().stream().sorted().collect(Collectors.toList());
            valueListSorted = map.values().stream().sorted().collect(Collectors.toList());
            changed = false;
        }
    }

    public List<K> keyListSorted(){
        sortLists();
        return keyListSorted;
    }

    public Collection<V> values(){
        return map.values();
    }

    public List<V> valueListSorted(){
        sortLists();
        return valueListSorted;
    }

    public void clear(){
        map.clear();
        reverseMap.clear();
        changed = true;
    }

    ///check same size and same objects pairs

    public void check() throws Exception{
        if (map.size()!=reverseMap.size()) throw new Exception("Error in maps sizes!");
        for (K k : map.keySet()) {
            if (reverseMap.get(map.get(k)) == null) throw new DamagedMapsException();
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        map.forEach((k,v)->stringBuilder.append("["+k.toString()+","+v.toString()+"]"+System.lineSeparator()));
        return stringBuilder.toString();
    }
}

