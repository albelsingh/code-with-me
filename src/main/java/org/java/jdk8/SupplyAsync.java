
package org.java.jdk8;

import org.java.dto.EmployeeDTO;
import org.java.dto.EmployeeDatabase;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SupplyAsync {
    public List<EmployeeDTO> getEmployees() throws ExecutionException, InterruptedException {
        Executor executor = Executors.newCachedThreadPool();
        CompletableFuture<List<EmployeeDTO>> listCompletableFuture = CompletableFuture
                .supplyAsync(() -> {
                    System.out.println("Executed by : " + Thread.currentThread().getName());
                    return EmployeeDatabase.fetchEmployees();
                },executor);
        return listCompletableFuture.get();
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        SupplyAsync supplyAsyncDemo = new SupplyAsync();
        List<EmployeeDTO> employees = supplyAsyncDemo.getEmployees();
        employees.stream().forEach(System.out::println);
    }
}   

