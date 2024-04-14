package org.java.util;

import java.util.Arrays;
import java.util.List;

public class AnagramCode {

    public static String sortString(String str){
        //char[] ch=str.toCharArray();
        //Arrays.sort(ch);
        int j = 0;
        char temp = 0;
        char[] chars = str.toCharArray();
        for(int i=0; i < chars.length; i++) {
            for(j=0; j < chars.length; j++) {
                if(chars[j] > chars[i]) {
                    System.out.println(chars[j]+" "+chars[i]);
                    temp = chars[i];
                    chars[i] = chars[j];
                    chars[j] = temp;
                }
            }
        }
        return new String(chars);
    }

    //RACE, CARE
    public static void main(String[] args) {
       String s1="RACE";
       String s2="CARE";
       //length is same
        // Sort the string
        System.out.println(sortString(s1));
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
