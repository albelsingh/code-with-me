package org.java.exp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.lang.reflect.Constructor;

@Data
public class ObjectCreation implements Cloneable, Serializable {
    String name = "GeeksForGeeks";

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // Super() keyword refers to parent class
        return super.clone();
    }
    public ObjectCreation(){

    }
    public ObjectCreation(String name){
        this.name=name;
    }

    public static void main(String[] args) {
        //1.New Keyword
        ObjectCreation objectCreation = new ObjectCreation();
        System.out.println("Using New Keyword " + objectCreation.name);
        //2.New Instance
       /* try {
            Class cls = Class.forName("ObjectCreation");
            // Creating object of main class
            // using instance method
            ObjectCreation obj = (ObjectCreation) cls.newInstance();

            // Print and display
            System.out.println("Using new instance " + obj.name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }*/

        //Using clone() method
        ObjectCreation obj1 = new ObjectCreation();

        // Try block to check for exceptions
        try {
            // Using the clone() method
            ObjectCreation obj2 = (ObjectCreation) obj1.clone();
            // Print and display the main class object
            // as created above
            System.out.println("Using Clone() method: " + obj2.name);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        //Using deserialization
        try {
            // Creating object of class in main() method
            ObjectCreation d = new ObjectCreation("GeeksForGeeks");
            FileOutputStream f
                    = new FileOutputStream("file.txt");
            ObjectOutputStream oos
                    = new ObjectOutputStream(f);
            oos.writeObject(d);
            oos.close();
            // Freeing up memory resources
            f.close();
            FileInputStream fileInputStream = new FileInputStream("file.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ObjectCreation obj4 = (ObjectCreation) objectInputStream.readObject();
            System.out.println("Using deserialization " + obj4);
            fileInputStream.close();
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Using newInstance() method reflection
        try {
            Constructor<ObjectCreation> constructor
                    = ObjectCreation.class.getDeclaredConstructor();

            ObjectCreation r = constructor.newInstance();

            // Custom passing
            r.setName("GeeksForGeeks");
            System.out.println("Using newInstance : " + r.name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
