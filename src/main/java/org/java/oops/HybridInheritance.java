package org.java.oops;
// Interface 1
interface Flyable {
    void fly();
}

// Interface 2
interface Walkable {
    void walk();
}

// Parent class
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}

// Child class inheriting from Animal and implementing Flyable and Walkable
class Bird extends Animal implements Flyable, Walkable {
    @Override
    public void fly() {
        System.out.println("Bird flies");
    }

    @Override
    public void walk() {
        System.out.println("Bird walks");
    }
}

/**
 * A mix of two or more types of inheritance.
 * Java does not support direct hybrid inheritance but can be achieved using interfaces
 */
public class HybridInheritance {
    public static void main(String[] args) {
        Bird bird=new Bird();
        bird.fly();
        bird.walk();
        bird.makeSound();
    }
}

