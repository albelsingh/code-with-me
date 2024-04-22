package org.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDemo {
    public static void main(String[] args) {

        /**
         * 1. can be declared list as final and modify
         * the list but can't reassign it
         *
         */
        final ArrayList<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        System.out.println(list);
        ArrayList<String> l=new ArrayList<>();
        //list=l; //can't reassign
        System.out.println(l);
        /**
         * Unmodifiable list
         */

        List<Integer> unModifiedList= Arrays.asList(1,2,3,4);
        unModifiedList.add(5);
        System.out.println(unModifiedList);

        //
    }
}
