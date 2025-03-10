package org.java.core;

public class ParentChildMethod {
        public void method1(){
            System.out.println("Parent method 1");
            method2();
        }

        public void method2(){
            System.out.println("Parent method 2");
            method3();
        }

        public static void method3(){
            System.out.println("Parent method 3");
        }
    }
    class ChildMethod extends ParentChildMethod{

        @Override
        public void method1(){
            super.method1();
            System.out.println("Child method 1");
        }

        @Override
        public void method2(){
            super.method2();
            System.out.println("Child method 2");
        }
        public static void method3(){
            System.out.println("Child method 3");
        }

        public static void main(String[] args) {
            ChildMethod c=new ChildMethod();
            c.method1();
        }
    }
