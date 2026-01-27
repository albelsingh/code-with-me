package org.java.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class DellTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 3, 2, 4, 6, 8, 6, 5, 7, 8};

        Arrays.stream(arr)
                .distinct()
                .boxed()// box to Integer to use Comparator
                .sorted(Collections.reverseOrder())
                .skip(1) // skip first two largest distinct values
                .findFirst()
                .ifPresent(
                        v -> System.out.println("3rd largest element: " + v)
                );
        // Alternative without boxing: work with primitive IntStream and index from the end
        int[] distinctSortedAsc = Arrays.stream(arr).distinct().sorted().toArray();
        if (distinctSortedAsc.length >= 3) {
            System.out.println("3rd largest (no boxing): " + distinctSortedAsc[distinctSortedAsc.length - 3]);
        }}
}
