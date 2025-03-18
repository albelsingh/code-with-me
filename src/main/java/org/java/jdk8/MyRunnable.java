package org.java.jdk8;

import java.util.stream.IntStream;

public class MyRunnable {
    public static void main(String[] args) {
        Runnable r=()-> {
            IntStream.rangeClosed(1,10).forEach(i-> System.out.println("Child Thread "+i));
        };
        Thread t=new Thread(r);
        t.start();
        IntStream.rangeClosed(1,10).forEach(i-> System.out.println("Main Thread "+i));
    }
}
