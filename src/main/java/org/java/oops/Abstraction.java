package org.java.oops;
// Java program showing the working of abstraction

// Creating an abstract class
// demonstrate abstraction
abstract class Abstraction {

    // Just providing that Abstractions has legs
    // Hiding the number of legs
    abstract void noOfLegs();
}

// A new child class is extending
// the parent abstract class above
class Elephant extends Abstraction {

    // Implementation of the abstract method
    public void noOfLegs()
    {
        // Printing message of function in non abstract
        // child class
        System.out.println("It has four legs");
    }
}

// Again a new child class is extended from parent
// Human class to override function created above
class Human extends Abstraction {

    // Same function over-riden
    public void noOfLegs()
    {
        // Message printed if this function is called or
        // Implementation of the abstract method
        System.out.println("It has two legs");
    }
}

 class AbsMain {

    // Main driver method
    public static void main(String[] args)
    {
        // Creating human object showing the implementation
        Human ob = new Human();

        ob.noOfLegs();

        // Creating object of above class in main
        Elephant ob1 = new Elephant();

        // Calling the function in main by
        // creating object of above non abstract class
        ob1.noOfLegs();
        // Implementation of abstraction
    }
}
