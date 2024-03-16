package org.java.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class WhyNotFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService=Executors.newFixedThreadPool(10);
        //Runnable thread
        executorService.execute(()-> System.out.println("Runnable Thread"));
        //Callable
        Future<List<Integer>> future = executorService.submit(() -> {
            System.out.println("Thread "+Thread.currentThread().getName());
            return Arrays.asList(1, 2, 3, 4, 5);
        });
        System.out.println(future.get());


        Future<List<Integer>> future1 = executorService.submit(() -> {
            System.out.println("Thread "+Thread.currentThread().getName());
            return Arrays.asList(8, 4, 6, 7, 5);
        });

        //There is no proper exception handling except try catch
        //We can not chain multiple future
        //we can not join multiple future
        //we can not manually complete future
        System.out.println(future1.get());
        Future<List<Integer>> future2 = executorService.submit(() -> {
            try {
                System.out.println("Thread "+Thread.currentThread().getName());
                System.out.println(10 / 0);
            }catch (ArithmeticException e){
                System.out.println(e.getMessage());
            }
            return Arrays.asList(12, 22, 13, 44, 5);
        });
        System.out.println(future2.get());


        CompletableFuture<String> completableFuture=new CompletableFuture<>();
        completableFuture.get();
        completableFuture.complete("test");


    }
}
