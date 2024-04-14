package org.java.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InfoVision {

    private String msg;

    public InfoVision(String msg){
        this.msg=msg;
    }
    public static void main(String[] args) {
        //How do you print ten random numbers using forEach?
        IntStream.rangeClosed(1,10).forEach(n->{
            System.out.println(Math.random());
        });
        //occurrence of each characters
        String str="AAAABBBCCD";
        List<Map.Entry<String, Long>> occ = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet()
                .stream().sorted(Comparator.comparing(m -> -m.getValue())).collect(Collectors.toList());
        System.out.println(occ);
    }
}
