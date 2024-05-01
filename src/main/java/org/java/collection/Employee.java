package org.java.collection;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
    private String id;
    private String name;
    private int age;
    private BigDecimal salary;

    public Employee(String id, String name, int age, BigDecimal salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    public static void main(String[] args) {
       List<Employee> employeeList=new ArrayList<>();
       Employee e1=new Employee("1","albel",40,new BigDecimal(10000));
       Employee e2=new Employee("2","murari",29,new BigDecimal(30000));
       Employee e3=new Employee("3","ajay",20,new BigDecimal(40000));
       Employee e4=new Employee("4","prakash",35,new BigDecimal(60000));
       Employee e5=new Employee("5","prakash",35,new BigDecimal(80000));
       employeeList.add(e1);
       employeeList.add(e2);
       employeeList.add(e3);
       employeeList.add(e4);
       employeeList.add(e5);
        List<Employee> sortedEmployee = employeeList.stream().sorted(Comparator.comparing(Employee::getName)
                .thenComparing(Employee::getAge).thenComparing(Employee::getSalary)).collect(Collectors.toList());
        System.out.println(sortedEmployee);
    }
}
