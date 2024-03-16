package org.java;

import lombok.extern.slf4j.Slf4j;
import nonapi.io.github.classgraph.json.JSONUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class Main {
    public static void sortArray(int a[]) {
        log.info("arr {}", a[0]);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i] < a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
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

   /*     //find first unique element from string
        String s1 = "i m programmer";
        char ch[] = s1.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char chr = ch[i];
            int count = 0;
            for (int j = i + 1; j < ch.length; j++) {
                if (chr == ch[j]) {
                    count++;
                }
            }
            if (count == 0) {
                System.out.println(" Element is " + chr);
            }
        }

        int a[] = {0, 2, 1, 0, 0, 2, 1, 0};
        sortArray(a);
        System.out.println("--------------------------------");
        String str1 = "Albel";
        String str2 = "Albel"; //created in string constant pool where both ref pointing same object
        System.out.println(str1.equals(str2));
        System.out.println(str1.hashCode() + " - " + str2.hashCode());
        String str3 = new String("Albel");
        String str4 = new String("Albel"); //created in Heap where both ref pointing diff object
        System.out.println(str3.equals(str4));
        System.out.println(str2.equals(str4));
        System.out.println(str3.hashCode() + " - " + str4.hashCode());
*/
       /* List<Integer> list= new ArrayList<>();
        list.add(1);
        list.add(4); //16
        list.add(6); //36
        list.add(8); //64
        list.add(9); // even,sq and sum
        System.out.println(list.stream().filter(n->n%2==0).mapToInt(i->i*i).reduce(0,(left, right) -> left+right));
        */
        String s="aabccd%#$";
        Map<String, Long> collect = Arrays.stream(s.replaceAll("[^a-zA-Z0-9]", "").split(""))
                //.filter(ch->!ch.equals(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

    }
}