package org.java.jdk8;

import javax.sql.rowset.Predicate;
import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class EvenOddPrinter {
private static Object object=new Object();
private static IntPredicate evenCond=i->i%2==0;
private static IntPredicate oddCond=i->i%2!=0;
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(()->EvenOddPrinter.printNumber(evenCond));
        CompletableFuture.runAsync(()->EvenOddPrinter.printNumber(oddCond));
        Thread.sleep(1000);
    }

    public static void printNumber(IntPredicate cond){
        IntStream.rangeClosed(1 , 10).filter(cond).forEach(EvenOddPrinter::execute);
    }
    public static void execute(int no){
        synchronized (object){
            System.out.println(Thread.currentThread().getName()+" : "+no);
            try {
                object.notify();
                object.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
