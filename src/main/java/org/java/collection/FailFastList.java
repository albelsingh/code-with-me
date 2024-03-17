package org.java.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastList {
    public static void main(String[] args) {
        /**
         * Fail-safe: it does not throw ConcurrentModificationException because it
         * operates on copy of list and modCount does not get change
         * modCount while iterating list
         */
        List<String> list2=new CopyOnWriteArrayList<>();
        list2.add("d");
        list2.add("e");
        Iterator<String> iterator2=list2.iterator();
        while(iterator2.hasNext()){
            System.out.println(iterator2.next());
            list2.add("f"); //modCount got changed
        }
        /**
         * Fail-fast iterator: modCount
         * throw ConcurrentModificationException if there is any change in
         * modCount while iterating list
         */
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        Iterator<String> iterator=list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            list.add("c"); //modCount got changed
        }
    }
}
