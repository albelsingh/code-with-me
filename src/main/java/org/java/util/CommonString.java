package org.java.util;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonString {
    /*
    * Find the longest Common Prefix in an array of Strings in java.
String[] strArr={"java2blog","javaworld","javabean","javatemp"};
So Longest common prefix in above String array will be “java” as all above string starts with “java”.
    * */

    public static String getLongestCommonString() {
        String arr[] = new String[]{"java2blog", "javaworld", "javabean", "javatemp"};
        //String arr[] = new String[]{"grace", "graceful","disgraceful","gracefully"};

        int len = arr.length;
        String str = arr[0];
        String result="";

        for (int i = 0; i < str.length();i++){
            for (int j=i+1;j<= str.length();j++){
                String commonStr=str.substring(i,j);
                int k=1;
                for(k=1;k<len;k++){
                        /*if(!arr[k].contains(commonStr)){
                            break;
                        }*/
                    if(!arr[k].startsWith(commonStr)){
                        break;
                    }
                }
                System.out.println("Length is k:: "+k+"Len :: "+len);
                if (k==len && result.length() <commonStr.length())
                result=commonStr;
            }
        }
        return result;
    }
}

class Test10{
    public static void main(String[] args) {
        System.out.println(CommonString.getLongestCommonString());
    }
}
