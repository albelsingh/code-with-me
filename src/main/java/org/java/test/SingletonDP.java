package org.java.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SingletonDP {

    String s;
    private static SingletonDP singletonDP= new SingletonDP();
    private SingletonDP(){
s="Test";
    }
    public static SingletonDP getObject(){
        return singletonDP;
    }

    public static void main(String[] args) {
        String s1 = "Öne";
        s1.concat("TWO");
        s1.concat("THREE");
        //System.out.println(s1);
        SingletonDP obj1=SingletonDP.getObject();
        SingletonDP obj2=SingletonDP.getObject();
        SingletonDP obj3=SingletonDP.getObject();
        System.out.println(obj1==obj2);

        List<String> list = Arrays.asList("apple","apple","banana","apple","orange","banana","papaya");
        System.out.println(list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));

    }
}
