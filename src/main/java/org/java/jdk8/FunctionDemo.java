package org.java.jdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class FunctionDemo {
    /**
     * A Function is another in-build functional interface in java.util.function
     * package, the function takes an input value and returns a value.
     * The function interface has four methods, mostly function used in map
     * feature of stream APIs.
     *
     * R apply(T var1);
     * default <V> Function<V, R> compose(Function<V, T> before);
     * default <V> Function<T, V> andThen(Function<R, V> after);
     * static <T> Function<T, T> identity();
     */
    @Test
    public void mapCities() {

        List<String> cities = new ArrayList<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Goa");
        cities.add("Pune");

        Function<String, Character> getFirstCharFunction = city -> {
            return city.charAt(0);
        };
        cities.stream().map(getFirstCharFunction)
                .forEach(System.out::println);
    }
}
