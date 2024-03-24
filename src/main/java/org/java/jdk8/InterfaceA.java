package org.java.jdk8;

public interface InterfaceA {
    int count=10;
    public default void show(){
        System.out.println("interface A show method called ");
    }
}
