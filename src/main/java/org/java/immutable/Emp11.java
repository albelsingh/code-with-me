package org.java.immutable;

import lombok.NoArgsConstructor;

final public class Emp11 {
    private final String name;
    private final EmpAddress address;

    public Emp11(String name, EmpAddress address) {
        this.name = name;
        EmpAddress tempAdd = new EmpAddress(address.getCity(),address.getPinCode());
        this.address = tempAdd;
    }

    public String getName() {
        return name;
    }

    public EmpAddress getAddress() {
        EmpAddress tempAdd = new EmpAddress(this.address.getCity(),this.address.getPinCode());
        return tempAdd;
    }

    public static void main(String[] args) {
        EmpAddress add = new EmpAddress("Bangalore",560076);
        Emp11 e = new Emp11("Neha", add);
        System.out.println(e.getName() + " "+ e.getAddress().getCity()+" " + e.getAddress().getPinCode()+" "+add.getPinCode());
        add.setPinCode(12345);
        System.out.println(e.getName() + " "+ e.getAddress().getCity()+" " + e.getAddress().getPinCode()+" "+add.getPinCode());
        e.getAddress().setPinCode(56789);
        e.getAddress().setCity("Hyd");
        System.out.println(e.getName() + " "+ e.getAddress().getCity()+" " + e.getAddress().getPinCode()+" "+add.getPinCode());
    }
}
