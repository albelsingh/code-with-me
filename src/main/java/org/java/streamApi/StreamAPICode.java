package org.java.streamApi;

import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Data
public class StreamAPICode {

    public List<Integer> calculateSquare(List<Integer> list){

        return list.stream().map(x->x*x).collect(Collectors.toList());
    }

    public List<String> findWords(List<String> wordList){

        return wordList.stream().filter(s->s.startsWith("S")).collect(Collectors.toList());
    }

    public List<String> sortList(List<String> wordList){

        return wordList.stream().sorted().collect(Collectors.toList());
    }

    public void printNumber(List<Integer> list){

        list.forEach(x-> System.out.println(x));
    }

    public int calculateSum(List<Integer> list){

        return list.stream().filter(x->x%2==0).reduce(0,(ans,i)-> ans+i);
    }
    public void flattenList(){
        // Creating a list of Prime Numbers
        List<Integer> PrimeNumbers = Arrays.asList(5, 7, 11,13);

        // Creating a list of Odd Numbers
        List<Integer> OddNumbers = Arrays.asList(1, 3, 5);

        // Creating a list of Even Numbers
        List<Integer> EvenNumbers = Arrays.asList(2, 4, 6, 8);

        List<List<Integer>> listOfListofInts =
                Arrays.asList(PrimeNumbers, OddNumbers, EvenNumbers);

        System.out.println("The Structure before flattening is : " +
                listOfListofInts);

        // Using flatMap for transformating and flattening.
        List<Integer> listofInts  = listOfListofInts.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.toList());

        System.out.println("The Structure after flattening is : " +
                listofInts);
    }

}
