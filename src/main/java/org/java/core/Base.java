package org.java.core;

public class Base {
    public void print() {
        System.out.println("Base");
    }

   /* public void printDerived() {
        System.out.println("Base class member");
    }*/
}

class Derived extends Base
{
    @Override
    public void print() {
        System.out.println("Derived");
    }

    public void printDerived() {
        System.out.println("Derived class member");
    }
}

class Main {
    public static void main(String[] args) {
        Base b = new Derived();
        b.print();
        //b.printDerived(); // can find this method in parent class
    }
}