package org.java.streamApi;

import net.bytebuddy.asm.Advice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GEProb {
    public static void main(String[] args) {
        //A123,ABCD,AB1234,A
        List<String> list= Arrays.asList("A123","ABCD","AB1234","A");

        List<String> stringList = list.stream().filter(str -> {
                    char[] ch = str.toCharArray();
            System.out.println(Character.getType(ch[0]));
                    if (ch.length > 2 && !Character.isDigit(ch[0]) && !Character.isDigit(ch[1]))
                        return true;
                    if (ch.length == 1 && ! Character.isDigit(ch[0]))
                        return true;
                    return false;
                }
        ).collect(Collectors.toList());
        System.out.println(stringList);
        System.out.println(Character.isAlphabetic(65)+" "+(int)'A');
    }
}
