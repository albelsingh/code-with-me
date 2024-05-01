package org.java.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringDupChar {
    public static void main(String[] args) {
        String s ="hdssdrrssaaddfss";
        List<Map.Entry<String, Long>> entryList = Arrays.stream(s.split("")).collect(Collectors.groupingBy(
                Function.identity(), Collectors.counting())).entrySet().stream().filter(m -> m.getValue() > 1).collect(Collectors.toList());
        //System.out.println(entryList);

        Consumer<String> stringConsumer= str-> System.out.println(str);
        Arrays.asList("test","Ajay","xyz").forEach(stringConsumer);

    }
}
