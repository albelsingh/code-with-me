package org.java.designpattern;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CloneObject implements Cloneable{
    int id;
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneObject ob=new CloneObject(1);
        System.out.println(ob.hashCode());
        CloneObject cloneObj=(CloneObject) ob.clone();
        System.out.println(cloneObj.hashCode());
    }
}
