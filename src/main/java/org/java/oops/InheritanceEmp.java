package org.java.oops;

// Java Program to illustrate Inheritance (concise)
// Base or Super Class
class InheritanceEmp {
    int salary = 60000;
    public void printEmpSalary(){
        System.out.println("Emp Salary::"+salary);
    }
}

// Inherited or Sub Class
class Engineer extends InheritanceEmp {
    int benefits = 10000;
    int salary=70000;
    public void printEngBenefits(){
        System.out.println("Eng Benefits::"+benefits);
    }
    @Override
    public void printEmpSalary(){
        System.out.println("Eng Salary ::"+salary);
    }
}

// Driver Class
class InheritanceMain {
    public static void main(String args[])
    {
        Engineer e1 = new Engineer();
        e1.printEngBenefits();
        e1.printEmpSalary(); //Child object means child method will be called

        InheritanceEmp emp=new InheritanceEmp();
        emp.printEmpSalary();
        //emp.printEngBenefits(); //CE Child specific method is not available to parent
        /**
         * Parent class ref can be used to hold child specific obj but we can't call child specific method
         * Note: If method is overridden in child class then we can call child class method
         */
        InheritanceEmp emp1=new Engineer();
        emp1.printEmpSalary(); // Child class method will be called
        //emp1.printEngBenefits(); //CE
        /**
         * Child class can't hold obj of parent class
         * Engineer eng=new InheritanceEmp();
         */

    }
}
