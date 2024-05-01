package org.java.jdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerDemo {
    /**
     * A Consumer is an in-build functional interface in the java.util.function package.
     * we use consumers when we need to consume objects, the consumer takes an
     * input value and returns nothing. The consumer interface has two methods.
     *
     * void accept(T value);
     * default Consumer<T> andThen(Consumer<? super T> after);
     *
     */
    @Test
    public void printCities() {

        List<String> cities = new ArrayList<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Goa");
        cities.add("Pune");

        Consumer<String> printConsumer= city-> System.out.println(city);
        cities.forEach(printConsumer);
    }
}
