package org.java.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class TechM {

    public static void main(String[] args) {

        String str="static";
        int j=str.length()-1;
        char ch[]=str.toCharArray();
        for(int i=0;i<str.length()/2;i++){
            char temp=ch[i];
            ch[i]=ch[j];
            ch[j]=temp;
            j--;
        }
        System.out.println(ch);
    }
}
