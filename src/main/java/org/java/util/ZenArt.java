package org.java.util;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ZenArt {

    public void findNonRepeatingChar(String str){
        /*Map<String,Integer> map=new LinkedHashMap<>();
        for(int i=0;i<str.length();i++){
            if(map.containsKey(String.valueOf(str.charAt(i)))) {
                map.put(String.valueOf(str.charAt(i)),map.get(String.valueOf(str.charAt(i)))+ 1);
            }
            else
                map.put(String.valueOf(str.charAt(i)),1);
        }
        System.out.println(map);
        for(Map.Entry<String,Integer> values: map.entrySet()){
            if(values.getValue()==1){
                System.out.println(values.getKey());
                break;
            }
        }*/
        Map<String, Long> frequency = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(frequency);
        String value = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(k -> k.getValue() == 1).findFirst().get().getKey();
        System.out.println(value);
        List<String> duplicatesElements = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(k -> k.getValue() == 2).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(duplicatesElements);
        List<String> uniqueElements = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(k -> k.getValue() == 1).map(Map.Entry::getKey).collect(Collectors.toList());
        System.out.println(uniqueElements);
    }

    public static void main(String[] args) {
        ZenArt zenArt=new ZenArt();
        //String str="aalbbe 5645ghf"; //a
        String str="i am an engineerf"; //m
        zenArt.findNonRepeatingChar(str);
        // it is printing but not maintaining insertion order
        System.out.println(Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));

    }
}
