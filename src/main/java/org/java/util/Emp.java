package org.java.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Emp {
    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;

    public Emp(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Id : " + id
                + ", Name : " + name
                + ", age : " + age
                + ", Gender : " + gender
                + ", Department : " + department
                + ", Year Of Joining : " + yearOfJoining
                + ", Salary : " + salary;
    }

    public static void main(String[] args) {
        List<Emp> empList = new ArrayList<Emp>();
        empList.add(new Emp(11, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        empList.add(new Emp(22, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        empList.add(new Emp(33, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        empList.add(new Emp(44, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        empList.add(new Emp(55, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));

        Emp emp = empList.stream().sorted(Comparator.comparing(e -> -e.getSalary())).skip(1).findFirst().get();
        System.out.println(emp);

        //Max age of the employee
        Integer maxAge = empList.stream().map(e -> e.getAge()).sorted(Comparator.comparing(age -> -age)).findFirst().get();
        System.out.println(maxAge);
    }

}
