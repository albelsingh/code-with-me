package org.java.jdk8;

/**
 * Lambda expressions is not replacement of Anonymous Inner class
 * Anonymous Inner class is more powerful than lambda expressions bcz
 * lambda expression can be written for functional interface only but anonymous inner class can
 * provide implementation for functional and non-functional interface
 *
 * 1.Anonymous Inner class can extend a normal class
 * 2.Anonymous Inner class can extend an abstract class
 * 3.Anonymous Inner class can implement an Interface which contains any number of abstract methods
 *
 * 1. Lambda expression can implement an interface which contains a single abstract method(FI)
 * Lambda expression != Anonymous Inner class
 * Thread t=new Thread()
 * {
 *     ...
 * };
 *
 * Creating Anonymous child class which extends Thread class
 *
 * Runnable r=new Runnable(){
 *     ...
 * };
 *Creating Anonymous Inner class which implements Runnable Interface
 */
public class AnonymousDemo {
    public static void main(String[] args) {
        Runnable r=new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<5;i++){
                    System.out.println("Child Thread");
                }
            }
        };
        Runnable r2= () -> {
            for(int i=0;i<5;i++){
                System.out.println("Child 2 Thread");
            }
        };
        Thread t=new Thread(r);
        t.start();
        for(int i=0;i<5;i++){
            System.out.println("Main Thread");
        }
        Thread t2=new Thread(r2);
        t2.start();
    }
}
