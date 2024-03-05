package org.java.util;

import java.util.ArrayList;
import java.util.List;

public class StringUtils {

    public static void main(String[] args) {
        // List<String> list = Arrays.asList("name1","name2","name3");
        List<String> list = new ArrayList<>();
        list.add("name1");
        list.add("name2");
        list.add("name3");
        //name1->aame1,name2->mame2,name3->eame3
        replaceFirstChar(list);
    }

    private static void replaceFirstChar(List<String> list) {
        String name = list.get(0);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            char newChar = name.charAt(i + 1);
            list.set(i, str.replace(str.charAt(0), newChar));
        }
        System.out.println(list);
    }
}
