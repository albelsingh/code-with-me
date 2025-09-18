package org.java.jdk8;

/**
 * Until 1.7
 * Every method in interface is public and abstract
 *
 * Method Related:
 * 1.8 V: default method + static method
 * 1.9 V: private method
 *
 * Variable Related:
 * There is no enhancement in 1.8 v every var is public static and final.
 *
 * Default Method: Virtual extension method or defender method
 * Without affecting implementation classes if we want to add new method to the
 * interface ===>Default method
 *
 * 1. it has default implementation in the interface that is the reason it is called default method
 * 2. default method is not allowed in class bcz default keyword already reserved in class but we can
 * override default method in class
 * 3.We can not override object class method as default method in interface bcz object class method is
 * already available to the child class
 *
 */

public interface DefaultInterfaceDemo {
    public void m1();
    public void m2();
    default void m3(){
        System.out.println("Default method implementation");
    }
}
class Test1 implements DefaultInterfaceDemo{
    public void m1(){}
    public void m2(){}
    public static void main(String[] args) {
        Test1 t=new Test1();
        t.m3();
    }
}
class Test2 implements DefaultInterfaceDemo{
    public void m1(){}
    public void m2(){}
    public void m3(){
        System.out.println("Test2 default implementation");
    }
    public static void main(String[] args) {
        Test2 t=new Test2();
        t.m3();
    }
}
class Test3 implements DefaultInterfaceDemo{
    public void m1(){}
    public void m2(){}
}

interface Left{
    default void m1(){
        System.out.println("Left Interface m1() method");
    }
}
interface Right{
    default void m1(){
        System.out.println("Right Interface m1() method");
    }
}
class Test implements Left,Right{
    @Override
    public void m1() {
        System.out.println("Our own implementation");
       // Left.super.m1();
        Right.super.m1();
    }

    public static void main(String[] args) {
        Test t=new Test();
        t.m1();
    }
}
//test