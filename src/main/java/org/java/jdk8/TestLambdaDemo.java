package org.java.jdk8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class TestLambdaDemo {
    public static void main(String[] args) throws Exception {
        String s = "Payment done";
        UPIPayment upi = (a,b)-> a+" "+b;
        System.out.println(upi.doPayment("10","20"));

        Function<Integer,String> f=t-> "Output :"+t;
        System.out.println(f.apply(10));

        Runnable runnable=()-> System.out.println("runnable implementation called");
        runnable.run();

        Callable<String> callable=()-> "Callable implementation called";
        System.out.println(callable.call());

        List<Integer> list= Arrays.asList(23,4,6,8,9,1,2,10);
        //>4 23,6,8,9,10 ->6,8,9,10,23
        List<Integer> sortedList = list.stream().filter(num -> num > 4).sorted().collect(Collectors.toList());
        System.out.println(sortedList);

        String input = "banana";
        Map<String, Long> freqMap = Arrays.stream(input.split("")).collect(
                groupingBy(Function.identity(), counting())
        );
        System.out.println(freqMap);
        /**
        Stream uses single core of the machine whereas parallel Stream uses multiple core of the
        machine.
         stream is better for write operation to maintain consistency
         parallel stream is better for read operation
         **/
        IntStream.rangeClosed(1,10).forEach(t-> System.out.println(Thread.currentThread().getName()+" "+t));
        System.out.println("===================");
        IntStream.rangeClosed(1,10).parallel().forEach(t-> System.out.println(Thread.currentThread().getName()+" "+t));

        //Check core available in your machine
        System.out.println(Runtime.getRuntime().availableProcessors());

        /**
         * How to decide Thread pool size
         * CPU Intensive Task : Max thread pool size equal to number of core in your processor
         * IO Intensive Task : Thread pool size should be larger than number of core in your processor
         */


    }
}
