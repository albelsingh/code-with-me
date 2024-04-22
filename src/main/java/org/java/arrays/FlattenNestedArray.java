package org.java.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class FlattenNestedArray {
    private static Stream<Object> flatten(Object[] array) {
        //return Arrays.stream(array).flatMap(o -> o instanceof Object[]?flatten((Object[])o) : Stream.of(o));
        return Arrays.stream(array).flatMap(o->o instanceof Object[]?flatten((Object[]) o):Stream.of(o));
    }

    public static void main(String[] args) {
        Object[] array = { 1, 2, new Object[]{ 3, 4, new Object[]{ 5 }, 6, 7 }, 8, 9, 10 };
        //Object[] brr = {new Object[]{ 3, 4,5, 6, 7 },new Object[]{ 8, 9, 10 }};
        System.out.println(flatten(array).collect(Collectors.toList()));

        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("one:one"),
                Arrays.asList("two:one", "two:two", "two:three"),
                Arrays.asList("three:one", "three:two", "three:three", "three:four"));
        List<String> listOfString = nestedList.stream().flatMap(o -> o.stream()).collect(Collectors.toList());
        System.out.println(listOfString);
    }
}
