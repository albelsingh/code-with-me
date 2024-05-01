package org.java.core;

public class Animal {
    int i=20;
    public void print(){
        System.out.println("Animal ::"+i);
    }
}
class Monkey extends Animal {
    int i=10;
    public void print(){
        System.out.println("Monkey ::"+i);
    }
    public void m1(Object o){
        System.out.println("Object :::");
    }
    public void m1(String s){
        System.out.println("String :::");
    }

    /**
     * reference to m1 is ambiguous
     *   both method m1(java.lang.String)  and method m1(java.lang.StringBuffer)
     *
     */
   /* public void m1(StringBuffer s){
        System.out.println("String :::");
    }*/

    public static void main(String[] args) {
        Animal animal=new Monkey();
        //Monkey monkey=new Animal();
        animal.print();//10
        System.out.println(animal.i);//20

        Monkey monkey=new Monkey();
        monkey.m1(null); //String
    }
}

