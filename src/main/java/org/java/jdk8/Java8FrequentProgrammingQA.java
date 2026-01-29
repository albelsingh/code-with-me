package org.java.jdk8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Java8FrequentProgrammingQA {
    public static void main(String[] args) {
        String input= "ilovejavatechie";
        // find frequency of each character in the string
        Arrays.stream(input.split("")).collect(Collectors.groupingBy(
                Function.identity(),Collectors.counting()
        )).forEach((k,v)-> System.out.println(k+" has frequency of "+v));
        // Find all the duplicate characters in the string
        Arrays.stream(input.split("")).collect(Collectors.groupingBy(
                Function.identity(),Collectors.counting()
        )).entrySet().stream().filter(e->e.getValue()>1)
                .forEach(e-> System.out.println(e.getKey()+" is duplicate with frequency "+e.getValue()));

        // Find all the unique characters in the string
        Arrays.stream(input.split("")).collect(Collectors.groupingBy(
                Function.identity(),Collectors.counting()
        )).entrySet().stream().filter(e->e.getValue()==1)
                .forEach(e-> System.out.println(e.getKey()+" is unique with frequency "+e.getValue()));
        // Find first non-repeating character in the string
        Arrays.stream(input.split("")).collect(Collectors.groupingBy(
                Function.identity(), LinkedHashMap::new,Collectors.counting()
        )).entrySet().stream().filter(x->x.getValue()==1)
                .findFirst()
                .ifPresent(e-> System.out.println("First non-repeating character is "+e.getKey()));

        // Second highest number in an integer array
        int arr[]= {12,35,1,10,34,1};
        List<Integer> sortedList = Arrays.stream(arr).boxed().sorted().toList();
        System.out.println("Second highest number is "+sortedList.get(sortedList.size()-2));
        // Find Longest string from a list of strings
        List<String> stringList = Arrays.asList("Java","JavaScript","Python","C++","Ruby on Rails");
       stringList.stream().reduce((word1,word2)-> word1.length()>=word2.length()?word1:word2)
               .ifPresent(longest-> System.out.println("Longest string is "+longest));
       // Find all number whose start with 1
        int numArr[]= {10,12,23,34,45,11,19,29,56};
        List<String> list = Arrays.stream(numArr).boxed().map(s -> s + "")
                .filter(s->s.startsWith("1")).toList();
        System.out.println("Numbers start with 1:"+list);
        //String.join method
        List<String> names=Arrays.asList("1","2","3","4","5");
        String result=String.join("-",names);
        System.out.println("Joined String: "+result);
        //skip & limit
        List<Integer> modifiedList= IntStream.rangeClosed(1,10).skip(2).limit(5).boxed().toList();
        System.out.println("Modified List: "+modifiedList);

    }
}
