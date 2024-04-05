package org.java.util;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class TwoThreadsDemo {
    //12345
    public  static Object object = new Object();
    public static IntPredicate evenCond= i->i%2==0;
    public static IntPredicate oddCond= i->i%2!=0;

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Void> completableFuture=CompletableFuture.runAsync(()->TwoThreadsDemo.printNumber(oddCond));
        CompletableFuture<Void> completableFuture1=CompletableFuture.runAsync(()->TwoThreadsDemo.printNumber(evenCond));
        Thread.sleep(1000);
    }

    public static void printNumber(IntPredicate cond){
        IntStream.rangeClosed(1,10).filter(cond).forEach(TwoThreadsDemo::write);
    }
    public static void write(int n) {
        synchronized (object){
            System.out.println(n);
            object.notify();
            try {
                object.wait();
            }catch (InterruptedException e){

            }

        }

    }

}
