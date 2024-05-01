package org.java.jdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PrediCateDemo {
    /**
     * A Predicate is a functional interface, which accepts an argument and
     * returns a boolean. Usually, it is used to apply in a filter for a
     * collection of objects.
     *
     * boolean test(T value);
     * default Predicate<T> and(Predicate<? super T> other);
     * default Predicate<T> negate();
     * default Predicate<T> or(Predicate<? super T> other);
     * static <T> Predicate<T> isEqual(Object targetRef);
     * static <T> Predicate<T> not(Predicate<? super T> target);
     */
    @Test
    public void filterCities() {

        List<String> cities = new ArrayList<>();
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Goa");
        cities.add("Pune");

        Predicate<String> filterCity = city -> city.equals("Mumbai");
        cities.stream().filter(filterCity).forEach(System.out::println);
    }
}
