package org.java.jdk8;

import java.util.*;

class ComparatorDemo implements Comparator<Integer>{

    @Override
    public int compare(Integer o1, Integer o2) {

        /*if(o1<o2) {
            return 1;
        }
        else if (o1>o2) {
            return -1;
        }
        else {
            return 0;
        }*/

        //return o1<o2?1:o1>o2?-1:0; //des
        //return o1<o2?-1:o1>o2?1:0; //asc

        return -o1.compareTo(o2);
    }
}
public class MyComparator {
    public static void main(String[] args) {
        ArrayList<Integer> l=new ArrayList<>();
        l.add(10);
        l.add(5);
        l.add(15);
        l.add(7);
        l.add(22);
        System.out.println(l);
        /**
         * asc order by default (Comparable Interface : obj1.compareTo(Obj2))
         * return -1 if obj1 has to come before obj2
         * return 1 if obj1 has to come after obj2
         * return 0 if obj1 and obj2 are equal
         */
        //Collections.sort(l);
        //System.out.println(l);
        /**
         * Any custom sort use  (Comparator Interface : compare(Obj1,Obj2))
         * return -1 if obj1 has to come before obj2
         * return 1 if obj1 has to come after obj2
         * return 0 if obj1 and obj2 are equal
         */
        Collections.sort(l,new ComparatorDemo());
        System.out.println(l);
    }
}
