package org.java.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LowesEmp {
    private String id;
    private String name;
    private double salary;
    private String dept;

    public LowesEmp(String id, String name, double salary, String dept) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "LowesEmp{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void reverseArray(){
        int arr[]=new int[]{1,2,3,4,5,6};
        int start=1;
        int end=4;
        for(int i=start;i<=end;i++){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }

    // 1 2 3 4 5 6 ->1,4->1,5,4,3,2,6
    public static void main(String[] args) {
        //Unmodifiable List
        List<Integer> listInt=Arrays.asList(1,2,3,4,5);
        /*listInt.add(new Integer(10));
        System.out.println(listInt);*/
        System.out.println(listInt.stream().mapToInt(i->i).sum());
        System.out.println(listInt.stream().count());
        List<Integer> l2=new ArrayList<>();
        l2.add(10);
        l2.add(20);
        l2.add(30);
        System.out.println(l2.stream().mapToInt(i->i).sum());

        // Can we declare list as final -> yes
        final List<Integer> l1=new ArrayList<>();
        l1.add(10);
        System.out.println(l1);
        //1 4 6 8 10 23 67
        //k=2
        LowesEmp e1=new LowesEmp("1","Albel",10000,"IT");
        LowesEmp e2=new LowesEmp("2","Chetan",1000000000,"CS");
        LowesEmp e3=new LowesEmp("3","Manish",10000,"EC");
        LowesEmp e4=new LowesEmp("4","Ajay",10000,"EC");
        List<LowesEmp> list=new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
        System.out.println(list.stream().collect(Collectors.groupingBy(st->st.getDept())));

       /* TreeSet<StringBuilder> t=new TreeSet<>(); //
        t.add(new StringBuilder("albel"));
        t.add(new StringBuilder("chetan"));
        System.out.println(t);//ClassCastException: java.lang.StringBuilder cannot be cast to java.lang.Comparable
        //SOLID*/
    }
}
