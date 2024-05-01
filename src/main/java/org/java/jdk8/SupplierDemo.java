package org.java.jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.Supplier;

public class SupplierDemo {
    /**
     * The Supplier Interface is a part of the java.util.function package.
     * It represents a function that does not take in any argument but produces
     * a value of type T. It contains only one method.
     *
     * T get();
     */

    @Test
    public void supplyCities() {

        Supplier<String[]> citySupplier = () -> {
            return new String[]{"Mumbai", "Delhi", "Goa", "Pune"};
        };
        Arrays.asList(citySupplier.get()).forEach(System.out::println);
    }
}
