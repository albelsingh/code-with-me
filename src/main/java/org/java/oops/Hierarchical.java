package org.java.oops;

/**
 * In Hierarchical Inheritance, one class serves as a superclass (base class)
 * for more than one subclass
 */
class ClassA {
    public void printA() {
        System.out.println("ClassA print method");
    }
}

class ClassB extends ClassA {
    public void printB() {
        System.out.println("ClassB print method");
    }
}

class ClassC extends ClassA {
    public void printC() {
        System.out.println("ClassC print method");
    }
}

public class Hierarchical {
    public static void main(String[] args) {
        ClassB b = new ClassB();
        b.printA();
        b.printB();
        ClassC c = new ClassC();
        c.printA();
        c.printC();
    }
}
