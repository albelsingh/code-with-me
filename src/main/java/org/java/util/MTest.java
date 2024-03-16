package org.java.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MTest {
    public static void main(String[] args) {
        List<Integer> list=Arrays.asList(1,4,8,22,40,11,33,99);

        List<Integer> evenList = list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
        List<Integer> oddList  = list.stream().filter(i -> i % 2 != 0).collect(Collectors.toList());
        System.out.println("Even List"+evenList);
        System.out.println("Odd List"+oddList);
        Map<Boolean, List<Integer>> map = list.stream().collect(Collectors.groupingBy(i -> i % 2 == 0));
        System.out.println(map);
        List mapList = list.stream().map(i -> i % 2 == 0).collect(Collectors.toList());
        System.out.println(mapList);

    }
}
