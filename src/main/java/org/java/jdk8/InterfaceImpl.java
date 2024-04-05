package org.java.jdk8;

public class InterfaceImpl implements InterfaceA,InterfaceB{
    @Override
    public void show() {
        InterfaceA.super.show();
    }
    public static void main(String[] args) {
        try {
           InterfaceImpl impl=new InterfaceImpl();
           impl.show();
           //System.out.println(++InterfaceA.count);
            /**
             *  We can't assign value to final variable
             */
        }catch (Error e){
            System.out.println("Error caught in catch block");
        }
    }


}
