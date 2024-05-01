package org.java.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DupRemove {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(10);
        list.add(10);
        list.add(20);
        list.add(10);
        list.add(4);
        list.add(5);
        list.add(20);
        Set<Integer> integerSet=new HashSet<>();
        list.stream().filter(n-> !integerSet.add(n)).forEach(System.out::println);
        System.out.println(integerSet);

        int a=1;
        String str="two";
        String s="";
        switch (str){
            case "one":
                System.out.println("1");
                s="one";
                break;
            case "two":
                System.out.println("2");
                s=str;
                break;
            default:
                System.out.println("Default");
        }
        System.out.println(s);
    }
}
