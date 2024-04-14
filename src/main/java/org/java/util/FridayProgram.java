package org.java.util;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FridayProgram {

    public static int[] reverseArray(int[] arr){
        int j=arr.length-1;
        for(int i=0;i<arr.length/2;i++){
            int temp=arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
            j--;
        }
        for(int i:arr){
            System.out.println(i);
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr=new int[]{1,4,0,3,5,8,2};
        //int[] brr=FridayProgram.reverseArray(arr);
        List<String> listStr= Arrays.asList("apple","banana","grapes","america");
        List<String> stringList = listStr.stream().filter(s -> s.startsWith("a")).collect(Collectors.toList());
        System.out.println(stringList);
        //String s="programmer";
        //String s="aalbbe 5645ghf"; //a
        String s="i am an engineerf"; //m
        Map.Entry<String, Long> stringLongEntry = Arrays.stream(s.split("")).filter(s1->!s1.equals(" ")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting())).entrySet().stream()
                .filter(m -> m.getValue() == 2).findFirst().get();
        System.out.println(stringLongEntry);
    }


}
