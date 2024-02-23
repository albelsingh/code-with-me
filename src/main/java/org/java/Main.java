package org.java;

import org.java.streamApi.CTS;
import org.java.streamApi.StreamAPICode;
import org.java.streamApi.CoForges;
import org.java.test.SumOfElements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.java.streamApi.CoForges.getPaire;
import static org.java.streamApi.CoForges.printPairs;

public class Main {
    public static void sortArray(int a[]){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a.length;j++){
                if(a[i] < a[j]){
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        Arrays.stream(a).forEach(System.out::print);
    }
    public static void main(String[] args) {
       /* StreamAPICode streamAPICode=new StreamAPICode();
        List<Integer> list=new ArrayList<>();
        list.add(new Integer(12));
        list.add(new Integer(13));
        list.add(new Integer(14));
        list.add(new Integer(15));
        System.out.println("Sum is:: "+list.stream().mapToInt(x->x).sum());
        System.out.println("Min is:: "+list.stream().mapToInt(x->x).min());
        System.out.println("Max is:: "+list.stream().mapToInt(x->x).max());
        System.out.println("3rd largest element is:: "+list.stream().mapToInt(x->x).sorted().limit(2).min());
        System.out.println("Square are ::"+streamAPICode.calculateSquare(list));
        List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany",
                "Italy", "U.K.","Canada");
        String G7Countries = G7.stream()
                .map(x -> x.toUpperCase())
                .collect(Collectors.joining(", "));
        System.out.println(" Join String "+G7Countries);

        List<String> stringList=new ArrayList<>();
        stringList.add("Reflection");
        stringList.add("Collection");
        stringList.add("Stream");
        System.out.println("String start with s ::"+streamAPICode.findWords(stringList));
        System.out.println("Sorted String ::"+streamAPICode.sortList(stringList));
        streamAPICode.printNumber(list);
        System.out.println("sum of list is ::"+streamAPICode.calculateSum(list));

        CoForges test=new CoForges();
        String str=test.reverseString("albel");
        System.out.println("String is "+str);

        int arr[] = { 1, 5, 7, -1, 5 };
        int n = arr.length;
        int sum = 6;

        printPairs(arr, n, sum);
        getPaire(arr,6);

        CTS cts=new CTS();
        System.out.println();
        cts.find3rdKey();
        streamAPICode.flattenList(); */

        //find first unique element from string
        String s1="i m programmer";
        char ch[]=s1.toCharArray();
        for(int i=0;i<ch.length;i++){
            char chr = ch[i];
            int count=0;
            for(int j=i+1;j<ch.length;j++){
                if(chr ==ch [j]){
                    count++;
                }
            }
            if(count == 0){
                System.out.println(" Element is "+chr);
            }
        }

        int a[] = {0,2,1,0,0,2,1,0};
        sortArray(a);


    }
}