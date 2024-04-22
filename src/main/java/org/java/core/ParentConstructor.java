package org.java.core;

public class ParentConstructor {
    public ParentConstructor(String s){
        System.out.println("Parent Class Param "+s);
    }
    public ParentConstructor(){
        this("Test");
        System.out.println("Parent Class Default Constructor");
    }
}
class ChildConstructor extends ParentConstructor{
    ChildConstructor(){
        //this("Constructor");  //parent class default constructor
        //super("Constructor"); //parent class param constructor
        System.out.println("Child Class Default Constructor");
    }
    ChildConstructor(String s){
        System.out.println("Child Class Param Constructor "+s);
    }
    public static void main(String[] args) {
        ChildConstructor child=new ChildConstructor();
        //ParentConstructor parent=new ParentConstructor();
    }
    /**
     * Parent class constructor will be called(either default or param constructor)
     * if you are creating an object of child class
     *
     * If you are creating an object of parent class then parent class constructor
     * only will be called
     *
     * if you are providing param constructor then you must provide default
     * constructor also
     */


}
