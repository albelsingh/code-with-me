package org.java.util;
@FunctionalInterface
public interface FuncInterface {
    void test();
}
class FuncDemo{
    public static void main(String[] args) {
        FuncInterface funcInterface=()-> System.out.println("functional interface called");
        funcInterface.test();
    }
}