package org.java.core;

public  class Base {
    int x=10;
    int y=20;
    public void print1() {
        System.out.println("Base print 1");
    }
    public void print2() {
        System.out.println("Base print 2");
    }
    protected void print3() {
        System.out.println("Base print 3");
    }
    private void print4() {
        System.out.println("Base print 4");
    }

   /* public void printDerived() {
        System.out.println("Base class member");
    }*/
}

class Derived extends Base
{
    int x=30;
    int z=40;
    public Derived(int x){
        this.x=x;
    }
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
    /**
     * final ,private method is not available for method overriding
     */
    private void print4() {
        System.out.println("Child print 4");
    }
    public void printDerived() {
        System.out.println("Derived class member");
    }
    public static void main(String[] args) {
        Base b = new Derived(45);
        b.print1();
        b.print2();
        b.print3();
        //b.printDerived(); // can find this method in parent class
        System.out.println(b.x);
        System.out.println(b.y);
        b.print1();
        //System.out.println(b.z); //CE
        Derived c = new Derived(45);
        System.out.println(c.x);
        System.out.println(c.y);
        System.out.println(c.z);
        c.print1();
        c.print4();
    }
}