package org.java.jdk8;

import java.time.LocalDateTime;

public class EvenOddPrintThread implements Runnable{
    Object object;
    static int i=1;

    public EvenOddPrintThread(Object object) {
        this.object = object;
    }

    @Override
    public void run() {
        while(i<=10){
            if(i%2==0&& Thread.currentThread().getName().equals("even")){
                synchronized (object){
                    System.out.println(Thread.currentThread().getName()+" : "+i);
                    i++;
                    try{
                       object.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
            if(i%2 !=0&& Thread.currentThread().getName().equals("odd")){
                synchronized (object){
                    System.out.println(Thread.currentThread().getName()+" : "+i);
                    i++;
                    object.notify();
                }
            }
        }

    }
    public static void main(String[] args) {
        Object obj=new Object();
        EvenOddPrintThread th1=new EvenOddPrintThread(obj);
        EvenOddPrintThread th2=new EvenOddPrintThread(obj);
        new Thread(th1,"even").start();
        new Thread(th2,"odd").start();
        LocalDateTime localDateTime=LocalDateTime.now();
    }
}


