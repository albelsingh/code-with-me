package org.java.util;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class StringStreamAPI {
    //String Array to Map With Stream API
    public static Map<String, String> arrayToMap(String[] arrayOfString) {
        return Arrays.asList(arrayOfString)
                .stream()
                .map(str -> str.split(":"))
                .collect(toMap(str -> str[0], str -> str[1]));
    }
    public static String joinString(String[] str){
        //return Arrays.stream(str).collect(Collectors.joining()); //albelajaymurari
        //return Arrays.stream(str).collect(Collectors.joining(",")); //albel,ajay,murari
        return Arrays.stream(str).collect(Collectors.joining(",","{","}")); //{albel,ajay,murari}

    }
    public static void main(String[] args) {
        String strArray[]={"a:2","b:4","f:6"};
        System.out.println(StringStreamAPI.arrayToMap(strArray));
        String arr[]={"albel","ajay","murari"};
        System.out.println(StringStreamAPI.joinString(arr));
    }
}
