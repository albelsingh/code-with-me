package org.java.common;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertFalse;

public class GenericList<T> {

    private List<T> item=new ArrayList<>();
    public void add(T item){
        this.item.add(item);
    }
    public T get(int i){
        return this.item.get(i);
    }

    @Override
    public String toString() {
        return "GenericList{" +
                "item=" + item +
                '}';
    }

    public static void main(String[] args) {
        GenericList<String> list=new GenericList<>();
        list.add("Albel");
        list.add("Naman");
        list.add("Virat");
        System.out.println(list);


    }
    @Test
    public void whenCreatesEmptyOptional_thenCorrect() {
        Optional<String> empty = Optional.empty();
        assertFalse(empty.isPresent());
    }
}
