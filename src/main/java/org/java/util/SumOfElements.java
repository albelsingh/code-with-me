package org.java.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfElements {
    public static void getSum() {

        int arr[]=new int[]{1,2,3,};

        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(4,5,6,7,8,9,10,11));
        System.out.println(list1.stream().filter(i-> !list2.contains(i)).mapToInt(i->i).sum());
        System.out.println(list2.stream().filter(i-> !list1.contains(i)).mapToInt(i->i).sum());
    }
    // Main driver method
    public static void main(String args[]) {
       SumOfElements.getSum();
    }
}
