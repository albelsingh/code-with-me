package org.java.collection;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
//public class Student implements Comparable<Student>{
public class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id == student.id && name.equals(student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

   /* @Override
    public int compareTo(Student s) {
         if(this.id<s.id)
            return -1;
        else if (this.id>s.id) {
            return 1;
        }
        return 0;
        //return -this.name.compareTo(s.name);
    }*/

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Student s1=new Student(1,"A");
        Student s5=new Student(10,"C");
        Student s2=new Student(2,"Y");
        Student s3=new Student(3,"S");
        Student s4=new Student(4,"G");
        Student s6=new Student(4,"A");
        ArrayList<Student> students=new ArrayList<>();
        students.add(s1);
        students.add(s4);
        students.add(s3);
        students.add(s2);
        students.add(s6);
        students.add(s5);
        Collections.sort(students,new IdComparator());
        System.out.println(students);
        List<Student> sortedStudent = students.stream().sorted(Comparator.comparing(Student::getId)).collect(Collectors.toList());
        System.out.println(sortedStudent);

        /**
         * Comparable interface follow single sorting algorithm if we
         * need to sort based on name then again we have to change the
         * logic in compareTo method
         */
    }
}
