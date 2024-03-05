package org.java.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Person {
    int id;
    String name;
    String adddress;
    int age;

    public static void main(String[] args) {
        List<Person> persons=new ArrayList<>();
        persons.add(new Person(1, "Ram" , "india", 22));
        persons.add(new Person(2, "Amrit" , "india", 25));
        persons.add(new Person(3, "Jack" , "india", 22));
        persons.add(new Person(4, "Rahim" , "india", 27));
        persons.add(new Person(5, "Amrit" , "india", 23));
        //1. Harman - save employee into map, age as key and emp object as value if key are unique
        //System.out.println(persons.stream().collect(Collectors.toMap(Person::getAge, person -> person)));
        //Harman - save employee into map, age as key and emp object as value if key are duplicate
        //System.out.println(persons.stream().collect(Collectors.groupingBy(Person::getAge,Collectors.mapping(person -> person,Collectors.toList()))));
        // 2 Sort list by name and age
        //persons.stream().sorted(Comparator.comparing(person -> person.getName())).collect(Collectors.toList()).forEach(System.out::println);
        persons.stream().sorted(Comparator.comparing(Person::getName).thenComparing(person -> person.getAge())).forEach(System.out::println);
    }
}
