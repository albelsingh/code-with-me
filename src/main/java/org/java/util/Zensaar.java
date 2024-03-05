package org.java.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Zensaar {

    public static void main(String[] args) {
        int arr[]= {1,2,4,6,8,9,5,3};
        Integer brr[]=new Integer[arr.length];
        for(int i=0;i<arr.length;i++){
            brr[i]=arr[i];
        }
        List<Integer> list = Arrays.asList(brr);
        Integer n=list.stream().sorted(Comparator.comparing(i->-i)).collect(Collectors.toList()).get(2);
        System.out.println(n);
        list.stream().filter(i->i%2==0).forEach(System.out::println);


    }
}
