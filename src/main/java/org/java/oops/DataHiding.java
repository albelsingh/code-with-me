package org.java.oops;

// Java Program showing working of data hiding
class DataHiding {

    // Private data (data hiding)
    private long curBalance = 0;

    // bandId is checked for authentication
    long bandId;
    String name;

    // Getter function to modify private data
    public long getBalance(long Id)
    {

        // Checking whether the user is
        // authorised or unauthorised

        // Comparing bandId of user and the given Id
        // then only it will get access
        if (this.bandId == Id) {

            // Return current balance
            return curBalance;
        }

        // Unauthorised user
        return -1;
    }
    // Setter function
    public void setBalance(long balance, long Id)
    {
        // Comparing bandId of user and the given Id
        // then only it will get access
        if (this.bandId == Id) {
            // Update balance in current ID
            curBalance = curBalance + balance;
        }
    }
}

// Another class created- Employee
class Emp {
    public static void main(String[] args)
    {
        // Creating employee object of DataHiding type
        DataHiding emp = new DataHiding();

        // Assigning employee object values
        emp.bandId = 12345;
        emp.name = "Roshan";

        // emp.getBalance(123456)
        emp.setBalance(10000, 12345);
        // This will no get access as bandId is given wrong
        // so
        // unauthorised user is not getting access that is
        // data hiding
        long empBalance = emp.getBalance(12345);
        // As this time it is valid user it will get access

        System.out.println("User Name"
                + " " + emp.name);
        System.out.println("bandId"
                + " " + emp.bandId);
        System.out.println("Current Balance"
                + " " + empBalance);
    }
}
