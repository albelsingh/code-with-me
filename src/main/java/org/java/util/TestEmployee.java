package org.java.util;

import lombok.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TestEmployee {
    private Integer id;
    private String firstname;
    private String lastName;
    private String department;

    public boolean equals(Object o) {
        if(o == null)
        {
            return false;
        }
        if (o == this)
        {
            return true;
        }
        if (this.getClass() != o.getClass())
        {
            return false;
        }
        TestEmployee e = (TestEmployee) o;
        return (this.getId() == e.getId());
    }

    @Override
    public int hashCode()
    {
        final int PRIME = 31;
        int result = 1;
        result = PRIME * result + getId();
        return result;
    }
    //Write Java program to find 2nd largest number in a non sorted array without using Sort function

    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(2,5,9,1,23,87,12,33);
        System.out.println(list.stream().sorted(Comparator.comparing(i->-1)).collect(Collectors.toList()).get(1));
        System.out.println(list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        int arr[] ={2,5,9,1,23,87,12,33};

        for(int i=0;i<arr.length-1;i++){
            for(int j=i;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(" "+arr[i]);
        }
        //System.out.print(arr[arr.length-2]);
        System.out.println("");
        TestEmployee e1 = new TestEmployee();
        TestEmployee e2 = new TestEmployee();

        e1.setId(100);
        e2.setId(100);

        System.out.println(e1.equals(e2));
        Set<TestEmployee> employees = new HashSet<>();
        employees.add(e1);
        employees.add(e2);

        System.out.println(employees);	//Prints two objects
    }
}
