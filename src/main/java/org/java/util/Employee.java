package org.java.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Employee {
//   O/P: print the name of 3rd highest salaried senior(by age) employee
 private int empId;
 private String name;
 private int age;
 private int salary;
 private String dept;
 
 

    public static void main(String[] args) {
        System.out.println("Inside main method");
        ArrayList<Employee> emplist = new ArrayList<>();
        emplist.add(new Employee(101, "vinod", 25, 10000,"Dev"));
        emplist.add(new Employee(107, "kumar", 35, 20000,"QA"));
        emplist.add(new Employee(103, "ravi", 15, 5000,"Dev"));
        emplist.add(new Employee(100, "charan", 35, 10000,"QA"));
        emplist.add(new Employee(100, "rama", 45, 10000,"QA"));
        emplist.add(new Employee(110, "navi", 55, 30000,"DevOps"));
        emplist.add(new Employee(110, "abc", 65, 35000,"Dev"));
        emplist.add(new Employee(110, "dummy", 75, 31000,"DevOps"));

         HashMap<String,Employee> map=new HashMap<>();
        emplist.forEach(employee -> {
            map.put(employee.getName(),employee);
        });

        Map.Entry<String,Employee> empMap = map.entrySet().stream().sorted(Comparator.comparing(entry->-entry.getValue().getAge()))
                .collect(toList())
                .get(2);
        System.out.println("Result::"+empMap);


       /* System.out.println("By Salary::"+map.entrySet().stream()
                .collect(Collectors.groupingBy(entry->entry.getValue().getSalary(),Collectors.mapping(entry->entry.getKey(),toList())))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(entry->-entry.getKey()))
                .collect(toList())
                .get(2));
*/
        System.out.println("By Age::"+map.entrySet().stream()
                .collect(Collectors.groupingBy(entry->entry.getValue().getAge(),Collectors.mapping(entry->entry.getKey(),toList())))
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(entry->-entry.getKey()))
                .collect(toList())
                .get(2));

        System.out.println(emplist.stream().sorted(Comparator.comparing(emp->- emp.getSalary())).collect(toList()).get(2));

        //WAP to find highest paid employee from each department
        //approach 1
        Map<String, Optional<Employee>> empDept = emplist.stream().collect(
                groupingBy(Employee::getDept, reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary))))
        );
        System.out.println(empDept);
        //approach 2
        Map<String, Object> highestPaidEmpListFromEachDept = emplist.stream().collect(
                groupingBy(Employee::getDept,
                        collectingAndThen(maxBy(Comparator.comparingDouble(Employee::getSalary)),Optional::get)
                )
        );
        System.out.println(highestPaidEmpListFromEachDept);

    }
}
