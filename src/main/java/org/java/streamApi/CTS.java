package org.java.streamApi;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class CTS {
// find out 3rd largest values for a key
    public int find3rdKey() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 33);  //4
        map.put("v", 43);  //5
        map.put("e", 33);  //6
        map.put("a", 32);  //4
        map.put("a", 13);  //
        map.put("a", 53);
        map.put("b", 63);
        map.put("c", 73);
       /* List<Integer> values = map.entrySet().stream()
                //.filter(x->x.getKey() == "a")
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(3)
                .map(Map.Entry::getValue)
               // .min(Comparator.comparing(Map.Entry::getValue)
               // .max(Comparator.comparing(Map.Entry::getValue))
                .collect(toList());*/
       return map.entrySet()
                .stream()
                .sorted(Comparator.comparing(entry->-entry.getValue()))
                .collect(Collectors.toList())
                .get(1).getValue();

       // return values.stream().mapToInt(v->v).min().orElseThrow(NoSuchElementException::new);
    }
    public Map.Entry<Integer,List<String>> nthLargestSalary(){

        Map<String,Integer> map = new HashMap<>();
        map.put("anil",1000);
        map.put("ankit",1200);
        map.put("bhavna",1300);
        map.put("james",1400);
        map.put("micael",1500);
        map.put("tom",1600);
        map.put("daniel",1700);

        Map.Entry<String,Integer> finalResult = map.entrySet()
                .stream()
                .sorted(Comparator.comparing(entry -> -entry.getValue())) // minus make it to do in desc order
                .collect(toList())
                .get(2);
        System.out.println(finalResult.getValue());


        //map.entrySet().stream().sorted(Comparator.comparing(entry-> -entry.getValue())).collect(toList()).get(2);
        map.entrySet()
                .stream()
                .collect(Collectors.groupingBy(entry->entry.getValue(),Collectors.mapping(entry->entry.getKey(),toList())))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(entry->-entry.getKey()))
                .collect(toList())
                .get(2);

        Map<String,Integer> map2 = new HashMap<>();
        map2.put("anil",1000);
        map2.put("ankit",1200);
        map2.put("bhavna",1200);
        map2.put("james",1200);
        map2.put("micael",1000);
        map2.put("tom",1300);
        map2.put("daniel",1300);
        map2.put("albel",1100);
        List<Map.Entry<Integer, List<String>>> finalResult2 = map2.entrySet()
                .stream()
                .collect(Collectors.groupingBy(entry ->entry.getValue(),
                        Collectors.mapping(entry -> entry.getKey(), toList())
                ))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(it -> -it.getKey())) // minus sign for decreasing order
                .collect(toList());

        return finalResult2.get(2); //n-1
    }
    // Main driver method
    public static void main(String args[]) {
        CTS cts=new CTS();
        System.out.println(cts.find3rdKey());
        System.out.println(cts.nthLargestSalary().getKey());
    }
}
