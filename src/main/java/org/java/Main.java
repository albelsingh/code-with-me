package org.java;

import lombok.extern.slf4j.Slf4j;
import org.java.streamApi.StreamAPICode;

import java.util.ArrayList;
import java.util.List;

import static org.java.TestClass.printPairs;

public class Main {

    public static void main(String[] args) {
        StreamAPICode streamAPICode=new StreamAPICode();
        List<Integer> list=new ArrayList<>();
        list.add(new Integer(12));
        list.add(new Integer(13));
        list.add(new Integer(14));
        list.add(new Integer(15));
        System.out.println("Square are ::"+streamAPICode.calculateSquare(list));

        List<String> stringList=new ArrayList<>();
        stringList.add("Reflection");
        stringList.add("Collection");
        stringList.add("Stream");
        System.out.println("String start with s ::"+streamAPICode.findWords(stringList));
        System.out.println("Sorted String ::"+streamAPICode.sortList(stringList));
        streamAPICode.printNumber(list);
        System.out.println("sum of list is ::"+streamAPICode.calculateSum(list));

        TestClass test=new TestClass();
        String str=test.reverseString("albel");
        System.out.println("String is "+str);

        int arr[] = { 1, 5, 7, -1, 5 };
        int n = arr.length;
        int sum = 6;

        printPairs(arr, n, sum);
    }
}