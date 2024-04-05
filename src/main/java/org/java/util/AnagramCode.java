package org.java.util;

import java.util.Arrays;
import java.util.List;

public class AnagramCode {

    public static String sortString(String str){
        char[] ch=str.toCharArray();
        Arrays.sort(ch);
        return new String(ch);
    }

    //RACE, CARE
    public static void main(String[] args) {
       String s1="RACE";
       String s2="CARE";
       //length is same
        // Sort the string
        // compare both string
        if(s1.length()== s2.length()){
            if(AnagramCode.sortString(s1).equals(AnagramCode.sortString(s2))){
                System.out.println("String are anagram");
            }else{
                System.out.println("String are not anagram");
            }
        }else{
            System.out.println("String are not anagram");
        }
        //2nd Highest Number from list
        List<Integer> list=Arrays.asList(70,80,10,20,30,40,90);

        int max=list.get(0);
        int prev=list.get(0);

        for(int i=0;i<list.size();i++){
            if(list.get(i)>max){
                prev = max;
                max=list.get(i);
            }
        }
        System.out.println(prev+" "+max);

    }
}
