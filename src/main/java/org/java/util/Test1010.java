package org.java.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test1010 {

    public static List<Integer> dupList(List<Integer> list){
        Set<Integer> set=new HashSet<>();
        return list.stream().filter(l-> !set.add(l)).collect(Collectors.toList());
    }
    public static void main(String[] args) {
        List<Integer> integerList = dupList(Arrays.asList(1, 2, 3, 2, 3,4,6,4,6,7));
        System.out.println(integerList);
    }
}
