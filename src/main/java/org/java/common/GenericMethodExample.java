package org.java.common;

import java.util.ArrayList;
import java.util.List;

public class GenericMethodExample {
    // Generic method
    public static <T> void arrayPrint( T[] a ) {
        Integer temp = 0;
        for(T item : a) {
            System.out.printf("%s",item);
            System.out.println();
        }
    }

    public static <T extends Number> double add (T one, T two)
    {
        return one.doubleValue() + two.doubleValue();
    }

    // Use example
    public static void main(String args[]) {
        Integer[] array1 = {0,1,2,3};
        String[] array2 = {"Hello","World"};
        Character[] array3 = {'G','E','N','E','R','I','C'};

        arrayPrint(array1);
        arrayPrint(array2);
        arrayPrint(array3);
        System.out.println(add(1,3));
        System.out.println(add(5.0,3));
        System.out.println(add(1l,8f));
        System.out.println(sum(1l,8f));


    }

    public static <T extends Number> int sum(T a,T b){
        return a.intValue()+b.intValue();
    }
}
