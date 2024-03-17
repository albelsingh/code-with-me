package org.java.collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NullKeyValue {
    public static void main(String[] args) {
        /**
         * It allows null insertions and it is non-synchronized
         * it lock entire object
         * initial capacity of map is 16
         */
        Map<String, String> m=new HashMap<>();
        m.put(null,null); // it stores this entry at 0 index
        System.out.println(m);

        /**
         * Hashtable does not allow null insertion and it is synchronized
         * it also lock entire object
         */
        Hashtable<Integer,String> hashtable = new Hashtable();
        hashtable.put(null,null);
        System.out.println(hashtable);

        /**
         * it does not allow null insertions in ConcurrentHashMap
         * it apply segment locking mechanism
         */
        Map<String, String> map=new ConcurrentHashMap<>();
        map.put(null,null);
        System.out.println(map);
    }
}
