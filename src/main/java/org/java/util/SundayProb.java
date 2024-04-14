package org.java.util;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SundayProb {
    /*
    * Given a list of integers, find out all the numbers starting with 1 with the help of java Streams?

public class NumberStartingWithOne{
    public static void main(String args[]) {
            List<Integer> myList = Arrays.asList(10,25,8,49,15,98,32);

			//Write your code here

    }
}
*
* Write a Java program that removes duplicate characters from a given string while maintaining
*  the order of the remaining characters.

String removeRepeating = "programming"

Output -> progamin
    * */

    public static void optimizeMe(int input) {
        int a,b,c;
        a=1;
        b= 2;
        c= 3;

        if(input==1) {
            c= 2;
        } else if(input==2) {
            a= 3;
        } else if(input==3) {
            b= 3;
        } else if(input==4) {
            b= 4;
        }

        switch (input){
            case 1:
                a=1;
                b=2;
                c=2;
                break;
            case 2:
                a=3;
                b=2;
                c=3;
                break;
            case 3:
                a=1;
                b=3;
                c=3;
                break;
            case 4:
                a=1;
                b=4;
                c=3;
                break;
            default:
                a=1;
                b=2;
                c=3;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,25,8,49,15,98,32);

       // list.stream().filter(n-> n.toString().startsWith("1")).forEach(System.out::println);
        String removeRepeating = "programming"; //
        Set<String> set=new LinkedHashSet<>();
        for(int i=0;i<removeRepeating.length();i++){
            if(!set.contains(removeRepeating.charAt(i))){
                set.add(String.valueOf(removeRepeating.charAt(i)));
            }
        }
        String str="infinite";
        String[] split = str.split("");
        Map<String, Long> charMap = Arrays.stream(split).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(charMap);


    }


}
