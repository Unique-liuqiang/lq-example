package 手写Hashmap;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用ArrayListHashMap
 */
public class ExtArrayListMap<Key,Value> {

    /**
     * 存数据
     */
   private List<Entry<Key,Value>> table=new ArrayList<>();


    public void put(Key key,Value value){
        //是否存在相同的
        Entry<Key, Value> existEntry = getEntry(key);
        if(existEntry!=null){
            existEntry.value=value;
            return;
        }
        Entry entry=new Entry<Key,Value>(key,value);
        table.add(entry);
    }

    public Value get(Key key){
        for(Entry<Key,Value> entry:table){
           if(entry.key.equals(key)){
               return entry.value;
           }
        }
        return null;
    }

    public void remove(Key key){
        Entry<Key, Value> entry = getEntry(key);
        if(entry!=null){
           table.remove(entry);
        }
    }
    private Entry<Key, Value>  getEntry(Key key) {
        for(Entry<Key,Value> entry:table){
            if(entry.key.equals(key)){
                  return entry;
            }
        }
        return null;
    }
}
class Entry<Key,Value>{
    Key key;
    Value value;
    public Entry(Key key,Value value){
        this.key=key;
        this.value=value;
    }
    public static void main(String[] args){
        ExtArrayListMap<String,Object> extArrayListMap=new ExtArrayListMap();
        extArrayListMap.put("1",2);
        extArrayListMap.put("1",3);
        System.out.println(extArrayListMap.get("2"));
    }
}
