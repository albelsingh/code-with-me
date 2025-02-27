package org.java.oops;
class A{
    public void m1(){
        System.out.println("A m1()");
    }
}
class B extends A{
    public void m2(){
        System.out.println("B m2()");
    }
}
class C extends B{
    public void m3(){
        System.out.println("C m3()");
    }
}
public class MultiLevelInheritance {
    public static void main(String[] args) {
        A a=new B();
        a.m1();
        C c=new C();
        c.m1();
        c.m2();
        c.m3();
    }
}
