package org.java.streamApi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortString {
    public static void main(String[] args) {
        List<String> listOfStr= Arrays.asList("albel","jatin","neha","xyz","anuj");
        String secondStr = listOfStr.stream().sorted(Comparator.comparing(s -> s))
                        .skip(1).findFirst().get();
        System.out.println(secondStr);
    }
}
