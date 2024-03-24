package org.java.exp;

// A Class that represents use-defined exception

class MyException extends RuntimeException {
    public MyException(String s)
    {
        // Call constructor of parent Exception
        super(s);
    }
    public MyException(String s,Throwable e){
        super(s,e);
    }
}

// A Class that uses above MyException
class MyExceptionDemo {
    // Driver Program
    public static void main(String args[])
    {
        try {
            System.exit(0);
            // Throw an object of user defined exception
            throw new MyException("GeeksGeeks");
        }
        catch (MyException ex) {
            System.out.println("Caught "+ex);
            // Print the message from MyException object
            System.out.println(ex.getMessage());
        }finally {
            System.out.println("finally block executed !!");
        }
    }
}

