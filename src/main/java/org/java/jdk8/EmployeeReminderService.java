package org.java.jdk8;

import org.java.dto.EmployeeDTO;
import org.java.dto.EmployeeDatabase;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeReminderService {
    public  CompletableFuture<Void> sendReminderToEmployee() {

        Executor executor=Executors.newFixedThreadPool(5);

        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("fetchEmployee : " + Thread.currentThread().getName());
            return EmployeeDatabase.fetchEmployees();
        },executor).thenApplyAsync((employees) -> {
            System.out.println("filter new joiner employee  : " + Thread.currentThread().getName());
            return employees.stream()
                    .filter(employee -> "TRUE".equals(employee.getNewJoiner()))
                    .collect(Collectors.toList());
        },executor).thenApplyAsync((employees) -> {
            System.out.println("filter training not complete employee  : " + Thread.currentThread().getName());
            return employees.stream()
                    .filter(employee -> "TRUE".equals(employee.getLearningPending()))
                    .collect(Collectors.toList());
        },executor).thenApplyAsync((employees) -> {
            System.out.println("get emails  : " + Thread.currentThread().getName());
            return employees.stream().map(EmployeeDTO::getEmail).collect(Collectors.toList());
        },executor).thenAcceptAsync((emails) -> {
            System.out.println("send email  : " + Thread.currentThread().getName());
            emails.forEach(EmployeeReminderService::sendEmail);
        },executor);
        return voidCompletableFuture;
    }



    public static void sendEmail(String email) {
        System.out.println("sending training reminder email to : " + email);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        EmployeeReminderService service=new EmployeeReminderService();
        //service.sendReminderToEmployee().get();
        Executor executor=Executors.newFixedThreadPool(5);
        CompletableFuture<String> f2=CompletableFuture.supplyAsync(()->"Good ").thenApplyAsync((s)->s+" Morning !!");
        System.out.println(f2.get());
        /**
         * We can use this method to work with the result of the previous call. However, a key point to remember is that the
         * return type will be combined of all calls.
         *
         * So this method is useful when we want to transform the result of a CompletableFuture call:
         */
        CompletableFuture<Object> f1=CompletableFuture.supplyAsync(()->{
            System.out.println("Fetching emp"+Thread.currentThread().getName());
            return "Hello ";
        },executor).thenCompose((s)->{
            System.out.println("Fetching emp"+Thread.currentThread().getName());
            return CompletableFuture.supplyAsync(() -> s + " World");
        });
        System.out.println(f1.get());

        /**
         * The thenCompose() is similar to thenApply() in that both return a new CompletionStage. However, thenCompose()
         * uses the previous stage as the argument. It will flatten and return a Future with the result directly, rather
         * than a nested future as we observed in thenApply():
         */
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCombine(CompletableFuture.supplyAsync(
                        () -> " World"), (s1, s2) -> s1 + s2).exceptionally(e-> {
                            System.out.println(e.getMessage());
                            return null;
                });
        System.out.println(completableFuture.get());

        CompletableFuture<String> future1
                = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2
                = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3
                = CompletableFuture.supplyAsync(() -> "World");

        /**
         * it does not return the any valuesNotice that the return type of the CompletableFuture.allOf() is a CompletableFuture<Void>.
         * The limitation of this method is that it does not return the combined results of all Futures. Instead, we have to get results
         * from Futures manually. Fortunately, CompletableFuture.join() method and Java 8 Streams API makes it simple
         */
        CompletableFuture<Void> combinedFuture
                = CompletableFuture.allOf(future1, future2, future3);
        /**
         * The CompletableFuture.join() method is similar to the get method, but it throws an unchecked exception in case the Future does
         * not complete normally.
         * This makes it possible to use it as a method reference in the Stream.map() method
         */
        String combined = Stream.of(future1, future2, future3)
                .map(CompletableFuture::join)
                .collect(Collectors.joining(" "));
        System.out.println(combined);


        /**
         *For error handling in a chain of asynchronous computation steps, we have to adapt the throw/catch idiom in a similar fashion.
         *
         * Instead of catching an exception in a syntactic block, the CompletableFuture class allows us to handle it in a special handle method.
         * This method receives two parameters: a result of a computation (if it finished successfully) and the exception thrown (if some computation
         * step did not complete normally).
         *
         * In the following example, we use the handle method to provide a default value when the asynchronous computation of a greeting was finished
         * with an error because no name was provided:
         */
        String name = null;
        CompletableFuture<String> f3
                =  CompletableFuture.supplyAsync(() -> {
            if (name == null) {
                throw new RuntimeException("Computation error!");
            }
            return "Hello, " + name;
        }).handle((s, t) -> s != null ? s : "Hello, Stranger!");

        System.out.println(f3.get());
    }
}
