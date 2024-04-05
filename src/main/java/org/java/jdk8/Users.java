package org.java.jdk8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.java.util.Employee;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Users {
    private String name;
    private String numbers;
    private List<String> email;
}

class UsersDemo {
    public static void main(String[] args) {
        List<Users> list = Stream.of(new Users("Albel", "8959462921", Arrays.asList("albelsingh35@gmail.com", "albelsingh31@gmail.com")),
                        new Users("Albel Singh", "8959462929", Arrays.asList("albelsingh@gmail.com", "albelsingh50@gmail.com")))
                .collect(Collectors.toList());
        list.stream().map(Users::getNumbers).forEach(System.out::println);
        List<String> emailList = list.stream().flatMap(u -> u.getEmail().stream()).collect(Collectors.toList());
        emailList.forEach(System.out::println);


        //find frequency of each chars in given string
        String input = "Banana apple";
        Map<String, Long> map = Arrays.stream(input.split("")).filter(ch -> !ch.equals(" "))
                .collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );
        System.out.println(map);
        // find char which occurrence is greater than 1
        String text = "1aabcaa1effgh";
        //{"a":4,"1":2,"f":2}
        System.out.println(Stream.of(text.split("")).collect(Collectors.groupingBy(Function.identity(),
                Collectors.counting())).entrySet().stream().filter(i -> 1 < i.getValue()).collect(Collectors.toList()));


        //List of emp in various dept, find highest paid employee from each dept
        ArrayList<Employee> emplist = new ArrayList<>();
        emplist.add(new Employee(101, "vinod", 25, 10000, "Dev"));
        emplist.add(new Employee(107, "kumar", 35, 20000, "Dev"));
        emplist.add(new Employee(103, "ravi", 15, 5000, "QA"));
        emplist.add(new Employee(100, "charan", 35, 11000, "QA"));
        emplist.add(new Employee(100, "rama", 45, 10000, "QA"));
        emplist.add(new Employee(110, "navi", 55, 31000, "DEVOPS"));
        emplist.add(new Employee(110, "abc", 65, 32000, "DEVOPS"));
        emplist.add(new Employee(110, "dummy", 75, 30000, "DEVOPS"));

        Map<String, Optional<Employee>> empMap = emplist.stream().
                collect(
                        Collectors.groupingBy(Employee::getDept,
                                Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary))))
                );
        System.out.println(empMap);
        //emplist.stream().parallel().forEach(System.out::println);
        //
        //IntStream.rangeClosed(1,10).forEach(t->System.out.println(Thread.currentThread().getName() + t));
        //IntStream.rangeClosed(1,10).parallel().forEach(t->System.out.println(Thread.currentThread().getName() + t));
        List<String> list1 = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
        System.out.println(list1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));

    }
}
