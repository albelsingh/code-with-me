package org.java.test;

import java.util.TreeSet;

public class Monkey extends  Animal{
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

    public static void main(String[] args) {
        Animal animal=new Monkey();
        //Monkey monkey=new Animal();
        animal.print();//10
        System.out.println(animal.i);//20

        Monkey monkey=new Monkey();
        monkey.m1(null); //String
    }
}
