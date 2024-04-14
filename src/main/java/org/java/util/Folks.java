package org.java.util;

import java.util.HashMap;

public class Folks {
    private String name;

    public Folks(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public static void main(String[] args) {
        HashMap<Folks,String> map=new HashMap<>();
        Folks f1=new Folks("Xyz");
        Folks f2=new Folks("XYz");
        Folks f3=new Folks("XYZ");
        Folks f4=new Folks("XYZ");

        map.put(f1,"A");
        map.put(f2,"A");
        map.put(f3,"A");
        map.put(f4,"A");
        System.out.println(f3==f4);
        System.out.println(f3.equals(f4));
        System.out.println("HashMap Size is "+map.size());
        String s1="Java";
        String s2="Java";
        String s3=new String("Java");
        String s4=new String("Java");
        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s4==s3);
    }
}