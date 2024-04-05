package org.java.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FailFastMap {
    public static void main(String[] args) {

        /**
         * Fail-safe: it does not maintain copy of map like CopyOnWriteArrayList
         */
        Map<Integer,String> m=new ConcurrentHashMap<>();
        m.put(1,"Albel");
        m.put(2,"Murari");

        Iterator<Integer> it = m.keySet().iterator();
        while(it.hasNext()){
            Integer key = it.next();
            System.out.println(key+" :"+m.get(key));
            m.put(3,"Ajay");
        }
        /**
         * Fail fast:
         */
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"Albel");
        map.put(2,"Murari");

        Iterator<Integer> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            System.out.println("---");
            Integer key = iterator.next();
            System.out.println(key+" :"+map.get(key));
            map.put(3,"Ajay");
        }
    }
}
