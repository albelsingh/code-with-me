package org.java.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {
    private String str;
    private static void replaceFirstChar(List<String> list) {
        String name = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            char newChar = name.charAt(i + 1);
            list.set(i, str.replace(str.charAt(0), newChar));
        }
        System.out.println(list);
    }


    public static void main(String[] args) {
        // List<String> list = Arrays.asList("name1","name2","name3");
        List<String> list = new ArrayList<>();
        list.add("name1");
        list.add("name2");
        list.add("name3");
        //name1->aame1,name2->mame2,name3->eame3
        replaceFirstChar(list);

        System.out.println("");
        //Input [1,2,3]  => Output [[1,2],[2,3],[3,4]]
        List<Integer> integerList= Arrays.asList(1,2,3,4);
        List<Integer> list1=integerList.subList(0,2);
        List<Integer> list2=integerList.subList(1,3);
        List<Integer> list3=integerList.subList(2,4);
        List<List<Integer>> mainList=new ArrayList<>();
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);
        System.out.println(mainList);
        System.out.println(mainList.stream().flatMap(l->l.stream()).collect(Collectors.toList()));

        String s1="ABC";
        s1="XYZ";
        System.out.println(s1);
        String s2=s1+"QWE";
        System.out.println(s2);

        String str1=new String("Hello");
        String str2=new String("Hello");
        String str3="Hello";
        String str4="Hello";
        System.out.println(str1==str2);
        System.out.println(str1==str3);
        System.out.println(str4==str3);

    }
}
