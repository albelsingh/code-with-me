package org.java.ds;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RKTN {
    public static void showFiles(File[] files) {
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("Hey this the DIR : " + file.getAbsolutePath());
                showFiles(file.listFiles()); // Calls same method again.
            } else {
                System.out.println("Your Files Again: " + file.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //D C
        CompletableFuture<List<String>> f1=CompletableFuture.supplyAsync(()->{
           File file=new File("./");
           for(File file1: Objects.requireNonNull(file.listFiles())){
               if(file1.isFile()){
                   System.out.println("Your Files Again: "+ file.getName()+" File Size "+file);
               }else if(file1.isDirectory()){
                   showFiles(file1.listFiles());
               }
           }
           return new ArrayList<>();
        });
        System.out.println(f1.get());

    }
}
