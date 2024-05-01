package org.java.core;

public abstract class MyAbstract {
    String name;
    public abstract void print();
    public MyAbstract() {
        System.out.println("Parent class default constructor");
    }
    public MyAbstract(String name) {
        System.out.println("parent Parametrize constructor called "+name);
    }
}
class MyAbstractImpl extends MyAbstract{

    @Override
    public void print() {
        System.out.println("Child class print method");
    }

    public MyAbstractImpl() {
        this("this");
        System.out.println("Child class default constructor");
    }

    public MyAbstractImpl(String name) {
        super("Constructor");
        System.out.println("Child class parametrize constructor "+name);
    }

    public static void main(String[] args) {
        MyAbstractImpl ab=new MyAbstractImpl();
        ab.print();
        MyAbstractImpl ab2=new MyAbstractImpl("Albel");
    }
}
