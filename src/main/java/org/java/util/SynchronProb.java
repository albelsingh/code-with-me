package org.java.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SynchronProb {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,5,2,4,3);
        int[] arr= new int[]{1,5,2,4,3};
        int first=list.get(0);
        int second=list.get(0);
        for(int i=1;i<list.size();i++){
            if(list.get(i)>first){
                second=first;
                first=list.get(i);
            } else if (list.get(i)>second) {
                if(first != list.get(i)){
                    second=list.get(i);
                }
            }
        }
        //int sum = list.stream().filter(i -> i % 2 != 0).map(n -> n * n).mapToInt(i -> i).sum();
        //int sum = list.stream().filter(i -> i % 2 != 0).map(n -> n * n).collect(Collectors.summingInt(Integer::intValue));
        //int sum = list.stream().filter(i -> i % 2 != 0).map(n -> n * n).mapToInt(i -> i).reduce(0,(a,b)->a+b);
        int sum = list.stream().filter(i -> i % 2 != 0).map(n -> n * n).reduce(0,Integer::sum);
        int result = Arrays.stream(arr).filter(i -> i % 2 != 0).map(n -> n * n).sum();
        System.out.println(sum+" "+result);
        //System.out.println(first+" "+second);
        Map<String, Map<Integer, List<Integer>>> map =new HashMap<>();
        Map<Integer, List<Integer>> internalMap= new HashMap<>();
        internalMap.put(100,list);
        map.put("friday",internalMap);
        List<Map.Entry<Integer, List<Integer>>> entryList = map.entrySet().stream().flatMap(m -> m.getValue().entrySet().stream()).collect(Collectors.toList());
        System.out.println(entryList);
        List<Integer> singleList = entryList.stream().flatMap(i -> i.getValue().stream()).collect(Collectors.toList());
        System.out.println(singleList);
    }
}
