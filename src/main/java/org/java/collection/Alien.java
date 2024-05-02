package org.java.collection;
import java.util.HashSet;

class Alien {
    public int id;
    public String name;
    public Alien(String name, int id) {
        this.name = name;
        this.id = id;
    }
    public int hashCode() {
        return this.id;
    }
    public String toString() {
        return "Alien: (" + this.name + "," + this.id+")";
    }
    public boolean equals(Object o) {
        if (o instanceof Alien) {
            Alien s = (Alien) o;
            return s.id == this.id ? true : false;
        }
        return false;
    }

}

class UpdateHashSet {
    public static void main(String[] args) {
        HashSet<Alien> studentList = new HashSet<>();
        Alien st1 = new Alien("Nimit", 1);
        Alien st2 = new Alien("Rahul", 3);
        Alien st3 = new Alien("Nimit", 2);
        Alien st4 = new Alien("Rohit", 4);
        Alien st5 = new Alien("Pooja", 2);
        Alien st6 = new Alien("Albel", 3);
        System.out.println(studentList.add(st1));
        System.out.println(studentList.add(st2));
        System.out.println(studentList.add(st3));
        System.out.println(studentList.add(st4));
        System.out.println(studentList.add(st5));
        System.out.println(studentList.add(st6));
        System.out.println(studentList.size()+" "+studentList); //4
        st1.id = 3;
        System.out.println(studentList.size()+" "+studentList);  //4
        st1.id = 5;
        System.out.println(studentList.contains(st1)+" "+studentList); //false
        System.out.println(studentList.contains(st5)); //true

    }

}