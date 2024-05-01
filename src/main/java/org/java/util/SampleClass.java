package org.java.util;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SampleClass {
    public static void main(String[] args) {
        Map<String,String> map=new HashMap<>();
        map.entrySet().stream().filter(m->Integer.parseInt(m.getValue())>70).map(m->m.getKey()).
                collect(Collectors.toList());
    }
}
