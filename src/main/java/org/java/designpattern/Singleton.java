package org.java.designpattern;

// Java program implementing Singleton class
// with using getInstance() method

import java.io.*;
import java.lang.reflect.InvocationTargetException;

// Class 1
// Helper class
class Singleton implements Cloneable, Serializable {
    // Static variable reference of single_instance
    // of type Singleton
    private static volatile Singleton single_instance = null;
    // Declaring a variable of type String
    public String s;

    // Here we will be creating private constructor restricted to this class itself
    private Singleton() throws IllegalAccessException {
        //preventing object creation using reflection
        if (single_instance != null) {
            throw new IllegalAccessException("Object can't be created using reflection");
        }
    }

    // Static method
    // Static method to create instance of Singleton class
    public static Singleton getInstance() throws IllegalAccessException {
        if (single_instance == null) {
            // To make thread safe
            synchronized (Singleton.class) {
                // check again as multiple threads
                // can reach above step
                if (single_instance == null)
                    single_instance = new Singleton();
            }
        }
        return single_instance;
    }

    //preventing singleton object from clone method
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return single_instance;
    }

    //preventing obj creation from serialization
    protected Object readResolve() {
        return single_instance;
    }
}

class SingletonDemo {
    // Main driver method
    public static void main(String args[]) throws CloneNotSupportedException, InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        Singleton x = Singleton.getInstance();
        Singleton y = Singleton.getInstance();
        System.out.println("Hashcode of x is " + x.hashCode());
        System.out.println("Hashcode of y is " + y.hashCode());
        //creating obj using clone method
        Singleton z = (Singleton) x.clone();
        System.out.println("Hashcode of z is " + z.hashCode());
        //Creating object using reflection API
        /*Singleton reflection=null;
        Constructor [] constructors=Singleton.class.getDeclaredConstructors();
        for(Constructor constructor:constructors){
            constructor.setAccessible(true);
            reflection =(Singleton) constructor.newInstance();
        }
        System.out.println("Hashcode of reflection is " +reflection.hashCode());*/

        //Creating object using serialization
        FileOutputStream fileOutputStream = new FileOutputStream("obj.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(x);

        FileInputStream fileInputStream = new FileInputStream("obj.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Singleton s = (Singleton) objectInputStream.readObject();
        System.out.println("Hashcode of s is " + s.hashCode());

    }
}

