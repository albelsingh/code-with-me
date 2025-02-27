package org.java.oops;
// Java program to illustrate the
// concept of Multiple inheritance

interface InterfaceOne {
    public void printA();
}

interface InterfaceTwo {
    public void printB();
}

interface InterfaceThree extends InterfaceOne, InterfaceTwo {
}
class InterfaceThreeImpl implements InterfaceThree{

    @Override
    public void printA() {
        System.out.println("InterfaceThree printA impl");
    }

    @Override
    public void printB() {
        System.out.println("InterfaceThree printB impl");
    }
}

// Drived class
public class MultipleInheritance {
    public static void main(String[] args)
    {
        InterfaceThree a = new InterfaceThreeImpl();
        a.printA();
        a.printB();
    }
}
