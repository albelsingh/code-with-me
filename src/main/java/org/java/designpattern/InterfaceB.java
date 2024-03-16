package org.java.designpattern;

public interface InterfaceB {
    int count=20;
    public default void show(){
        System.out.println("interface B show method called ");
    }
}
