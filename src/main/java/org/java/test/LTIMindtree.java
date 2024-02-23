package org.java.test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LTIMindtree {


    public static void main(String[] args) {
        Map<String,Integer> empMap=new HashMap();
        empMap.put("Ravi",24000);
        empMap.put("Reshma",25000);
        empMap.put("Lakhan",6000);
        empMap.put("Juhi",14000);
        empMap.put("Sharoj",24000);
        //System.out.println(empMap.entrySet().stream().sorted(Comparator.comparing(emp->-emp.getValue())).collect(Collectors.toList()).get(1));
        System.out.println(empMap.entrySet().stream().collect(Collectors.
                groupingBy(emp->emp.getValue(),Collectors.mapping(emp1->emp1.getKey(),Collectors.toList()))
        ).entrySet().stream().sorted(Comparator.comparing(e->-e.getKey())).collect(Collectors.toList()).get(1));

        String str1="abcdef"; // a b c d e f a b c d e f
        String substring="cdef"; //
        StringBuffer sb=new StringBuffer(str1);
        for(int i=0;i<str1.length();i++){
            sb.append(str1.charAt(i));
        }
        //System.out.println(sb);
        for (int i =0;i<sb.length();i++){
            for(int j=i;j<sb.length();j++){
                String s2= sb.substring(i,j);
                if(s2.equals(substring))
                    System.out.println("it is substring");
            }
        }

    }

}
