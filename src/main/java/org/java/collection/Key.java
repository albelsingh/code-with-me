package org.java.collection;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Key {

    String keyStr;

    public void setKeyStr(String str) {
        keyStr = str;
    }

    public int hashCode() {
        return keyStr.hashCode();
    }

}

class Main {
    public static void main(String[] args) {
        Map<Key, Integer> map = new HashMap<>();
        Key k1 = new Key();
        k1.setKeyStr("abc");
        map.put(k1, 100);
        System.out.println(map.get(k1)); //100
        k1.setKeyStr("xyzzy");
        System.out.println(map.get(k1)); //null


        Integer secondLargest = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 9).stream().sorted(Comparator.comparing(i -> -i)).skip(1).findFirst().get();
        System.out.println(secondLargest);

        List<Map.Entry<Integer, Long>> entries = Arrays.asList(1, 2, 3, 4, 5, 5, 5, 2).stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .sorted(Comparator.comparing(m -> -m.getValue())).collect(Collectors.toList());
        System.out.println(entries);

        int result=10/0;
        try{
            System.out.println("inside try block");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally {
            System.out.println("finally block executed");//it won't execute
        }
    }
}
