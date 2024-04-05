package org.java.streamApi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.*;

public class Anagram {

    public static String sortStr(String str){
         char[] ch=str.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }

    public static void main(String[] args) {
        //1) List of Input Words :
        //
        //listen
        //pot
        //take
        //opt
        //silent
        //top
        //give
        //
        //Output : Print sets of anagrams (listen, silent), (pot, top, opt)
        List<String> list=new ArrayList<>();
        list.add("listen");
        list.add("silent");
        list.add("pot");
        list.add("top");
        list.add("opt");
        list.add("give");
        list.add("take");
        //length should be same
        //sort and compare


        for(int i=0;i< list.size();i++){
            for(int j=i+1;j< list.size();j++){
                if(list.get(i).length() == list.get(j).length()){
                   String str1=Anagram.sortStr(list.get(i));
                   String str2=Anagram.sortStr(list.get(j));
                   if(str1.equals(str2)){
                       System.out.println(list.get(i)+","+list.get(j));
                   }
                }
            }
        }
        List<Integer> arr=Arrays.asList(1,2,3,4,5);
        List<Integer> sqarr = arr.stream().map(i -> i * i).collect(Collectors.toList());
        System.out.println(sqarr);
    }
}
