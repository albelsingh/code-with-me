package org.java.collection;

import org.java.util.Person;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {
        /**
        set internally uses map
        If you are using set with primitive type no need to override hashcode and equal method
        **/
        Set<Integer> integerSet=new HashSet<>();
        integerSet.add(10);
        integerSet.add(10);
        integerSet.add(10);
        integerSet.add(30);
        System.out.println(integerSet);
        /**
         * If you are using any custom or wrapper class object you need to override hashcode and equal method
         */
        Student p1=new Student(1,"Albel");
        Student p2=new Student(1,"Albel");
        Student p3=new Student(2,"Murari");
        Student p4=new Student(2,"Murari");
        Set<Student> personSet=new HashSet<>();
        personSet.add(p1);
        personSet.add(p2);
        personSet.add(p3);
        personSet.add(p4);
        System.out.println(personSet);
    }
}
