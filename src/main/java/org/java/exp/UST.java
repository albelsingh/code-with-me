package org.java.exp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class UST {
    private String id;
    private String name;
    private int salary;

    public UST(String id,String name, int salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class USTDemo{
    public static void main(String[] args) {
        UST u1=new UST("1234","Albel",1000);
        UST u2=new UST("4645","Pawan",2000);
        UST u3=new UST("7567","Bala",3000);
        UST u4=new UST("6567","Nishat",4000);
        UST u5=new UST("9776","Prakash",5000);
        List<UST> list=new ArrayList<>();
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);
        list.add(u5);
        System.out.println(list.stream().sorted(Comparator.comparing( u-> -u.getSalary())).collect(Collectors.toList()).get(3).getName());
        //System.out.println(map.entrySet().stream().sorted(Comparator.comparing( u-> -u.getValue().getSalary())).collect(Collectors.toList()).get(1).getValue().getName());


        /*Input:
        {"P10", "P101", "P199", "P12", "P13", "P11", "R221", "R22", "R225", "R223", "R222", "R224", "B95", "B49", "B36"}

        Output:
        B36, 49, 95, P10-13, 101, 199, R22, 221-225*/
    }
}
