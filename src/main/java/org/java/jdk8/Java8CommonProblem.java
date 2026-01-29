package org.java.jdk8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8CommonProblem {
    public static void main(String[] args) {
        List<Student> studentList = Stream.of(
                        new Student(1, "Rohit", 30, "Male", "Mechanical Engineering", "Mumbai", 122, Arrays.asList("+912632632782", "+1673434729929")),
                        new Student(2, "Pulkit", 56, "Male", "Computer Engineering", "Delhi", 67, Arrays.asList("+912632632762", "+1673434723929")),
                        new Student(3, "Ankit", 25, "Female", "Mechanical Engineering", "Kerala", 164, Arrays.asList("+912632633882", "+1673434709929")),
                        new Student(4, "Satish Ray", 30, "Male", "Mechanical Engineering", "Kerala", 26, Arrays.asList("+9126325832782", "+1671434729929")),
                        new Student(5, "Roshan", 23, "Male", "Biotech Engineering", "Mumbai", 12, Arrays.asList("+012632632782")),
                        new Student(6, "Chetan", 24, "Male", "Mechanical Engineering", "Karnataka", 90, Arrays.asList("+9126254632782", "+16736784729929")),
                        new Student(7, "Arun", 26, "Male", "Electronics Engineering", "Karnataka", 324, Arrays.asList("+912632632782", "+1671234729929")),
                        new Student(8, "Namdev", 31, "Male", "Computer Engineering", "Karnataka", 433, Arrays.asList("+9126326355782", "+1673434729929")),
                        new Student(9, "Sonu", 27, "Female", "Computer Engineering", "Karnataka", 7, Arrays.asList("+9126398932782", "+16563434729929", "+5673434729929")),
                        new Student(10, "Shubham", 26, "Male", "Instrumentation Engineering", "Mumbai", 98, Arrays.asList("+912632646482", "+16734323229929")))
                .collect(Collectors.toList());

        // 1. Find the list of students whose rank is in between 50 and 100
        studentList.stream().filter(student -> student.getRank() > 50 && student.getRank() < 100)
                .forEach(student -> System.out.println("Student with rank between 50 and 100: " + student));
        //2. Find the Students who stays in Karnataka and sort them by their names
        studentList.stream().filter(student -> student.getCity().equalsIgnoreCase("Karnataka"))
                .sorted(Comparator.comparing(student -> student.getFirstName(), Comparator.reverseOrder()))
                .forEach(student -> System.out.println("Student from Karnataka: " + student));

        // 3. Find all departments names
        studentList.stream().map(Student::getDept).distinct()
                .forEach(dept -> System.out.println("Department Name: " + dept));
        //4.  Find all the contact numbers
        studentList.stream().map(Student::getContacts).flatMap(List::stream).distinct()
                .forEach(contacts -> System.out.println("Contact Numbers: " + contacts));
        //5.  Group The Student By Department Names
        studentList.stream().collect(Collectors.groupingBy(Student::getDept))
                .forEach((dept, students) -> System.out.println("Department: " + dept + " Students: " + students));

        studentList.stream().collect(Collectors.groupingBy(Student::getDept, Collectors.counting()))
                .forEach((dept, count) -> System.out.println("Department: " + dept + " Students: " + count));

        //6. Find the department who is having maximum number of students
        studentList.stream().collect(Collectors.groupingBy(Student::getDept, Collectors.counting()))
                .entrySet().stream().max(Comparator.comparingLong(Map.Entry::getValue))
                .ifPresent(entry -> System.out.println("Department with max students: " + entry.getKey() + " Count: " + entry.getValue()));
        //7. Find the average age of male and female students
        studentList.stream().collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)))
                .forEach((gender, avgAge) -> System.out.println("Gender:" + gender + " Average Age: " + avgAge));

        //8. Find the highest rank in each department
        studentList.stream().collect(Collectors.groupingBy(Student::getDept,
                        Collectors.minBy(Comparator.comparingInt(Student::getRank))))
                .forEach((dept, student) -> System.out.println("Department: " + dept + " Top Rank Student: " + student.get()));

        //9 .Find the student who has second rank
        studentList.stream().sorted(Comparator.comparing(Student::getRank))
                .skip(1).findFirst()
                .ifPresent(student -> System.out.println("Student with second rank: " + student));
    }
}
