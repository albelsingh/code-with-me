package org.java.common;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepeatingChar {
    public static void main(String[] args) {
        String str="capgeminibangalore";//i
        Set<String> strSet = Arrays.stream(str.split("")).collect(Collectors.toSet());
        //applying group by on set does not help us because it stores unique values
        System.out.println(strSet.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
        Set<String> set=new HashSet<>();
        System.out.println(Arrays.stream(str.split("")).filter(ch->!set.add(ch)).findFirst().get());
        //1,neha 34
        //
    }
}
