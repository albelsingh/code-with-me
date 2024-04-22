package org.java.core;

public  class Base {
    public void print1() {
        System.out.println("Base print 1");
    }

    public void print2() {
        System.out.println("Base print 2");
    }
    protected void print3() {
        System.out.println("Base print 3");
    }

   /* public void printDerived() {
        System.out.println("Base class member");
    }*/
}

class Derived extends Base
{
    public void print1() {
        System.out.println("Child print 1");
    }

    /**
     * Weaker access privilege is not allowed
     */
   /* protected void print2() {
        System.out.println("Child print 2");
    }*/
    @Override
    public void print3() {
        System.out.println("Child print 3");
    }

    public void printDerived() {
        System.out.println("Derived class member");
    }
}

class Main {
    public static void main(String[] args) {
        Base b = new Derived();
        b.print1();
        b.print2();
        b.print3();
        //b.printDerived(); // can find this method in parent class
    }
}