package org.java.jdk8;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@FunctionalInterface
public interface MyFunctionalInterface {
    void doPayment(int i);
    //Other Features
    default void scanQR(){
        System.out.println("Scanning QR Code");
    }

    //Utility method
    static void getPaymentDate(){
        System.out.println("Payment Date is "+new Date().getTime());
    }
}

class MyFunctionalDemo{
    public static void main(String[] args) {
        MyFunctionalInterface functionalInterface=new MyFunctionalInterface() {
            @Override
            public void doPayment(int i) {
                System.out.println("Hello Interface "+i);
            }
        };
        functionalInterface.doPayment(10);
        functionalInterface.scanQR();
        MyFunctionalInterface.getPaymentDate();

        MyFunctionalInterface mf =(i)-> System.out.println("Payment using lambda Function " + i);
        mf.doPayment(10);
        Runnable run=()-> System.out.println("Thread is created");
        new Thread(run).start();

        Function<Integer,String> function = (t)->"output "+t;
        System.out.println(function.apply(90));

        Predicate predicate=(i)-> i.equals(10);
        System.out.println(predicate.test(11));


        List<Integer> list = Arrays.asList(10,29,20,34,56,87,1,5,8,9,4,1,2,2,3,10,20,5);
        //Find out unique number which dividable by 5
        list.stream().filter(i->i%5==0).distinct().sorted().forEach(System.out::println);
        //fnd out duplicate number
        Set<Integer> item=new HashSet<>();
        list.stream().filter(i->!item.add(i)).sorted().forEach(System.out::print);
        //Using Frequency method
        list.stream().filter(i->Collections.frequency(list,i)>1).forEach(System.out::println);
        //

    }
}
