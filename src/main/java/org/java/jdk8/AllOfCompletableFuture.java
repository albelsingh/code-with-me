package org.java.jdk8;

import lombok.SneakyThrows;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AllOfCompletableFuture {
    public static String method1() {
        System.out.println("Running method1... thread id: " + Thread.currentThread().getId());
        String returnValue = "Hello from method1!";
        System.out.println("Return value: " + returnValue);
        return returnValue;
    }

    public static void method2(String arg) {
        System.out.println("Running method2... thread id: " + Thread.currentThread().getId());
        System.out.println("Incoming argument: " + arg);
    }

    public static String method3(String arg) {
        System.out.println("Running method3... thread id: " + Thread.currentThread().getId());
        System.out.println("Incoming argument: " + arg);
        String returnValue = "Hello from method3!";
        System.out.println("Return value: " + returnValue);
        return returnValue;
    }


    public static CompletableFuture<String> method4(String arg) {
        return CompletableFuture.supplyAsync(()->{
            System.out.println("Running method4... thread id: " + Thread.currentThread().getId());
            return arg + "  - Well, hello to you too!";
        });
    }

    public static CompletableFuture<String> method5(String arg) {
        return CompletableFuture.supplyAsync(()->{
            System.out.println("Running method5... thread id: " + Thread.currentThread().getId());
            return arg + arg + arg;
        });
    }
    @SneakyThrows
    public static void main(String[] args) {
        System.out.println("Main thread running... thread id: " + Thread.currentThread().getId());

        CompletableFuture<Void> all = CompletableFuture.allOf(method4("Hello!"), method5("Hi!"));
        CompletableFuture cf = all.thenRun(() ->
                System.out.println("Running this after all ... thread id: " + Thread.currentThread().getId()))
                .exceptionally(e->{e.getMessage();
                return null;
                });
        System.out.println(cf.get());

        System.out.println("Main thread finished");
    }
}
