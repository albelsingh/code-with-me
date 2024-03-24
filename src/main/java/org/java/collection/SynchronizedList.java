package org.java.collection;

import org.java.jdk8.EvenOddPrinter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedList{
    List<String> list= Collections.synchronizedList(new ArrayList<>());
    ExecutorService executorService=Executors.newFixedThreadPool(10);
    void addString(String str){
        CompletableFuture.runAsync(()-> {
            list.add(str);
            System.out.println("Added by "+Thread.currentThread().getName()+" "+str);
        },executorService);
    }
    List<String> getList(){
        return this.list;
    }
    public static void main(String[] args) {
        //List<String> list= Collections.synchronizedList(new ArrayList<>());
        SynchronizedList thread=new SynchronizedList();
        thread.addString("Albel");
        thread.addString("Murari");
        thread.addString("Ajay");
        thread.addString("Preeti");
        thread.addString("xyz");
        thread.addString("xyz");
        thread.addString("xyz");
        thread.addString("xyz");
        thread.addString("xyz");
        thread.addString("xyz");
        thread.addString("xyz");
        thread.addString("xyz");
        System.out.println(thread.getList());
    }
}
