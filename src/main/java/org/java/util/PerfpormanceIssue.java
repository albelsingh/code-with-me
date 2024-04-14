package org.java.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PerfpormanceIssue {

        public static void main(String[] args) {
            List<Integer> numbers = new ArrayList<>();
            IntStream.rangeClosed(1,100000).mapToObj(i->numbers.add(i)).collect(Collectors.toList());

            int target = 75000;
            boolean isFound = searchNumber(numbers, target);

            if (isFound) {
                System.out.println("Target " + target + " found in the list.");
            } else {
                System.out.println("Target " + target + " not found in the list.");
            }
        }

        public static boolean searchNumber(List<Integer> list, int target) {
           if(list.contains(new Integer(target)))
                    return true;
            return false;
        }
    }
