package org.java.util;

import java.util.PriorityQueue;
import java.util.Queue;

//Thread 1 to write num after 1 sec
//Thread 2 to read num after 5 sec
class MyRunnable2 implements Runnable{
    public void run(){
        for(int i=0;i<11;i+=2) {
            System.out.println(i);
        }
    }
}

class MyRunnable1 implements Runnable{
    public void run(){
        for(int i=1;i<=11;i+=2) {
            System.out.println(i);
        }
    }
}

class MultithreadingDemo{
    static Object lock = new Object();

    public static void main(String[] args) {
        Queue<Integer> queue=new PriorityQueue<>();
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                    synchronized (lock) {
                        try {
                            for(int i=0;;i++){
                                System.out.print("Thread 1 Writing "+i+"\n");
                                queue.add(i);
                                Thread.sleep(1000);
                            }
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                    synchronized (lock) {
                        try {
                            System.out.println("Thread 2 reading "+queue+"\n");
                            Thread.sleep(5000);
                            t1.join();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
            }
        });
        t1.start();
        t2.start();


    }


}


