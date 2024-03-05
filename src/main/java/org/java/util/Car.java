package org.java.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Car{
    int id;
    String name;
    long price;
    public Car(int id, String name, long price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
class HPEExample {
    public static void main(String[] args) {
        List<Car> carsList = new ArrayList<Car>();
        carsList.add(new Car(1,"Maruti",500000));
        carsList.add(new Car(2,"Hyundai",800000));
        carsList.add(new Car(3,"Volswagon",900000));
        carsList.add(new Car(4,"Ford",1000000));
        carsList.add(new Car(5,"Audi",2500000));

        List<Car> carsList1 =  carsList.stream().filter(car->car.price >700000 & car.price <1100000).collect(Collectors.toList());
        carsList1.forEach(c-> System.out.println(c.name));
    }
}