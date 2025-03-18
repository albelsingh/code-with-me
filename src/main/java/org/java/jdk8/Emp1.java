package org.java.jdk8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Emp1 {
    public String name;
    public int eno;
    public Emp1(String name,int eno){
        this.name=name;
        this.eno=eno;
    }
    public String toString(){
        return eno+":"+name;
    }
}
class Emp1Demo{
    public static void main(String[] args) {
        ArrayList<Emp1> l=new ArrayList<>();
        l.add(new Emp1("Sunny",123));
        l.add(new Emp1("Bunny",465));
        l.add(new Emp1("Chinny",768));
        l.add(new Emp1("Vinny",145));
        ArrayList<Integer> list=new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(15);
        Collections.sort(list);
        System.out.println(l);
        System.out.println(list);
        /**
         * Asc order based on emp no
         */
        //Comparator<Emp1> c=(e1,e2)->e1.eno<e2.eno?-1:e1.eno>e2.eno?1:0;
        Collections.sort(l,(e1,e2)->e1.eno<e2.eno?-1:e1.eno>e2.eno?1:0);
        System.out.println(l);
        /**
         * Sort based on alphabetical order of emp names
         * s1.compareTo(s2) for alphabetical order
         */
        Collections.sort(l,(e1,e2)->e1.name.compareTo(e2.name));
        System.out.println(l);
    }
}
