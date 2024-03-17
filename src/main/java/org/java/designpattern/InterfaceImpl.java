package org.java.designpattern;

public class InterfaceImpl implements InterfaceA,InterfaceB{
    public static void main(String[] args) {
        try {
           InterfaceImpl impl=new InterfaceImpl();
           impl.show();
           //System.out.println(++InterfaceA.count); //can not assign value to final variable
        }catch (Error e){
            System.out.println("Error caught in catch block");
        }
    }
    @Override
    public void show() {
        InterfaceB.super.show();
    }
}
