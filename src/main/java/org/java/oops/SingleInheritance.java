package org.java.oops;
class One{
    public void m1(){
        System.out.println("One class m1() method");
    }
}
class Two extends One{
    public void m2(){
        System.out.println("Two class m2() method");
    }
}
public class SingleInheritance {
    public static void main(String[] args) {
        Two t=new Two();
        t.m2();
        t.m1();
    }
}
