package org.java.util;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EyTest {
    public static void main(String[] args) {
        //Mock vs MockBean
        //runasSync and supplyasSync and CompletableFuture
        //can we create object of abstract class
        //terminate and intermidiate method, what if we don't apply terminator method to stream
        String s="i am an engineer"; //m
        System.out.println(s);
        System.out.println(Arrays.stream(s.split("")).filter(i-> !i.equals(" ")).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,
                        Collectors.counting())).entrySet().stream().filter(m->m.getValue()==1).findFirst().get().getKey());
        System.out.println();

    }

}
